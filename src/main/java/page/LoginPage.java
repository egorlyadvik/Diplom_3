package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = ".//a[@href='/register']")
    private WebElement registerLink;
    @FindBy(xpath = ".//div[label[text()='Email']]//input")
    private WebElement emailInput;
    @FindBy(xpath = ".//div[label[text()='Пароль']]//input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = ".//a[@href='/forgot-password']")
    private WebElement passwordRecoveryLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickRegisterLink() {
        registerLink.click();
        return new RegistrationPage(driver);
    }

    public LoginPage fillEmailInput(String email) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(loginButton));
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public PasswordRecoveryPage clickPasswordRecoveryLink() {
        passwordRecoveryLink.click();
        return new PasswordRecoveryPage(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}
