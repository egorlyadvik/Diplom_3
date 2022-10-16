package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    WebDriver driver;
    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    private WebElement accountButton;
    @FindBy(xpath = ".//nav//a[@href='/feed']")
    private WebElement orderListButton;
    @FindBy(xpath = ".//p[text()='Конструктор']")
    private WebElement constructorButton;
    @FindBy(xpath = ".//nav/div/a[@href='/']")
    private WebElement logoButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Account button for unauthorized user click")
    public LoginPage clickAccountButtonForUnauthorizedUser() {
        accountButton.click();
        return new LoginPage(driver);
    }
    @Step("Account button for authorized user click")
    public AccountPage clickAccountButtonForAuthorizedUser() {
        accountButton.click();
        return new AccountPage(driver);
    }
    @Step("Order list button click")
    public OrderListPage clickOrderListButton() {
        orderListButton.click();
        return new OrderListPage(driver);
    }
    @Step("Constructor button click")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return new MainPage(driver);
    }
    @Step("Logo button click")
    public MainPage clickLogoButton() {
        logoButton.click();
        return new MainPage(driver);
    }
}
