package Tests;

import Pageobjects.pimPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTests extends BaseTest {
    pimPage pim;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        pim = new pimPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        pim.enterValidLoginCredentialsInInputField();
        pim.loginBtn();
        pim.idDisplayed();
        pim.clickPagesOnLeftPaneMethod("PIM");
        pim.pimPageValidationMethod();
       // pim.pim_ClickAddUser();
       // pim.pim_selectEmploymentsStatus("Freelance");
        pim.employeeDeleteFunction("may  orenshtein");
    }

}
