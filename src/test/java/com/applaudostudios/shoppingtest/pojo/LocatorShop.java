package com.applaudostudios.shoppingtest.pojo;

/*
   This class enables to use constants to locate elements in the page
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class LocatorShop {

    public static final String URL_WEB = "http://automationpractice.com/index.php";

    public static final String DRIVER_TYPE = "webdriver.chrome.driver";

    public static final String DRIVER_LOCATION = "src/test/resources/chromedriver/v92chromedriver.exe";

    public static final String CONTENT_CLASS = "tab-content";

    public static final String ADD_CART_XPATH = "//span[text()='Add to cart']//ancestor::a";

    public static final String MORE_XPATH = "//span[text()='More']//ancestor::a";

    public static final String ADD_NAME = "Submit";

    public static final String PROCEED_XPATH = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a";

    public static final String CART_LABEL_XPATH = "//header[@id='header']/div[3]/div/div/div[3]/div/a";

    public static final String DELETE_ITEM_XPATH = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[1]/i";

    public static final String SEARCH_INPUT_ID = "search_query_top";

    public static final String SEARCH_ICON_XPATH = "//*[@id='searchbox']/button";

}
