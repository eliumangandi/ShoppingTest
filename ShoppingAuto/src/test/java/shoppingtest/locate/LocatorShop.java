package shoppingtest.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shoppingtest.utils.WebDriverActions;

import java.util.List;

/*
   This class enables to use constants to locate elements in the page
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class LocatorShop {

    public static final String CONTENT_CLASS = "tab-content";

    public static final String ADD_CART_XPATH = "//span[text()='Add to cart']//ancestor::a";

    public static final String MORE_XPATH = "//span[text()='More']//ancestor::a";

    public static final String ADD_NAME = "Submit";

    public static final String PROCEED_XPATH = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a";

    public static final String CART_LABEL_XPATH = "//header[@id='header']/div[3]/div/div/div[3]/div/a";

    public static final String DELETE_ITEM_XPATH = "//tbody/tr[1]/td[7]/div[1]/a[1]/i";

    public static final String TABLE_DELETE_ID = "cart_summary";

    public static final String SEARCH_INPUT_ID = "search_query_top";

    public static final String SEARCH_COUNTING_XPATH = "heading-counter";

    public static final String SEARCH_FAIL_XPATH = "//*[@id='center_column']/p";

    public static final String SEARCH_ICON_XPATH = "//*[@id='searchbox']/button";

    /*
    this method enables search item from search input
    @param driver WebDriver object
    @param message String number
     */
    public static void searchFunctionality(WebDriverActions webAction, WebDriver driver, String message){
        WebElement searchInput = driver.findElement(By.id(LocatorShop.SEARCH_INPUT_ID));
        searchInput.sendKeys(message);
        WebElement searchIcon = driver.findElement(By.xpath(LocatorShop.SEARCH_ICON_XPATH));
        webAction.scriptExecutor(searchIcon);
    }

    /*
    this method add item from a specific position using the More button
    @param driver WebDriver object
    @param position integer number
    @return String
     */
    public static String addItem(WebDriverActions webActions,WebDriver driver, int position){
        WebElement lineItem = LocatorShop.findItem(driver, position);
        webActions.elementMouseHover(lineItem);

        WebElement moreBtn = lineItem.findElement(By.xpath(LocatorShop.MORE_XPATH));

        webActions.scriptExecutor(moreBtn);

        WebElement addCartBtn = driver.findElement(By.name(LocatorShop.ADD_NAME));
        webActions.scriptExecutor(addCartBtn);

        driver.navigate().refresh();
        WebElement quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        quantity.click();
        quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        return quantity.getText();
    }

    /*
    this method delete item from cart
    @param driver WebDriver object
     */
    public static String deleteItem( WebDriver driver, WebDriverActions webActions ) {
        WebElement table = driver.findElement(new By.ById(LocatorShop.TABLE_DELETE_ID));
        WebElement deleteLink = table.findElement( By.xpath( LocatorShop.DELETE_ITEM_XPATH ) );
        webActions.scriptExecutor(deleteLink);

        WebElement quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        quantity.click();
        quantity = driver.findElement(By.xpath(LocatorShop.CART_LABEL_XPATH));
        return quantity.getText();
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

    public static String searchResult(WebDriver driver){
        return driver.findElement(By.className(LocatorShop.SEARCH_COUNTING_XPATH)).getText();
    }

    public static String searchFailResult(WebDriver driver){
        return driver.findElement(By.xpath(LocatorShop.SEARCH_FAIL_XPATH)).getText();
    }

    public static String storeInfo(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='block_contact_infos']/div/h4")).getText();
    }

}
