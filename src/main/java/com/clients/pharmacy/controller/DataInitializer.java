package com.clients.pharmacy.controller;

import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.service.UserService;
import com.clients.pharmacy.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    @Autowired
    private final UserService userService;
    private final UserMapper userMapper;

    public DataInitializer(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void initData() {
        saveUsers();
    }

    private void saveUsers() {
//        UserRequestDto bob = new UserRequestDto("Bob", "Alison",
//                "10.01.2000", false, "master's degree");
//        userService.add(bob);
//        UserRequestDto alice = new UserRequestDto("Alice", "Tomson",
//                "18.05.1989", false, "master's degree");
//        userService.add(alice);
//        UserRequestDto tom = new UserRequestDto("Tom", "Bobson",
//                "25.12.2012", true, "master's degree");
//        userService.add(tom);
    }
}
