package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage extends AbstractComponents {
    WebDriver driver;

    String validUsername;

    String validPassword;

    String invalidUsername;

    String loginErrorMessage;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxt;

    @FindBy(xpath = "//section[@id='login']//h2")
    WebElement loginTitleTxt;

    @FindBy(xpath = "//section[@id='appointment']//h2")
    WebElement appointmentTitleTxt;

//    @FindBy(xpath = "//section[@id='login']//div//p[2]")
//    WebElement loginErrorTxt;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement loginErrorTxt;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement loginSuccessfullDisplayMessage;

    public loginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        public void enterValidLoginCredentialsInInputField() {
            validUsername = Utils.getElementFromPropertiesFile("validUsername", "global");
            validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
         //   waitForWebElementToAppear(usernameTxt);
            usernameTxt.sendKeys(validUsername);
         //   waitForWebElementToAppear(passwordTxt);
            passwordTxt.sendKeys(validPassword);
        }

        public void enterInvalidLoginCredentialsInInputField() {
            invalidUsername = Utils.getElementFromPropertiesFile("invalidUsername", "global");
            validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
         //   waitForWebElementToAppear(usernameTxt);
            usernameTxt.sendKeys(invalidUsername);
         //   waitForWebElementToAppear(passwordTxt);
            passwordTxt.sendKeys(validPassword);
        }


        public void loginBtn() {
            loginBtn.click();
        }
        public void idDisplayed(){
            loginSuccessfullDisplayMessage.isDisplayed();
        }
        public void validateErrorMessage(){
            loginErrorMessage = loginErrorTxt.getText();
            Assert.assertEquals(loginErrorMessage,"Invalid credentials");
        }

    }




