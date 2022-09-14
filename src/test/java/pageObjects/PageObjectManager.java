package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        this.landingPage = new LandingPage(driver);
        return this.landingPage;
    }

    public OffersPage getOffersPage() {
        this.offersPage = new OffersPage(driver);
        return this.offersPage;
    }

    public CheckoutPage getCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
