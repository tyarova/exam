package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage {

    /**
     * Declaration and initialization of the Web element, that represents search field on the Web page.
     */
    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    /**
     * Constructor of GoogleStartPage class that takes instance from GoogleBasePage class and
     * initialize GoogleStartPage WebElements via PageFactory
     * @param driver - WebDriver instance
     */
    public GoogleStartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verifies that the search field is displayed on the Web page.
     * Visibility of the search field confirms that the Google Start page has been loaded.
     * @return {@code true} if search field on the Google start page has been loaded
     * @throws NoSuchElementException if search field has not been loaded
     */
    @Override
    public boolean isLoaded(){
        boolean isLoaded = false;
        try {
            waitUntilElementIsClickable(searchField, 5);
            isLoaded = searchField.isDisplayed();
        }catch (NoSuchElementException e){
            isLoaded = false;
        } return isLoaded;
    }

    /**
     * Performs search by specific Search term
     * @param searchTerm - data we are searching for
     * @return new object of the GoogleSearchResultsPage class
     */
    public GoogleSearchResultsPage searchFor (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.submit();
        return new GoogleSearchResultsPage(driver);
    }
}
