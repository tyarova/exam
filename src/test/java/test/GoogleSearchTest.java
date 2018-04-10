package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleSearchResultsPage;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {

    @DataProvider
        public Object[][] searchTerm(){
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"},
                {"Selenium"},
        };
    }

    /**
     * Test that verifies basic Search by specific Search term.
     * Checks if each of the first two pages includes ten search results with search term in title.
     * Expected Result:
     * - Number of search results on page 1 is 10. Each search result contains search term.
     * - Number of search results on page 2 is 10. Each search result contains search term.
     */
    @Test (dataProvider ="searchTerm" )
    public void basicSearchTest(String searchTerm) {
        GoogleSearchResultsPage searchResultsPage = startPage.searchFor(searchTerm);
        Assert.assertTrue(searchResultsPage.isLoaded(),
                "Search results have not been shown");

        List<String> results = searchResultsPage.getResults();

        Assert.assertEquals(results.size(), 10,
                "There are less than 10 results have been found");

        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Search Term " + searchTerm + " not found in title");
        }

        searchResultsPage.switchToSecondSearchResultsPage();
        Assert.assertEquals(searchResultsPage.returnCurrentPage(), "2",
                "Pages do not match");
        Assert.assertEquals(results.size(), 10,
                "There are less than 10 results have been found on the second page");

        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Search Term " + searchTerm + " not found in title");
        }
    }
}
