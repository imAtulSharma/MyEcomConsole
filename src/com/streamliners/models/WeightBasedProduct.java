package com.streamliners.models;

/**
 * represents a weight based product with...
 * minQty - minimum quantity have to purchase at least
 * pricePerKg - price of the product of 1 kg
 */
public class WeightBasedProduct extends Product{

    float minQty, pricePerKg;

    /**
     * Constructor to initialize with all parameters
     *
     * @param name       name of the product
     * @param imageURL   url of the image of the product
     * @param minQty     minimum quantity have to purchase at least
     * @param pricePerKg price of the product of 1 kg
     */
    public WeightBasedProduct(String name, String imageURL, float minQty, float pricePerKg) {
        super(name, imageURL);
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    /**
     * Overriding the method {@link Object#toString()}
     *
     * @return the data of the {@link WeightBasedProduct} class with all parameters
     */
    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", minQty=" + minQty +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
