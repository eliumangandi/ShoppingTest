package shoppingtest.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import shoppingtest.utils.ShoppingDriver;

public class Zubale extends ShoppingDriver {

    @Test
    public void goToExpressRestaurant(){

        WebElement soluciones = driver.findElement(By.id("w-dropdown-toggle-2"));
        soluciones.click();
        WebElement express = driver.findElement(By.xpath("//div[@class='zu-header__dropdown-texts']"));
        express.click();

        WebElement solicitar = driver.findElement(By.xpath("//a[@class='zu-button yellow w-button']"));

        String texto = solicitar.getText();

        Assert.assertEquals(texto,"Solicitalo ahora");

    }

}
