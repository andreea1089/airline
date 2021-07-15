package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterConfirmationPage extends BasePage {
    private final By homePageButton = By.xpath(".//a[contains(text(), 'Homepage')]");


    public boolean isRegisterConfirmationPageDisplayed(){
        waitUntilElementIsVisible(homePageButton);
        return driverFindElement(homePageButton).isDisplayed();
    }
    public RegisterConfirmationPage(WebDriver driver) {
        super(driver);
    }
}
