package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private final By connectButton = By.xpath("//div[@id='login-popup']//button[@type='submit']");
    private final By createAccountButton = By.xpath("//div[@id='login-popup']/a[contains(@href,'CreateAccount')]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage clickOnSignUpButton(){
        waitUntilElementIsVisible(createAccountButton);
        clickOnElement(createAccountButton);
        return PageFactory.initElements(driver, RegisterPage.class);
    }
}
