package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import utils.TimeToWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private final By logoBlueAir = By.xpath("//div[@class='wrapper']/a[@title='Blue Air Logo']");
    private final By loginButtonHeader = By.xpath("//a[contains(@id,'login')]");
    private final By languageCurrencyButtonHeader = By.xpath("//li[@id='language-currency-selector']/a");
    private final By dismissCookie = By.xpath("//button[contains(@class,'cookies') and contains(@class,'remove')]");
    private final By cookieNotification = By.id("divCookies");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void dismissCookieNotificationIfDisplayed(){
        waitUntilElementIsVisible(cookieNotification);
        if (driverFindElement(cookieNotification).isDisplayed()){
            driverFindElement(dismissCookie).click();
        }
    }

    public LoginPage clickOnLoginButton() {
        waitUntilElementIsVisible(loginButtonHeader);
        clickOnElement(loginButtonHeader);
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public LanguageCurrencyPage clickOnLanguageCurrencyButton(){
        waitUntilElementIsVisible(loginButtonHeader);
        clickOnElement(languageCurrencyButtonHeader);
        return PageFactory.initElements(driver, LanguageCurrencyPage.class);
    }

    public void clickOnElement(WebElement element) {
        waitUntilElementIsClickable(element);
        element.click();
    }

    public void clickOnElement(By locator) {
        waitUntilElementIsClickable(locator);
        WebElement element = driverFindElement(locator);
        element.click();
    }

    public void clickOnElementFromParent(By element, WebElement parent){
        driverFindElementInParent(element, parent).click();
    }

    public void clickOnElementFromParent(By element, By parent){
        driverFindElementInParent(element, parent).click();
    }

    // TODO: vezi de ce nu merg functiile de cautare in parinte

    public WebElement driverFindElement(By locator) {
        waitUntilElementIsVisible(locator);
        return driver.findElement(locator);
    }

    public WebElement driverFindElement(String locator){
        waitUntilElementIsVisible(By.xpath(locator));
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> driverFindElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement driverFindElementInParent(By element, WebElement parent) {
        return parent.findElement(element);
    }

    public WebElement driverFindElementInParent(By element, By parent) {
        WebElement parentWebElement = driverFindElement(parent);
        return parentWebElement.findElement(element);
    }

    public void setElementText(WebElement element, String text) {
        enterText(element, text);
    }

    public void setElementText(By locator, String text) {
        WebElement element = driverFindElement(locator);
        enterText(element, text);
    }

    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void selectByValueInDropdown(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectByValueInDropdown(By dropdown, String value) {
        WebElement dropdownWebElement = driverFindElement(dropdown);
        Select select = new Select(dropdownWebElement);
        select.selectByValue(value);
    }

    public void selectByVisibleTextInDropdown(By dropdown, String value) {
        WebElement dropdownWebElement = driverFindElement(dropdown);
        Select select = new Select(dropdownWebElement);
        select.selectByVisibleText(value);
    }


    public List<WebElement> getDisplayedOptionsFor(By optionsLocator){
        return driverFindElements(optionsLocator);
    }

    public void waitUntilElementIsVisible(By locator, int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Element is not displayed")
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait.until(driver -> driver.findElement(locator).isDisplayed());
    }

    public void waitUntilElementIsVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeToWait.FIVE_SECONDS))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Element is not displayed")
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeToWait.THREE_SECONDS))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Element is not displayed")
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsClickable(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeToWait.FIVE_SECONDS))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Element is not displayed")
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementIsClickable(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TimeToWait.FIVE_SECONDS))
                .pollingEvery(Duration.ofMillis(10))
                .withMessage("Element is not displayed")
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Scrolls to element when it's already in the DOM
     * @param locator
     */

    public void scrollToElement(By locator){
        WebElement element = driverFindElement(locator);
        String script = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }

    public void scrollToElement(WebElement element){
        String script = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }
}
