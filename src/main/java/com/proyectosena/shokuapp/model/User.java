package com.proyectosena.shokuapp.model;

import com.proyectosena.shokuapp.enumeration.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

}
