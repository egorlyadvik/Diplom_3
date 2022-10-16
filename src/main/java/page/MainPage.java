package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainPage {

    WebDriver driver;
    public final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement enterAccountButton;
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement createOrderButton;
    @FindBy(xpath = ".//div[span[contains(@class, 'text')]]")
    private List<WebElement> ingredientTabs;
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

    @Step("Get list of ingredient tabs")
    public List<WebElement> getIngredientTabs() {
        return ingredientTabs;
    }

    @Step("Check needed tab is selected")
    public boolean isTabSelected(String tabName) {
        return selectedTab.getText().contains(tabName);
    }

    @Step("Check ingredient tabs are switching")
    public void checkIngredientTabSwitch() {
        List<WebElement> tabsList = getIngredientTabs();
        for (int i = tabsList.size() - 1; i >= 0; i--) {
            WebElement ingredientTab = tabsList.get(i);
            ingredientTab.click();

            String ingredientTabName = ingredientTab.getText();

            assertTrue(isTabSelected(ingredientTabName));
        }
    }
}
