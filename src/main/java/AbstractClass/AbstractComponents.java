package AbstractClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AbstractComponents {
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
    //create ExtentReports and attach reporter(s)
    ExtentReports extent = new ExtentReports();
    JavascriptExecutor javaScriptExecutor;
    WebDriver driver;

    public String getTitle;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javaScriptExecutor = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropdownBtn;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminBtn;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement loginSuccessfullDisplayMessage;

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    /**
     * This method is used to select the option from the sidebar menu
     * @param Option  Click 1 for Home || 2 for Support || 3 for Change password || 4 for Logout
     */
    public void clickOnDropdownAndClickOnPages(int Option) throws InterruptedException {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//ul[@class='oxd-dropdown-menu'] //a[@class='oxd-userdropdown-link'])["+Option+"]")).click();
        Thread.sleep(2000);
    }

    public void clickPagesOnLeftPane(String pageName) throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='"+pageName+"']")).click();
        Thread.sleep(2000);

    }

    //driver.findElement(By.xpath("//ul[@class='oxd-main-menu'] //span[text()='Admin']")).click();
    public void addWait() throws InterruptedException {
        Thread.sleep(2000);
    }
    public void idDisplayed(){
        loginSuccessfullDisplayMessage.isDisplayed();
    }

}
