package com.clients.pharmacy.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String secondName;
    private int dateOfBirth;
    private boolean isMarried;
    private String typeOfEducation;
}
