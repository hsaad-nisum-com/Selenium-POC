package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class recruitmentAddCandidatePage extends AbstractComponents {
    WebDriver driver;
    public recruitmentAddCandidatePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'] ")
    WebElement recruitmentAddCandidatePageHeader;

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

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement recruitmentAddCandidate_addFirstName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    WebElement recruitmentAddCandidate_addMiddleName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement recruitmentAddCandidate_addLastName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement recruitmentAddCandidate_email;

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


    public void recruitmentAddCandidatePageValidation(){
        recruitmentAddCandidatePageHeader.isDisplayed();
}

    public void recruitmentAddCandidate_uploadFileMethod() throws AWTException, InterruptedException {
        addWait();
    System.out.println("Before");
        WebElement fileUploadElement = driver.findElement(By.xpath("//input[@type=\"file\"]"));
    System.out.println("After");
        fileUploadElement.sendKeys("/Users/hsaad/Desktop/Brotherhood/Document.docx");
    System.out.println("End");
    addWait();

}
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addCandidateSaveBtn;

    @FindBy(css = ".oxd-toast-container  .oxd-toast--success ")
    WebElement recruitmentAddCandidate_successToasterMessage;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    WebElement recruitmentCandidateList_employeeName;

    public void recruitmentAddCandidate_addCandidateDetails(String empName) throws InterruptedException {
        recruitmentAddCandidate_addFirstName.sendKeys("Hafiz");
        addWait();
        recruitmentAddCandidate_addMiddleName.sendKeys("Saad");
        addWait();
        recruitmentAddCandidate_addLastName.sendKeys("Mansoor");
        addWait();
        recruitmentAddCandidate_email.sendKeys("test@test.com");
        // file upload method
        addWait();
        System.out.println("Before");
        WebElement fileUploadElement = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        System.out.println("After");
        fileUploadElement.sendKeys("/Users/hsaad/Desktop/Brotherhood/Document.docx");
        addWait();
        System.out.println("End");
        addWait();

        WebElement datePickerInput = driver.findElement(By.xpath("//input[@placeholder=\"yyyy-mm-dd\"]"));
        datePickerInput.click();
        addWait();
        WebElement desiredDate = driver.findElement(By.xpath("(//div[@class=\"oxd-calendar-date\"])[1]"));
        desiredDate.click();


addWait();

        addCandidateSaveBtn.click();
        recruitmentAddCandidate_successToasterMessage.isDisplayed();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
        addWait();
        recruitmentCandidateList_employeeName.sendKeys("Hafiz ");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\""+empName+"\")]")).click();
        addWait();
        addCandidateSaveBtn.click();
    }
}
