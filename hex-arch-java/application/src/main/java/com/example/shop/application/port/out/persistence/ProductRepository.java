package com.example.shop.application.port.out.persistence;

import com.example.shop.model.product.Product;

import java.util.List;


/**
 * Outgoing persistence port for products.
 *
 * @author Paul Anthony Begley
 */
public interface ProductRepository {


  List<Product> findByNameOrDescription(String query);
}