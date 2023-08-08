package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = "a[href='https://tutorialsninja.com/demo/index.php?route=account/edit']")
    private WebElement editLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open Edit info.
     */
    @Step("Open acc info")
    public void openAccInfo() {
        waitForVisibilityOf(editLink);
        editLink.click();
    }
}
