package com.streamliners.controllers;

import com.streamliners.models.Cart;
import com.streamliners.models.Product;
import com.streamliners.models.ProductType;
import com.streamliners.models.Variant;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class to perform certain operations on the item for the cart
 */
public class CartOperations {
    private final Scanner scanner = new Scanner(System.in);
    private final Cart cart;
    private final HashMap<String, Product> products;

    public CartOperations(Cart cart, HashMap<String, Product> products) {
        this.cart = cart;
        this.products = products;
    }

    /**
         * To add available product in the cart
         */
    public void addItem() {
            // Checking for the available products
            if (products.isEmpty()) {
                System.out.print("\u001B[31m" + "\nSorry :( No products available" + "\u001B[0m");
                return;
            }
            while (true) {
                // Displaying menu to select product to add in the cart
                System.out.print("\nChoose from the following products..." +
                        "\n0: Go Back");

                // Index of the menu
                int i = 1;

                // Displaying name of the products available in the shop for purchasing
                for (String key : products.keySet()) {
                    System.out.print("\n" + (i++) + ": " + products.get(key).name);
                }

                // Taking response from the user
                System.out.print("\nPlease enter your response: ");
                int chooseOption = scanner.nextInt();

                // While user select Go Back the break the loop
                if (chooseOption == 0) break;

                // Trying to add the product in the cart by accessing the index from the menu
                // if FAILED then the user might entered wrong input as displayed in the menu
                try {
                    // Index of the product in the product map
                    int index = chooseOption - 1;

                    addingItem(index);
                    System.out.println("\u001B[32m" + "DONE! Product added into cart successfully." + "\u001B[0m");
                } catch (Exception e) {
                    System.out.print("\u001B[31m" + "\nERROR! wrong input entered." + "\u001B[0m");
                }
            }
        }

    /**
     * To add the product in the cart
     * @param index index of the product to be added
     */
    private void addingItem(int index) {
        int chooseOption;
        // Array of objects for the name of the available products
        Object[] productNames = products.keySet().toArray();

        // Accessing the product through the key which is accessed from it's index value
        Product product = products.get(productNames[index]);

        // Checking for the product type
        if (product.type == ProductType.TYPE_WEIGHT_BASED_PRODUCT) {
            // Taking quantity for the product
            System.out.print("\nPlease enter the quantity of the product: ");
            float qty = scanner.nextFloat();

            // Adding the product in the cart as an item
            cart.add(product, qty);
        } else {
            int j = 1;

            // Displaying variants of the product
            System.out.print("\nChoose Variant to add into cart...");
            for (Variant variant : product.variants) {
                System.out.print("\n" + (j++) + ": " + variant.name + " Rs. " + variant.price);
            }
            System.out.print("\nPlease enter your response: ");
            chooseOption = scanner.nextInt();

            // Index of the variant choose
            index = chooseOption - 1;

            // Accessing the variant through it's index
            Variant variant = product.variants.get(index);

            // Adding the variant based product in the cart
            cart.add(product, variant);
        }
    }

    /**
         * To remove item from the cart
         */
    public void removeItem() {
            while (true) {
                // Displaying the menu to select item to be added
                System.out.print("\nChoose from the following products..." +
                        "\n0: Go Back");

                // Menu index
                int i = 1;

                // Array of the name of the items in the cart
                Object[] itemsName = cart.cartItems.keySet().toArray();
                for (String key : cart.cartItems.keySet()) {
                    System.out.print("\n" + (i++) + ": " + cart.cartItems.get(key).name);
                }

                System.out.print("\nPlease enter your response: ");
                int chooseOption = scanner.nextInt();

                // To go back from the menu
                if (chooseOption == 0) return;

                // trying to remove the product
                // otherwise FAILED then there is no product in the cart with the name entered
                try {
                    // Index to access the cart item to be edited
                    int index = chooseOption - 1;

                    // Get the key to get the product from the product list
                    String[] key = itemsName[index].toString().split(" ");
                    Product product = products.get(key[0]);


                    // Removing the product from the cart
                    cart.remove(product);
                    System.out.println("\u001B[32m" + "DONE! Product removed successfully from cart." + "\u001B[0m");
                    // Return the function when item removed
                    return;
                } catch (Exception e) {
                    System.out.println("\u001B[31m" + "ERROR! wrong input entered." + "\u001B[0m");
                }
            }
        }

    /**
         * To edit item in the cart
         */
    public void editItem() {
            while (true) {
                // Displaying the menu to select item to be added
                System.out.print("\nChoose from the following products..." +
                        "\n0: Go Back");

                // Menu index
                int i = 1;

                // Array of the name of the items in the cart
                Object[] itemsName = cart.cartItems.keySet().toArray();
                for (String key : cart.cartItems.keySet()) {
                    System.out.print("\n" + (i++) + ": " + cart.cartItems.get(key).name);
                }

                System.out.print("\nPlease enter your response: ");
                int chooseOption = scanner.nextInt();

                // To go back from the menu
                if (chooseOption == 0) return;

                // Trying to edit the item
                // otherwise FAILED then the user must enter wrong input
                try {
                    // Index to access the cart item to be edited
                    int index = chooseOption - 1;

                    // Get the key to get the product from the product list
                    String[] key = itemsName[index].toString().split(" ");
                    Product product = products.get(key[0]);

                    // Checking the type of the product
                    if (product.type == ProductType.TYPE_WEIGHT_BASED_PRODUCT) {
                        System.out.print("\nEnter new quantity of the product: ");
                        float qty = scanner.nextFloat();

                        // Add the product in the cart with new quantity the method handle edition on its own
                        cart.add(product, qty);
                    } else {
                        i = 1;

                        // Displaying menu for the variants available for the product
                        System.out.print("\nChoose new Variant...");
                        for (Variant variant : product.variants) {
                            System.out.print("\n" + (i++) + ": " + variant.name + " Rs. " + variant.price);
                        }
                        System.out.print("\nPlease enter your response: ");
                        chooseOption = scanner.nextInt();
                        index = chooseOption - 1;

                        // Variant of the product
                        Variant variant = product.variants.get(index);

                        // removing the product from the cart and adding new product with new quantity
                        cart.remove(product);
                        cart.add(product, variant);
                    }
                    System.out.println("\u001B[32m" + "DONE! Product edited successfully." + "\u001B[0m");
                } catch (Exception e) {
                    System.out.print("\u001B[31m" + "\nERROR! wrong input entered." + "\u001B[0m");
                }
            }
        }
}
