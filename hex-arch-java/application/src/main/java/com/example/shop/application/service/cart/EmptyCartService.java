package com.example.shop.application.service.cart;

import com.example.shop.application.port.in.cart.EmptyCartUseCase;
import com.example.shop.application.port.out.persistence.CartRepository;
import com.example.shop.model.customer.CustomerId;
import java.util.Objects;

/**
 * Use case implementation: Emptying a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public class EmptyCartService implements EmptyCartUseCase {

  private final CartRepository cartRepository;

  public EmptyCartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public void emptyCart(CustomerId customerId) {
    Objects.requireNonNull(customerId, "'customerId' must not be null");

    cartRepository.deleteByCustomerId(customerId);
  }
}