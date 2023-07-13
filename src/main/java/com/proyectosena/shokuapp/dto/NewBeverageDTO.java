package com.proyectosena.shokuapp.dto;

import com.proyectosena.shokuapp.enumeration.DrinkType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewBeverageDTO {
    private Long id;
    private Integer price;
    private DrinkType drinkType;
    private String flavor;
    private String brand;
    private String ingredients;
    private String description;
}
