package com.financas.demo.user.mapper;

import com.financas.demo.shared.util.DateFormatUtil;
import com.financas.demo.user.dto.request.UserCreateRequestDto;
import com.financas.demo.user.dto.request.UserUpdateRequestDto;
import com.financas.demo.user.dto.response.UserResponseDto;
import com.financas.demo.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(UserCreateRequestDto userCreateRequestDto) {
        return UserEntity.builder()
                .name(userCreateRequestDto.getName())
                .active(Boolean.TRUE)
                .build();
    }

    public UserEntity toEntity(UserUpdateRequestDto userUpdateRequestDto) {
        return UserEntity.builder()
                .idUser(userUpdateRequestDto.getIdUser())
                .name(userUpdateRequestDto.getName())
                .active(userUpdateRequestDto.getActive())
                .created_at(userUpdateRequestDto.getCreated_at())
                .updated_at(userUpdateRequestDto.getUpdated_at())
                .build();
    }

    public UserResponseDto toDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .idUser(userEntity.getIdUser())
                .name(userEntity.getName())
                .active(userEntity.getActive())
                .created_at(DateFormatUtil.format(userEntity.getCreated_at()))
                .updated_at(DateFormatUtil.format(userEntity.getUpdated_at()))
                .build();
    }
}
