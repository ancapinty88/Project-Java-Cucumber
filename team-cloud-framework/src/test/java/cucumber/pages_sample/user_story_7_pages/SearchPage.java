package cucumber.pages_sample.user_story_7_pages;

import cucumber.pages_sample.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.SeleniumHelper.clickElement;
import static utils.SeleniumHelper.wait;


public class SearchPage extends BasePage {

    //WebElements should be here

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;

    @FindBy(how = How.NAME, using = "description")
    private WebElement SearchProductDescription;

    @FindBy(how = How.NAME, using = "sub_category")
    private WebElement SearchSubcategories;

    @FindBy(xpath = "//a[contains(text(), 'MacBook')]")
    private List<WebElement> macResults;

    @FindBy(xpath = "//a[contains(text(),'iPhone')]")
    private List<WebElement> iphResults;

    @FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
    private WebElement noResultMsg;

    @FindBy(how = How.ID, using = "tab-description")
    private WebElement description;

//    @FindBy(xpath = "//a[contains(text(),'iph')]")
//    private List<WebElement> textIph;




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

   public static String getSearchPageUrl(){
        return "https://www.demoshop24.com/index.php?route=product/search";
   }

   public void verifyThatUserIsOnSearchPage(){
        String expectedUrl = SearchPage.getSearchPageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
   }

    public void verifyThatUserIsOnHomePage() {
        String expectedUrl = SearchPage.getHomePageUrl();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }




    public void clickOnSubcategoriesCheckbox(){
        clickElement(SearchSubcategories);
        Assert.assertTrue(SearchSubcategories.isSelected());
    }


    public void clickOnProductDescription(){
        clickElement(SearchProductDescription);
    }

    public void clickOnSearchBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        clickElement(searchBar);
    }



    public void SearchBarIsDisplayed(){
//        if (searchBar.isDisplayed()){
//            System.out.println("Search Bar is displayed.");
//        } else {
//            System.out.println("Search Bar is not displayed");
//        }
        Assert.assertTrue(searchBar.isDisplayed());


        }

    public void SearchButtonIsDisplayed(){
//        if (searchButton.isDisplayed()){
//            System.out.println("Search Button is displayed.");
//        } else {
//            System.out.println("Search Button is not displayed");
//        }

        Assert.assertTrue(searchButton.isDisplayed());
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
        searchBar.click();
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


    public boolean areResultsContainingText(List<WebElement> results, String searchText) {
        for (WebElement result : results) {
            if (result.getText().toLowerCase().contains(searchText.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void verifyThatResultsContainsTextMac(){
        assertTrue(areResultsContainingText(macResults, "mac"));
    }

    public void verifyThatResultsContainsTextIph(){
        assertTrue(areResultsContainingText(iphResults, "iph"));
    }


    public void verifyThatNoResultsFound(String expectedMsg){
        assertEquals(expectedMsg, noResultMsg.getText());
    }

}


