package cucumber.stepDefinitions.user_story_7_steps;
import cucumber.pages_sample.user_story_7_pages.SearchPage;

import cucumber.stepDefinitions.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class UserStory7Steps {


    private WebDriver driver;
    static SearchPage searchPage;
    public UserStory7Steps(){
        this.driver = Hooks.driver;
        searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
//        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
//        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
//        checkoutPage = PageFactory.initElements(Hooks.driver, CheckoutPage.class);
    }

        @When("I am on {string}")
    public void iAmOnPage(String page) {
            driver = new ChromeDriver();
            switch (page.toLowerCase()) {
                case "home page":
                    searchPage = new SearchPage(driver);
                    driver.get("https://www.demoshop24.com/index.php?route=common/home" + page.toLowerCase());
                    break;


                default:
                    throw new IllegalArgumentException("Unsupported page: " + page);
            }

            @Then("I click on {string} field")
            public void iClickOnField (String field){
                switch (field.toLowerCase()) {
                    case "search bar":
                        if (searchPage != null) {
                            searchPage.clickOnSearchBar();
                        } else {
                            throw new IllegalStateException("No valid page object found");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported field: " + field);
                }
            }

            @Then("The search bar is displayed")
            public void theSearchBarIsDisplayed () {
                if (searchPage != null) {
                    boolean isSearchBarDisplayed = searchPage.isSearchBarDisplayed();
                } else {
                    throw new IllegalStateException("no valid page object found");
                }
            }
        }
}


