package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GoogleBasePage {
    WebDriver driver;

    /**
     * Constructor of GoogleBasePage class which takes Webdriver instance initialized in @BeforeMethod
     * for reuse in GoogleBasePage class methods
     * @param driver - Webdriver instance
     */
    public GoogleBasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Wait until WebElement is Visible on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - the time, that we can set in seconds, to wait for needed element
     * @return WebElement we waited for
     */
    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - the time, that we can set in seconds, to wait for needed element
     * @return WebElement we waited for
     */
    public void waitUntilElementIsClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Returns {@code true} if needed element on Web page has been loaded
     * @return {@code true} if needed element on Web page has been loaded
     */
    public abstract boolean isLoaded();

}
