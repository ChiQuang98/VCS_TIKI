package VCS_Tiki.pages;

import VCS_Tiki.commons.CommonPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*  ----
 * 	---- Author: DungNT
 */

public class OrderProductsPage extends CommonPageObject {
    @FindBy(xpath = "//h1[@class='title']")
    private WebElementFacade productName;
    @FindBy(xpath = "//p[@class='price']")
    private WebElementFacade productPrice;
    @FindBy(xpath = "//input[@class='input']")
    private WebElementFacade txtQuantity;
    @FindBy(xpath = "//button[@class='btn btn-add-to-cart']")
    private WebElementFacade btnAddToCart;
    @FindBy(xpath = "//a[@class='btn-view-cart']")
    private WebElementFacade btnViewCart;
    @FindBy(xpath = "//a[@class='cart-products__name']")
    private WebElementFacade cartProductName;
    @FindBy(xpath = "//p[@class='cart-products__real-prices']")
    private WebElementFacade cartProductPrice;
    @FindBy(xpath = "//a[@class='cart-products__name']")
    private WebElementFacade cartProductQuantity;
    @FindBy(xpath = "//span[@class='prices__value prices__value--final']")
    private WebElementFacade priceFinal;
    @FindBy(xpath = "//button[contains(text(),'+')]")
    private WebElementFacade iconPlus;

    public String getNameProductInDetailedInfo() {
        waitUntilElementVisible(productName);
        return productName.getText();
    }

    public int formatMoneySeparatedByComma(String value) {
        value = value.replaceAll("[^\\d-]", "");
        return Integer.parseInt(value);
    }

    public String getPriceProduct() {
        waitUntilElementVisible(productPrice);
        return productPrice.getText();
    }

    public int PriceProductInDetailedInfo() {
        return formatMoneySeparatedByComma(getPriceProduct());
    }

    public void addQuantity(String quantity) {
        getHighlightedElement(txtQuantity).click();
        getHighlightedElement(txtQuantity).clear();
        getHighlightedElement(txtQuantity).type(quantity);
    }

    public void clickBtnAddToCart() {
        waitUntilElementVisible(btnAddToCart);
        getHighlightedElement(btnAddToCart).click();
    }

    public void clickBtnViewCart() {
        waitUntilElementVisible(btnViewCart);
        getHighlightedElement(btnViewCart).click();
    }

    public String getCartProductName() {
        waitUntilElementVisible(cartProductName);
        return cartProductName.getText();
    }
    public String getCartProductPrice() {
        waitUntilElementVisible(cartProductPrice);
        return cartProductPrice.getText();
    }
    public int CartProductPrice() {
        return formatMoneySeparatedByComma(getCartProductPrice());
    }
    public String getCartProductQuantity() {
        WebDriverWait wait = new WebDriverWait (getDriver(),40);
        WebElement num = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='qty-input']")));
        String number = num.getAttribute("value");
//        waitABit(10000);
//        waitUntilElementVisible(cartProductQuantity);
//        cartProductQuantity.getAttribute("value");
        return number;
    }
    public int CartProductQuantity() {
        return formatMoneySeparatedByComma(getCartProductQuantity());
    }
    public String getFinalPrice() {
        waitUntilElementVisible(priceFinal);
        return priceFinal.getText();
    }
    public int FinalPrice() {
        return formatMoneySeparatedByComma(getFinalPrice());
    }
    public int calculatePriceValue(){
        int quantity = CartProductQuantity();
        int price = CartProductPrice();
        int priceValue = quantity*price;
        return  priceValue;
    }
}