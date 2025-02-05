package com.example.shop.application.service.cart;

import com.example.shop.application.port.in.cart.GetCartUseCase;
import com.example.shop.application.port.out.persistence.CartRepository;
import com.example.shop.model.cart.Cart;
import com.example.shop.model.customer.CustomerId;
import java.util.Objects;

/**
 * Use case implementation: Retrieving a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public class GetCartService implements GetCartUseCase {

  private final CartRepository cartRepository;

  public GetCartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart getCart(CustomerId customerIdVeryLong) {
    Objects.requireNonNull(customerIdVeryLong, "'customerId' must not be null");

    return cartRepository
        .findByCustomerId(customerIdVeryLong)
        .orElseGet(() -> new Cart(customerIdVeryLong));
  }
}
