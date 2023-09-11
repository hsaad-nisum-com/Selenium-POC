package Tests;

import Pageobjects.changePasswordPage;
import Pageobjects.supportPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTests extends BaseTest {
    changePasswordPage updatePass ;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        updatePass = new changePasswordPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        updatePass.enterValidLoginCredentialsInInputField();
        updatePass.loginBtn();
        updatePass.idDisplayed();
        updatePass.clickTopRightDropdown(3);
        updatePass.changePasswordValidation();
    }
}
