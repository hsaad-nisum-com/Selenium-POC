package Tests;

import Pageobjects.pimPage;
import Pageobjects.timePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeTests extends BaseTest {
    timePage time;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        time = new timePage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        time.enterValidLoginCredentialsInInputField();
        time.loginBtn();
        time.idDisplayed();
        time.clickPagesOnLeftPaneMethod("Time");
        time.timePageValidationMethod();
        time.time_employeeSearchFunction("Anthony  Nolan");
    }
}
