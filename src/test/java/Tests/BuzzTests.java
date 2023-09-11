package Tests;

import Pageobjects.buzzPage;
import Pageobjects.leavePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuzzTests extends BaseTest {
    buzzPage buzz;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        buzz = new buzzPage(driver);
    }

    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        buzz.enterValidLoginCredentialsInInputField();
        buzz.loginBtn();
        buzz.idDisplayed();
        buzz.clickPagesOnLeftPaneMethod("Buzz");
        buzz.buzzValidationMethod();
    }
}
