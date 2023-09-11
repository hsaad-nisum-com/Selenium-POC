package Tests;

import Pageobjects.AdminPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class adminTests extends BaseTest {
    AdminPage admin;

    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        admin = new AdminPage(driver);
    }
    @Test(priority = 1)
    public void enterValidLoginCredentialsInInputField() throws InterruptedException {
        admin.enterValidLoginCredentialsInInputField();
        admin.loginBtn();
        admin.idDisplayed();
        admin.clickPagesOnLeftPaneMethod("Admin");
        admin.adminPageValidationMethod();
       // admin.admin_Validation_SelectUserRoleAndClickOnSearch("ESS");
       // admin.admin_Validation_SelectStatusAndClickOnSearch("Enable");
      //  admin.admin_InputEmployeeName_Field();
        admin.addUserButtonTC();
       // admin.saveForm_Validation_WithoutAllRequiredFields("ESS","Enabled");
//        admin.addUser_CancelButton();
//        admin.addUserWithoutInsertRequiredField();
        admin.selectUserRoleFromList("ESS");
        admin.selectEmployeeStatus("Enabled");
        admin.addUserPasswordField("Testing123");
    //    admin.addUser_ValidationOnInvalidPasswordField();
        admin.addUsr_Username_Hint();
        admin.addUsr_Username();
        admin.addUserConfirmPasswordField("Testing123");
        admin.addUser_OldPasswordAndConfirmPasswordShouldBeSame();
        admin.addUserSaveButton();
      //  admin.employeeDeleteFunction("David  Morris");

    }
}
