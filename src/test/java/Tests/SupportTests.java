package Tests;

import Pageobjects.homePage;
import Pageobjects.supportPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SupportTests extends BaseTest {
    supportPage support ;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        support = new supportPage(driver);
    }

    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        support.enterValidLoginCredentialsInInputField();
        support.loginBtn();
        support.idDisplayed();
        support.clickTopRightDropdown(2);
        support.supportPageValidation();
    }
}
