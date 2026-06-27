package com.financas.demo.user.controller;

import com.financas.demo.user.dto.request.UserCreateRequestDto;
import com.financas.demo.user.dto.request.UserUpdateRequestDto;
import com.financas.demo.user.dto.response.UserResponseDto;
import com.financas.demo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{idUser}")
    public ResponseEntity<UserResponseDto> readById(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.readById(idUser));
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateRequestDto requestDto) {
        return ResponseEntity.ok(userService.create(requestDto));
    }

    @PutMapping()
    public ResponseEntity<UserResponseDto> update(@RequestBody UserUpdateRequestDto requestDto) {
        return ResponseEntity.ok(userService.update(requestDto));
    }
}
