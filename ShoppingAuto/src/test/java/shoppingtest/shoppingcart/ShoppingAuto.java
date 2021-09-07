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

        locatorShop.searchFunctionality( "Printed");
        locatorShop.scrollDown();
        Assert.assertEquals(locatorShop.searchResult(),"5 results have been found.");

    }

    @Test(priority=1)
    public void searchFail(){

        locatorShop.returnHome(URL_WEB);
        locatorShop.searchFunctionality("hey");
        Assert.assertEquals(locatorShop.searchFailResult(),"No results were found for your search \"hey\"");
    }

    @Test(priority=2)
    public void addToCart(){
        //add to cart
        locatorShop.returnHome(URL_WEB);
        String label = locatorShop.addItem( 3);
        Assert.assertEquals(label,"Cart 1 Product");

    }

    @Test(priority=3)
    public void deleteItem(){
        //delete item
        String label = locatorShop.deleteItem();
        Assert.assertEquals(label,"Cart (empty)");
    }

    @Test(priority=4)
    public void scrollToStoreInfo(){
        //scroll to store information

        Assert.assertEquals(
                locatorShop.storeInfo(),
                "Store information");
        Assert.assertEquals(locatorShop.storeAddress(),
                "Selenium Framework, Research Triangle Park, North Carolina, USA");
        Assert.assertEquals(locatorShop.storeContact( ),
                "(347) 466-7432");
        Assert.assertEquals(locatorShop.storeEmail(),
                "support@seleniumframework.com");
    }

}
