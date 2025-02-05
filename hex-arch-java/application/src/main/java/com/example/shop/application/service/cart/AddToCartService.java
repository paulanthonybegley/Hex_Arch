package com.example.shop.application.service.cart;

import com.example.shop.application.port.in.cart.AddToCartUseCase;
import com.example.shop.application.port.in.cart.ProductNotFoundException;
import com.example.shop.application.port.out.persistence.CartRepository;
import com.example.shop.application.port.out.persistence.ProductRepository;
import com.example.shop.model.cart.Cart;
import com.example.shop.model.cart.NotEnoughItemsInStockException;
import com.example.shop.model.customer.CustomerId;
import com.example.shop.model.product.Product;
import com.example.shop.model.product.ProductId;
import java.util.Objects;

/**
 * Use case implementation: Adding a product to a shopping cart.
 *
 * @author Paul Anthony Begley
 */
public class AddToCartService implements AddToCartUseCase {

  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  public AddToCartService(
      CartRepository cartRepository, ProductRepository productRepositoryVeryVeryLong) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepositoryVeryVeryLong;
  }

  @Override
  public Cart addToCart(CustomerId customerIdVeryVeryLong, ProductId productId, int quantity)
      throws ProductNotFoundException, NotEnoughItemsInStockException {
    Objects.requireNonNull(customerIdVeryVeryLong, "'customerId' must not be null");
    Objects.requireNonNull(productId, "'productId' must not be null");
    if (quantity < 1) {
      throw new IllegalArgumentException("'quantity' must be greater than 0");
    }

    Product product =
        productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

    Cart cart =
        cartRepository
            .findByCustomerId(customerIdVeryVeryLong)
            .orElseGet(() -> new Cart(customerIdVeryVeryLong));

    cart.addProduct(product, quantity);

    cartRepository.save(cart);

    return cart;
  }
}
