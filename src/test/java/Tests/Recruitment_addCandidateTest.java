package Tests;

import Pageobjects.recruitmentAddCandidatePage;
import Pageobjects.recruitmentPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class Recruitment_addCandidateTest extends BaseTest {
    recruitmentAddCandidatePage recruitAddCandidate;
    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        recruitAddCandidate = new recruitmentAddCandidatePage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException, AWTException {
        recruitAddCandidate.enterValidLoginCredentialsInInputField();
        recruitAddCandidate.loginBtn();
        recruitAddCandidate.idDisplayed();
        recruitAddCandidate.clickPagesOnLeftPaneMethod("Recruitment");
        recruitAddCandidate.recruitmentPageValidationMethod();
        recruitAddCandidate.recruitment_ClickAddUser();
        recruitAddCandidate.recruitmentAddCandidatePageValidation();
        recruitAddCandidate.recruitmentAddCandidate_addCandidateDetails("Hafiz Saad Mansoor");
       // recruitAddCandidate.recruitmentAddCandidate_uploadFileMethod();

    }

}
