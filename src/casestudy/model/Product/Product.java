package casestudy.model.Product;

import java.io.Serializable;

public class Product implements Serializable {
    private String name ;
    private double price ;
    private double duration ;
    private Category operatingSystem ;
    private double quantity ;

    public Product(String name, double price, double duration, Category operatingSystem, double quantity) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.operatingSystem = operatingSystem;
        this.quantity = quantity;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Category getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(Category operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
