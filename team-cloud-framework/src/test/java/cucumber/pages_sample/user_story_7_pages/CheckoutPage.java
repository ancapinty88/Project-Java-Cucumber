package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public static String getCheckoutPageUrl(){
        return "https://www.demoshop24.com/index.php?route=checkout/cart";
    }

    public void verifyThatUserIsOnCheckoutPage(){
        String expectedUrl = CheckoutPage.getCheckoutPageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @FindBy(how = How.ID, using = "search")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;



    public boolean clickOnSearchBar() throws Throwable{
        clickOnSearchBar();
        return false;
    }
    public boolean isSearchBarDisplayed() throws Throwable{
        return clickOnSearchBar();
    }
}

