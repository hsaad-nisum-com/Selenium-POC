package Pageobjects;

import AbstractClass.AbstractComponents;
import Utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class timePage extends AbstractComponents {
    WebDriver driver;
    public timePage(WebDriver driver){
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

    @FindBy(xpath = "//h6[text()='Time']")
    WebElement timeTitleTxt;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement admin_employeeName_inputField;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement addUserSaveBtn;
    @FindBy(css =".orangehrm-container .oxd-table-row--with-border .oxd-table-cell-action-space")
    WebElement employeeList_Viewbutton;


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
    public void timePageValidationMethod()  {
       String timeValidationText = timeTitleTxt.getText();
        Assert.assertEquals(timeValidationText,"Time");
    }
    public void time_employeeSearchFunction(String empName) throws InterruptedException {
        // Delete by trash icon
        admin_employeeName_inputField.sendKeys("Anthony  Nolan");
        addWait();
        driver.findElement(By.xpath("//span[contains(text(),\"" + empName + "\")]")).click();
        //  driver.findElement(By.xpath("//span[contains(text(),'Abdul  Rehman')]")).click();
        // driver.findElement(By.cssSelector("[role=\"+option+\"]")).click();

        addWait();
        addUserSaveBtn.click();
        addWait();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
        addWait();
        employeeList_Viewbutton.click();
        addWait();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
        addWait();
    }
}
