package Tests;

import Pageobjects.changePasswordPage;
import Pageobjects.logoutPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {
    logoutPage logout ;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        logout = new logoutPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        logout.enterValidLoginCredentialsInInputField();
        logout.loginBtn();
        logout.idDisplayed();
        logout.clickTopRightDropdown(4);
        logout.logoutPageValidation();
    }
}
