package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GoogleStartPage;

public class GoogleBaseTest {

    /**
     * Declaration of WebDriver variable
     */
    WebDriver driver;

    /**
     * Declaration of the reference variable to refer on the object of GoogleStartPage class
     */
    GoogleStartPage startPage;

    /**
     * Chain of calls to run before each test method:
     * 1.downloads the latest version of the WebDriver binary and exports the proper Java system variable
     * 2.creates the driver object, depending on browser type
     * 3.opens environment link
     * 4.creates new object of the GoogleStartPage class
     * @param browserType - the browser(Firefox, Chrome), used for test run. Chrome is set as default browser
     * as it has been passed as parameter by TestNG annotation @Parameters to @BeforeMethod
     * @param envURL - the environment link, used for test run. The link "https://www.google.com/"
     * has been passed as parameter by TestNG annotation @Parameters to @BeforeMethod. Browser opens this link by default.
     */
    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType, @Optional("https://www.google.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Here we can run default browser");
                break;
        }
        driver.get(envURL);
        startPage = new GoogleStartPage(driver);
    }

    /**
     * Chain of calls to run after each test method:
     * Closes browser after test passed/failed
     */
    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}
