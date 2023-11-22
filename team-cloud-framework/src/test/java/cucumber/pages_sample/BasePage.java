package cucumber.pages_sample;

import cucumber.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumHelper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.SeleniumHelper.clickElement;

public class BasePage {

    protected WebDriver driver;
    protected SeleniumHelper seleniumHelper;


    public BasePage(WebDriver driver) {
        this.driver = Hooks.driver;
        this.seleniumHelper = new SeleniumHelper(driver);

    }

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;

    @FindBy(how = How.ID, using = "button-search")
    private WebElement buttonSearch;

    @FindBy(how = How.NAME, using = "description")
    private WebElement searchProductDescription;

    @FindBy(how = How.NAME, using = "sub_category")
    private WebElement searchSubcategories;

    @FindBy(xpath = "//a[contains(text(),'Mac')]")
    private WebElement macResults;

    @FindBy(how = How.ID, using = "tab-description")
    private WebElement description;

    @FindBy(xpath = "//a[contains(text(),'iph')]")
    private WebElement textIph;

    @FindBy(xpath = "//select[@class='form-control']")
    private List<WebElement> dropdown;

    @FindBy(how = How.ID, using = "input-limit")
    private WebElement showProducts;

    @FindBy(how = How.NAME, using = "category_id")
    private WebElement categoryDropdown;

    @FindBy(css = "#input-sort > option:nth-child(4)")
    private WebElement option4Dropdown;

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortByList;

    @FindBy(css = "#input-limit > option:nth-child(3)")
    private WebElement optionShow50;

    @FindBy(xpath = "//a[contains(text(),'iPhone')]")
    private WebElement iphResults;


    public void clickOnOptionShow50() {
        optionShow50.click();
    }

    public void clickOnShowProductList() {
        showProducts.click();
    }

    public void clickOnSortByList() {
        sortByList.click();
        sortByList.isDisplayed();
    }

    public void clickOnOption4Dropdown() {
        option4Dropdown.click();
        option4Dropdown.isDisplayed();
    }

    @FindBy(xpath = "//p[@class='price']")
    private List<WebElement> resultsPriceOption;

    public void SearchBar() {
        clickElement(searchBar);
        //searchBar.sendKeys(text);
    }

    public void clickOnSearchButton() {
        clickElement(searchButton);
    }

    //search in the page after homepage, second search
    public void clickOnButtonSearch() {
        clickElement(buttonSearch);
    }

//    public void clickSearchCategories() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement categoriesCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("sub_category")));
//        clickElement(searchSubcategories);
//    }

    public void clickSearchProductDescription() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productDescriptionCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
        clickElement(searchProductDescription);
    }


    public void selectOptionByValue(String value) {
        Select dropdown = new Select(categoryDropdown);
        dropdown.selectByValue(value);
    }

    public void showByValue(String value) {
        Select dropdown = new Select(showProducts);
        dropdown.selectByValue(value);
    }


    private void clickOnSearchBar() {
        clickElement(searchBar);
    }

    public void sortResultsByPriceAscending(String xpath) {

        List<WebElement> priceElements = driver.findElements(By.xpath(xpath));

        // Extract prices as strings
        List<String> priceStrings = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            priceStrings.add(priceElement.getText());
        }

        // Convert prices to numeric values
        List<Double> prices = new ArrayList<>();
        for (String priceString : priceStrings) {
            try {
                // Extract numeric part and convert to double
                double price = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));
                prices.add(price);
            } catch (NumberFormatException e) {
                // Handle non-numeric characters
                System.out.println("Skipping non-numeric price: " + priceString);
            }
        }

        // Check if the prices are in ascending order
        if (!isSortedAscending(prices)) {
            throw new AssertionError("Prices are NOT in low to high order.");
        }
    }

    private static boolean isSortedAscending(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}







