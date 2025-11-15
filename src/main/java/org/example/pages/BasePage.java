package org.example.pages;

import org.example.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void openUrl(String url) {
        Reporter.log("Opening URL: " + url, true);
        driver.get(url);
    }

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.TIMEOUT_IN_SECONDS));
    }

    public String getTitle(){
        final String title = this.driver.getTitle();
        Reporter.log(String.format("Getting Title From Page: %s", title), true);
        return title;
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Reporter.log("Clicking on: " + by.toString(), true);
        this.driver.findElement(by).click();
    }

    public void sendKeys(By by, String value){
        Reporter.log(String.format("Sending [%s] to: %s", value, by.toString()), true);
        this.driver.findElement(by).sendKeys(value);
    }

    public WebElement getElement(By by){
        return this.driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        return this.driver.findElements(by);
    }

    public void mouseOver(WebElement element){
        Reporter.log("Hovering on: " + element.toString(), true);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
