package casestudy.service.User;

import casestudy.model.ShoppingCart.Cart;
import casestudy.service.IGenerateSerVice;

public interface ICartService extends IGenerateSerVice <Cart> {
    void proceedToCheckout  () ;

}
