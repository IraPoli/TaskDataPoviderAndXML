package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted' ]")
    private List<WebElement> productList;

    @FindBy(xpath = "//button[contains(@class,'buy-button')]")
    private List<WebElement> buyButtonList;


    @FindBy(xpath = "//button[@opencart]")
    private WebElement openCurtButton;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstProduct() {
        productList.get(0).click();
    }

    public void addFirstProduct() {
        buyButtonList.get(1).click();
    }

    public void clickOpenCartButton() {
        openCurtButton.click();
    }
}
