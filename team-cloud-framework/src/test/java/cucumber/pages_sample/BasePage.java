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


    @FindBy(how = How.ID, using = "search")
    private WebElement searchBar;

    @FindBy(how = How.CLASS_NAME, using = "fa-search")
    private WebElement searchButton;

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

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.ID, using = "input-limit")
    private WebElement showProducts;

    @FindBy(how = How.NAME, using = "category_id")
    private WebElement categoryDropdown;


    public void SearchBar() {
        clickElement(searchBar);
        //searchBar.sendKeys(text);
    }

    public void clickOnSearchButton(){
        clickElement(searchButton);
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
        dropdown.selectByValue(value);
    }

    public void sortByByValue(String value){
        Select dropdown = new Select(sortBy);
        dropdown.selectByValue(value);
    }

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






}



