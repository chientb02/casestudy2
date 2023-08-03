package caseStudy.service.user;

import caseStudy.model.shoppingCart.Cart;
import caseStudy.service.IGenerateSerVice;

public interface ICartService extends IGenerateSerVice <Cart> {
    void proceedToCheckout  () ;
    double checkBill () ;
    void displayBill () ;
}
