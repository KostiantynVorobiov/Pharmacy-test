package com.clients.pharmacy.service.mapper;

import com.clients.pharmacy.entity.User;
import com.clients.pharmacy.entity.dto.UserRequestDto;
import com.clients.pharmacy.entity.dto.UserResponseDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public User mapToModel(UserRequestDto userRequestDto) {
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .dateOfBirth(LocalDate.parse(userRequestDto.getDateOfBirth(), formatter))
                .married(userRequestDto.isMarried())
                .typeOfEducation(userRequestDto.getTypeOfEducation())
                .build();
    }

    public UserResponseDto mapToResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth().format(formatter))
                .married(user.isMarried())
                .typeOfEducation(user.getTypeOfEducation())
                .build();
    }
}
