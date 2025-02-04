package com.example.shop.model.customer;

/**
 * A customer ID value object (enabling type-safety and validation).
 *
 * @author Paul Anthony Begley
 */
public record CustomerId(int value) {

  public CustomerId {
    if (value < 1) {
      throw new IllegalArgumentException("'value' must be a positive integer");
    }
  }
}
