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
    public void iAmOnHomePage() {
        driver.get(searchPage.getHomePageUrl());
        searchPage.verifyThatUserIsOnHomePage();
    }

    @When("I click on search bar field")
    public void iClickOnSearchBarField(){
        searchPage.SearchBar();
    }

    @Then("The search bar is displayed")
    public void theSearchBarIsDisplayed(){
        searchPage.SearchBarIsDisplayed();
    }

    @Given("I am on Shopping cart page")
    public void iAmOnShoppingCartPage() {
        driver.get(shoppingCartPage.getShoppingCartPageUrl());
        shoppingCartPage.verifyThatUserIsOnShoppingCartPage();
    }

    @Given("I am on Checkout page")
    public void iAmOnCheckoutPage() {
        driver.get(checkoutPage.getCheckoutPageUrl());
        checkoutPage.verifyThatUserIsOnCheckoutPage();

    }

    @Then("The search button is displayed")
    public void theSearchButtonIsDisplayed(){
        searchPage.SearchButtonIsDisplayed();
    }

    @When("I click on search bar")
    public void iClickOnSearchBar(){
        searchPage.clickOnSearchBar();
    }

    @And("I write {string} in the search bar")
    public void iWriteInTheSearchBar(String iph){
        searchPage.writeText(iph);


    }

    @And("I write iph in the search bar")
    public void iWriteIphInTheSearchBar() {
        searchPage.enterText("iph");
        assertEquals("iph", "iph");

    }

    @Then("Click on Search in product descriptions checkbox")
    public void clickOnSearchInProductDescriptionsCheckbox() {
        searchPage.clickSearchProductDescription();
    }
    @And("Write mac into Search Criteria input")
    public void writeMacIntoSearchCriteriaInput() {
        searchPage.writeText("mac");
    }

    @And("Check if word mac is in product description")
    public void checkIfWordMacIsInProductDescription(){
        assertEquals("mac", "mac");
    }

    @And("Select the parent category from the dropdown field")
    public void selectTheParentCategoryFromTheDropdownField() {
        basePage.selectOptionByValue("18");
    }

    @And("I click on Search in Subcategories checkbox")
    public void iClickOnSearchInSubcategoriesCheckbox(){
        searchPage.clickOnSubcategoriesCheckbox();
    }

    @Then("Check if mac is in the name of the results")
    public void checkIfMacIsInTheNameOfTheResults(){
        searchPage.verifyThatResultsContainsTextMac();
    }

    @And("Select another parent category from the dropdown field")
    public void selectAnotherParentCategoryFromTheDropdownField() {
        basePage.selectOptionByValue("25");
    }


    @Then("Select option from the Sort by dropdown")
    public void selectOptionFromTheSortByDropdown(){
        basePage.clickOnSortByList();
        basePage.clickOnOption4Dropdown();
        basePage.sortResultsByPriceAscending("//p[@class='price']");

    }


    @Then("Select number of products from the Show dropdown")
    public void selectNumberOfProductsFromTheShowDropdown(){
        basePage.clickOnShowProductList();
        basePage.clickOnOptionShow50();
    }

    @When("Write mac into Search bar")
    public void writeMacIntoSearchBar(){
        searchPage.enterText("mac");
    }

    @Then("I click on button search")
    public void iClickOnButtonSearch(){
        basePage.clickOnButtonSearch();
    }

    @Then("Check if there is no results")
    public void checkIfThereIsNoResults() {
        searchPage.verifyThatNoResultsFound("There is no product that matches the search criteria.");

    }


    @When("Write a text with more than allowed characters")
    public void writeATextWithMoreThanCharacters(){
        searchPage.enterText("macmacmacmacmacm");
    }

    @Then("A message1 should be displayed")
    public void aMessage1ShouldBeDisplayed() {
        assertEquals("The maximum allowed input characters count is 15", "");
    }

    @Then("I click on search button and check")
    public void iClickOnSearchButtonAndCheck(){
        searchPage.clickOnSearchButton();
        searchPage.verifyThatResultsContainsTextIph();
    }

    @When("I click on search button")
    public void iClickOnSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPage.clickOnSearchButton();
    }

    @When("Write a text with characters that are not allowed")
    public void writeATextWithCharactersThatAreNotAllowed(){
        searchPage.verifyThatUserIsOnSearchPage();
        searchPage.enterText("mac@");
    }


    @Then("A message2 should be displayed")
    public void aMessage2ShouldBeDisplayed() {
        assertEquals("Special character like a “, ()!@#$%^* are not allowed(should be truncated)","");

    }

    @When("Write a text with less than allowed characters")
    public void writeATextWithLessThanAllowedCharacters(){
        searchPage.enterText("mac");
    }

    @Then("A message3 should be displayed")
    public void aMessage3ShouldBeDisplayed(){
        assertEquals("The minimum allowed input characters count is 5", "");
    }
}

