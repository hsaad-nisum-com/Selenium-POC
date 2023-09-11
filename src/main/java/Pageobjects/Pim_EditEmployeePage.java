package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class Pim_EditEmployeePage extends AbstractComponents {

    WebDriver driver;
    public Pim_EditEmployeePage(WebDriver  driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    String validUsername;
    String validPassword;


    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//section[@id='login']//h2")
    WebElement loginTitleTxt;

    @FindBy(xpath = "//h6[text()='PIM']")
    WebElement pimTitleTxt;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addUserBtn;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'] ")
    WebElement pimAddEmployeePageHeader;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement pimAddEmployee_addFirstName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    WebElement pimAddEmployee_addMiddleName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement pimAddEmployee_addLastName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement pimAddEmployee_employeeId;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addEmployeeSaveBtn;

    @FindBy(css = ".oxd-toast-container  .oxd-toast--success ")
    WebElement pimAddEmployee_successToasterMessage;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    WebElement pimEmployeeList_employeeName;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus']")
    WebElement pimEmployeeList_uploadImagePlusIcon;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement employeeUserNameInputField;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    WebElement getPimAddEmployee_employeeId;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;
    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    WebElement admin_employee_EditRecord;
    @FindBy(xpath = "//*[contains(text(),'Admin')]")
    WebElement admin_userRole_dropdown;


    public void enterValidLoginCredentialsInInputField() {
        validUsername = Utils.getElementFromPropertiesFile("validUsername", "global");
        validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
        //   waitForWebElementToAppear(usernameTxt);
        usernameTxt.sendKeys(validUsername);
        //   waitForWebElementToAppear(passwordTxt);
        passwordTxt.sendKeys(validPassword);
    }
    public void loginBtn() {
        loginBtn.click();
    }
    public void clickPagesOnLeftPaneMethod(String text) throws InterruptedException  {
        clickPagesOnLeftPane(text);
    }
    public void pimPageValidationMethod() throws InterruptedException {
        String pimValidationText = pimTitleTxt.getText();
        Assert.assertEquals(pimValidationText,"PIM");
        addWait();
        getPimAddEmployee_employeeId.sendKeys("0358");
        addWait();
//        pimEmployeeList_employeeName.sendKeys("Hafiz Saad Mansoor");
//        addWait();
        addEmployeeSaveBtn.click();
    }
    public void pim_ClickAddUser(){
        addUserBtn.click();
    }
    public void pimAddEmployeePageValidation(){
        pimAddEmployeePageHeader.isDisplayed();
    }
        public void pimAddEmployee_addEmployeeDetails() throws InterruptedException {
        pimAddEmployee_addFirstName.sendKeys("Hafiz");
        pimAddEmployee_addMiddleName.sendKeys("Saad");
        pimAddEmployee_addLastName.sendKeys("Mansoor");
            int minValue = 1;
            int maxValue = 100;
            int numberOfRandomNumbers = 10;
            // Create an instance of Random class
            Random random = new Random();
            // Generate and print random numbers using a for loop
            for(int i = 0; i < numberOfRandomNumbers; i++) {
                int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
                //  employeeUserNameInputField.click();
                employeeUserNameInputField.sendKeys("0"+randomNumber);
                addWait();
                break;
            }

      //  pimAddEmployee_employeeId.sendKeys("12345");
        addWait();
            System.out.println("Before:");
            WebElement fileInput = driver.findElement(By.xpath("//input[@type=\"file\"]"));
            System.out.println("After:");
            fileInput.sendKeys("/Users/hsaad/Desktop/dp.jpeg");
            System.out.println("End:");
            addWait();
            addEmployeeSaveBtn.click();
        pimAddEmployee_successToasterMessage.isDisplayed();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        addWait();
            // search by employee id
//            getPimAddEmployee_employeeId.sendKeys("0358");
//        addWait();
        pimEmployeeList_employeeName.sendKeys("Hafiz Saad Mansoor");
        addWait();
        addEmployeeSaveBtn.click();
//

//        pimEmployeeList_uploadImagePlusIcon.sendKeys("Users/hsaad/Download/image (2).png");

    }
    public void pim_EditInputEmployeeName_Field(String empName ) throws InterruptedException {
        admin_employeeName_inputField.sendKeys("ido  orenshtein");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\""+empName+"\")]")).click();
        // driver.findElement(By.xpath("//span[contains(text(),'Paul  Collings')]")).click();
        // driver.findElement(By.cssSelector("[role=\"+option+\"]")).click();

        addWait();
        addUserSaveBtn.click();
        addWait();
        admin_employee_EditRecord.click();
        addWait();
        pimAddEmployee_addFirstName.sendKeys("ab");
        addWait();
        pimAddEmployee_addMiddleName.sendKeys("cd");
        addWait();
        pimAddEmployee_addLastName.sendKeys("e");
        addWait();
        driver.findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")).click();
        addWait();
        driver.quit();

    }

//    public void addUsr_Username() throws InterruptedException {
//        int minValue = 1;
//        int maxValue = 100;
//        int numberOfRandomNumbers = 10;
//        // Create an instance of Random class
//        Random random = new Random();
//        // Generate and print random numbers using a for loop
//        for(int i = 0; i < numberOfRandomNumbers; i++) {
//            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
//            //  employeeUserNameInputField.click();
//            employeeUserNameInputField.sendKeys("New test user No  " + randomNumber);
//            addWait();
//            break;
//        }
//    }
}
