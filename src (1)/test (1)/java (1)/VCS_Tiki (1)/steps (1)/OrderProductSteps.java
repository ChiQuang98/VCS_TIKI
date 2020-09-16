package VCS_Tiki.steps;

import VCS_Tiki.pages.OrderProductsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

/*  ----
 * 	---- Author: DungNT
 */

public class OrderProductSteps  {
    OrderProductsPage orderProductsPage;
    @Step
    public void verifyDetailedInfoProduct(String name, String price) {
        int priceInt = Integer.parseInt(price);
        Assert.assertEquals(name,orderProductsPage.getNameProductInDetailedInfo());
        Assert.assertEquals(priceInt,orderProductsPage.PriceProductInDetailedInfo());
    }
    @Step
    public void orderProduct(String quantity) {
        orderProductsPage.addQuantity(quantity);
        orderProductsPage.clickBtnAddToCart();
        orderProductsPage.clickBtnViewCart();
        ///Test change
    }
    @Step
    public void verifyProductInCart(String name, String price, String quantity) {
        int priceInt = Integer.parseInt(price);
        Assert.assertEquals(name,orderProductsPage.getCartProductName());
        Assert.assertEquals(priceInt,orderProductsPage.CartProductPrice());
        Assert.assertEquals(quantity,orderProductsPage.getCartProductQuantity());
        Assert.assertEquals(orderProductsPage.FinalPrice(),orderProductsPage.calculatePriceValue());
    }
}
