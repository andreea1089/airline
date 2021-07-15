package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage;
    private HomePage homePage;
    private BasePage basePage;

    @BeforeTest
    public void initializeRegisterPage(){
        openURLInBrowser();
        homePage = getHomePage();
        basePage = getBasePage();
        homePage.closePrivacyPopUpIfDisplayed();
    }

    @Test
    public void testCompleteFlowForSuccessfulSignUp() {
        LanguageCurrencyPage languageCurrencyPage = basePage.clickOnLanguageCurrencyButton();
        languageCurrencyPage.dismissCookieNotificationIfDisplayed();
        languageCurrencyPage.selectLanguage("English");
        languageCurrencyPage.selectCurrency("Euro");
        languageCurrencyPage.applyLanguageAndCurrencySettings();
        registerPage = homePage.clickOnLoginButton().clickOnSignUpButton();
        registerPage.dismissCookieNotificationIfDisplayed();
        registerPage.setFirstName("Andreea");
        registerPage.setLastName("Cnej");
        registerPage.setEmailAddress("delia.carp89@gmail.com");
        registerPage.setPassword("deliasidanut");
        registerPage.setPasswordConfirmation("deliasidanut");
        registerPage.selectCompleteBirthDay("10", "august", "1989");
        registerPage.selectFemaleGender();
        registerPage.selectTermsAndConditionsAgreement();
        RegisterConfirmationPage registerConfirmationPage = registerPage.clickOnRegisterButton();
        Assert.assertTrue(registerConfirmationPage.isRegisterConfirmationPageDisplayed(), "Register confirmation page is not displayed");
        // TODO: make test pass
    }

    @Test
    public void verifyGenderOptionsCannotBeSelectedSimultaneous() {

    }

    @Test
    public void verifyLanguageDropdownOptions() {

    }
}
