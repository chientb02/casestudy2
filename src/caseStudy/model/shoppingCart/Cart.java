package caseStudy.model.shoppingCart;

import java.io.Serializable;

public class Cart implements Serializable {
    private static final long serialVersionUID = 234122996006267687L;
    private String name ;
    private double price;
    private double quantity ;
    private String account ;

    public Cart(String name, double price, double quantity, String account) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.account = account;
    }

    public Cart() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
