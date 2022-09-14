package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;
    private By promoButton = By.cssSelector(".promoBtn");
    private By placeOrder = By.xpath("//button[contains(., 'Place Order')]");
    private By productName = By.cssSelector("tbody tr td:nth-child(2) .product-name");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }



    public boolean VerifyPromoBtn() {
        return driver.findElement(promoButton).isDisplayed();
    }

    public boolean VerifyPlaceOrder() {
        return driver.findElement(placeOrder).isDisplayed();
    }

    public boolean VerifyProductName(String name) {
        String pName = driver.findElement(productName).getText().split("-")[0].trim();
        return pName.equals(name);
    }

}
