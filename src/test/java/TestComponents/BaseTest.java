package TestComponents;

import Pageobjects.landingPage;
import Utility.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BaseTest {

    protected WebDriver driver;

     public landingPage lp;



    public WebDriver initializeDriver() {
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : Utils.getElementFromPropertiesFile("browser", "global");
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Invalid browser specified!");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public landingPage launchApplication() {

        initializeDriver();
        lp = new landingPage(driver);
        lp.goTo();
        return lp;

    }

//    @AfterMethod(alwaysRun = true)
//    public void teardown() {
//        driver.close();
//    }
}


