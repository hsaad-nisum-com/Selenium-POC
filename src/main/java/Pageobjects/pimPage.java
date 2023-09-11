package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pimPage extends AbstractComponents {
    WebDriver driver;
    public pimPage(WebDriver driver){
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

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement admin_employee_DeleteRecord;

    @FindBy(xpath = "//input[@value=\"2\"]")
    WebElement admin_employee_DeleteRecord_2ndCheckbox;

    @FindBy(css = ".orangehrm-horizontal-padding .oxd-text /*[contains(text(),' (50) Records Found')]")
    WebElement admin_employee_TotalRecordFound;

    @FindBy(css = ".oxd-toast-container  .oxd-toast--success ")
    WebElement admin_deleteToasterMessage;
    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    WebElement clickOnAddRoleDropdown;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;
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
    public void loginBtn() {
        loginBtn.click();
    }
    public void clickPagesOnLeftPaneMethod(String text) throws InterruptedException  {
        clickPagesOnLeftPane(text);
    }
    public void pimPageValidationMethod() {
       String pimValidationText = pimTitleTxt.getText();
        Assert.assertEquals(pimValidationText,"PIM");
    }
    public void pim_ClickAddUser(){
        addUserBtn.click();
    }
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;

    public void pim_deleteRecord() throws InterruptedException {
        admin_employee_DeleteRecord.click();
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
        Thread.sleep(1000);
        if(admin_deleteToasterMessage.isDisplayed()){
            System.out.println("Deleted successfully");
        } else {
            System.out.println("deleted failed");
        }
    }
    public void pim_selectEmploymentsStatus(String userRole) throws InterruptedException {
        clickOnAddRoleDropdown.click();
        waitForWebElementToAppear(clickOnAddRoleDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\"" + userRole + "\")]")).click();
        addWait();

    }
    public void employeeDeleteFunction(String empName) throws InterruptedException {
        // Delete by trash icon
        admin_employeeName_inputField.sendKeys("may  orenshtein");
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

    }
}
