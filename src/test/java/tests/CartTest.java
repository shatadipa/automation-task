package tests;

import org.example.models.Product;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private String searchQuery = "Winter";

    @Test
    public void verifyCartShowsCorrectItemAndPrice_WhenAnItemIsAddedToCart() throws InterruptedException {
        homePage = new HomePage(driver).open();
        searchPage = homePage.clickProductsLink();
        searchPage = searchPage.searchProduct(searchQuery);
        int searchResultCount = searchPage.getSearchResultItemCount();
        Reporter.log("Search Result Count: " + searchResultCount);
        Assert.assertTrue(searchResultCount > 0, String.format("No Search Results were found for the search query %s", searchQuery));

        // Add the first item from search result to cart page.
        Product productFromSearchPage = searchPage.getProduct(0);
        searchPage.addToCart(0);
        cartPage = searchPage.goToCartPage();
        Product productFromCartPage = cartPage.getProduct();

        Assert.assertEquals(productFromCartPage.getProductName(), productFromSearchPage.getProductName());
        Assert.assertEquals(productFromCartPage.getProductPrice(), productFromSearchPage.getProductPrice());

        double total = cartPage.getTotal();
        double price = productFromCartPage.getProductPrice();
        int quantity = cartPage.getProductQuantity();
        Assert.assertEquals(total, price*quantity);
    }
}
