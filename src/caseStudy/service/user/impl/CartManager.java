package caseStudy.service.user.impl;

import caseStudy.io.IOFile;
import caseStudy.model.shoppingCart.Address;
import caseStudy.model.shoppingCart.Bill;
import caseStudy.model.shoppingCart.CustomerDetails;
import caseStudy.model.shoppingCart.Cart;
import caseStudy.service.admin.impl.WatchManager;
import caseStudy.service.login.Login;
import caseStudy.service.user.ICartService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManager implements ICartService, IOFile<Cart> {
    private final List<Cart> carts;
    private final List<Bill> bills;
    private  List<Cart> listCarts;
    private final Scanner scanner;


    private final String PATH = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\cart.txt";
    private final String PATHBill = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\bill.txt";

    private final WatchManager productManager;

    public CartManager(Scanner scanner ,WatchManager productManager) {
        this.scanner = scanner;
        carts = read(PATH);
        bills = readBill(PATHBill) ;
        this.productManager = productManager;
    }

    @Override
    public void write(List<Cart> carts, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(carts);
        } catch (IOException e) {

        }
    }

    @Override
    public List<Cart> read(String path) {
        List<Cart> cartList = new ArrayList<>();
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                cartList = (List<Cart>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {

        }
        return cartList;
    }
    public void writeBill(List<Bill> bills, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(bills);
        } catch (IOException e) {

        }
    }

    public List<Bill> readBill(String path) {
        List<Bill> billsList = new ArrayList<>();
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                billsList = (List<Bill>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {

        }
        return billsList;
    }

    @Override
    public void create() {
        Double quantityBuy;
        System.out.println("input name product want to buy");
        String nameBuy = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < productManager.getProducts().size(); i++) {
            if (productManager.getProducts().get(i).getName().equals(nameBuy)) {
                System.out.println("input quantity want to buy");
                quantityBuy = Double.parseDouble(scanner.nextLine());
                for (int j = 0; j < carts.size(); j++) {
                    if (carts.get(j).getName().equals(nameBuy));{
                        if(quantityBuy + carts.get(j).getQuantity() <= productManager.getProducts().get(i).getQuantity() ){
                            carts.get(i).setQuantity(quantityBuy + carts.get(j).getQuantity());
                            return;
                        }
                    }
                }
                if (quantityBuy < productManager.getProducts().get(i).getQuantity()) {
                    flag = false;
                    carts.add(new Cart(nameBuy,productManager.getProducts().get(i).getPrice(), quantityBuy, Login.currentUser));
                    System.out.println("Added product to cart successfully.");
                    write(carts, PATH);
                }
            }
        }
        if(flag) {
            System.out.println("Input is not valid.");
        }

    }

    @Override
    public void update() {
    display();
        System.out.println("input name product want to edit");
        String name = scanner.nextLine();
        for (int i = 0; i < carts.size(); i++) {
            if(carts.get(i).getName().equals(name)){
                System.out.println("1. edit quantity");
                System.out.println("2. delete product");
                Integer choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 :
                        System.out.println("input quantity want to edit");
                        Double newQuantity = Double.parseDouble(scanner.nextLine());
                      if (newQuantity == 0 ) {
                          carts.remove(i);
                          break;
                      }
                        carts.get(i).setQuantity(newQuantity);
                      break;
                    case 2 :
                        carts.remove(i) ;
                        break;
                }
            }
        }
        write(carts, PATH);
    }

    @Override
    public void display() {
        for (Cart cart :
                carts) {
            if (cart.getAccount().equals(Login.currentUser)) {
                System.out.println(cart);
            }
        }
        checkBill();
    }

    @Override
    public void delete() {

    }

    @Override
    public void proceedToCheckout() {
        display();
        System.out.println("input name");
        String newName = scanner.nextLine();
        System.out.println("input addressDetails");
        String addressDetails = scanner.nextLine();
        System.out.println("input hamlet");
        String hamlet = scanner.nextLine();
        System.out.println("input commune");
        String commune = scanner.nextLine();
        System.out.println("input district");
        String district = scanner.nextLine();
        System.out.println("input city");
        String city = scanner.nextLine();
        System.out.println("input phoneNumber");
        String phoneNumber = scanner.nextLine();
        CustomerDetails customerDetails = new CustomerDetails(newName,new Address(addressDetails,hamlet,commune,district,city),phoneNumber);
        Bill bill = new Bill(Login.currentUser,listCarts,checkBill(),customerDetails, LocalDate.now());
        bills.add(bill);
        System.out.println(bill);
        writeBill(bills, PATHBill);
        for (int i = 0; i < carts.size(); i++) {
            if(carts.get(i).getAccount().equals(Login.currentUser)){
                for (int j = 0; j < productManager.getProducts().size(); j++) {
                    if(productManager.getProducts().get(j).getName().equals(carts.get(i).getName())){
                        productManager.getProducts().get(j).setQuantity(productManager.getProducts().get(j).getQuantity()-carts.get(i).getQuantity());
                    }
                }

            }
        }
        for (Cart cart :
                carts) {
            if (cart.getAccount().equals(Login.currentUser)){
                carts.remove(cart);
            }
        }
        write(carts, PATH);
        productManager.write(productManager.getProducts(),"C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\product.txt");
        System.out.println("---------------------");
    }

    @Override
    public double checkBill() {
        double total = 0 ;
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getAccount().equals(Login.currentUser)){
                listCarts.add(carts.get(i));
                total += carts.get(i).getQuantity() * carts.get(i).getPrice() ;
            }
        }
        System.out.println("Total payment :" + total);
        return total ;
    }

    @Override
    public void displayBill() {
        for (Bill bill :
                bills) {
            if(bill.getAccount().equals(Login.currentUser)){
                System.out.println(bill);
            }
        }
    }
}