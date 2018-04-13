package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {

    /**
     * Declaration and initialization of the list of Web elements, that represent search results on the Web page.
     */
    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    /**
     * Declaration and initialization of the Web element, that represents container with search results on the Web page.
     */
    @FindBy(xpath = "//div[@id='res']")
    private WebElement searchResultsContainer;

    /**
     * Declaration and initialization of the Web element, that represents the second page of Google search results.
     */
    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondSearchResultsPage;

    /**
     * Declaration and initialization of the Web element, that represents the current page of Google search results.
     */
    @FindBy(xpath = "//td[@class='cur']")
    private WebElement currentPage;

    /**
     * Constructor of GoogleSearchResultsPage class that takes instance from GoogleBasePage class and
     * initialize GoogleSearchResultsPage WebElements via PageFactory
     * @param driver - WebDriver instance
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Verifies that the block with search results is displayed on the Web page.
     * Visibility of the search results confirms that the Google search results page has been loaded.
     * @return {@code true} if block with search results on the Google search results page has been loaded
     * @throws NoSuchElementException if search results block has not been loaded
     */
    @Override
    public boolean isLoaded(){
        boolean isLoaded = false;
        try {
            waitUntilElementIsVisible(searchResultsContainer, 5);
            isLoaded = searchResultsContainer.isDisplayed();
        }catch (NoSuchElementException e){
            isLoaded = false;
        } return isLoaded;
    }

    /**
     * Switches to second page of search results through the pagination block on the footer
     */
    public void switchToSecondSearchResultsPage(){
        secondSearchResultsPage.click();
    }

    /**
     * Creates the array, that is filled up by search results
     * @return the list of results, triggered by search
     */
    public List<String> getResults() {
        waitUntilElementIsVisible(searchResultsContainer, 5);
        List<String> resultsList = new ArrayList();
        for(WebElement result: searchResults) {
            String elementTitle = result.getText().toLowerCase();
            resultsList.add(elementTitle);
        }
        return resultsList;
    }

    /**
     * Returns the search results current page number
     * @return page number
     */
    public String getCurrentPageNumber(){
        String currentPageNumber = currentPage.getText();
        return currentPageNumber;
    }
}
