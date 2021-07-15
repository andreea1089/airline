package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class WebDriverManager {
    private WebDriver driver;
    private PropertyFileManager propertyFileManager = PropertyFileManager.getInstance();
    private String driverLocation = propertyFileManager.getDriverLocation();
    private String url = propertyFileManager.getUrl();

    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver",driverLocation );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
