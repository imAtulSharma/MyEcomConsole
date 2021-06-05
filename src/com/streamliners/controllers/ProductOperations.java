package com.streamliners.controllers;

import com.streamliners.models.Product;
import com.streamliners.models.ProductType;
import com.streamliners.models.Variant;

import java.util.*;

/**
 * Class to perform certain operations on the product available
 */
public class ProductOperations {
    private final static Scanner scanner = new Scanner(System.in);
    private final HashMap<String, Product> products;

    public ProductOperations(HashMap<String, Product> products) {
        this.products = products;
    }

    /**
     * To add the product in the shop
     */
    public void addProduct() {
        // Displaying the available type of the product
        String menu = "\nSelect type of the product..." +
                "\n0: Go Back" +
                "\n1: Add Weight Based Product" +
                "\n2: Add Variant Based Product" +
                "\nEnter your choice: ";


        int chooseOption = 1;

        // checking to go back from the menu
        while (chooseOption != 0) {
            System.out.print(menu);
            chooseOption = scanner.nextInt();

            // To add weight based product
            if (chooseOption == 1) addWeightBasedProduct();

            // To add variant based product
            else if (chooseOption == 2) addVariantBasedProduct();

            // if user enter any other option
            else if (chooseOption != 0) System.out.println("\u001B[31m" + "ERROR! Incorrect Option. Please select from 0 to 2" + "\u001B[0m");
        }
    }

    /**
     * To edit the product in the shop
     */
    public void editProduct() {
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

            // Array of objects for the name of the available products
            Object[] productNames = products.keySet().toArray();

            // Displaying name of the products available in the shop for purchasing
            for (String key : products.keySet()) {
                System.out.print("\n" + (i++) + ": " + products.get(key).name);
            }

            // Taking response from the user
            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // While user select Go Back the break the loop
            if (chooseOption == 0) break;

            // Index of the product in the product map
            int index = chooseOption - 1;

            // Accessing the product through the key which is accessed from it's index value
            Product product = products.get(productNames[index]);

            // Checking the product type
            if (product.type == ProductType.TYPE_WEIGHT_BASED_PRODUCT) {
                editWeightBasedProduct(product);
            } else if (product.type == ProductType.TYPE_VARIANT_BASED_PRODUCT) {
                editVariantBasedProduct(product);
            }
        }
    }

    /**
     * To delete the product from the shop
     */
    public void deleteProduct() {
        while (true) {
            // Checking for the available products
            if (products.isEmpty()) {
                System.out.print("\u001B[31m" + "\nSorry :( No products available" + "\u001B[0m");
                return;
            }

            // Displaying menu to select product to add in the cart
            System.out.print("\nChoose from the following products..." +
                    "\n0: Go Back");

            // Index of the menu
            int i = 1;

            // Array of objects for the name of the available products
            Object[] productNames = products.keySet().toArray();

            // Displaying name of the products available in the shop for purchasing
            for (String key : products.keySet()) {
                System.out.print("\n" + (i++) + ": " + products.get(key).name);
            }

            // Taking response from the user
            System.out.print("\nPlease enter your response: ");
            int chooseOption = scanner.nextInt();

            // While user select Go Back the break the loop
            if (chooseOption == 0) break;

            // Index of the product in the product map
            int index = chooseOption - 1;

            // Accessing the product through the key which is accessed from it's index value
            products.remove(productNames[index]);
            System.out.println("\u001B[32m" + "DONE! Product deleted successfully." + "\u001B[0m");
        }
    }

    /**
     * To add the weight based product in the shop
     *
     */
    private void addWeightBasedProduct() {
        // Take the name of the product
        System.out.print("\nEnter name of the product: ");

        // Make sure the user enter something
        String name = scanner.nextLine();
        while (name.isEmpty()) name = scanner.nextLine();

        // Key for the product in the products map
        String key = name.toUpperCase();

        // Check if the product already exists in the map
        if (products.containsKey(key)) {
            System.out.println("\u001B[31m" + "ERROR! Product already exists." + "\u001B[0m");
            return;
        }

        inputWeightBasedProduct(key);
    }

    /**
     * To take weight based product details
     * @param key key of the product to add it in map
     */
    private void inputWeightBasedProduct(String key) {
        // Taking other necessary fields
        System.out.print("Enter image URL of the product: ");
        String imageURL = scanner.nextLine();

        System.out.print("Enter minimum quantity of the product: ");
        float minQty = scanner.nextFloat();

        System.out.print("Enter price per kg: ");
        float pricePerKg = scanner.nextFloat();

        products.put(key, new Product(key, imageURL, minQty, pricePerKg));
        System.out.println("\u001B[32m" + "DONE! Product added successfully" + "\u001B[0m");
    }

    /**
     * To add the variant based product in the shop
     *
     */
    private void addVariantBasedProduct() {
        // Take name of the product
        System.out.print("\nEnter name of the product: ");

        String name = scanner.nextLine();
        while (name.isEmpty()) name = scanner.nextLine();

        // Key for the product in the products map
        String key = name.toUpperCase();

        // Check if the product already exists in the map
        if (products.containsKey(key)) {
            System.out.println("\u001B[31m" + "ERROR! Product already exists." + "\u001B[0m");
            return;
        }

        // Taking other necessary fields
        System.out.print("Enter image URL of the product: ");
        String imageURL = scanner.nextLine();

        System.out.print("Enter the variant string of the product: ");
        String variantString = scanner.nextLine();

        // Separate the words enter for the variants
        String[] s = variantString.split(" ");

        // List of the variants added
        List<Variant> variants = new ArrayList<>();

        // Adding variants to the product
        for (int x = 0; x < s.length; x += 2) {
            Variant variant = new Variant(s[x],Float.parseFloat(s[x+1]));
            variants.add(variant);
        }

        // Adding the product in the products map
        products.put(key,new Product(key, imageURL, variants));
        System.out.println("\u001B[32m" + "DONE! Product added successfully" + "\u001B[0m");
    }

    /**
     * To edit weight based product in the shop
     *
     * @param product map of all the products available
     */
    private void editWeightBasedProduct(Product product) {
        // Taking all the field new
        System.out.print("Enter new image URL of the product: ");
        String newImageURL = scanner.nextLine();
        while (newImageURL.isEmpty()) newImageURL = scanner.nextLine();

        System.out.print("Enter new minimum quantity of the product: ");
        float newMinQty = scanner.nextFloat();

        System.out.print("Enter new price per kg: ");
        float newPricePerKg = scanner.nextFloat();

        // Updating the product
        product.imageURL = newImageURL;
        product.minQty = newMinQty;
        product.pricePerKg = newPricePerKg;

        System.out.println("\u001B[32m" + "DONE! Product edit successfully." + "\u001B[0m");
    }

    /**
     * To edit variant based product in the shop
     *
     * @param product map of all the products available
     */
    private void editVariantBasedProduct(Product product) {
        // Taking all the field new
        System.out.print("Enter new image URL of the product: ");
        String newImageURL = scanner.nextLine();
        while (newImageURL.isEmpty()) newImageURL = scanner.nextLine();

        System.out.print("Enter the variant string of the product: ");
        String variantString = scanner.nextLine();

        // Separate the words enter for the variants
        String[] s = variantString.split(" ");

        // List of the variants added
        List<Variant> variants = new ArrayList<>();

        // Adding variants to the product
        for (int x = 0; x < s.length; x += 2) {
            Variant variant = new Variant(s[x],Float.parseFloat(s[x+1]));
            variants.add(variant);
        }

        // Updating the product
        product.imageURL = newImageURL;
        product.variants = variants;

        System.out.println("\u001B[32m" + "DONE! Product edit successfully." + "\u001B[0m");
    }
}
