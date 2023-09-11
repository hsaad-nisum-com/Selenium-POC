package Tests;

import Pageobjects.performancePage;
import Pageobjects.timePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PerformanceTests extends BaseTest {
    performancePage performance;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        performance = new performancePage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        performance.enterValidLoginCredentialsInInputField();
        performance.loginBtn();
        performance.idDisplayed();
        performance.clickPagesOnLeftPaneMethod("Performance");
        performance.performancePageValidationMethod();
    }
}
