package com.proyectosena.shokuapp.util;

import com.proyectosena.shokuapp.model.Beverage;
import com.proyectosena.shokuapp.model.Product;
import com.proyectosena.shokuapp.model.User;

public interface IUtils {
    User getUserById(final Long userId);
    Product getProductById(final Long productId);
    Beverage getBeverageById(final Long beverageId);
}
