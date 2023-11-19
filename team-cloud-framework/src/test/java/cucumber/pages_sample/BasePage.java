package cucumber.pages_sample;

import cucumber.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    protected String getButtonColor(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        return button.getCssValue("background-color");
    }

    protected String getButtonTextColor(WebElement button) {
        wait.until(ExpectedConditions.visibilityOf(button));
        return button.getCssValue("color");
    }

    protected String getMessageColor(WebElement message) {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getCssValue("background-color");
    }

    protected String getMessageTextColor(WebElement message) {
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getCssValue("color");
    }

    protected String getInputFieldValue(WebElement inputField) {
        wait.until(ExpectedConditions.visibilityOf(inputField));
        return inputField.getAttribute("value");
    }

    protected String getSelectedRadioButtonValue(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        for (WebElement radioButton : elements) {
            if (radioButton.isSelected()) {
                return radioButton.getAttribute("value");
            }
        }
        return null;
    }

    protected List<String> getSelectedCheckboxValues(List<WebElement> checkboxes) {
        wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
        List<String> selectedValues = new ArrayList<>();
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                selectedValues.add(checkbox.getAttribute("value"));
            }
        }
        return selectedValues;
    }

    protected String getSelectedDropdownOption(WebElement dropdown) {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    protected void waitForElementsToBeVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void sendKeysToElement(WebElement element, String keysToSend) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keysToSend);
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

//    public boolean isElementDisplayed(){
//        return driver.findElement().isDisplayed();
//    }
//
//    public void clickOnSearchBar(){
//        clickOnSearchBar();
//    }
//    public void isSearchBarDisplayed(){
//        clickOnSearchBar();
//    }
//
//    public void clickOnSearchButton(){
//        clickOnSearchBar();
//    }
//    public void isSearchButtonDisplayed(){
//        clickOnSearchButton();
//    }


}
