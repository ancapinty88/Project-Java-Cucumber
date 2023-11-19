package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    //WebElements should be here

    @FindBy(xpath = "//span[.='My Account']")
    private WebElement myAccountMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.ID, using = "search")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;

    @FindBy(how = How.NAME, using = "description")
    private WebElement SearchProductDescription;

    @FindBy(how = How.NAME, using = "sub_category")
    private WebElement SearchSubcategories;

    @FindBy(xpath = "//a[contains(text(),'Mac')]")
    private WebElement macResults;

    @FindBy(how = How.ID, using = "tab-description")
    private WebElement description;

    @FindBy(xpath = "//a[contains(text(),'iph')]")
    private WebElement textIph;

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.ID, using = "input-limit")
    private WebElement showProducts;




    //Methods should be here

    public void getHomePageUrl() {
        driver.get("https://www.demoshop24.com/index.php?route=common/home");
    }
    public void getShoppingCartPageUrl(){driver.get("https://www.demoshop24.com/index.php?route=checkout/cart");}
    public void getCheckoutPageUrl(){driver.get("https://www.demoshop24.com/index.php?route=checkout/checkout");}

    //public void clickOnMyAccount() {
        //clickElement(myAccountMenu);
    //}

//    public boolean clickOnSearchBar(){
//        clickOnSearchBar();
//        return false;
//    }
//    public boolean isSearchBarDisplayed(){
//        return clickOnSearchBar();
//    }

}
