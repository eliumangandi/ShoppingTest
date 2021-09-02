package shoppingtest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import shoppingtest.utils.WebDriverActions;

import java.util.concurrent.TimeUnit;

public class ShoppingDriver {

    public static final String URL_WEB = "http://automationpractice.com/index.php";

    public static final String DRIVER_TYPE = "webdriver.chrome.driver";

    public static final String DRIVER_LOCATION = "src/test/resources/chromedriver/v92chromedriver.exe";

    public WebDriver driver;

    public WebDriverActions webActions;


    @BeforeClass
    public void initDriver(){
        System.setProperty(DRIVER_TYPE, DRIVER_LOCATION);
        driver = new ChromeDriver();
        driver.get(URL_WEB);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        webActions = new WebDriverActions(driver);
    }

    @AfterClass
    public void closeDriver(){
        //driver.quit();
    }


}
