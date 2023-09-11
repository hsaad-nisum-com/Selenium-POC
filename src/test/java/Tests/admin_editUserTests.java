package Tests;

import Pageobjects.AdminPage;
import Pageobjects.Admin_editUserPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class admin_editUserTests extends BaseTest {
    Admin_editUserPage edit_admin;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        edit_admin = new Admin_editUserPage(driver);
    }
    @Test(priority = 1)
    public void editExistingRecordBySearch() throws InterruptedException {
        edit_admin.enterValidLoginCredentialsInInputField();
        edit_admin.loginBtn();
        edit_admin.idDisplayed();
        edit_admin.clickPagesOnLeftPaneMethod("Admin");
        edit_admin.adminPageValidationMethod();
        // admin.admin_Validation_SelectUserRoleAndClickOnSearch("ESS");
        // admin.admin_Validation_SelectStatusAndClickOnSearch("Enable");
        edit_admin.admin_EditInputEmployeeName_Field("Virat  Kohli");
        edit_admin.getTotalRecordCountsBeforeDelete();
        edit_admin.employeeDeleteFunction("Virat  Kohli");
        edit_admin.getTotalRecordCountsAfterDelete();
        }
    }

