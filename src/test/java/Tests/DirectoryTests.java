package Tests;

import Pageobjects.dashboardPage;
import Pageobjects.directoryPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DirectoryTests extends BaseTest {
    directoryPage directory;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        directory = new directoryPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        directory.enterValidLoginCredentialsInInputField();
        directory.loginBtn();
        directory.idDisplayed();
        directory.clickPagesOnLeftPaneMethod("Directory");
        directory.directoryPageValidationMethod();
    }
}
