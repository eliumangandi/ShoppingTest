package shoppingtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shoppingtest.locate.LocatorShop;

import java.util.List;

/*
   This class provides methods to use selenium webdriver
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class WebDriverActions {

    public WebDriver driver = null;

    public WebDriverActions(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /*
        this method move mouse to specific element
        @param driver WebDriver object
        @param element WebElement object
         */
    public void elementMouseHover( WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    /*
    this method enables wait for an element to be visible
    @param driver WebDriver object
    @param element WebElement object
     */
    public void waitForElement( WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    /*
    this method executes Script action
    @param driver WebDriver object
    @param element WebElement object
     */
    public void scriptExecutor( WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }


    /*
    this method returns the driver to home page
    @param driver WebDriver object
     */
    public void returnHome(String url ){
        driver.navigate().to( url );
    }


    /*
    this method scroll down the page
    @param driver WebDriver object
    @param position integer number
    @return String
     */
    public void scrollDown(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,550)", "");
    }

}
