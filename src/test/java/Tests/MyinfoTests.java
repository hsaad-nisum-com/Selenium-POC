package Tests;

import Pageobjects.myInfoPage;
import Pageobjects.recruitmentPage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Base64;

public class MyinfoTests extends BaseTest {
    myInfoPage myinfo;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        myinfo = new myInfoPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        myinfo.enterValidLoginCredentialsInInputField();
        myinfo.loginBtn();
        myinfo.idDisplayed();
        myinfo.clickPagesOnLeftPaneMethod("My Info");
        myinfo.myInfoPageValidationMethod();
    }
}
