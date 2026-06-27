package com.financas.demo.user.service;

import com.financas.demo.user.entity.UserEntity;
import com.financas.demo.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
