package com.proyectosena.shokuapp.model;

import com.proyectosena.shokuapp.enumeration.DrinkType;
import com.proyectosena.shokuapp.enumeration.RollType;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "beverages")
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    @NonNull
    private Long id;
    @NonNull
    private Integer price;
    @Enumerated(EnumType.STRING)
    @Column(name = "drink_type")
    private DrinkType drinkType;
    private String flavor;
    private String brand;
    @Enumerated(EnumType.STRING)
    @Column(name = "roll_type")
    private RollType rollType;
    private String ingredients;
    private String description;
}
