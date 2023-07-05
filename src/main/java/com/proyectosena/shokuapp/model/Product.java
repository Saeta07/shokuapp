package com.proyectosena.shokuapp.model;

import com.proyectosena.shokuapp.enumeration.DishCategory;
import com.proyectosena.shokuapp.enumeration.DrinkType;
import com.proyectosena.shokuapp.enumeration.RollType;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NonNull
    private Long id;
    private int price;
    private DishCategory dishCategory;
    private DrinkType drinkType;
    private String flavor;
    private String brand;
    private RollType rollType;
    private List<String> ingredients;
    @NonNull
    private String description;
    private Boolean vegetarian;
    private Boolean vegan;


}
