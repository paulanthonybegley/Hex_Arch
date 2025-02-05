package com.example.shop.application.port.out.persistence;

import com.example.shop.model.product.Product;
import com.example.shop.model.product.ProductId;

import java.util.List;
import java.util.Optional;


/**
 * Outgoing persistence port for products.
 *
 * @author Paul Anthony Begley
 */
public interface ProductRepository {
  void save(Product product);

  Optional<Product> findById(ProductId productId);

  List<Product> findByNameOrDescription(String query);
}