package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static utils.SeleniumHelper.clickElement;

public class ShoppingCartPage extends BasePage {


    public static String getShoppingCartPageUrl() {
        return "https://www.demoshop24.com/index.php?route=checkout/cart";
    }

    @FindBy(how = How.ID, using = "search")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatUserIsOnShoppingCartPage() {
        String expectedUrl = ShoppingCartPage.getShoppingCartPageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void clickOnSearchBar() {
        clickElement(searchBar);

    }


}


