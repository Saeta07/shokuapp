package com.proyectosena.shokuapp.modelo;

import com.proyectosena.shokuapp.enumerado.Cargo;
import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String email;
    @NonNull
    private String cedulaIdentidad;
    @NonNull
    private Cargo cargo;

}
