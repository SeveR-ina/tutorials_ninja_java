package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.EditAccInfoPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BasicTest {

    private HomePage homePage;

    /**
     * Sets and loads test properties.
     */
    @BeforeTest
    public void doBeforeTest() {
        initializeProperties();
        loadPropertiesFromFile();
    }

    /**
     * Opens Browser, goes to start URL, accepts cookies.
     * Opens Home page and signs in.
     *
     * @param browser  can be chosen via parameter and value from testng xml.
     * @param headless can be chosen via parameter and value from testng xml.
     */
    @Parameters({"browser", "headless"})
    @BeforeMethod
    public void openBrowserAndAcceptCookiesAndSignIn(String browser, boolean headless) {

        //Prepare web drivers:
        doPreparationsFor(browser, headless);

        homePage = new HomePage(driver);
        defaultImplicitWait();
    }

    @AfterMethod
    public void closeBrowser() {
        quitDriver();
    }

    @Test(description = "After logging in, User sees his profile")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story : Verify that after successful log in user can see his profile")
    public void logIn() {
        String email = testProperties.getProperty("email");
        String pass = testProperties.getProperty("pass");

        //Go to Log in Page:
        homePage.goToLogInPage();

        //Sign in with test data email and password:
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, pass);

        AccountPage accountPage = new AccountPage(driver);
        accountPage.openAccInfo();

        EditAccInfoPage editAccInfoPage = new EditAccInfoPage(driver);

        Assert.assertEquals(email, editAccInfoPage.getAccEmail(), "Actual account email != expected email");
    }
}
