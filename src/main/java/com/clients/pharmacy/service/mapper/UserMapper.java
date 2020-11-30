package com.clients.pharmacy.service.mapper;

import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.entity.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToModel(UserRequestDto userRequestDto) {
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .secondName(userRequestDto.getSecondName())
                .dateOfBirth(userRequestDto.getDateOfBirth())
                .isMarried(userRequestDto.isMarried())
                .typeOfEducation(userRequestDto.getTypeOfEducation())
                .build();
    }

    public UserResponseDto mapToResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .dateOfBirth(user.getDateOfBirth())
                .isMarried(user.isMarried())
                .typeOfEducation(user.getTypeOfEducation())
                .build();
    }
}