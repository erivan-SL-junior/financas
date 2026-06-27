package com.financas.demo.user.service;

import com.financas.demo.user.dto.request.UserCreateRequestDto;
import com.financas.demo.user.dto.request.UserUpdateRequestDto;
import com.financas.demo.user.dto.response.UserResponseDto;
import com.financas.demo.user.entity.UserEntity;
import com.financas.demo.user.exception.*;
import com.financas.demo.user.mapper.UserMapper;
import com.financas.demo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto readById(Long id) {
        return userMapper.toDto(this.findById(id));
    }

    public UserResponseDto create(UserCreateRequestDto userCreateRequestDto) {
        this.validate(userCreateRequestDto);

        UserEntity newUser = this.save(userMapper.toEntity(userCreateRequestDto));
        return userMapper.toDto(newUser);
    }

    public UserResponseDto update(UserUpdateRequestDto userUpdateRequestDto) {
        this.validate(userUpdateRequestDto);
        UserEntity updateUser = this.findById(userUpdateRequestDto.getIdUser());

         if (userUpdateRequestDto.getName() != null)
            updateUser.setName(userUpdateRequestDto.getName());
         if (userUpdateRequestDto.getActive() != null)
            updateUser.setActive(userUpdateRequestDto.getActive());

         UserEntity changedUser = this.save(updateUser);
         return userMapper.toDto(changedUser);
    }

    private boolean existsUserById(Long id){
        return userRepository.existsById(id);
    }

    private UserEntity findById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() -> new UserNotFoundException(idUser.toString()));
    }

    @Transactional
    private UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    private void validate(UserCreateRequestDto userCreateRequestDto) {
        this.validateUserNull(userCreateRequestDto);

        if (userCreateRequestDto.getName() == null)
            throw new UserCreatingMissingAtributesExeception();

        final int MINIMUM_NAME_LENGTH = 4;
        if (userCreateRequestDto.getName().length() < MINIMUM_NAME_LENGTH)
            throw new UserMinimumNameLengthException();
    }

    private void validate(UserUpdateRequestDto userUpdateRequestDto) {
        this.validateUserNull(userUpdateRequestDto);

        Long userId = userUpdateRequestDto.getIdUser();
        if (!this.existsUserById(userId))
            throw new UserNotFoundException(userId.toString());
        if (userUpdateRequestDto.getName() == null && userUpdateRequestDto.getActive() == null)
            throw new UserUpdateEmptyException();
    }

    private void validateUserNull(Object requestDto){
        if (requestDto == null)
            throw new UserNullException();
    }
}
