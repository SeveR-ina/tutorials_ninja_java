package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccInfoPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    public EditAccInfoPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open Edit info.
     */
    @Step("Open acc info")
    public String getAccEmail() {
        waitForVisibilityOf(emailInput);
        return emailInput.getAttribute("value");
    }
}
