package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver driver;
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement logoutButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Logout button click")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    @Step("Check logout button is displayed")
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }
}
