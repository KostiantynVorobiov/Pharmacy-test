package com.clients.pharmacy.service;

import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.entity.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    User add(UserRequestDto userRequestDto);

    List<UserResponseDto> getAll();

    UserResponseDto get(Long id);

    void update(Long id, UserRequestDto userRequestDto);

    void delete(Long id);

    List<UserResponseDto> findByName(String name);
}
