package com.streamliners.models;

import java.util.List;

/**
 * represents a variant based product with...
 * variants - list of all {@link Variant} of the product
 */
public class VariantBasedProduct extends Product{

    List<Variant> variants;

    /**
     * Constructor to initialize with all parameters
     *
     * @param name     name of the product
     * @param imageURL URL of the image of the product
     * @param variants list of all {@link Variant} of the product
     */
    public VariantBasedProduct(String name, String imageURL, List<Variant> variants) {
        super(name, imageURL);
        this.variants = variants;
    }

    /**
     * Overriding the method {@link Object#toString()}
     *
     * @return the data of the {@link WeightBasedProduct} class with all parameters
     */
    @Override
    public String toString() {
        return "VariantBasedProduct{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", variants=" + variants +
                '}';
    }
}
