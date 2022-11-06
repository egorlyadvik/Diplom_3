import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import page.Header;
import page.MainPage;
import user.UserOperations;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

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
    @DisplayName("Login is successful from main page")
    @Description("Login is successful from main page by enter account button click")
    public void loginIsSuccessfulFromMainPage() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();

        assertTrue("Create order button isn't displayed", mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login is successful from header")
    @Description("Login is successful from header by account button click")
    public void loginIsSuccessfulFromHeaderAccountButton() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        new Header(driver).clickAccountButtonForUnauthorizedUser()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();

        assertTrue("Create order button isn't displayed", mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login is successful from registration page")
    @Description("Login is successful from registration page by login link click")
    public void loginIsSuccessfulFromRegistrationPage() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .clickRegisterLink()
                .clickLoginLink()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();

        assertTrue("Create order button isn't displayed", mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Login is successful from recovery page")
    @Description("Login is successful from recovery page by login link click")
    public void loginIsSuccessfulFromPasswordRecoveryPage() {
        String email = userData.get("email");
        String password = userData.get("password");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .clickPasswordRecoveryLink()
                .clickLoginLink()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();

        assertTrue("Create order button isn't displayed", mainPage.isCreateOrderButtonDisplayed());
    }
}
