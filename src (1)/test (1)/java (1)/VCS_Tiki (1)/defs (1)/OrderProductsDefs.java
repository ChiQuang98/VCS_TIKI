package VCS_Tiki.defs;

import VCS_Tiki.steps.LoginSteps;
import VCS_Tiki.steps.OrderProductSteps;
import VCS_Tiki.steps.SearchProductSteps;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.When;

/*  ----
 * 	---- Author: DungNT
 */

public class OrderProductsDefs {
    @Steps
    LoginSteps loginStep;
    @Steps
    SearchProductSteps searchProductSteps;
    @Steps
    OrderProductSteps orderProductSteps;
    @Given("I access to Tiki.vn")
    public void iAccessToTiki() {
        loginStep.accessTikiBrowser();
    }

    @When("I login with username is {string} and password is {string}")
    public void iLoginWithUsernameIsAndPasswordIs(String username, String password) {
        loginStep.loginWithUsernameAndPassword(username,password);
    }

    @And("I search product with keyword is {string}")
    public void iSearchProductWithKeywordIs(String keyword) {
        searchProductSteps.searchProduct(keyword);
    }

    @And("I choose product with the ordinal numbers is {string}")
    public void iChooseProductWithTheOrdinalNumbersIs(String number) {
        searchProductSteps.chooseProduct(number);
    }
    @When("I add product to cart with quantity is {string}")
    public void iAddProductToCartWithQuantityIs(String quantity) {
        orderProductSteps.orderProduct(quantity);
    }

    @Then("I should see the product's name is {string},price is {string} and quantity is {string} in cart")
    public void iShouldSeeTheProductSNameIsPriceIsAndQuantityIsInCart(String name, String price, String quantity) {
        orderProductSteps.verifyProductInCart(name,price,quantity);
    }

    @Then("this product will be displayed with corrected {string} and {string} in the screen")
    public void thisProductWillBeDisplayedWithCorrectedAndInTheScreen(String name, String price) {
        orderProductSteps.verifyDetailedInfoProduct(name,price);
    }
}
