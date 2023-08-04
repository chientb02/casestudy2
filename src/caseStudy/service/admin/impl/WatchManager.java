package caseStudy.service.admin.impl;

import caseStudy.io.IOFile;
import caseStudy.model.product.Category;
import caseStudy.model.product.Product;
import caseStudy.service.admin.IProductService;
import caseStudy.service.login.Login;
import caseStudy.service.user.impl.CartManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WatchManager implements IProductService , IOFile<Product> {
    CartManager cartManager ;
    private final List<Product> products;
    private final Scanner scanner;
    private final caseStudy.service.admin.impl.CategoryManage categoryManage;
    private final String PATH = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\product.txt";

    public WatchManager(Scanner scanner, caseStudy.service.admin.impl.CategoryManage categoryManage) {
        products = read(PATH);
        this.scanner = scanner;
        this.categoryManage = categoryManage;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void write(List<Product> products, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(products);
        } catch (IOException e) {

        }
    }


    @Override
    public List<Product> read(String path) {
        List<Product> productList = new ArrayList<>();
        File file = new File(path);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                productList = (List<Product>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {

        }
        return productList;
    }

    @Override
    public void create() {
    categoryManage.display();
        System.out.println("Input name category ");
        String name = scanner.nextLine();
        boolean flag = false;
        int index = 0 ;
        for (int i = 0; i <  categoryManage.getCategories().size(); i++) {
            if(categoryManage.getCategories().get(i).getName().equals(name)){
                flag = true ;
                index = i ;
        }}
        if(flag) {
            System.out.println("input name");
            String newName = scanner.nextLine();
            System.out.println("input Price");
            double newPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("input Duration");
            double Duration = Double.parseDouble(scanner.nextLine());
            System.out.println("input Quantity");
            double Quantity = Double.parseDouble(scanner.nextLine());
            products.add(new Product(newName,newPrice,Duration,categoryManage.getCategories().get(index),Quantity));
            System.out.println("creat is success");

        }else {
            System.out.println("not have category input");
        }
        write(products, PATH);
        System.out.println("                               -----");
    }

    @Override
    public void update() {
        categoryManage.display();
        System.out.println("Input name category ");
        String name = scanner.nextLine();
        boolean flag = true ;
        for (Product product :products
        ){
            if(product.getOperatingSystem().getName().equals(name)){
                System.out.println(product);
            }
        }
        System.out.println("input name product want to update");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getOperatingSystem().getName().equals(name) && products.get(i).getName().equals(nameProduct)) {
                flag = false;
                System.out.println("Input new name: ");
                products.get(i).setName(scanner.nextLine());
                System.out.println("Input new Price");
                products.get(i).setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Input new Quantity");
                products.get(i).setQuantity(Double.parseDouble(scanner.nextLine()));
                System.out.println("update is success");
            }
        }
        if (flag) {
            System.out.println("Not exist product have this name");
        }
        write(products, PATH);
        System.out.println("                               -----");
    }


    @Override
    public void display() {

        if (!products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                System.out.print(i+1 + ".   ");
                System.out.println(products.get(i));
            }
        } else {
            System.out.println("Not exist product in list!");
        }
        System.out.println("                               -----");

    }


    @Override
    public void delete() {
        categoryManage.display();
        System.out.println("Input name category ");
        String name = scanner.nextLine();
        boolean flag = true ;
        display();
        System.out.println("input name product want to delete");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getOperatingSystem().getName().equals(name) && products.get(i).getName().equals(nameProduct)) {
                flag = false;
               products.remove(i);
                System.out.println("delete is success");
            }
        }
        if (flag) {
            System.out.println("Not exist product have this name");
        }
        write(products, PATH);
        System.out.println("                               -----");
    }

    @Override
    public void displayMaxPrice() {
        if (!products.isEmpty()) {
            double max = products.get(0).getPrice();
            for (Product product : products) {
                if (product.getPrice() > max) {
                    max = product.getPrice();
                }
            }
            for (Product product : products) {
                if (product.getPrice() == max) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("Not exist product in list!");
        }
        System.out.println("                               -----");

    }

    @Override
    public void displayMinPrice() {
        if (!products.isEmpty()) {
            double min = products.get(0).getPrice();
            for (Product product : products) {
                if (product.getPrice() < min) {
                    min = product.getPrice();
                }
            }
            for (Product product : products) {
                if (product.getPrice() == min) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("Not exist product in list!");
        }
        System.out.println("                               -----");

    }

    @Override
    public void searchByName() {
        boolean check = false;
        System.out.println("Input name you want search: ");
        String search = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist product have name contains this word!");
        }
        System.out.println("                               -----");

    }

    @Override
    public void searchByPrice() {
        boolean check = false;
        System.out.println("Input min price you want search: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Input max price you want search: ");
        double max = Double.parseDouble(scanner.nextLine());
        if (min > max) {
            System.out.println("Please input again!");
        } else {
            for (Product product : products) {
                if (product.getPrice() < max && product.getPrice() > min) {
                    System.out.println(product);
                    check = true;
                }
            }
            if (!check) {
                System.out.println("Not exist product have price between your input!");
            }
        }
        System.out.println("                               -----");

    }

    @Override
    public void displayByCategory(Category category) {
        boolean check = false;
        categoryManage.display();
        System.out.println("Input name category you want display: ");
        String categoryName = scanner.nextLine();
        for (Product product : products) {
            if (product.getOperatingSystem().getName().equals(categoryName)) {
                System.out.println(product);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not exist product of your category choice!");
        }

        System.out.println("                               -----");
    }

}
