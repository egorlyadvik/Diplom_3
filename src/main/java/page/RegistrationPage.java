package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;
    @FindBy(xpath = ".//div[label[text()='Имя']]//input")
    private WebElement nameInput;
    @FindBy(xpath = ".//div[label[text()='Email']]//input")
    private WebElement emailInput;
    @FindBy(xpath = ".//div[label[text()='Пароль']]//input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement registerButton;
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement loginLink;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Name input fill")
    public RegistrationPage fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Email input fill")
    public RegistrationPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Password input fill")
    public RegistrationPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Registration button click")
    public LoginPage clickRegisterButton() {
        registerButton.click();
        return new LoginPage(driver);
    }

    @Step("Check password error message is displayed")
    public boolean isPasswordErrorMessageDisplayed() {
        emailInput.click();
        return passwordErrorMessage.isDisplayed();
    }

    @Step("Login link click")
    public LoginPage clickLoginLink() {
        loginLink.click();
        return new LoginPage(driver);
    }
}
