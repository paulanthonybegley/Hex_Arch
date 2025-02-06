package com.example.shop.adapter.in.rest.product;

import com.example.shop.model.money.Money;
import com.example.shop.model.product.Product;

/**
 * Model class for returning a product (in a list ... that's without description) via REST API.
 *
 * @author Paul Anthony Begley
 */
public record ProductInListWebModel(String id, String name, Money price, int itemsInStock) {

  public static ProductInListWebModel fromDomainModel(Product product) {
    return new ProductInListWebModel(
        product.id().value(), product.name(), product.price(), product.itemsInStock());
  }
}
