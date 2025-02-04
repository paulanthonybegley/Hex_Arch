package com.example.shop.application.port.in.product;


import com.example.shop.model.product.Product;
import java.util.List;

/**
 * Use case: Finding products via a search query.
 *
 * @author Paul Anthony Begley
 */
public interface FindProductsUseCase {

  List<Product> findByNameOrDescription(String query);
}
