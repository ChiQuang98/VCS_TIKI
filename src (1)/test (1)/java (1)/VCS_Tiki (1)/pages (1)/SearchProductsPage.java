package VCS_Tiki.pages;

import VCS_Tiki.commons.CommonPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*  ----
 * 	---- Author: DungNT
 */

public class SearchProductsPage extends CommonPageObject {
    @FindBy(xpath = "//input[@placeholder='Tìm sản phẩm, danh mục hay thương hiệu mong muốn ...']")
    private WebElementFacade txtSearch;
    @FindBy(xpath = "//button[text()='Tìm kiếm']")
    private WebElementFacade btnSearch;
    @FindBy(xpath = "//label[@class='checkbox is-tikinow']//span[@class='ico']")
    private WebElementFacade checkBoxTikiNow;
    @FindBy(xpath = "//div[contains(@class,'product-box-list')]//div[2]//a[1]")
    private WebElementFacade stt;
    @FindBy(xpath = "//div[contains(@class,'product-box-list')]//div[2]//a[1]//span[@class='final-price']")
    private WebElementFacade productPrice;
    @FindBy(xpath = "//div[contains(@class,'product-box-list')]//div[2]//a[1]//span[@class='title']")
    private WebElementFacade productTitle;
    private String iconClose ="//span[@class='tikicon icon-circle-close']";

    public void enterKeyword(String keyword) {
        waitUntilElementInvisible(iconClose);
        waitUntilElementVisible(txtSearch);
//        getHighlightedElement(txtSearch).click();
        getHighlightedElement(txtSearch).type(keyword);
    }
    public void clickBtnSearch(){
        waitUntilElementVisible(btnSearch);
        getHighlightedElement(btnSearch).click();
    }
    public void tickCheckBox(){
        waitUntilElementVisible(checkBoxTikiNow);
        getHighlightedElement(checkBoxTikiNow).click();
    }
    public String getProductPriceInSearchPage(String number){
        WebDriverWait wait = new WebDriverWait (getDriver(),20);
        String str = (getDriver().findElement(By.xpath("//div[contains(@class,'product-box-list')]//div["+number+"]//a[1]//span[@class='final-price']"))).getText();
        str = str.replace(str.substring(str.length()-4), "");
        str = str.replaceAll("[^\\d-]", "");
        String price = str;
        return price;
    }
    public void chooseProduct(String number) {
//        // lấy thông tin sản phẩm muốn chọn ở trang kết quả search
//        WebDriverWait wait = new WebDriverWait (getDriver(),20);
//        String str = (getDriver().findElement(By.xpath("//div[contains(@class,'product-box-list')]//div[1]//a[1]//span[@class='final-price']"))).getText();
//        str = str.replace(str.substring(str.length()-4), "");
//        str = str.replaceAll("[^\\d-]", "");
//        String price = str;
        // lấy thông tin sản phẩm ở trang chi tiết sản phẩm
        WebDriverWait wait1 = new WebDriverWait (getDriver(),20);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-box-list')]//div[" + number + "]//a[1]"))).click();
//        String str1 = (getDriver().findElement(By.xpath("//div[@class='price-and-icon']"))).getText();
//        str1 = str1.replaceAll("[^\\d-]", "");
//        String price1 = str1;
//        return price1;
        // so sánh thông tin sản phẩm ở 2 trang trên
//        Assert.assertEquals(price, price1);

    }

}
