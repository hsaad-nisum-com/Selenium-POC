package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin_editUserPage extends AbstractComponents{
    int Actual_number = 0;
    int AfterDelete_number = 0;
    WebDriver driver;

    public Admin_editUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String validUsername;

    String validPassword;

    String invalidUsername;

    String loginErrorMessage;


    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//section[@id='login']//h2")
    WebElement loginTitleTxt;

    @FindBy(xpath = "//section[@id='appointment']//h2")
    WebElement appointmentTitleTxt;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropdownBtn;

    @FindBy(xpath = "//h6[normalize-space()='About']")
    WebElement aboutModal;
    @FindBy(xpath = "//h6[text()='Admin']")
    WebElement adminHeaderText;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addUserBtn;

    @FindBy(xpath = "//h6[text()='Add User']")
    WebElement addUserTitleValidation;

    @FindBy(xpath = "//h6[text()='Add User']")
    WebElement requiredErrorValidation;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;

    @FindBy(xpath = "//button[text()=' Cancel ']")
    WebElement addUserCancelBtn;


    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    WebElement AddUsr_userRoleField;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    WebElement clickOnAddRoleDropdown;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    WebElement clickOnAddStatusDropdown;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement addUserPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement addUserConfirmPassword;


    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement employeeUserNameInputField;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeUserNameHint;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement passwordNotMatchMessage;

    @FindBy(xpath = "(//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"])[1]")
    WebElement passwordAtleast_8characters;

    @FindBy(xpath = "//*[contains(text(),'Admin')]")
    WebElement admin_userRole_dropdown;

    @FindBy(xpath = "//*[contains(text(),'Disable')]")
    WebElement status_userRole_dropdown;

    @FindBy(xpath = ".orangehrm-container .oxd-table-body .oxd-table-card :nth-child(3)")
    WebElement admin_userRole_searchList;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;

    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    WebElement admin_employee_EditRecord;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement admin_employee_DeleteRecord;

    @FindBy(xpath = "//input[@value=\"2\"]")
    WebElement admin_employee_DeleteRecord_2ndCheckbox;

    @FindBy(css = ".orangehrm-horizontal-padding .oxd-text /*[contains(text(),' (50) Records Found')]")
    WebElement admin_employee_TotalRecordFound;

    @FindBy(css = ".oxd-toast-container  .oxd-toast--success ")
    WebElement admin_deleteToasterMessage;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    WebElement admin_ResetEmployeeList;

    public void enterValidLoginCredentialsInInputField() {
        validUsername = Utils.getElementFromPropertiesFile("validUsername", "global");
        validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
        //   waitForWebElementToAppear(usernameTxt);
        usernameTxt.sendKeys(validUsername);
        //   waitForWebElementToAppear(passwordTxt);
        passwordTxt.sendKeys(validPassword);
    }

    public void loginBtn() throws InterruptedException {
        loginBtn.click();
        Thread.sleep(2000);
    }

    public void clickPagesOnLeftPaneMethod(String text) throws InterruptedException {
        clickPagesOnLeftPane(text);
    }

    public void adminPageValidationMethod() {
        String adminValidationText = adminHeaderText.getText();
        Assert.assertEquals(adminValidationText, "Admin");
    }

    public void addUserButtonTC() throws InterruptedException {
        addUserBtn.isDisplayed();
        System.out.println(addUserBtn.getText());
        addUserBtn.click();
        String addUserHeaderText = addUserTitleValidation.getText();
        Assert.assertEquals(addUserHeaderText, "Add User");
        // System.out.println(addUserHeaderText);
        Thread.sleep(2000);
    }

    public void addUserWithoutInsertRequiredField() {
        addUserSaveBtn.click();
        requiredErrorValidation.isDisplayed();
    }

    public void addUser_CancelButton() {
        addUserCancelBtn.click();
        String adminValidationText = adminHeaderText.getText();
        Assert.assertEquals(adminValidationText, "Admin");
    }


    public void selectUserRoleFromList(String userRole) throws InterruptedException {
        clickOnAddRoleDropdown.click();
        waitForWebElementToAppear(clickOnAddRoleDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userRole + "\")]")).click();
        addWait();
    }

    public void selectEmployeeStatus(String userStatus) throws InterruptedException {
        clickOnAddStatusDropdown.click();
        // waitForWebElementToAppear(clickOnAddStatusDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userStatus + "\")]")).click();
        addWait();
    }

    public void addUserPasswordField(String password) throws InterruptedException {
        // addUserPassword.click();
        addUserPassword.sendKeys(password);
    }

    public void addUser_ValidationOnInvalidPasswordField() throws InterruptedException {
        // addUserPassword.click();
        // addUserPassword.sendKeys(password);
        // addWait();
        String validatePassword = addUserPassword.getText();
        if (validatePassword.length() < 8) {
            passwordAtleast_8characters.isDisplayed();
        }
    }

    public void addUserConfirmPasswordField(String confirmPassword) throws InterruptedException {
        // addUserConfirmPassword.click();
        addUserConfirmPassword.sendKeys(confirmPassword);
        addWait();
    }

    public void addUser_OldPasswordAndConfirmPasswordShouldBeSame() throws InterruptedException {
        // addUserConfirmPassword.click();
//        addUserConfirmPassword.sendKeys(confirmPassword);
//        addWait();
        String pass = addUserPassword.getText();
        String Confirf_pass = addUserConfirmPassword.getText();
        Assert.assertEquals(pass, Confirf_pass);
        //  passwordNotMatchMessage.isDisplayed();
    }

    public void addUsr_Username() throws InterruptedException {
        int minValue = 1;
        int maxValue = 100;
        int numberOfRandomNumbers = 10;
        // Create an instance of Random class
        Random random = new Random();
        // Generate and print random numbers using a for loop
        for (int i = 0; i < numberOfRandomNumbers; i++) {
            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            //  employeeUserNameInputField.click();
            employeeUserNameInputField.sendKeys("New test user No  " + randomNumber);
            addWait();
            break;
        }
    }

    public void addUsr_Username_Hint() throws InterruptedException {
        employeeUserNameHint.sendKeys("Russel  Hamilton");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),\"Russel  Hamilton\")]")).click();
        addWait();
    }

    public void addUserSaveButton() throws InterruptedException {
        addUserSaveBtn.click();
        addWait();
    }

    //    public void RandomFunctionExample(){
//            int minValue = 1;
//            int maxValue = 100;
//            int numberOfRandomNumbers = 10;
//            // Create an instance of Random class
//            Random random = new Random();
//            // Generate and print random numbers using a for loop
//            for(int i = 0; i < numberOfRandomNumbers; i++) {
//                int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
//                System.out.println(randomNumber);
//            }
//        }
    public void saveForm_Validation_WithoutAllRequiredFields(String userRole, String userStatus) throws InterruptedException {
        clickOnAddRoleDropdown.click();
        waitForWebElementToAppear(clickOnAddRoleDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userRole + "\")]")).click();
        addWait();

        clickOnAddStatusDropdown.click();
        // waitForWebElementToAppear(clickOnAddStatusDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userStatus + "\")]")).click();
        addWait();

        addUserSaveBtn.click();
        addWait();
        requiredErrorValidation.isDisplayed();
    }

    public void admin_Validation_SelectUserRoleAndClickOnSearch(String userRole) throws InterruptedException {
        clickOnAddRoleDropdown.click();
        waitForWebElementToAppear(clickOnAddRoleDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userRole + "\")]")).click();
        addWait();
        addUserSaveBtn.click();
        addWait();
        //  String U_role = admin_userRole_dropdown.getText();
//        if(admin_userRole_dropdown.isDisplayed()){
//           driver.quit();
//        }
        List<WebElement> myList = driver.findElements(By.cssSelector(".orangehrm-container .oxd-table-body .oxd-table-card :nth-child(3)"));
        // myList.contains("Admin");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println();
            String ls_userROle = myList.get(i).getText();
            Assert.assertEquals(ls_userROle, "ESS");
        }

//        boolean booleanValue = Boolean.parseBoolean(U_role);
//        Assert.assertFalse(booleanValue);
    }

    public void admin_Validation_SelectStatusAndClickOnSearch(String status) throws InterruptedException {
        clickOnAddStatusDropdown.click();
        waitForWebElementToAppear(clickOnAddStatusDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + status + "\")]")).click();
        addWait();
        addUserSaveBtn.click();
        addWait();
        //  String U_role = admin_userRole_dropdown.getText();
//        if(admin_userRole_dropdown.isDisplayed()){
        driver.quit();
//        }
        List<WebElement> myList = driver.findElements(By.cssSelector(".orangehrm-container .oxd-table-body .oxd-table-card :nth-child(5)"));

        for (int i = 0; i < myList.size(); i++) {
            String ls_Status = myList.get(i).getText();
            Assert.assertEquals(ls_Status, "Enabled");
        }
        driver.quit();
    }

    public void admin_EditInputEmployeeName_Field(String empName ) throws InterruptedException {
        admin_employeeName_inputField.sendKeys("Virat  Kohli");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\""+empName+"\")]")).click();
       // driver.findElement(By.xpath("//span[contains(text(),'Paul  Collings')]")).click();
       // driver.findElement(By.cssSelector("[role=\"+option+\"]")).click();

        addWait();
        addUserSaveBtn.click();
        addWait();
        admin_employee_EditRecord.click();
        addWait();
        admin_userRole_dropdown.click();
        driver.findElement(By.xpath("//*[contains(text(),'ESS')]")).click();
        addWait();
//        admin_userRole_dropdown.click();
//        driver.findElement(By.xpath("//*[contains(text(),'Enabled')]")).click();
       // driver.findElement(By.xpath("//*[contains(text(),'Disabled')]")).click();
//        addWait();
        addUserSaveBtn.click();
        addWait();
      //  driver.quit();

    }
    public void getTotalRecordCountsBeforeDelete() throws InterruptedException {
     //   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
//        int Actual_number = 0;
//        int AfterDelete_number = 0;
        String totalRecord = admin_employee_TotalRecordFound.getText();
        String pattern = "\\((\\d+)\\)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(totalRecord);

        while (matcher.find()) {
            String numberInBrackets = matcher.group(1);
            Actual_number = Integer.parseInt(numberInBrackets);
            System.out.println("Found total count before delete : " + Actual_number);
            // System.out.printf(totalRecord);
            addWait();
        }
    }
    public void getTotalRecordCountsAfterDelete() throws InterruptedException {
     //   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
       //   int Actual_number = 0;l
//        int AfterDelete_number = 0;
        String totalRecord = admin_employee_TotalRecordFound.getText();
        String pattern = "\\((\\d+)\\)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(totalRecord);

        while (matcher.find()) {
            String numberInBrackets = matcher.group(1);
            AfterDelete_number = Integer.parseInt(numberInBrackets);
            System.out.println("Found updated count after delete : " + AfterDelete_number);
            // System.out.printf(totalRecord);
            addWait();
        }
        if(Actual_number>AfterDelete_number){
            System.out.printf("Deleted successfully");
        }
        else {
            System.out.printf("deleted failed");
        }
    }
    public void employeeDeleteFunction(String empName) throws InterruptedException {
      //  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        // Delete by trash icon
        admin_employeeName_inputField.sendKeys("Virat  Kohli");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\"" + empName + "\")]")).click();
        //  driver.findElement(By.xpath("//span[contains(text(),'Abdul  Rehman')]")).click();
        // driver.findElement(By.cssSelector("[role=\"+option+\"]")).click();

        addWait();
        addUserSaveBtn.click();
        addWait();

        admin_employee_DeleteRecord.click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
        Thread.sleep(1000);
        if(admin_deleteToasterMessage.isDisplayed()){
            System.out.println("Deleted successfully");
        } else {
            System.out.println("deleted failed");
        }

        addWait();
        admin_ResetEmployeeList.click();
        addWait();
        driver.quit();
    }

        // Delete multiple records by checkbox
//        for ( int i=0;i<4;i++){
//            driver.findElement(By.xpath("//input[@value=\"2\"]")).click();
//        }
    //    driver.findElement(By.xpath("//input[@value=\"2\"]")).click();

//        addWait();
//        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")).click();
//        addWait();
//        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
//        addWait();



}

