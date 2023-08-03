package caseStudy.model.shoppingCart;

import java.time.LocalDate;
import java.util.List;

public class Bill {
    private String account ;
    private List<Cart> carts ;
    private double Price ;
    private CustomerDetails customerDetails;
    private LocalDate TimeOfPurchase ;

    public Bill(String account, List<Cart> carts, double price, CustomerDetails customerDetails, LocalDate timeOfPurchase) {
        this.account = account;
        this.carts = carts;
        Price = price;
        this.customerDetails = customerDetails;
        TimeOfPurchase = timeOfPurchase;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Bill() {
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public LocalDate getTimeOfPurchase() {
        return TimeOfPurchase;
    }

    public void setTimeOfPurchase(LocalDate timeOfPurchase) {
        TimeOfPurchase = timeOfPurchase;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "carts=" + carts +"\n"  +
                ", Price=" + Price +"\n"  +
                ", customerDetails=" + customerDetails +"\n"  +
                ", TimeOfPurchase=" + TimeOfPurchase +
                '}';
    }
}
