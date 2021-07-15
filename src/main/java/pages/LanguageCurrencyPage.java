package pages;

import com.sun.tools.javac.comp.Todo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.text.Normalizer;

public class LanguageCurrencyPage extends BasePage {
    private final By language = By.xpath("//div[@id='language-popup']//div[contains(@class,' language-select')]");
    private final By currency = By.xpath("//div[@id='language-popup']//div[contains(@class,' currency-select')]");
    private final By apply = By.xpath("//div[@id='language-popup']//button[@type='submit']");
    private final String languageOption = "//div[contains(@class,' language-select')]//li[normalize-space()='%s']";
    private final String currencyOption = "//div[contains(@class,' currency-select')]//span[contains(text(), '%s')]";

    public LanguageCurrencyPage(WebDriver driver) {
        super(driver);
    }

    public void selectLanguage(String option){
        waitUntilElementIsVisible(language);
        clickOnElement(language);
        String chosenOption = String.format(languageOption, option);
        WebElement elementOption = driverFindElement(chosenOption);
        scrollToElement(elementOption);
        clickOnElement(elementOption);
    }

    public void selectCurrency(String option){
        waitUntilElementIsVisible(currency);
        clickOnElement(currency);
        String chosenOption = String.format(currencyOption, option);
        WebElement elementOption = driverFindElement(chosenOption);
        scrollToElement(elementOption);
        clickOnElement(elementOption);
    }

    public HomePage applyLanguageAndCurrencySettings() {
        WebElement webElement = driverFindElement(apply);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
        return PageFactory.initElements(driver, HomePage.class);
        // TODO: extract method to click with JS
    }
}
