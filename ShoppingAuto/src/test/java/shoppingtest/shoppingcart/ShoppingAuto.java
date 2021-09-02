package shoppingtest.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Test;
import shoppingtest.locate.LocatorShop;
import shoppingtest.utils.ShoppingDriver;

/*
   This class enables to use testng framework
   @author: Yonatan E Juarez
   @version: 08/19/2021
 */
public class ShoppingAuto extends ShoppingDriver {

    @Test(priority=0)
    public void searchSuccess(){

        LocatorShop.searchFunctionality(webActions, "Printed");
        webActions.scrollDown();
        Assert.assertEquals(LocatorShop.searchResult(webActions.getDriver()),"5 results have been found.");

    }

    @Test(priority=1)
    public void searchFail(){

        webActions.returnHome(URL_WEB);
        LocatorShop.searchFunctionality(webActions, "hey");
        Assert.assertEquals(LocatorShop.searchFailResult(webActions.getDriver()),"No results were found for your search \"hey\"");
    }

    @Test(priority=2)
    public void addToCart(){
        //add to cart
        webActions.returnHome(URL_WEB);
        String label = LocatorShop.addItem(webActions, 3);
        Assert.assertEquals(label,"Cart 1 Product");

    }

    @Test(priority=3)
    public void deleteItem(){
        //delete item
        String label = LocatorShop.deleteItem(webActions.getDriver(), webActions);
        Assert.assertEquals(label,"Cart (empty)");
    }

    @Test(priority=4)
    public void scrollToStoreInfo(){
        //scroll to store information

        Assert.assertEquals(
                LocatorShop.storeInfo(
                        webActions, "//*[@id='block_contact_infos']/div/h4"),
                "Store information");
        Assert.assertEquals(LocatorShop.storeInfo(
                webActions, "//*[@id='block_contact_infos']/div/ul/li[1]"),
                "Selenium Framework, Research Triangle Park, North Carolina, USA");
        Assert.assertEquals(LocatorShop.storeInfo(
                        webActions, "//*[@id='block_contact_infos']/div/ul/li[2]/span"),
                "(347) 466-7432");
        Assert.assertEquals(LocatorShop.storeInfo(
                        webActions, "//*[@id='block_contact_infos']/div/ul/li[3]/span/a"),
                "support@seleniumframework.com");
    }

}
