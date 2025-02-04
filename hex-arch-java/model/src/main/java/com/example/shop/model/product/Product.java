package com.example.shop.model.product;

import com.example.shop.model.money.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A product listed in the shop.
 *
 * @author Paul Anthony Begley
 */
@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class Product {

  private final ProductId id;
  private String name;
  private String description;
  private Money price;
  private int itemsInStock;
}
