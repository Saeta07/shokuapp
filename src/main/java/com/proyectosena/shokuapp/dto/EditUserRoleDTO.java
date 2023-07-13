package com.proyectosena.shokuapp.dto;

import com.proyectosena.shokuapp.enumeration.UserRole;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditUserRoleDTO {
    private UserRole userRole;
}
