package Tests;

import Pageobjects.homePage;
import Pageobjects.loginPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest {
    homePage home;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        home = new homePage(driver);
    }

    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        home.enterValidLoginCredentialsInInputField();
        home.loginBtn();
        home.idDisplayed();
        home.clickTopRightDropdown(1);
        home.aboutModalValidation();
    }

}
