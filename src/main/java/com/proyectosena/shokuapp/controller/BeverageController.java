package com.proyectosena.shokuapp.controller;

import com.proyectosena.shokuapp.dto.NewBeverageDTO;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.Beverage;
import com.proyectosena.shokuapp.repository.BeverageRepository;
import com.proyectosena.shokuapp.service.BeverageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/beverages")
@AllArgsConstructor
@Slf4j
public class BeverageController {
    private final BeverageService beverageService;
    private final BeverageRepository beverageRepository;

    @GetMapping
    public List<Beverage> getAllBeverages() {
        return beverageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beverage> getBeverageById(@PathVariable Long id) {
        Optional<Beverage> optionalBeverage = beverageRepository.findById(id);
        if (optionalBeverage.isPresent()) {
            return ResponseEntity.ok(optionalBeverage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createBeverage(@RequestBody final NewBeverageDTO newBeverage) {
        beverageService.addNewBeverage(newBeverage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beverage> updateProduct(@PathVariable Long id, @RequestBody Beverage beverage) {
        Optional<Beverage> optionalBeverage = beverageRepository.findById(id);
        if (optionalBeverage.isPresent()) {
            Beverage existingBeverage = optionalBeverage.get();
            existingBeverage.setName(beverage.getName());
            existingBeverage.setBrand(beverage.getBrand());
            existingBeverage.setDrinkType(beverage.getDrinkType());
            existingBeverage.setFlavor(beverage.getFlavor());
            existingBeverage.setIngredients(beverage.getIngredients());
            existingBeverage.setDescription(beverage.getDescription());
            Beverage updatedBeverage = beverageRepository.save(existingBeverage);
            return ResponseEntity.ok(updatedBeverage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeverage(@PathVariable Long id) {
        Optional<Beverage> optionalBeverage= beverageRepository.findById(id);
        if (optionalBeverage.isPresent()) {
            beverageRepository.delete(optionalBeverage.get());
            log.info("Beverage deleted successfully");
            return ResponseEntity.ok().build();
        } else {
            log.warn(ResourceNotFoundException.MESSAGE);
            throw new ResourceNotFoundException();
        }
    }
}
