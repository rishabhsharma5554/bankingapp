package com.rishabhtech.bankingapp.controller;

import com.rishabhtech.bankingapp.model.dto.Response;
import com.rishabhtech.bankingapp.model.dto.UserDto;
import com.rishabhtech.bankingapp.model.entity.User;
import com.rishabhtech.bankingapp.model.mapper.UserMapper;
import com.rishabhtech.bankingapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/iam/us/api/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Response> createUser(@RequestBody UserDto user)
    {
        log.info("Creating user...");
        userService.createUser(userMapper.toEntity(user));
        Response response = new Response("User created successfully", "success", null,new Date().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<Response> getUsers()
    {
        log.info("Fetching users...");
        List<User> users = userService.getUsers();
        List<UserDto> userDtoList = users.stream().map(userMapper::toDTO).toList();
        Response response = new Response("Users fetched successfully", "success", userDtoList, new Date().toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
