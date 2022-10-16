package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderListPage {

    WebDriver driver;
    @FindBy(xpath = ".//main/div/h1[text()='Лента заказов']")
    private WebElement orderListTopic;

    public OrderListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Check order list topic is displayed")
    public boolean isOrderListTopicDisplayed() {
        return orderListTopic.isDisplayed();
    }
}
