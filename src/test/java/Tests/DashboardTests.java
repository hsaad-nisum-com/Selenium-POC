package Tests;

import Pageobjects.dashboardPage;
import Pageobjects.performancePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTests extends BaseTest {
    dashboardPage dashboard;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        dashboard = new dashboardPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        dashboard.enterValidLoginCredentialsInInputField();
        dashboard.loginBtn();
        dashboard.idDisplayed();
        dashboard.clickPagesOnLeftPaneMethod("Dashboard");
        dashboard.dashboardPageValidationMethod();
    }
}
