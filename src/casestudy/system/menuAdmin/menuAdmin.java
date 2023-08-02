package casestudy.system.menuAdmin;

import casestudy.service.Admin.impl.CategoryManage;
import casestudy.service.Admin.impl.WatchManager;

import java.util.Scanner;

public class menuAdmin {
//    public static void main(String[] args) {


        public  void menuUser() {
            do {
                try {
                    Scanner scanner = new Scanner(System.in);
                    MenuCategory menuCategory = new MenuCategory();
                    MenuProduct menuProduct = new MenuProduct();
                    CategoryManage categoryManage = CategoryManage.getInstance(scanner);
                    WatchManager productManage = new WatchManager(scanner, categoryManage);
                    do {
                        System.out.println("Menu");
                        System.out.println("1. Menu product");
                        System.out.println("2. Menu category");
                        System.out.println("0. Exit");
                        System.out.println("Enter your choice: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                menuProduct.menu(productManage);
                                break;
                            case 2:
                                menuCategory.menu();
                                break;
                            case 0:
                                System.exit(0);
                        }
                    } while (true);
                } catch (Exception e) {
                    System.out.println();
                }
            }while (true);
        }
    }
