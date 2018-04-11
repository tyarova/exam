package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {

    //ToDo: Add JavaDocs for every WebElement
    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@id='res']")
    private WebElement searchResultsContainer;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondSearchResultsPage;

    @FindBy(xpath = "//td[@class='cur']")
    private WebElement currentPage;

    /**
     * Constructor of GoogleSearchResultsPage class that takes instance from GoogleBasePage class and
     * initialize GoogleSearchResultsPage WebElements via PageFactory
     * @param driver - Webdriver instance ToDo: Fix typo in WebDriver
     */
    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * ToDo: It's not clear in general what is this method for
     * Returns {@code true} if block with search results on the Google search results page has been loaded
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
        List<String> resultsStringList = new ArrayList();
        //ToDo: what's inside variable called x? ;)
        for(WebElement x: searchResults) {
            String elementTitle = x.getText().toLowerCase();
            resultsStringList.add(elementTitle);
        }
        return resultsStringList;
    }

    /**
     * ToDo: What is this? should it be called getCurrentPageNumber() ?
     * Returns the number of the current page of search results
     * @return page number
     */
    public String returnCurrentPage(){
        //ToDo: Should this variable be called currentPageNumber?
        String pageValue = currentPage.getText();
        return pageValue;
    }
}
