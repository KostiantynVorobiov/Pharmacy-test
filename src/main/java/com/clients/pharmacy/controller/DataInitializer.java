package com.clients.pharmacy.controller;

import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.service.UserService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
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
}
