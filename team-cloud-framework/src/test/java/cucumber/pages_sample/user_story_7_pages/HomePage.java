package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static cucumber.stepDefinitions.Hooks.driver;
import static org.junit.Assert.assertEquals;
import static utils.SeleniumHelper.clickElement;
import static utils.SeleniumHelper.wait;


public class HomePage extends BasePage {

    //WebElements should be here

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
    private List<WebElement> macResults;

    @FindBy(how = How.ID, using = "tab-description")
    private WebElement description;

    @FindBy(xpath = "//a[contains(text(),'iph')]")
    private WebElement textIph;


    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.ID, using = "input-limit")
    private WebElement showProducts;

    @FindBy(how = How.NAME, using = "category_id")
    private WebElement allCategories;





    //Methods should be here

    public static String getHomePageUrl() {
        return "https://www.demoshop24.com/index.php?route=common/home";
    }

    public void verifyThatUserIsOnHomePage() {
        String expectedUrl = HomePage.getHomePageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void clickOnSubcategoriesCheckbox(){
        clickElement(SearchSubcategories);
    }




    public void clickOnProductDescription(){
        clickElement(SearchProductDescription);
    }


    public void clickOnSearchBar(){
        clickElement(searchBar);

    }

    public void SearchBarIsDisplayed(){
        if (searchBar.isDisplayed()){
            System.out.println("Search Bar is displayed.");
        } else {
            System.out.println("Search Bar is not displayed");
        }

        }

    public void SearchButtonIsDisplayed(){
        if (searchButton.isDisplayed()){
            System.out.println("Search Button is displayed.");
        } else {
            System.out.println("Search Button is not displayed");
        }

    }

//    public void enterTextInSearchBar(String searchText) {
//        WebElement search = waitForElementVisible(By.id("search"));
//        searchInput.clear();
//        searchInput.sendKeys(searchText);
//    }

//not working
//    public void writeText(String text) {
//        searchBar.clear();
//        searchBar.sendKeys(text);
//    }

//not working
    public void enterText(String text){
        searchBar.clear();
        searchBar.sendKeys(text);

        //not working for test3
//        private WebElement waitForElementVisible(By search) {
//            return wait.until(ExpectedConditions.visibilityOfElementLocated(search));
//        }
    }
    //working for test4
    public void writeText(String text) {
        WebElement searchBar = waitForElementVisible(By.id("input-search"));
        searchBar.clear(); // Clear any existing text in the search bar
        searchBar.sendKeys(text);
    }

    private WebElement waitForElementVisible(By search) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(search));
    }
//not working to check that the list has the word mac
    public void verifySearchResultsContainKeyword(String mac) throws AssertionError {
        for (WebElement result: macResults){
            String productName = result.getText();
            if (!productName.toLowerCase().contains(mac.toLowerCase())){
                throw new AssertionError("The product name '" + productName + "' does not contain the keyword '" + mac + "'");
            }
        }
        System.out.println("All search results contain the keyword '" + mac + "'");
    }





}



