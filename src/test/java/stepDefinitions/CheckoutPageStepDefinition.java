package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    TestContextSetup tcs;
    CheckoutPage checkoutPage;
    LandingPage landingPage;

    public CheckoutPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        this.checkoutPage = tcs.pageObjectManager.getCheckoutPage();
        this.landingPage = tcs.pageObjectManager.getLandingPage();
        
    }

    @And("verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }

    @And("validates the item name in checkout page")
    public void validatesTheItemNameInCheckoutPage() {
        Assert.assertTrue(checkoutPage.VerifyProductName(tcs.landingPageProductName));
    }
}
