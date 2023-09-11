package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class recruitmentPage extends AbstractComponents {
    WebDriver driver;
    public recruitmentPage(WebDriver driver){
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

    @FindBy(xpath = "//h6[text()='Recruitment']")
    WebElement recruitmentTitleTxt;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addUserBtn;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement admin_employee_DeleteRecord;
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
    public void loginBtn() {
        loginBtn.click();
    }
    public void clickPagesOnLeftPaneMethod(String text) throws InterruptedException  {
        clickPagesOnLeftPane(text);
    }
    public void recruitmentPageValidationMethod()  {
       String recruitmentValidationText = recruitmentTitleTxt.getText();
        Assert.assertEquals(recruitmentValidationText,"Recruitment");
    }
    public void recruitment_ClickAddUser(){
        addUserBtn.click();
    }

    public void employeeDeleteFunction(String empName) throws InterruptedException {
        // Delete by trash icon

        admin_employeeName_inputField.sendKeys("Hafiz Saad Mansoor");
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
