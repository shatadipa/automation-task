package org.example.pages;

import org.example.models.Product;
import org.example.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartTableRow = By.cssSelector(".cart_info table tbody tr");
    private By productName = By.cssSelector(".cart_description a");
    private By productPrice = By.cssSelector(".cart_price p");
    private By productQuantity = By.cssSelector(".cart_quantity button");
    private By productTotal = By.cssSelector(".cart_total p");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public Product getProduct(){
        String name = getElement(cartTableRow).findElement(productName).getText();
        String priceText = getElement(cartTableRow).findElement(productPrice).getText();
        double price = Utilities.getPriceFromPriceText(priceText);
        return new Product(name, price);
    }

    public double getTotal(){
        String productTotalText = getElement(cartTableRow).findElement(productTotal).getText();
        return Utilities.getPriceFromPriceText(productTotalText);
    }

    public int getProductQuantity(){
        return Integer.parseInt(getElement(cartTableRow).findElement(productQuantity).getText());
    }

}
