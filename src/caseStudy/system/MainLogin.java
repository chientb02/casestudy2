package caseStudy.system;

import caseStudy.service.admin.impl.CategoryManage;
import caseStudy.service.admin.impl.WatchManager;
import caseStudy.service.login.Login;
import caseStudy.system.menuAdmin.MenuAdmin;
import caseStudy.system.menuUser.MenuUser;

import java.util.Scanner;

public class MainLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryManage categoryManage = CategoryManage.getInstance(scanner);
        WatchManager productManage = new WatchManager(scanner, categoryManage);
        MenuAdmin admin = new MenuAdmin();
        MenuUser user = new MenuUser();
        Login login = new Login();
        while (true) {
            System.out.println("-----------------------");
            System.out.println("1. SignUp ");
            System.out.println("2. Login ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 :  login.SignUp();
                            break;
                case 2:
                    boolean flag = login.checkLogin() ;
                    if (flag){
                    System.out.println("login is success");
                    if(Login.currentUser.equals("admin")){
                        admin.menuAdmin();
                    }else {
                        user.menuUser(productManage);
                    }
                    }else {
                    System.out.println("login is not success");
                }
                    break;
            }
        }
    }

}
