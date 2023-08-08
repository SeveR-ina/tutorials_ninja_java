package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passInput;

    @FindBy(css = "input[type='submit']")
    private WebElement loginBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Log in.
     */
    @Step("Log in with {email} and password")
    public void login(String email, String pass) {
        waitForVisibilityOf(emailInput);
        sendKeys(emailInput, email);
        sendKeys(passInput, pass);
        loginBtn.click();
    }
}
