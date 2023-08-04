package caseStudy.system.menuAdmin;

import caseStudy.service.admin.impl.CategoryManage;
import caseStudy.service.admin.impl.WatchManager;
import caseStudy.service.user.impl.CartManager;

import java.util.Scanner;

public class MenuAdmin {
//    public static void main(String[] args) {


        public  void menuAdmin() {

                try {
                    Scanner scanner = new Scanner(System.in);
                    MenuCategory menuCategory = new MenuCategory();
                    MenuProduct menuProduct = new MenuProduct();
                    CategoryManage categoryManage = CategoryManage.getInstance(scanner);
                    WatchManager productManage = new WatchManager(scanner, categoryManage);
                    CartManager cartManager = new CartManager(scanner, productManage);
                    int choice = 0;
                    do {
                        System.out.println("Menu");
                        System.out.println("1. Menu product");
                        System.out.println("2. Menu category");
                        System.out.println("3. List of people who have made purchases.");
                        System.out.println("0. Exit");
                        System.out.println("Enter your choice: ");
                       choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                menuProduct.menu(productManage);
                                break;
                            case 2:
                                menuCategory.menu();
                                break;
                            case 3 :
                                cartManager.displayAllBillAdmin();
                                break;
                        }
                    } while (choice!= 0);
                } catch (Exception e) {
                    System.out.println();
                }
        }
    }
