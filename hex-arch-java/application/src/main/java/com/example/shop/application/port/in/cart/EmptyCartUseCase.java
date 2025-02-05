package com.example.shop.application.port.in.cart;

import com.example.shop.model.customer.CustomerId;

/**
 * Use case: Emptying a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public interface EmptyCartUseCase {

  void emptyCart(CustomerId customerId);
}
