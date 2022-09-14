package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    TestContextSetup tcs;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
        this.landingPage = tcs.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) throws InterruptedException {
        landingPage.searchItem(string);

        Thread.sleep(1000);
        tcs.landingPageProductName = landingPage.getProductName();
        System.out.println(tcs.landingPageProductName + " is Extracted from home page");
    }

    @And("Added {string} items of the selected product to cart")
    public void addedItemsOfTheSelectedProductToCart(String arg0) {
        landingPage.addProductToCart(Integer.parseInt(arg0) - 1);
    }

    @Then("User proceeds to Checkout")
    public void userProceedsToCheckout() throws InterruptedException {
        landingPage.CheckoutItems();
        Thread.sleep(2000);
    }
}
