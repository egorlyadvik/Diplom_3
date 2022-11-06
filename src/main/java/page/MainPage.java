package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;
    public final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement enterAccountButton;
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement createOrderButton;
    @FindBy(xpath = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]")
    private WebElement selectedTab;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(mainPageUrl);
    }

    @Step("Enter account button click")
    public LoginPage clickEnterAccountButton() {
        enterAccountButton.click();
        return new LoginPage(driver);
    }

    @Step("Check create order button is displayed")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.isDisplayed();
    }

    @Step("Check needed tab is selected")
    public boolean isTabSelected(String tabName) {
        return selectedTab.getText().contains(tabName);
    }

    @Step("Ingredient tab click")
    public MainPage clickTab(String tabName) {
        WebElement tabElement = driver.findElement(By.xpath(String.format(".//span[@class='text text_type_main-default' and text()='%s']", tabName)));
        WebElement tabElementParent = driver.findElement(By.xpath(String.format(".//span[@class='text text_type_main-default' and text()='%s']/parent::div", tabName)));

        if (!tabElementParent.getAttribute("class").contains("tab_tab_type_current__2BEPc")) {
            tabElement.click();
        }
        return this;
    }
}
