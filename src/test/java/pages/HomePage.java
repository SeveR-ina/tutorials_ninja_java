package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='https://tutorialsninja.com/demo/index.php?route=account/account']")
    private WebElement accLink;

    @FindBy(css = "a[href='https://tutorialsninja.com/demo/index.php?route=account/login']")
    private WebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Goes to the Login page.
     */
    @Step("Go to the Log in page")
    public void goToLogInPage() {
        waitForVisibilityOf(accLink);
        accLink.click();
        waitForVisibilityOf(loginLink);
        loginLink.click();
    }
}
