package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homePage extends AbstractComponents {
    WebDriver driver;
    public homePage(WebDriver driver) {
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

    @FindBy(xpath = "//div[@class='oxd-brand-banner']")
    WebElement leftPaneBanner;



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


    public void clickTopRightDropdown(int value) throws InterruptedException {
        waitForWebElementToAppear(dropdownBtn);
        clickOnDropdownAndClickOnPages(value);
    }
//    public void selectDropdownPages() {
//        waitForWebElementToAppear(selectdropdownPages);
//        selectdropdownPages.click();
//    }

    public void aboutModalValidation(){
        waitForWebElementToAppear(aboutModal);
        String aboutPopupText = aboutModal.getText();
        Assert.assertEquals(aboutPopupText,"About");
    }

}
