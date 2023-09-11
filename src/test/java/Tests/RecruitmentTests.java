package Tests;

import Pageobjects.pimPage;
import Pageobjects.recruitmentPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecruitmentTests extends BaseTest {
    recruitmentPage recruitment;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        recruitment = new recruitmentPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        recruitment.enterValidLoginCredentialsInInputField();
        recruitment.loginBtn();
        recruitment.idDisplayed();
        recruitment.clickPagesOnLeftPaneMethod("Recruitment");
        recruitment.recruitmentPageValidationMethod();
        recruitment.employeeDeleteFunction("Hafiz Saad Mansoor");
    }
}
