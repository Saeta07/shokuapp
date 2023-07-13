package com.proyectosena.shokuapp.controller;

import com.proyectosena.shokuapp.dto.NewProductDTO;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.Product;
import com.proyectosena.shokuapp.repository.ProductRepository;
import com.proyectosena.shokuapp.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllUsers() {
        return productRepository.findAll();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getEmployeeList() {
        return new ResponseEntity<>(productService.listProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody final NewProductDTO newProduct) {
        productService.addNewProduct(newProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDishCategory(product.getDishCategory());
            existingProduct.setRollType(product.getRollType());
            existingProduct.setRamenType(product.getRamenType());
            existingProduct.setIngredients(product.getIngredients());
            existingProduct.setDescription(product.getDescription());
            Product updatedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
            log.info("User deleted successfully");
            return ResponseEntity.ok().build();
        } else {
            log.warn(ResourceNotFoundException.MESSAGE);
            throw new ResourceNotFoundException();
        }
    }

}
