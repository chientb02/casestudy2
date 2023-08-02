package casestudy.system.menuAdmin;

import casestudy.model.Product.Category;
import casestudy.service.Admin.impl.WatchManager;

import java.util.Scanner;

public class MenuProduct {
    public void menu(WatchManager productManage) {
        Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Menu");
                System.out.println("1. Add product");
                System.out.println("2. Update product");
                System.out.println("3. Display all product");
                System.out.println("4. Display all product name");
                System.out.println("5. Display all product price min");
                System.out.println("6. Display all product price max");
                System.out.println("7. Display all product price");
                System.out.println("8. Display all product category");
                System.out.println("9. Delete");
                System.out.println("0. Exit");
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        productManage.create();
                        break;
                    case 2:
                        productManage.update();
                        break;
                    case 3:
                        productManage.display();
                        break;
                    case 4:
                        productManage.searchByName();
                        break;
                    case 5:
                        productManage.displayMinPrice();
                        break;
                    case 6:
                        productManage.displayMaxPrice();
                        break;
                    case 7:
                        productManage.searchByPrice();
                        break;
                    case 8:
                        productManage.displayByCategory(new Category());
                        break;
                    case 9:
                        productManage.delete();
                        break;
                }
            } while (choice != 0);
        }
    }
