package cucumber.pages_sample.user_story_4_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //WebElements should be here

    @FindBy(xpath = "//span[.='My Account']")
    private WebElement myAccountMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Methods should be here

    public void getHomePageUrl() {
        driver.get("https://www.demoshop24.com/index.php?route=common/home");
    }

    public void clickOnMyAccount() {
        clickElement(myAccountMenu);
    }

}
