package com.example.shop.model.cart;

/**
 * An exception indicating that a customer wanted to add more items of a product to the cart than
 * were available.
 *
 * @author Paul Anthony Begley
 */
public class NotEnoughItemsInStockException extends Exception {

    private final int itemsInStock;
  
    public NotEnoughItemsInStockException(String message, int itemsInStock) {
      super(message);
      this.itemsInStock = itemsInStock;
    }
  
    public int itemsInStock() {
      return itemsInStock;
    }
  }
