package Tests;

import Pageobjects.leavePage;
import Pageobjects.pimPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveTests extends BaseTest {
    leavePage leave;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        leave = new leavePage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        leave.enterValidLoginCredentialsInInputField();
        leave.loginBtn();
        leave.idDisplayed();
        leave.clickPagesOnLeftPaneMethod("Leave");
        leave.leavePageValidationMethod();
        leave.leaveSearchByDate();
        leave.leaveSearchByUsername("Anthony  Nolan");
        leave.leaveSearchByStatus("US - Personal");
    }
}
