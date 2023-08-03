package caseStudy.model.shoppingCart;

import java.io.Serializable;

public class CustomerDetails implements Serializable {
    private String name ;
    private Address address ;
    private String phoneNumber ;

    public CustomerDetails() {
    }

    public CustomerDetails(String name, Address address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "name='" + name + "\n" +
                ", address=" + address +"\n" +
                ", phoneNumber='" + phoneNumber +
                '}';
    }
}
