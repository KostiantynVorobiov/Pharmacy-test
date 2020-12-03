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
        UserRequestDto alice = new UserRequestDto("Alica", "Bobson",
                "10.01.2000", true, "master's degree");
        userService.add(alice);
        UserRequestDto tom = new UserRequestDto("Tom", "Alicon",
                "18.05.1989", true, "master's degree");
        userService.add(tom);
        UserRequestDto david = new UserRequestDto("David", "Bobson",
                "25.12.2012", true, "master's degree");
        userService.add(david);
    }

    /* JSON for Postman
    "firstName": "Alica",
"secondName": "Bobson",
"dateOfBirth": "11.07.1999",
"isMarried": true,
"typeOfEducation": "master's degree"

"firstName": "Tom",
"secondName": "Aliconson",
"dateOfBirth": "11.05.2010",
"isMarried": true,
"typeOfEducation": "master's degree"

"firstName": "David",
"secondName": "Bobson",
"dateOfBirth": "19.01.1985",
"isMarried": true,
"typeOfEducation": "master's degree"
     */
}
