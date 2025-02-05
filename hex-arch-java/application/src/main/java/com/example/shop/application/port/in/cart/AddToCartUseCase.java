package com.example.shop.application.port.in.cart;

import com.example.shop.model.cart.Cart;
import com.example.shop.model.cart.NotEnoughItemsInStockException;
import com.example.shop.model.customer.CustomerId;
import com.example.shop.model.product.ProductId;

/**
 * Use case: Adding a product to a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public interface AddToCartUseCase {

  Cart addToCart(CustomerId customerId, ProductId productId, int quantity)
      throws ProductNotFoundException, NotEnoughItemsInStockException;
}
