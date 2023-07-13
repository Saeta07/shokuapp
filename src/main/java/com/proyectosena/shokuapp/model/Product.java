package com.proyectosena.shokuapp.model;

import com.proyectosena.shokuapp.enumeration.DishCategory;
import com.proyectosena.shokuapp.enumeration.RamenType;
import com.proyectosena.shokuapp.enumeration.RollType;
import lombok.*;

import javax.persistence.*;
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @Column(name = "product_id")
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer price;
    @Enumerated(EnumType.STRING)
    @Column(name = "dish_category")
    private DishCategory dishCategory;
    @Enumerated(EnumType.STRING)
    @Column(name = "roll_type")
    private RollType rollType;
    @Enumerated(EnumType.STRING)
    @Column(name = "ramen_type")
    private RamenType ramenType;
    private String ingredients;
    private String description;
    @ManyToOne
    private User appUser;


}
