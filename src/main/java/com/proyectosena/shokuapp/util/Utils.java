package com.proyectosena.shokuapp.util;

import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.Beverage;
import com.proyectosena.shokuapp.model.Product;
import com.proyectosena.shokuapp.model.User;
import com.proyectosena.shokuapp.repository.BeverageRepository;
import com.proyectosena.shokuapp.repository.ProductRepository;
import com.proyectosena.shokuapp.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Utils implements IUtils {

    private UserRepository userRepository;

    private ProductRepository productRepository;

    private BeverageRepository beverageRepository;

    public User getUserById(final Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public Product getProductById(final Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public Beverage getBeverageById(final Long beverageId){
        Optional<Beverage> beverageOptional = beverageRepository.findById(beverageId);

        if(beverageOptional.isPresent()){
            return beverageOptional.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

}
