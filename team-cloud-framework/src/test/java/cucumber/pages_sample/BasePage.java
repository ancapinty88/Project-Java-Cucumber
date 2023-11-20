package cucumber.pages_sample;

import cucumber.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.SeleniumHelper.*;

public class BasePage {

    protected WebDriver driver;
    protected SeleniumHelper seleniumHelper;

    @FindBy(xpath = "//span[.='My Account']")
    private WebElement myAccountMenu;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginFromMyAccountDropdown;

    @FindBy(xpath = "//a[text()='My Account']")
    private WebElement myAccountFromMyAccountDropdown;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement shoppingCartDropdown;

    @FindBy(xpath = "//p[@class='text-center']")
    private WebElement shoppingCartIsEmptyMessage;

    @FindBy(xpath = "//button[@title='Remove']")
    private WebElement removeFromCartButton;

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

    public WebElement getSelectedOption(){
        return option4Dropdown;
    }

    @FindBy(xpath = "//p[@class='price']")
    private List<WebElement> resultsPriceOption;




        public void SearchBar() {
        clickElement(searchBar);
        //searchBar.sendKeys(text);
    }

    public void clickOnSearchButton(){
        clickElement(searchButton);
    }

    //search in the page after homepage, second search
    public void clickOnButtonSearch(){
        clickElement(buttonSearch);
    }

    public void clickSearchCategories(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categoriesCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("sub_category")));
        clickElement(searchSubcategories);
    }
    public void clickSearchProductDescription(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productDescriptionCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
        clickElement(searchProductDescription);
    }


    public void selectOptionByValue(String value) {
        Select dropdown = new Select(categoryDropdown);
        dropdown.selectByVisibleText(value);
    }

//    public void sortByByValue(String value){
//        WebElement sortByDropdown = dropdown.get(1);
//        Select dropdown = new Select(sortByDropdown);
//        dropdown.selectByValue(value);
//    }

    public void showByValue(String value){
        Select dropdown = new Select(showProducts);
        dropdown.selectByValue(value);
    }

    public void clickOnMyAccount() {
        clickElement(myAccountMenu);
    }

    public void clickOnLoginFromMyAccountDropdown() {
        clickElement(loginFromMyAccountDropdown);
    }

    public void verifyThatUserIsLoggedIn() {
        clickElement(myAccountMenu);
        waitUntilElementIsVisible(myAccountFromMyAccountDropdown);
        assertTrue(myAccountFromMyAccountDropdown.isDisplayed());
    }

    public void clickShoppingCartButton() {
        clickElement(shoppingCart);
    }

    public void verifyThatItemsAreAddedToShoppingCart(String expectedText) {
        waitUntilTextIsPresentInElement(shoppingCartDropdown, expectedText);
        assertEquals(expectedText, shoppingCartDropdown.getText());
    }



    public void verifyThatShoppingCartIsEmpty(String expectedMessage) {
        clickOnShoppingCartDropdown();
        waitUntilElementIsVisible(shoppingCartIsEmptyMessage);
        assertEquals(expectedMessage, shoppingCartIsEmptyMessage.getText());
    }

    private List<WebElement> getShoppingCartEmptyMessageElements() {
        By emptyCartMessageLocator = By.xpath("//p[@class='text-center' and contains(text(),'Your shopping cart is empty!')]");
        return driver.findElements(emptyCartMessageLocator);
    }

    private void clickOnShoppingCartDropdown() {
        clickElement(shoppingCartDropdown);
    }

    private void removeFromCartUntilEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        while (true) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(removeFromCartButton)).click();
            } catch (TimeoutException e) {
                break;
            }
        }
    }

    private void clickOnSearchBar(){
        clickElement(searchBar);
    }



    public void sortResultsByPriceAscending() {
        // Create a list to store the prices as strings
        List<String> priceStrings = new ArrayList<>(resultsPriceOption.stream()
                .map(WebElement::getText)
                .toList());
        // Sort the list of price strings in ascending order
        priceStrings.sort(Comparator.comparingDouble(this::extractPrice));

        // Update the order of WebElement list based on the sorted price strings
        for (int i = 0; i < resultsPriceOption.size(); i++) {
            resultsPriceOption.get(i).sendKeys(priceStrings.get(i));
        }

        }

    private double extractPrice(String priceString) {

        // Remove leading and trailing whitespaces and then try to parse
        priceString = priceString.trim();

        // Handle the case where the string is empty after trimming
        if (priceString.isEmpty()) {
            return 0.0; // or throw an exception, depending on your requirements
        }

        // Attempt to parse the numeric value
        try {
            return Double.parseDouble(priceString.replace("$", ""));
        } catch (NumberFormatException e) {
            // Handle the exception or log an error message
            e.printStackTrace();
            return 0.0; // or throw an exception, depending on your requirements
        }
    }




}





