package caseStudy.service.login;

import caseStudy.model.login.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    ArrayList<Account> listAcc = new ArrayList<>();
    public static String currentUser = null;

    public void SignUp () {
        listAcc = readAcc() ;
        System.out.println("input Account");
        String acc = sc.nextLine();
        for (Account account :
                listAcc) {
            if(acc.equals(account.getAccount()) || acc.equals("admin") ){
                System.out.println( "Name not available.");
                return;
            }
        }
        System.out.println("input Password");
        String password = sc.nextLine();
        listAcc.add(new Account(acc,password));
        writeAcc(listAcc);
        System.out.println("SignUp is success");
    }
    public boolean checkLogin() {
        listAcc = readAcc();
        System.out.println("input Account");
        String acc = sc.nextLine();
        System.out.println("input Password");
        String password = sc.nextLine();
        for (int i = 0; i < listAcc.size(); i++) {
            if(listAcc.get(i).getAccount().equals(acc) && listAcc.get(i).getPassword().equals(password) ) {
                currentUser = acc ;
                return true ;
            }
        }
        return false ;
    }

    public static void writeAcc(ArrayList<Account> accounts) {

        try {
            File file = new File("C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\acc.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accounts);
            objectOutputStream.close();
        } catch (IOException e) {

        }
    }

    public static ArrayList<Account> readAcc() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\acc.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            accounts = (ArrayList<Account>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {

        }
        return accounts;
    }


}
