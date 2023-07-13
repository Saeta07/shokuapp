package com.proyectosena.shokuapp.dto;

import com.proyectosena.shokuapp.enumeration.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortUserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private UserRole role;
}
