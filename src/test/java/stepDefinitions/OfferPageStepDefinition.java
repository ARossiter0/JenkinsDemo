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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    TestContextSetup tcs;
    PageObjectManager pageObjectManager;

    public OfferPageStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void userSearchedForShortnameInOffersPage(String arg0) throws InterruptedException {
        switchToOffersPage();

        OffersPage offersPage = tcs.pageObjectManager.getOffersPage();

        offersPage.searchItem(arg0);
        Thread.sleep(1000);
        tcs.offerPageProductName = offersPage.getProductName();
    }

    public void switchToOffersPage() {
        LandingPage landingPage = tcs.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        tcs.genericUtils.switchWindowToChild();
    }

    @And("validate product name in offers page matches with Landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(tcs.offerPageProductName, tcs.landingPageProductName);
    }
}
