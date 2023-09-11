package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class maintenancePage extends AbstractComponents {
    WebDriver driver;

    public maintenancePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//h6[text()='Administrator Access']")
    WebElement maintenanceTitleTxt;

    public void enterValidLoginCredentialsInInputField() {
        validUsername = Utils.getElementFromPropertiesFile("validUsername", "global");
        validPassword = Utils.getElementFromPropertiesFile("validPassword", "global");
        usernameTxt.sendKeys(validUsername);
        passwordTxt.sendKeys(validPassword);
    }

    public void loginBtn() {
        loginBtn.click();
    }

    public void clickPagesOnLeftPaneMethod(String text) throws InterruptedException {
        clickPagesOnLeftPane(text);
    }

    public void maintenancePageValidationMethod() {
        String maintenanceValidationText = maintenanceTitleTxt.getText();
        Assert.assertEquals(maintenanceValidationText, "Administrator Access");
    }
}
