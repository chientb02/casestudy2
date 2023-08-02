package casestudy.system.menuAdmin;

import casestudy.service.Admin.impl.CategoryManage;

import java.util.Scanner;

public class MenuCategory {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        CategoryManage categoryManage = new CategoryManage(scanner);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Add category");
            System.out.println("2. Update category");
            System.out.println("3. Display all category");
            System.out.println("4. Delete category");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    categoryManage.create();
                    break;
                case 2:
                    categoryManage.update();
                    break;
                case 3:
                    categoryManage.display();
                    break;
                case 4 :
                    categoryManage.delete();
            }
        } while (choice != 0);
    }
}
