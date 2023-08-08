package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TimeOuts;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    private final Duration defaultTime;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.defaultTime = Duration.ofSeconds(TimeOuts.DEFAULT_TIMEOUT_IN_SECONDS.getTimeOutValue());
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for visibility of the page element for default time.
     */
    @Step("Wait for visibility of element: {0}")
    protected void waitForVisibilityOf(WebElement webElement) {
        new WebDriverWait(driver, defaultTime).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Fills the inputs with specific text.
     */
    @Step("Enter text: {text} to the input: {field}}")
    protected void sendKeys(WebElement field, String text) {
        field.click();
        field.clear();
        field.sendKeys(text);
    }
}
