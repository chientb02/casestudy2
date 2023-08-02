package casestudy.system;

import casestudy.service.Login.Login;

import java.util.Scanner;

public class MainLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        while (true) {
            System.out.println("-----------------------");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 :  login.SignUp();
                            break;
                case 2:
                    boolean flag = login.checkLogin() ;
                    if (flag){
                    System.out.println("login is success");
                }else {
                    System.out.println("login is not success");
                }
                    break;
            }


        }
    }

}
