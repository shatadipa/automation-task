package org.example.pages;

import org.example.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By productsLink = By.cssSelector("a[href='/products']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(){
        driver.navigate().to(Config.BASE_URL);
        return this;
    }

    public SearchPage clickProductsLink(){
        click(productsLink);
        return new SearchPage(driver);
    }
}
