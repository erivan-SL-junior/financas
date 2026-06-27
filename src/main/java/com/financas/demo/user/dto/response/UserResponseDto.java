package com.financas.demo.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponseDto {
    private Long idUser;
    private String name;
    private Boolean active;
    private String created_at;
    private String updated_at;
}
