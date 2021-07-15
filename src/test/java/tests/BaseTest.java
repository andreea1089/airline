package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HomePage;
import utils.WebDriverManager;


public class BaseTest {
    private WebDriverManager webDriverManager = new WebDriverManager();


    public void openURLInBrowser() {
        webDriverManager.initializeDriver();
    }

    public HomePage getHomePage() {
        return PageFactory.initElements(getDriver(), HomePage.class);
    }

    public BasePage getBasePage() {
        return PageFactory.initElements(getDriver(), BasePage.class);
    }

    @AfterTest
    public void closeBrowser() {
//        getDriver().close();
    }

    protected WebDriver getDriver() {
        return webDriverManager.getDriver();
    }
}
