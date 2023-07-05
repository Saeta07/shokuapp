package com.proyectosena.shokuapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewUserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
