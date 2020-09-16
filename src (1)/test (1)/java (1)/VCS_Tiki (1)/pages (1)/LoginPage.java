package VCS_Tiki.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import VCS_Tiki.commons.CommonPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
/*  ----
 * 	---- Author: DungNT
 */
public class LoginPage extends CommonPageObject {
    private String popup ="//*[@id='onesignal-popover-dialog']";
    private String btnConfirm ="//*[@id='onesignal-popover-dialog']";
    @FindBy(xpath = "//*[@id='email']")
    private WebElementFacade txtUsername;
    @FindBy(xpath = "//*[@id='password']")
    private WebElementFacade txtPassword;
    @FindBy(xpath = "//button[text()='Đăng nhập']")
    private WebElementFacade btnLogin;
    @FindBy(xpath = "//*[@class='tikicon icon-user']")
    private WebElementFacade iconLogin;
    @FindBy(xpath = "(//button[contains(text(),'Đăng nhập')])[5]")
    private WebElementFacade btnSubmitLogin;
//    public void accessWebsite() {
//        getDriver().get("https://tiki.vn/");
//        getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        getDriver().manage().window().maximize();
//        waitUntilHTMLReady(50);
//        WebDriverWait wait = new WebDriverWait (getDriver(),50);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='onesignal-popover-dialog']")));
//        skipAds();
//    }
//
//    public void skipAds() {
////        try{
////            getDriver().switchTo().alert().dismiss();
////        }catch(Exception e){
////            System.out.println("unexpected pop up not present");
////        }
////
//        if (getDriver().findElement(By.xpath(popup)).isDisplayed()) {
//                getDriver().findElement(By.xpath(btnConfirm)).click();
//                clickBtnUserLogin();
//            }
//        else
//            return;
//    }
    public void accessWebsite() {
        getDriver().get("https://tiki.vn/");
        getDriver().manage().window().maximize();
        WebDriverWait wait = new WebDriverWait (getDriver(),50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='onesignal-slidedown-dialog']")));
        skipAds();
    }
//<div id="onesignal-slidedown-dialog" class="onesignal-slidedown-dialog"><div id="normal-slidedown"><div class="slidedown-body" id="slidedown-body"><div class="slidedown-body-icon"><img class="default-icon" alt="notification icon" src="data:image/svg+xml,%3Csvg fill='none' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 40 40'%3E%3Cg clip-path='url(%23clip0)'%3E%3Cpath fill-rule='evenodd' clip-rule='evenodd' d='M33.232 28.434a2.5 2.5 0 001.768.733 1.667 1.667 0 010 3.333H5a1.667 1.667 0 110-3.333 2.5 2.5 0 002.5-2.5v-8.104A13.262 13.262 0 0118.333 5.122V1.667a1.666 1.666 0 113.334 0v3.455A13.262 13.262 0 0132.5 18.563v8.104a2.5 2.5 0 00.732 1.767zM16.273 35h7.454a.413.413 0 01.413.37 4.167 4.167 0 11-8.28 0 .417.417 0 01.413-.37z' fill='%23BDC4CB'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0'%3E%3Cpath fill='%23fff' d='M0 0h40v40H0z'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E"></div><div class="slidedown-body-message">Đăng ký nhận ưu đãi và sản phẩm giá tốt nhất hàng ngày tại TIKI</div><div class="clearfix"></div><div id="onesignal-loading-container"></div></div><div class="slidedown-footer" id="slidedown-footer"><button class="align-right primary slidedown-button" id="onesignal-slidedown-allow-button">Nhận ưu đãi</button><button class="align-right secondary slidedown-button" id="onesignal-slidedown-cancel-button">bỏ qua</button><div class="clearfix"></div></div></div></div>
    //Bỏ qua quảng cáo
    public void skipAds() {
        if (getDriver().findElement(By.xpath("//*[@id='onesignal-slidedown-dialog']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//*[@id='onesignal-slidedown-cancel-button']")).click();
        } else return;
    }

    public void clickBtnUserLogin() {
        Actions mouse = new Actions(getDriver());
        mouse.moveToElement(iconLogin).perform();
        waitUntilElementVisible(btnLogin);
        getHighlightedElement(btnLogin).click();
    }
    public void enterLoginCredentials(String username, String password) {
        getHighlightedElement(txtUsername).type(username);
        getHighlightedElement(txtPassword).type(password);
        waitUntilElementVisible(btnSubmitLogin);
        getHighlightedElement(btnSubmitLogin).click();
    }
}
