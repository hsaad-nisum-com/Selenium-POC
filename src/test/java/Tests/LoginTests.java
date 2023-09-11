package Tests;

import Pageobjects.loginPage;
import TestComponents.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junit.framework.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;

//@Listeners({TestListener.class})
//@Epic("Regression Tests")
//@Feature("Login Test")
public class LoginTests extends BaseTest {

    loginPage login;

  //  String username;

//    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
//    WebElement username;
//    @FindBy(xpath = "//input[@placeholder='Password']")
//    WebElement userPass;
//    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
//    WebElement userLogin;


//    @Test
//    public static void enterValidLoginCredentialsInInputField(){
  @BeforeMethod(alwaysRun = true)
    public void loginAndSelectHrRole() {
        login = new loginPage(driver);
    }
//    }
    @Test(priority = 1)
    public void enterInvalidLoginCredentialsInInputField(){
      login.enterInvalidLoginCredentialsInInputField();
        login.loginBtn();
        login.validateErrorMessage();

    }
    @Test(priority = 2)
    public void enterValidLoginCredentialsInInputField(){
        login.enterValidLoginCredentialsInInputField();
        login.loginBtn();
       login.idDisplayed();
    }


//    @BeforeMethod(alwaysRun = true)
//    public void loginAndSelectHrRole() {
//        login = new loginPage(driver);
//        login.clickLoginOption();
//    }
//
//    @Test(priority = 1)
//    public void verifyThatTheLoginPageIsDisplayedWhenTheUserClickLoginOption() {
//        login.verifyLoginPageTitle();
//    }
//
//    @Test(priority = 2)
//    public void verifyTheUserEntersValidUsernameAndPasswordThenClickTheLoginButton() {
//        login.enterValidLoginCredentialsInInputField();
//        login.loginBtn();
//        login.verifyMakeAppointmentPageTitle();
//    }
//
//    @Test(priority = 3)
//    public void verifyTheUserEntersInvalidUsernameAndPasswordThenClickTheLoginButton() {
//        login.enterInvalidLoginCredentialsInInputField();
//        login.loginBtn();
//        login.verifyLoginErrorMessage();
//    }
}
