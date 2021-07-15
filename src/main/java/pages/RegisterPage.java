package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class RegisterPage extends BasePage {
    private final By registrationForm = By.xpath("//form[@id='register-form']");
    private final By myAccountHeading = By.xpath(".//div[contains(@class, 'register__content')]//span[text()='My Account']");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By emailAddress = By.id("EmailAddress");
    private final By password = By.id("Password");
    private final By passwordConfirmation = By.id("PasswordConfirmation");
    private final By day = By.id("birthday-day");
    private final By month = By.id("birthday-month");
    private final By year = By.id("birthday-year");
    private final By maleGender = By.xpath(".//label[@for='gender-male']");
    private final By femaleGender = By.xpath(".//label[@for='gender-female']");
    private final By promotionalAgreement = By.xpath(".//label[contains(@for,'promotional')]");
    private final By termsAndConditionsAgreement = By.xpath(".//label[contains(@for,'tc-agreement')]");
    private final By registrationButton = By.xpath("//form[@id='register-form']//button[@type='submit']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegisterPageDisplayed() {
        return driverFindElement(registrationForm).isDisplayed();
    }

    public void selectFemaleGender() {
        clickOnElement(femaleGender);
    }

    public void selectMaleGender() {
        clickOnElement(maleGender);
    }

    public void selectCompleteBirthDay(String dayOption, String monthOption, String yearOption) {
        waitUntilElementIsVisible(day, 3);
        selectByValueInDropdown(day, dayOption);
        waitUntilElementIsVisible(month, 3);
        selectByVisibleTextInDropdown(month, monthOption);
        waitUntilElementIsVisible(year, 3);
        selectByValueInDropdown(year, yearOption);
    }

    public void selectPromotionalAgreement(){
        clickOnElement(driverFindElement(promotionalAgreement));
    }

    public void selectTermsAndConditionsAgreement(){
        clickOnElement(driverFindElement(termsAndConditionsAgreement));
    }

    public boolean isPromotionalAgreementSelected(){
        return driverFindElement(promotionalAgreement).isSelected();
    }

    public boolean isTermsAndConditionsAgreementSelected(){
        return driverFindElement(termsAndConditionsAgreement).isSelected();
    }

    public void setFirstName(String enteredName) {
        setElementText(firstName, enteredName);
    }

    public void setLastName(String enteredLastName) {
        setElementText(lastName, enteredLastName);
    }

    public void setPassword(String enteredPassword) {
        setElementText(password, enteredPassword);
    }

    public void setPasswordConfirmation(String enteredPasswordConfimamtion) {
        setElementText(passwordConfirmation, enteredPasswordConfimamtion);
    }

    public void setEmailAddress(String enteredEmailAddress) {
        setElementText(emailAddress, enteredEmailAddress);
    }

    public RegisterConfirmationPage clickOnRegisterButton(){
        scrollToElement(registrationButton);
        clickOnElement(registrationButton);
        return PageFactory.initElements(driver, RegisterConfirmationPage.class);
    }

    private void selectOptionFromListIfPresent(String option, List<WebElement> options) {
        Optional<WebElement> targetOption = options.stream().filter(op -> op.getText().toLowerCase().equals(option.toLowerCase())).findAny();
        if (targetOption.isPresent()) {
            clickOnElement(targetOption.get());
        } else throw new NoSuchElementException("Option " + option + " does not exist.");
    }

}
