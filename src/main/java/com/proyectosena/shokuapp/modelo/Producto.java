package com.proyectosena.shokuapp.modelo;

import com.proyectosena.shokuapp.enumerado.CategoriaPlato;
import com.proyectosena.shokuapp.enumerado.TipoBebida;
import com.proyectosena.shokuapp.enumerado.TipoRoll;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private Long id;
    private int precio;
    private CategoriaPlato categoriaPlato;
    private TipoBebida tipoBebida;
    private String sabor;
    private String marca;
    private TipoRoll tipoRoll;
    private List<String> ingredientes;
    @NonNull
    private String descripcion;
    private Boolean vegetariano;
    private Boolean vegano;


}
