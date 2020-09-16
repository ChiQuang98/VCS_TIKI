package VCS_Tiki.steps;

import VCS_Tiki.commons.CommonPageObject;
import VCS_Tiki.pages.SearchProductsPage;

/*  ----
 * 	---- Author: DungNT
 */

public class SearchProductSteps extends CommonPageObject {
    SearchProductsPage searchProductsPage;

    public void searchProduct(String keyword) {
        searchProductsPage.enterKeyword(keyword);
        searchProductsPage.clickBtnSearch();
        searchProductsPage.tickCheckBox();
    }
    public void chooseProduct(String number) {
       searchProductsPage.chooseProduct(number);

    }
}
