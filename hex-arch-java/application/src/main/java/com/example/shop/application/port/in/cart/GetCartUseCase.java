package com.example.shop.application.port.in.cart;

import com.example.shop.model.cart.Cart;
import com.example.shop.model.customer.CustomerId;

/**
 * Use case: Retrieving a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public interface GetCartUseCase {

  Cart getCart(CustomerId customerId);
}
