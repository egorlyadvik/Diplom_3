package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage {

    WebDriver driver;
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement loginLink;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Login link click")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }
}
