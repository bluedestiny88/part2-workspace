/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.Location;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.USATax;
import java.util.Collection;

public class Order {

  private double totalCost;
  private String id;
  Location consumerLocation;

  public Order(String id) {
    this.id = id;
  }




  /**
   * DONE: get the items from the cart and iterate over them, print each item's product code get
   * cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");

    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    System.out.println("Order Total: " + cart.total());
    totalCost = cart.total();
  }

  public String getId() {
    return id;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public double getTax() {
    TaxCalculator taxes;
    double taxAmount = 0;
    switch (consumerLocation) {
      case USA:
        taxes = new USATax();
        taxAmount = taxes.taxAmount(totalCost);
        break;
      case EUROPE:
        taxes = new EuropeTax();
        taxAmount = taxes.taxAmount(totalCost);
        break;
      default:
        taxes = new OnlineTax();
        taxAmount = taxes.taxAmount(totalCost);
    }
    return taxAmount;
  }
}

