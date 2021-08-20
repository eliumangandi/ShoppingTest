package com.applaudostudios.shoppingtest.shoppingcart;

import com.applaudostudios.shoppingtest.pojo.LocatorShop;
import com.applaudostudios.shoppingtest.utils.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/*
   This class enables to use testng framework
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class ShoppingAuto {

    private WebDriver driver;

    @BeforeClass
    public void initDriver(){
        System.setProperty(LocatorShop.DRIVER_TYPE, LocatorShop.DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(LocatorShop.URL_WEB);
        driver.manage().window().maximize();
    }


    @AfterSuite
    public void closeDriver(){
       driver.quit();
    }

    @Test
    public void CartTest(){

        //search
        WebDriverActions.searchFunctionality(driver, "Printed");
        WebDriverActions.waitWhile(driver);
        WebDriverActions.scrollDown(driver);
        WebDriverActions.waitWhile(driver);

        WebDriverActions.returnHome(driver);
        WebDriverActions.searchFunctionality(driver, "hey");

        //add to cart
        WebDriverActions.returnHome(driver);
        String label = WebDriverActions.addItem(driver, 3);


        //delete from cart
        WebDriverActions.deleteItem(driver);
        WebDriverActions.scrollDown(driver);
        WebDriverActions.scrollDown(driver);
    }

}
