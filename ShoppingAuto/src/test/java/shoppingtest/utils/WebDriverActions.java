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
public abstract class WebDriverActions {

    /*
    this method move mouse to specific element
    @param driver WebDriver object
    @param element WebElement object
     */
    public static void elementMouseHover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /*
    this method enables wait a moment between actions
    @param driver WebDriver object
     */
    public static void waitWhile(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,100);
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    /*
    this method enables wait for an element to be visible
    @param driver WebDriver object
    @param element WebElement object
     */
    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    /*
    this method executes Script action
    @param driver WebDriver object
    @param element WebElement object
     */
    public static void scriptExecutor(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    /*
    this method find item from a line list array
    @param driver WebDriver object
    @param itemPosition integer number
    @return WebElement
     */
    public static WebElement findItem(WebDriver driver, int itemPosition){
        WebElement divContent;
        divContent = driver.findElement( By.className( LocatorShop.CONTENT_CLASS ));
        List<WebElement> lineList = divContent.findElements(By.tagName("li"));
        return lineList.get(itemPosition);
    }

    /*
    this method add item from a specific position using the Add to cart button
    @param driver WebDriver object
    @param position integer number
    @return String
     */
    public static String addItemToCart(WebDriver driver, int position){
        WebElement lineItem = WebDriverActions.findItem(driver, position);
        WebDriverActions.elementMouseHover(driver, lineItem);

        WebDriverActions.waitWhile(driver);
        WebElement addCartBtn = lineItem.findElement(By.xpath(LocatorShop.ADD_CART_XPATH));
        //WebDriverActions.waitAlert(driver,addCartBtn);
        WebDriverActions.waitWhile(driver);
        WebDriverActions.scriptExecutor(driver, addCartBtn);

        WebElement proceedBtn = driver.findElement(By.xpath(LocatorShop.PROCEED_XPATH));
        WebDriverActions.waitWhile(driver);
        WebDriverActions.scriptExecutor( driver, proceedBtn );

        driver.navigate().refresh();
        WebElement quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        quantity.click();
       quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        return quantity.getText();
    }

    /*
    this method add item from a specific position using the More button
    @param driver WebDriver object
    @param position integer number
    @return String
     */
    public static String addItem(WebDriver driver, int position){
        WebElement lineItem = WebDriverActions.findItem(driver, position);
        WebDriverActions.elementMouseHover(driver, lineItem);

        WebDriverActions.waitWhile(driver);
        WebElement moreBtn = lineItem.findElement(By.xpath(LocatorShop.MORE_XPATH));
        //WebDriverActions.waitAlert(driver,addCartBtn);
        WebDriverActions.waitWhile(driver);
        WebDriverActions.scriptExecutor(driver, moreBtn);

        WebElement addCartBtn = driver.findElement(By.name(LocatorShop.ADD_NAME));
        WebDriverActions.scriptExecutor( driver, addCartBtn );

        driver.navigate().refresh();
        WebElement quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        quantity.click();
        quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        return quantity.getText();
    }

    /*
    this method returns the driver to home page
    @param driver WebDriver object
     */
    public static void returnHome( WebDriver driver ){
        driver.navigate().to( LocatorShop.URL_WEB );
    }

    /*
    this method delete item from cart
    @param driver WebDriver object
     */
    public static void deleteItem( WebDriver driver ) {
        WebElement deleteLink = driver.findElement( By.xpath( LocatorShop.DELETE_ITEM_XPATH ) );
        WebDriverActions.scriptExecutor(driver,deleteLink);
        WebDriverActions.waitWhile( driver );
    }

    /*
    this method enables search item from search input
    @param driver WebDriver object
    @param message String number
     */
    public static void searchFunctionality(WebDriver driver, String message){
        WebElement searchInput = driver.findElement(By.id(LocatorShop.SEARCH_INPUT_ID));
        searchInput.sendKeys(message);
        WebElement searchIcon = driver.findElement(By.xpath(LocatorShop.SEARCH_ICON_XPATH));
        WebDriverActions.scriptExecutor(driver, searchIcon);
    }

    /*
    this method scroll down the page
    @param driver WebDriver object
    @param position integer number
    @return String
     */
    public static void scrollDown(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,550)", "");
    }

}
