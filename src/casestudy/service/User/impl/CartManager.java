package casestudy.service.User.impl;

import casestudy.IO.IOFile;
import casestudy.model.Product.Category;
import casestudy.model.ShoppingCart.Cart;
import casestudy.service.Admin.impl.WatchManager;
import casestudy.service.Login.Login;
import casestudy.service.User.ICartService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManager implements ICartService, IOFile<Cart> {
    private final List<Cart> carts;
    private final Scanner scanner;
    private final String PATH = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\casestudy\\IO\\Cart.txt";
    private final String PATHBill = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\casestudy\\IO\\Bill.txt";

    private final WatchManager productManager;

    public CartManager(Scanner scanner, WatchManager productManager) {
        this.scanner = scanner;
        carts = read(PATH);
        this.productManager = productManager;
    }

    @Override
    public void write(List<Cart> carts, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(carts);
        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return cartList;
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
                    carts.add(new Cart(nameBuy, quantityBuy, Login.currentUser));
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
    }

    @Override
    public void display() {
        for (Cart cart :
                carts) {
            if (cart.getAccount().equals(Login.currentUser)) {
                System.out.println(cart);
            }
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void proceedToCheckout() {

    }


}
