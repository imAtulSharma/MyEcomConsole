package com.streamliners.models;

import java.util.Objects;

/**
 * represents a product with...
 * name - name of the product
 * imageURL - URL of image of the product
 */
public class Product {

    public String name, imageURL;

    /**
     * Constructor to initialize product with all parameters
     *
     * @param name     name of the product
     * @param imageURL url of the image of the product
     */
    public Product(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    /**
     * Overriding the method {@link Object#toString()}
     *
     * @return the data of the {@link Product} class with all parameters
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    /**
     * Overriding the method {@link Object#equals(Object)}
     *
     * @param o object to compare with
     * @return  true when both are same otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(imageURL, product.imageURL);
    }

    /**
     * Overriding the method {@link Object#hashCode()}
     *
     * @return integer value of the hash code generated
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, imageURL);
    }
}
