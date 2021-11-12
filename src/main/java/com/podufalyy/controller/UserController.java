package com.podufalyy.controller;

import com.podufalyy.domain.User;
import com.podufalyy.dto.UserDto;
import com.podufalyy.mapper.AbstractMapper;
import com.podufalyy.mapper.UserMapper;
import com.podufalyy.service.AbstractService;
import com.podufalyy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
@AllArgsConstructor
public class UserController extends AbstractController<User, UserDto, Integer> {
    private final UserService userService;
    private final UserMapper userMapper;


    @Override
    protected AbstractService<User, Integer> getService() {
        return userService;
    }

    @Override
    protected AbstractMapper<User, UserDto> getMapper() {
        return userMapper;
    }
}