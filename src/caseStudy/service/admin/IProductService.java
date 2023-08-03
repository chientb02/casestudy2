package caseStudy.service.admin;

import caseStudy.model.product.Category;
import caseStudy.model.product.Product;
import caseStudy.service.IGenerateSerVice;

public interface IProductService extends IGenerateSerVice<Product> {

    void displayMaxPrice();

    void displayMinPrice();

    void searchByName();

    void searchByPrice();

    void displayByCategory(Category category);
}
