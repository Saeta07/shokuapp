package com.proyectosena.shokuapp.dto;

import com.proyectosena.shokuapp.enumeration.DishCategory;
import com.proyectosena.shokuapp.enumeration.RamenType;
import com.proyectosena.shokuapp.enumeration.RollType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
    private DishCategory dishCategory;
    private RollType rollType;
    private RamenType ramenType;
    private String ingredients;
    private String description;
}
