package com.streamliners.models;

import java.util.List;
import java.util.Objects;

/**
 * represents a product with...
 *
 * name - name of the product
 * imageURL - URL of image of the product
 * type - whether it is weight based or variant based product
 */
public class Product {

    public String name, imageURL;
    public int type;

    /**
     * fields for the Variant Based Product
     * variants - list of all {@link Variant} of the product
     */
    public List<Variant> variants;

    /**
     * fields for the Weight Based Product
     * minQty - minimum quantity have to purchase at least
     * pricePerKg - price of the product of 1 kg
     */
    float minQty, pricePerKg;

    /**
     * Constructor for the variant based product
     *
     * @param name      name of the product
     * @param imageURL  URL of the image for the product
     * @param variants  list of the variants of the product
     */
    public Product(String name, String imageURL, List<Variant> variants) {
        this.type = ProductType.TYPE_VARIANT_BASED_PRODUCT;
        this.name = name;
        this.imageURL = imageURL;
        this.variants = variants;
    }

    /**
     * Constructor for the weight based product
     *
     * @param name       name of the product
     * @param imageURL   URL of the image for the product
     * @param minQty     minimum quantity must be purchased of the product
     * @param pricePerKg price of the product of 1 kg
     */
    public Product(String name, String imageURL, float minQty, float pricePerKg) {
        this.type = ProductType.TYPE_WEIGHT_BASED_PRODUCT;
        this.name = name;
        this.imageURL = imageURL;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    // /**
    //  * Overriding the method {@link Object#toString()}
    //  *
    //  * @return the data of the {@link Product} class with all parameters
    //  */
    // @Override
    // public String toString() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //
    //     if (this.type == ProductType.TYPE_WEIGHT_BASED_PRODUCT) {
    //         stringBuilder.append("WeightBasedProduct { ");
    //     } else {
    //         stringBuilder.append("VariantBasedProduct { ");
    //     }
    //
    //     stringBuilder.append("name = ").append(this.name);
    //
    //     if (this.type == ProductType.TYPE_WEIGHT_BASED_PRODUCT) {
    //         stringBuilder.append("minQty = ").append(this.minQty);
    //         stringBuilder.append(", pricePerKg = ").append(this.pricePerKg);
    //     } else {
    //         stringBuilder.append(", variants = ").append(this.variants);
    //     }
    //     stringBuilder.append(" } ");
    //
    //     return stringBuilder.toString();
    // }
    //
    // /**
    //  * Overriding the method {@link Object#equals(Object)}
    //  *
    //  * @param o object to compare with
    //  * @return  true when both are same otherwise false
    //  */
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Product product = (Product) o;
    //     return Objects.equals(name, product.name) && Objects.equals(imageURL, product.imageURL);
    // }
    //
    // /**
    //  * Overriding the method {@link Object#hashCode()}
    //  *
    //  * @return integer value of the hash code generated
    //  */
    // @Override
    // public int hashCode() {
    //     return Objects.hash(name, imageURL);
    // }
}
