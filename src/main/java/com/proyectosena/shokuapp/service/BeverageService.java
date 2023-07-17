package com.proyectosena.shokuapp.service;

import com.proyectosena.shokuapp.dto.NewBeverageDTO;
import com.proyectosena.shokuapp.model.Beverage;

import java.util.List;

public interface BeverageService {

    List<Beverage> beveragesList();

    void addNewBeverage(NewBeverageDTO newBeverageDTO);

    void updateBeverage(Long id, Beverage beverage);

    void deleteBeverage(Long id);
}
