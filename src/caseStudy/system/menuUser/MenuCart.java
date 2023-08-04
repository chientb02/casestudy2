package caseStudy.system.menuUser;

import caseStudy.model.product.Category;
import caseStudy.service.admin.impl.WatchManager;
import caseStudy.service.user.impl.CartManager;

import java.util.Scanner;

public class MenuCart {
    public  void menuCart(CartManager cartManager) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("My Cart");
        cartManager.display();
        System.out.println("----------------------------------");
        do {
            System.out.println("1. Display cart");
            System.out.println("2. Update to Cart");
            System.out.println("3. proceed To Checkout");
            System.out.println("4. Display purchased orders");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cartManager.display();
                    break;
                case 2:
                    cartManager.update();
                    break;
                case 3:
                    cartManager.proceedToCheckout();
                    break;
                case 4:
                    cartManager.displayBill();
                    break;
                case 5 :
                    cartManager.delete();
                    break;

            }
        } while (choice != 0);
    }
    }

