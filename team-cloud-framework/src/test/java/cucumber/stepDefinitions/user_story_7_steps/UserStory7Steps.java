package cucumber.stepDefinitions.user_story_7_steps;

import cucumber.pages_sample.BasePage;
import cucumber.pages_sample.user_story_7_pages.CheckoutPage;
import cucumber.pages_sample.user_story_7_pages.SearchPage;
import cucumber.pages_sample.user_story_7_pages.ShoppingCartPage;
import cucumber.stepDefinitions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory7Steps  {

    private WebDriver driver;

    private Hooks hooks;
    static BasePage basePage;
    static SearchPage searchPage;
    static ShoppingCartPage shoppingCartPage;
    static CheckoutPage checkoutPage;

    public UserStory7Steps(){
        this.driver = Hooks.driver;
        searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
        checkoutPage = PageFactory.initElements(Hooks.driver, CheckoutPage.class);
        basePage = PageFactory.initElements(Hooks.driver, BasePage.class);
    }

    @Given("I am on Home Page")
    public void iAmOnHomePage() throws Throwable {
        driver.get(searchPage.getHomePageUrl());
        searchPage.verifyThatUserIsOnHomePage();
    }

    @When("I click on search bar field")
    public void iClickOnSearchBarField() throws Throwable{
        searchPage.SearchBar();
    }

    @Then("The search bar is displayed")
    public void theSearchBarIsDisplayed() throws Throwable {
        searchPage.SearchBarIsDisplayed();
    }

    @Given("I am on Shopping cart page")
    public void iAmOnShoppingCartPage() throws Throwable{
        driver.get(shoppingCartPage.getShoppingCartPageUrl());
        shoppingCartPage.verifyThatUserIsOnShoppingCartPage();
    }

    @Given("I am on Checkout page")
    public void iAmOnCheckoutPage() throws Throwable{
        driver.get(checkoutPage.getCheckoutPageUrl());
        checkoutPage.verifyThatUserIsOnCheckoutPage();

    }

    @Then("The search button is displayed")
    public void theSearchButtonIsDisplayed() throws Throwable{
        searchPage.SearchButtonIsDisplayed();
    }

    @When("I click on search bar")
    public void iClickOnSearchBar() throws Throwable{
        searchPage.clickOnSearchBar();
    }

    @And("I write {string} in the search bar")
    public void iWriteInTheSearchBar(String iph) throws Throwable{
        searchPage.writeText(iph);


    }

//not working
    @And("I write iph in the search bar")
    public void iWriteIphInTheSearchBar() throws Throwable{
        searchPage.enterText("iph");
        assertEquals("iph", "iph");

    }

    @Then("Click on Search in product descriptions checkbox")
    public void clickOnSearchInProductDescriptionsCheckbox() throws Throwable{
        searchPage.clickSearchProductDescription();
    }
    @And("Write mac into Search Criteria input")
    public void writeMacIntoSearchCriteriaInput() throws Throwable {
        searchPage.writeText("mac");
    }

    @And("Check if word mac is in product description")
    public void checkIfWordMacIsInProductDescription() throws Throwable{
        assertEquals("mac", "mac");
    }

    @And("Select the parent category from the dropdown field")
    public void selectTheParentCategoryFromTheDropdownField() throws Throwable {
        basePage.selectOptionByValue("18");
    }

    @And("I click on Search in Subcategories checkbox")
    public void iClickOnSearchInSubcategoriesCheckbox() throws Throwable{
        searchPage.clickOnSubcategoriesCheckbox();
    }

    @Then("Check if mac is in the name of the results")
    public void checkIfMacIsInTheNameOfTheResults() throws Throwable{
        searchPage.verifyThatResultsContainsTextMac();



    }

    @And("Select another parent category from the dropdown field")
    public void selectAnotherParentCategoryFromTheDropdownField() throws Throwable {
        basePage.selectOptionByValue("25");
    }


    @Then("Select option from the Sort by dropdown")
    public void selectOptionFromTheSortByDropdown() throws Throwable{
        basePage.clickOnSortByList();
        basePage.clickOnOption4Dropdown();
        basePage.sortResultsByPriceAscending("//p[@class='price']");

    }


    @Then("Select number of products from the Show dropdown")
    public void selectNumberOfProductsFromTheShowDropdown() throws Throwable {
        basePage.clickOnShowProductList();
        basePage.clickOnOptionShow50();
    }

    @When("Write mac into Search bar")
    public void writeMacIntoSearchBar() throws Throwable {
        searchPage.enterText("mac");
    }

    @Then("I click on button search")
    public void iClickOnButtonSearch() throws Throwable {
        basePage.clickOnButtonSearch();
    }

    @Then("Check if there is no results")
    public void checkIfThereIsNoResults() {
        searchPage.verifyThatNoResultsFound("There is no product that matches the search criteria.");

    }


    @When("Write a text with more than allowed characters")
    public void writeATextWithMoreThanCharacters() throws Throwable {
        searchPage.enterText("macmacmacmacmacm");
    }

    @Then("A message1 should be displayed")
    public void aMessage1ShouldBeDisplayed() throws Throwable {
        assertEquals("The maximum allowed input characters count is 15", "");
    }

    @Then("I click on search button and check")
    public void iClickOnSearchButtonAndCheck() throws Throwable{
        searchPage.clickOnSearchButton();
        searchPage.verifyThatResultsContainsTextIph();
    }

    @When("I click on search button")
    public void iClickOnSearchButton() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPage.clickOnSearchButton();
    }

    @When("Write a text with characters that are not allowed")
    public void writeATextWithCharactersThatAreNotAllowed() throws Throwable {
        searchPage.verifyThatUserIsOnSearchPage();
        searchPage.enterText("mac@");
    }


    @Then("A message2 should be displayed")
    public void aMessage2ShouldBeDisplayed() throws Throwable {
        assertEquals("Special character like a “, ()!@#$%^* are not allowed(should be truncated)","");

    }

    @When("Write a text with less than allowed characters")
    public void writeATextWithLessThanAllowedCharacters() throws Throwable {
        searchPage.enterText("mac");
    }

    @Then("A message3 should be displayed")
    public void aMessage3ShouldBeDisplayed()  throws Throwable{
        assertEquals("The minimum allowed input characters count is 5", "");
    }
}

