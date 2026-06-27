package com.financas.demo.user.repository;

import com.financas.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsById(Long id);
}
