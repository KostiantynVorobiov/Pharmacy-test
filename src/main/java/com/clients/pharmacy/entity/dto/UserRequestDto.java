package com.clients.pharmacy.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private boolean isMarried;
    private String typeOfEducation;
}
