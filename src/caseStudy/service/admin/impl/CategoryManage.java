package caseStudy.service.admin.impl;

import caseStudy.io.IOFile;
import caseStudy.model.product.Category;
import caseStudy.service.admin.ICategoryService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryManage implements ICategoryService , IOFile<Category> {
    private final List<Category> categories;
    private final Scanner scanner;
    private final String PATH = "C:\\Users\\min\\IdeaProjects\\Case-Study\\src\\caseStudy\\io\\category.txt";

    private static CategoryManage categoryManage;

    public CategoryManage(Scanner scanner) {
        this.scanner = scanner;
        categories = read(PATH);
    }

    public static CategoryManage getInstance(Scanner scanner) {
        if (categoryManage == null) {
            categoryManage = new CategoryManage(scanner);
        }
        return categoryManage;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void write(List<Category> categories, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(categories);
        } catch (IOException e) {

        }
    }

    @Override
    public List<Category> read(String path) {
        List<Category> categoryList = new ArrayList<>();
        File file = new File(path);
        try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(fileInputStream);
            if (obj.available() != -1) {
                categoryList =(List<Category>) obj.readObject();
            }
        } catch (IOException | ClassCastException | ClassNotFoundException e) {

        }
        return categoryList;
    }

    private Category getCategory() {
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        return new Category(name);
    }

    @Override
    public void create() {
        categories.add(getCategory());
        write(categories, PATH);
        System.out.println("add is success");
        System.out.println("                               -----");
    }

    @Override
    public void update() {
        display();
        System.out.println("Input name want to update");
        String name = scanner.nextLine();
        boolean flag = true ;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(name)) {
                flag = false;
                System.out.println("Input new name: ");
                String newName = scanner.nextLine();
                categories.get(i).setName(newName);
                System.out.println("update is success");
            }
        }
        if (flag) {
            System.out.println("Not exist category have this id!");
        }
        System.out.println("                               -----");
        write(categories, PATH);
    }


    @Override
    public void display() {
        if (!categories.isEmpty()) {
            for (int i = 0; i < categories.size(); i++) {
                System.out.print(i+1);
                System.out.println(categories.get(i));
            }
        } else {
            System.out.println("Not exist category in list!");
        }
        System.out.println("                               -----");
    }

    @Override
    public void delete() {
        System.out.println("Input name want to delete");
        String name = scanner.nextLine();
        boolean flag = true ;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(name)) {
                flag = false;
                categories.remove(i);
                System.out.println("delete is success");
            }
        }
        if (flag) {
            System.out.println("Not exist category have this id!");
        }
        write(categories, PATH);
        System.out.println("                               -----");
    }
}
