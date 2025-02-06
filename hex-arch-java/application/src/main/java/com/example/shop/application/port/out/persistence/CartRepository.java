package com.example.shop.application.port.out.persistence;

import com.example.shop.model.cart.Cart;
import com.example.shop.model.customer.CustomerId;
import java.util.Optional;

/**
 * Outgoing persistence port for carts.
 *
 * @author Paul Anthony Begley
 */
public interface CartRepository {

  void save(Cart cart);

  Optional<Cart> findByCustomerId(CustomerId customerId);

  void deleteByCustomerId(CustomerId customerId);
}
