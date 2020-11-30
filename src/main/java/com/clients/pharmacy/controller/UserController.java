package com.clients.pharmacy.controller;

import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.entity.dto.UserResponseDto;
import com.clients.pharmacy.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDto> getAll(@RequestParam Optional<String> name) {
        if (name.isEmpty()) {
            return userService.getAll();
        }
        return userService.findByName(name.get());
    }

    @PostMapping
    public User create(@RequestBody UserRequestDto userRequestDto){
        return userService.add(userRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        userService.update(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
