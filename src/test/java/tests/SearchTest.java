package tests;

import org.example.pages.HomePage;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private HomePage homePage;
    private SearchPage searchPage;
    private String searchQuery = "Winter";

    @Test
    public void verifySearchResultsAppear_WhenSearchedForAProduct() throws InterruptedException {
        homePage = new HomePage(driver).open();
        searchPage = homePage.clickProductsLink();
        searchPage = searchPage.searchProduct(searchQuery);
        int searchResultCount = searchPage.getSearchResultItemCount();

        Assert.assertTrue(searchResultCount>0, String.format("No Search Results were found for the search query %s", searchQuery));
    }

}
