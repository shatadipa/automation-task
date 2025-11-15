package org.example.pages;

import org.example.models.Product;
import org.example.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private By searchProductInput = By.id("search_product");
    private By searchProductButton = By.id("submit_search");
    private By searchResultItem = By.className("single-products");
    private By addToCartButton = By.cssSelector(".product-overlay .add-to-cart");
    private By viewCartLinkInCartModel = By.cssSelector("#cartModal a[href='/view_cart']");
    private By productName = By.cssSelector(".productinfo p");
    private By productPrice = By.cssSelector(".productinfo h2");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchProduct(String searchQuery){
        sendKeys(searchProductInput, searchQuery);
        click(searchProductButton);
        return this;
    }

    public int getSearchResultItemCount(){
        return driver.findElements(searchResultItem).size();
    }

    public SearchPage addToCart(int index){
        mouseOver(getElements(searchResultItem).get(index));
        getElements(addToCartButton).get(index).click();
        return this;
    }

    public Product getProduct(int index){
        String productName = getProductName(index);
        double productPrice = getProductPrice(index);

        return new Product(productName, productPrice);
    }

    private String getProductName(int index){
        return getElements(productName).get(index).getText();
    }

    private double getProductPrice(int index){
        String priceText = getElements(productPrice).get(index).getText();
        return Utilities.getPriceFromPriceText(priceText);
    }

    public CartPage goToCartPage(){
        click(viewCartLinkInCartModel);
        return new CartPage(driver);
    }
}
