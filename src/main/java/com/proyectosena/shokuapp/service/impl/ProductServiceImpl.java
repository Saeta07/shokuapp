package com.proyectosena.shokuapp.service.impl;

import com.proyectosena.shokuapp.dto.NewProductDTO;
import com.proyectosena.shokuapp.dto.ProductDTO;
import com.proyectosena.shokuapp.exception.ExistingResourceException;
import com.proyectosena.shokuapp.exception.ResourceNotFoundException;
import com.proyectosena.shokuapp.model.Product;
import com.proyectosena.shokuapp.repository.ProductRepository;
import com.proyectosena.shokuapp.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final IUtils utils;
    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
    private static final String EXISTING_PRODUCT_MESSAGE = "Product already registered";

    public ProductServiceImpl(ProductRepository productRepository, IUtils utils) {
        this.productRepository = productRepository;
        this.utils = utils;
    }

    @Override
    public List<Product> listProducts() {
        logger.info("Retrieval all products...");
        return productRepository.findAll();
    }

    @Override
    public ProductDTO getProductInfo(final Long id) {
        Product product = utils.getProductById(id);

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .dishCategory(product.getDishCategory())
                .rollType(product.getRollType())
                .ramenType(product.getRamenType())
                .ingredients(product.getIngredients())
                .description(product.getDescription())
                .build();
    }

    @Override
    public void addNewProduct(final NewProductDTO newProductDTO) {
        logger.info("Insert a new product ...");
        if (!productRepository.existsById(newProductDTO.getId())) {
            Product newProduct = Product.builder()
                    .id(newProductDTO.getId())
                    .name(newProductDTO.getName())
                    .price(newProductDTO.getPrice())
                    .dishCategory(newProductDTO.getDishCategory())
                    .rollType(newProductDTO.getRollType())
                    .ramenType(newProductDTO.getRamenType())
                    .ingredients(newProductDTO.getIngredients())
                    .description(newProductDTO.getDescription())
                    .build();

            productRepository.save(newProduct);
            log.info("Product created successfully");
        }
        else {
            log.warn("Product already registered");
            throw new ExistingResourceException(EXISTING_PRODUCT_MESSAGE);
        }
    }

    @Override
    @Transactional
    public void updateProduct(Long id, final Product product) {

        logger.info("Update a product ...");

        Optional<Product> productDb = productRepository.findById(id);

        if (productDb.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        Product products = utils.getProductById(id);

        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setDishCategory(product.getDishCategory());
        product.setRollType(product.getRollType());
        product.setRamenType(product.getRamenType());
        product.setIngredients(product.getIngredients());
        product.setDescription(product.getDescription());

        log.info("Product updated successfully");

    }

    @Override
    public void deleteProduct(final Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException();
        }
    }
}
