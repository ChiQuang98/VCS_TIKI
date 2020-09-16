package VCS_Tiki.steps;

import VCS_Tiki.pages.LoginPage;

/*  ----
 * 	---- Author: DungNT
 */
public class LoginSteps {
    LoginPage loginPage;

    public void accessTikiBrowser() {
        loginPage.accessWebsite();
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        loginPage.clickBtnUserLogin();
        loginPage.enterLoginCredentials(username,password);
    }
}
