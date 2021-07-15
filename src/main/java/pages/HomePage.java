package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private final By privacyPopUp = By.id("privacy-policy-popup");
    private final By closeButtonPrivacyPopUp = By.xpath("//button[contains(@title,'Close')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closePrivacyPopUpIfDisplayed(){
        WebElement popUp = driverFindElement(privacyPopUp);
        if (popUp.isDisplayed()) {
            driverFindElementInParent(closeButtonPrivacyPopUp, popUp).click();
        }
    }

}
