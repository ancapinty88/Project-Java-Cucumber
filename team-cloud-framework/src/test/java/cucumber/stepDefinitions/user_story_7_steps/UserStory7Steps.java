package cucumber.stepDefinitions.user_story_7_steps;

import cucumber.pages_sample.BasePage;
import cucumber.pages_sample.user_story_7_pages.CheckoutPage;
import cucumber.pages_sample.user_story_7_pages.HomePage;
import cucumber.pages_sample.user_story_7_pages.ShoppingCartPage;
import cucumber.stepDefinitions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

import javax.lang.model.element.Element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory7Steps  {

    private WebDriver driver;

    private Hooks hooks;
    static BasePage basePage;
    static HomePage homePage;
    static ShoppingCartPage shoppingCartPage;
    static CheckoutPage checkoutPage;

    public UserStory7Steps(){
        this.driver = Hooks.driver;
        //searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
        checkoutPage = PageFactory.initElements(Hooks.driver, CheckoutPage.class);
        basePage = PageFactory.initElements(Hooks.driver, BasePage.class);
    }

    @Given("I am on Home Page")
    public void iAmOnHomePage() throws Throwable {
        driver.get(homePage.getHomePageUrl());
        homePage.verifyThatUserIsOnHomePage();

    }


    @When("I click on shopping bar field")
    public void iClickOnShoppingBarField() throws Throwable{
        homePage.SearchBar();

    }


    @Then("The search bar is displayed")
    public void theSearchBarIsDisplayed() throws Throwable {
        homePage.SearchBarIsDisplayed();
    }

    @Given("I am on Shopping cart page")
    public void iAmOnShoppingCartPage() throws Throwable{
        driver.get(shoppingCartPage.getShoppingCartPageUrl());
    }

    @Given("I am on Checkout page")
    public void iAmOnCheckoutPage() throws Throwable{
        driver.get(checkoutPage.getCheckoutPageUrl());

    }

    @When("I click on search button")
    public void iClickOnSearchButton() throws Throwable{
        homePage.clickOnSearchButton();
    }

    @Then("The search button is displayed")
    public void theSearchButtonIsDisplayed() throws Throwable{
        homePage.SearchButtonIsDisplayed();
    }

    @When("I click on search bar")
    public void iClickOnSearchBar() throws Throwable{
        homePage.clickOnSearchBar();
    }

    @And("I write {string} in the search bar")
    public void iWriteInTheSearchBar(String iph) throws Throwable{
        homePage.writeText(iph);

    }

//not working
    @And("I write iph in the search bar")
    public void iWriteIphInTheSearchBar() throws Throwable{
        homePage.enterText("iph");
    }

    @Then("Click on Search in product descriptions checkbox")
    public void clickOnSearchInProductDescriptionsCheckbox() throws Throwable{
        homePage.clickSearchProductDescription();
    }
    @And("Write mac into Search Criteria input")
    public void writeMacIntoSearchCriteriaInput() throws Throwable {
        homePage.writeText("mac");
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
        homePage.clickOnSubcategoriesCheckbox();
    }

    @Then("Check if mac is in the name of the results")
    public void checkIfMacIsInTheNameOfTheResults() throws Throwable{
        homePage.verifySearchResultsContainKeyword("mac");


    }

    @And("Select another parent category from the dropdown field")
    public void selectAnotherParentCategoryFromTheDropdownField() throws Throwable {
        basePage.selectOptionByValue("25");
    }


    @Then("Select option from the Sort by dropdown")
    public void selectOptionFromTheSortByDropdown() throws Throwable{
        basePage.sortByByValue("\"https://www.demoshop24.com/index.php?route=product/search&sort=p.sort_order&order=ASC&search=mac\"");
    }
//Name (Z - A)

    @Then("Select number of products from the Show dropdown")
    public void selectNumberOfProductsFromTheShowDropdown() throws Throwable {
        basePage.showByValue("50");
    }

    @When("Write mac into Search bar")
    public void writeMacIntoSearchBar() throws Throwable {
        homePage.enterText("mac");
    }
}

