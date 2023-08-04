package caseStudy.model.shoppingCart;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 234122996006267687L;
    private String  addressDetails ;
    private String hamlet ;
    private String commune ;
    private String district ;
    private String city ;

    public Address(String addressDetails, String hamlet, String commune, String district, String city) {
        this.addressDetails = addressDetails;
        this.hamlet = hamlet;
        this.commune = commune;
        this.district = district;
        this.city = city;
    }

    public Address() {
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressDetails='" + addressDetails + "\n"  +
                ", hamlet='" + hamlet + "\n"  +
                ", commune='" + commune + "\n"  +
                ", district='" + district + "\n"  +
                ", city='" + city  +
                '}';
    }
}
