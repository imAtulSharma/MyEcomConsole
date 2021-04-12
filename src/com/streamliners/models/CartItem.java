package com.streamliners.models;

/**
 * represents Cart Item with...
 *
 * name - name of the item
 * unitPrice - price per unit of the cart item
 * qty - quantity of the item
 */
public class CartItem {
    String name;
    float unitPrice, qty;

    /**
     * Constructor to create cart item with...
     *
     * @param name name of the product
     * @param unitPrice price of the product of unit quantity
     * @param qty quantity of the product
     */
    public CartItem(String name, float unitPrice, float qty) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    /**
     * @return the cost of the item
     */
    public float cost() {
        return unitPrice * qty;
    }

    /**
     * overriding {@link Object#toString()} method
     *
     * @return all data in a formatted string
     */
    @Override
    public String toString() {
        return "\n\t" + name + " ( " +
                String.format("%f X %f = %f", unitPrice, qty, cost()) +
                " )";
    }
}
