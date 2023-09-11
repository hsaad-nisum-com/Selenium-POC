package Tests;

import Pageobjects.directoryPage;
import Pageobjects.maintenancePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaintenanceTests extends BaseTest {
    maintenancePage maintenance;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        maintenance = new maintenancePage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        maintenance.enterValidLoginCredentialsInInputField();
        maintenance.loginBtn();
        maintenance.idDisplayed();
        maintenance.clickPagesOnLeftPaneMethod("Maintenance");
        maintenance.maintenancePageValidationMethod();
    }
}
