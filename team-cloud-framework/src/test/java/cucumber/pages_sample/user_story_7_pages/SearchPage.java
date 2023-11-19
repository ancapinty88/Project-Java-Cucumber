package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BasePage {

    @FindBy(how = How.ID, using = "search")
    private WebElement searchBar;

    public SearchPage(WebDriver driver){
        super(driver);

        this.searchBar = searchBar;
    }

    public void clickOnSearchBar(){
        clickElement(searchBar);
    }
    public boolean isSearchBarDisplayed(){
        return isSearchBarDisplayed();
    }
}
