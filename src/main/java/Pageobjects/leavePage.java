package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class leavePage extends AbstractComponents {
    WebDriver driver;
    public leavePage(WebDriver driver){
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

    @FindBy(xpath = "//h6[text()='Leave']")
    WebElement leaveTitleTxt;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addCandidateSaveBtn;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;
    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    WebElement clickOnAddStatusDropdown;

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
    public void leavePageValidationMethod()  {
       String leavePageValidationText = leaveTitleTxt.getText();
        Assert.assertEquals(leavePageValidationText,"Leave");
    }
    public void leaveSearchByDate() throws InterruptedException {
        addWait();

        WebElement datePickerInput1 = driver.findElement(By.xpath("//input[@placeholder=\"yyyy-mm-dd\"]"));
        datePickerInput1.click();
        addWait();
        WebElement desiredDate1 = driver.findElement(By.xpath("(//div[@class=\"oxd-calendar-date\"])[1]"));
        desiredDate1.click();
        addWait();
        WebElement datePickerInput2 = driver.findElement(By.xpath("(//input[@placeholder=\"yyyy-mm-dd\"])[2]"));
        datePickerInput2.click();
        addWait();
        WebElement desiredDate2 = driver.findElement(By.xpath("(//div[@class=\"oxd-calendar-date\"])[2]"));
        desiredDate2.click();
        addCandidateSaveBtn.click();
        addWait();
    }
    public void leaveSearchByUsername(String empName) throws InterruptedException {
        admin_employeeName_inputField.sendKeys("Anthony  Nolan");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\"" + empName + "\")]")).click();
        addWait();
        addUserSaveBtn.click();
        addWait();
    }
    public void leaveSearchByStatus(String status) throws InterruptedException {
        clickOnAddStatusDropdown.click();
        waitForWebElementToAppear(clickOnAddStatusDropdown);
        driver.findElement(By.xpath("//*[contains(text(),\""+status+"\")]")).click();
        addWait();
        addUserSaveBtn.click();
        addWait();
    }
}
