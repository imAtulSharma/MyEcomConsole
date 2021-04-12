package com.streamliners;

import com.streamliners.models.Product;
import com.streamliners.models.Variant;
import com.streamliners.models.VariantBasedProduct;
import com.streamliners.models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The Main class of the project with...
 * @see Main#main(String[])
 */
public class Main {

    public static void main(String[] args) {

/*
        //  Creating an object of Product class
        Product product = new Product("Apple", "a.bc");
        System.out.println(product);
*/

/*
        //  Getting the null pointer exception error
        Product product1 = new Product();
        System.out.println(product1.name);
        System.out.println(product1.name.toUpperCase());
*/

/*
        // Creating an object of WeightBasedProduct class
        WeightBasedProduct product = new WeightBasedProduct("Apple", "", 1, 100);
        System.out.println(product);
        System.out.println(product.name);
*/

/*
        // Trying the list data type
        List<String> strings = new ArrayList<>(
                Arrays.asList("A", "B", "C")
        );
        System.out.println(strings);
*/

/*
        // creating an object of Variant based product
        VariantBasedProduct product = new VariantBasedProduct(
                "kiwi",
                "abc.com",
                new ArrayList<>(
                        Arrays.asList(new Variant("500g", 90),
                                new Variant("1kg", 180))
                )
        );
        System.out.println(product);
*/

/*
        // Create two objects and check their equality and hash code
        Product a = new Product("a", "");
        Product b = new Product("a", "");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
*/
    }
}
