package Tests;

import Pageobjects.Pim_EditEmployeePage;
import TestComponents.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Pim_EditEmployeeTest extends BaseTest {
    Pim_EditEmployeePage pim_addEmployee;
    @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        pim_addEmployee = new Pim_EditEmployeePage(driver);
    }
    @Test(priority = 1)
    public void pim_AddEmpPage_Validation() throws InterruptedException, IOException {
        pim_addEmployee.enterValidLoginCredentialsInInputField();
        pim_addEmployee.loginBtn();
        pim_addEmployee.idDisplayed();
        pim_addEmployee.clickPagesOnLeftPaneMethod("PIM");
      //  pim_addEmployee.pimPageValidationMethod();
     //   pim_addEmployee.pim_ClickAddUser();
       // pim_addEmployee.pimAddEmployeePageValidation();
       // pim_addEmployee.pimAddEmployee_addEmployeeDetails();
        pim_addEmployee.pim_EditInputEmployeeName_Field("ido  orenshtein");


    }
}
