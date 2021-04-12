package com.streamliners;

import com.streamliners.models.*;

import java.util.*;

/**
 * The Main class of the project with...
 * @see Main#main(String[])
 */
public class Main {

    public static void main(String[] args) {

        /*
        // Trying Hash Map example
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 123);
        map.put("B", 456);
        map.put("C", 789);

        // return true if "A" exists in the map otherwise false
        System.out.println(map.containsKey("A"));
        */

        // making an object Product
        Product apple = new Product("Apple", "abc.com",0.5f,100),
                orange = new Product("Orange", "abcd.com",0.5f,80),
                kiwi = new Product("Kiwi", "kiwi.com", new ArrayList<>(
                        Arrays.asList(
                                new Variant("500g", 96),
                                new Variant("1Kg", 180)
                        )
                )),
                        surfExcel = new Product("Surf Excel", "surf.com", new ArrayList<>(
                                Arrays.asList(new Variant("1kg", 180))
                        ));

        // trying to add products in the cart
        Cart cart = new Cart();
        cart.add(orange,2.5f);
        cart.add(kiwi, kiwi.variants.get(1));
        cart.add(kiwi, kiwi.variants.get(1));
        cart.add(kiwi, kiwi.variants.get(1));
        cart.add(surfExcel, surfExcel.variants.get(0));
        cart.add(surfExcel, surfExcel.variants.get(0));

        System.out.println(cart);
        System.out.println();

        // trying to remove products in the cart
        cart.remove(orange);

        System.out.println(cart);
        System.out.println();

        // removing one quantity surf excel from the cart
        cart.decrement(surfExcel, surfExcel.variants.get(0));

        System.out.println(cart);
        System.out.println();

        // removing the surf excel from the cart
        cart.decrement(surfExcel, surfExcel.variants.get(0));

        System.out.println(cart);
    }
}
