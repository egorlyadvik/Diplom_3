import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import page.Header;
import page.MainPage;
import user.UserOperations;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountTest extends BaseTest {

    UserOperations userOperations;
    Map<String, String> userData;

    @Before
    public void userRegistration() {
        userOperations = new UserOperations();
        userData = userOperations.createUser();
    }

    @After
    public void userDelete() {
        userOperations.deleteUser();
    }

    @Test
    @DisplayName("Account page can be opened from main page")
    @Description("Account page can be opened from main page by account button click")
    public void accountPageIsOpenedFromMainPage() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        assertTrue(new Header(driver)
                .clickAccountButtonForAuthorizedUser()
                .isLogoutButtonDisplayed());
    }

    @Test
    @DisplayName("Account page can be opened from order list page")
    @Description("Account page can be opened from order list page by account button click")
    public void accountPageIsOpenedFromOrderListPage() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = new Header(driver);
        assertTrue(header
                .clickOrderListButton()
                .isOrderListTopicDisplayed());

        assertTrue(header
                .clickAccountButtonForAuthorizedUser()
                .isLogoutButtonDisplayed());
    }

    @Test
    @DisplayName("Main page can be opened by constructor button click")
    public void mainPageIsOpenedByConstructorButtonClick() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = new Header(driver);
        assertTrue(header
                .clickAccountButtonForAuthorizedUser()
                .isLogoutButtonDisplayed());

        assertTrue(header
                .clickConstructorButton()
                .isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Main page can be opened by logo button click")
    public void mainPageIsOpenedByLogoButtonClick() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = new Header(driver);
        assertTrue(header
                .clickAccountButtonForAuthorizedUser()
                .isLogoutButtonDisplayed());

        assertTrue(header
                .clickLogoButton()
                .isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Logout is successful")
    @Description("Logout is successful by logout button at account page click")
    public void logoutButtonShouldLogoutUser() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed());

        Header header = new Header(driver);

        assertTrue(header
                .clickAccountButtonForAuthorizedUser()
                .clickLogoutButton()
                .isLoginButtonDisplayed());
    }
}
