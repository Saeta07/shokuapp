package com.proyectosena.shokuapp.service;

import com.proyectosena.shokuapp.dto.NewProductDTO;
import com.proyectosena.shokuapp.dto.ProductDTO;
import com.proyectosena.shokuapp.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();

    ProductDTO getProductInfo(Long id);

    void addNewProduct(NewProductDTO newProductDTO);

    void updateProduct(Long id, final Product product);

    void deleteProduct(Long id);
}
