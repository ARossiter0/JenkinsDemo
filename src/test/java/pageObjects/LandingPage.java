package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPage {

    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By addItemBtn = By.cssSelector("div.products div.product:nth-child(1) .increment");
    private By cartBag = By.cssSelector("[alt='Cart'");
    private By checkOutButton = By.xpath("//button[contains(., 'PROCEED TO CHECKOUT')]");
    private By addToCartBtn = By.xpath("//button[contains(., 'ADD TO CART')]");
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String itemName) {
        driver.findElement(search).sendKeys(itemName);
    }

    public String getSearchText() {
        return driver.findElement(search).getText();
    }

    public String getProductName() {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

    public void CheckoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkOutButton).click();
    }

    public void addProductToCart(int num) {
        for (int i = 0; i < num; i++) {
            driver.findElement(addItemBtn).click();
        }
        driver.findElement(addToCartBtn).click();
    }
}
