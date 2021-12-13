import model.FilterRozetka;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CurtPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.PropertiesReader;
import utils.XMLToObject;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Task4Tests {

    private static final long DEFAULT_WAITING_TIME = 90;

    private WebDriver driver;

    @DataProvider(name = "data")
    public static  Object[][] getData(){
        XMLToObject xmlToObject = new XMLToObject();
        FilterRozetka filterRozetka = xmlToObject.convert();
        Object[][] filter = new Object[1][2];
        filter[0][0] = filterRozetka.getItemName();
        filter[0][1] = filterRozetka.getSumLimit();
        return filter;
    }

    @BeforeTest

    public void profileSetUp() {

        PropertiesReader propertiesReader = new PropertiesReader();
        String driverName = propertiesReader.getDriverName();
        String driverLocation = propertiesReader.getDriverLocation();
        System.setProperty(driverName, driverLocation);
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = new PropertiesReader().getUrl();
        driver.get(url);

    }

    @Test(dataProvider = "data")
    public void task4Test(String itemName, int limit) throws InterruptedException {
        sleep(4190);//to escape CAPTCHA
        getHomePage().enterTextToSearchField(itemName);
        getSearchResultPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultPage().addFirstProduct();
        getSearchResultPage().clickOpenCartButton();
        int sumPrice = getCurtPage().getSumPrice();

        System.out.println(sumPrice);
        Assert.assertTrue(sumPrice  > 500);
        System.out.println(itemName);
        System.out.println(limit);

    }



    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }

    public SearchResultPage getSearchResultPage(){
        return new SearchResultPage(getDriver());
    }

    public CurtPage getCurtPage(){
        return new CurtPage(getDriver());
    }
}
