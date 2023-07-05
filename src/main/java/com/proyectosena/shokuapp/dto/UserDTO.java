package com.proyectosena.shokuapp.dto;

import com.proyectosena.shokuapp.enumeration.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private UserRole role;
    private String email;
}
