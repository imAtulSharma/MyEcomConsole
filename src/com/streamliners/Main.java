package com.streamliners;

import com.streamliners.controllers.CartOperations;
import com.streamliners.controllers.ProductOperations;
import com.streamliners.models.*;

import java.util.*;

/**
 * The Main class of the project with...
 * @see Main#main(String[])
 */
public class Main {

    public static void main(String[] args) {
        // Map of all the available products
        HashMap<String, Product> products = new HashMap<>();
        // Car object to store items
        Cart cart = new Cart();

        // For operations on products and cart
        ProductOperations productOperations = new ProductOperations(products);
        CartOperations cartOperations = new CartOperations(cart, products);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            // Make a option receiver integer variable
            int chooseOption = scanner.nextInt();

            switch (chooseOption) {
                case 0:
                    System.out.println("\u001B[33m" + "You exit the application." + "\u001B[0m");
                    return;
                case 1:
                    System.out.print("\nYou choose to add a product...");
                    productOperations.addProduct();
                    break;
                case 2:
                    System.out.print("\nYou choose to edit a product...");
                    productOperations.editProduct();
                    break;
                case 3:
                    System.out.print("\nYou choose to delete a product...");
                    productOperations.deleteProduct();
                    break;
                case 4:
                    System.out.println("\u001B[33m" + products.values() + "\u001B[0m");
                    break;
                case 5:
                    System.out.print("\nYou choose to add a product in your cart...");
                    cartOperations.addItem();
                    break;
                case 6:
                    System.out.print("\nYou choose to edit a item in cart...");
                    cartOperations.editItem();
                    break;
                case 7:
                    System.out.print("\nYou choose to delete a item from cart...");
                    cartOperations.removeItem();
                    break;
                case 8:
                    System.out.println("\u001B[33m" + cart + "\u001B[0m");
                    break;
                case 9:
                    System.out.println("\u001B[32m" + "THANK YOU! COME BACK.\nORDER RECEIVED" + "\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31m" + "ERROR! You entered wrong input. Please select from 0 to 9" + "\u001B[0m");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        // Menu Driver
        String optionsMenu = "Select your choice from the given ones..." +
                "\n\n0: To exit the application(cancel order)" +
                "\n1: To add product [ADMIN]" +
                "\n2: To edit product [ADMIN]" +
                "\n3: To delete product [ADMIN]" +
                "\n4: See all products [ADMIN]" +
                "\n\n5: To add product [CUSTOMER]" +
                "\n6: To edit product [CUSTOMER]" +
                "\n7: To remove product from cart [CUSTOMER]" +
                "\n8: To See your cart [CUSTOMER]" +
                "\n9: To place order [CUSTOMER]" +
                "\nPlease enter your choice: ";

        // Print the menu in the console
        System.out.print(optionsMenu);
    }
}
