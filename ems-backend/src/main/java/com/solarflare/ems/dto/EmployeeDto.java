package com.solarflare.ems.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

