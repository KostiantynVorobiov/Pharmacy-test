package com.clients.pharmacy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean married;
    private String typeOfEducation;
}
