package com.proyectosena.shokuapp.service.impl;

import com.proyectosena.shokuapp.dto.NewBeverageDTO;
import com.proyectosena.shokuapp.exception.ExistingResourceException;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.Beverage;
import com.proyectosena.shokuapp.repository.BeverageRepository;
import com.proyectosena.shokuapp.service.BeverageService;
import com.proyectosena.shokuapp.util.IUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BeverageServiceImpl implements BeverageService {
    private final BeverageRepository beverageRepository;
    private final IUtils utils;
    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    private static final String EXISTING_BEVERAGE_MESSAGE = "Beverage already registered";


    public BeverageServiceImpl(BeverageRepository beverageRepository, IUtils utils) {
        this.beverageRepository = beverageRepository;
        this.utils = utils;
    }

    @Override
    public List<Beverage> beveragesList(){
        logger.info("All Beverages");
        return beverageRepository.findAll();
    }

    @Override
    public void addNewBeverage(final NewBeverageDTO newBeverageDTO){
        logger.info("Insert a new Beverage");
        if(!beverageRepository.existsById(newBeverageDTO.getId())){
            Beverage newBeverage = Beverage.builder()
                    .id(newBeverageDTO.getId())
                    .name(newBeverageDTO.getName())
                    .price(newBeverageDTO.getPrice())
                    .drinkType(newBeverageDTO.getDrinkType())
                    .brand(newBeverageDTO.getBrand())
                    .ingredients(newBeverageDTO.getIngredients())
                    .description(newBeverageDTO.getDescription())
                    .build();

            beverageRepository.save(newBeverage);
            log.info("Beverage successfully created");
        }
        else{
            log.warn("Beverage already registered");
            throw new ExistingResourceException(EXISTING_BEVERAGE_MESSAGE);
        }
    }

    @Override
    @Transactional
    public void updateBeverage(Long id, final Beverage beverage) {

        logger.info("Update a beverage ...");

        Optional<Beverage> beverageDb = beverageRepository.findById(id);

        if (beverageDb.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Beverage beverages = utils.getBeverageById(id);

        beverage.setName(beverage.getName());
        beverage.setPrice(beverage.getPrice());
        beverage.setDrinkType(beverage.getDrinkType());
        beverage.setBrand(beverage.getBrand());
        beverage.setFlavor(beverage.getFlavor());
        beverage.setIngredients(beverage.getIngredients());
        beverage.setDescription(beverage.getDescription());

        log.info("Beverage updated successfully");

    }

    @Override
    public void deleteBeverage(final Long id) {
        try {
            beverageRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }

}
