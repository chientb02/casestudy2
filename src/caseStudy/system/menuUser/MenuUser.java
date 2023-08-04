package caseStudy.system.menuUser;

import caseStudy.model.product.Category;
import caseStudy.service.admin.impl.WatchManager;
import caseStudy.service.user.impl.CartManager;

import java.util.Scanner;

public class MenuUser {
    public void menuUser(WatchManager productManage) {
        Scanner scanner = new Scanner(System.in);
        CartManager cartManager = new CartManager(scanner , productManage);
        MenuCart menuCart = new MenuCart();
        int choice;
        System.out.println("Welcome to Store");
        System.out.println("--------------------------------------------------");
        do {
            System.out.println("Menu");
            System.out.println("1.  Display all product category");
            System.out.println("2.  Display all product name");
            System.out.println("3.  Display all product price min");
            System.out.println("4.  Display all product price max");
            System.out.println("5.  Display all product price");
            System.out.println("6.  Display all product");
            System.out.println("7.  Display Cart");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayByCategory(new Category());
                    break;
                case 2:
                    productManage.searchByName();
                    break;
                case 3:
                    productManage.displayMinPrice();
                    break;
                case 4:
                    productManage.displayMaxPrice();
                    break;
                case 5:
                    productManage.searchByPrice();
                    break;
                case 6:
                    productManage.display();
                    break;
                case 7:
                    menuCart.menuCart(cartManager);
                    break;
                case 10 :
                    cartManager.create();
            }
        } while (choice != 0);
    }
}
