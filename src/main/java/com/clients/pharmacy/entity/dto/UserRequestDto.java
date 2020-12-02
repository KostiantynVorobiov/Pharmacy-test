package com.clients.pharmacy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private boolean isMarried;
    private String typeOfEducation;
}
