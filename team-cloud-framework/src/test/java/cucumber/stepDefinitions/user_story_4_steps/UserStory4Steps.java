package cucumber.stepDefinitions.user_story_4_steps;

import cucumber.pages_sample.user_story_4_pages.HomePage;
import cucumber.stepDefinitions.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserStory4Steps {

    private WebDriver driver;

    static HomePage homePage;

    public UserStory4Steps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
    }

    @When("^I am on Home Page$")
    public void IAmOnHomePage() throws InterruptedException {
        homePage.getHomePageUrl();
        Thread.sleep(5000);
    }

    @Then("^I click on My Account$")
    public void IClickOnMyAccount() throws InterruptedException {
        homePage.clickOnMyAccount();
        Thread.sleep(2000);
    }

    //steps here

}
