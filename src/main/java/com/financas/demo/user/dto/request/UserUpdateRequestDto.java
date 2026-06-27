package com.financas.demo.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserUpdateRequestDto {
    @NotNull(message = "User ID can not be Null for update")
    private Long idUser;
    private String name;
    private Boolean active;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
