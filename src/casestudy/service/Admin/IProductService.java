package casestudy.service.Admin;

import casestudy.model.Product.Category;
import casestudy.model.Product.Product;
import casestudy.service.IGenerateSerVice;

public interface IProductService extends IGenerateSerVice<Product> {

    void displayMaxPrice();

    void displayMinPrice();

    void searchByName();

    void searchByPrice();

    void displayByCategory(Category category);
}
