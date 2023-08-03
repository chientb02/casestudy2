package casestudy.model.ShoppingCart;

import casestudy.model.login.Account;

import java.io.Serializable;

public class Cart implements Serializable {
    private String name ;
    private double quantity ;
    private String account ;

    public Cart(String name, double quantity, String account) {
        this.name = name;
        this.quantity = quantity;
        this.account = account;
    }

    public Cart() {
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
                ", quantity=" + quantity +
                '}';
    }
}
