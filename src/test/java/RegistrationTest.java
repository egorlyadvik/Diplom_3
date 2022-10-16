import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import page.MainPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Registration is successful")
    @Description("Registration is successful with correct password")
    public void registrationIsSuccessfulWithCorrectPassword() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@test.ru";
        String password = RandomStringUtils.randomAlphanumeric(6);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterAccountButton()
                .clickRegisterLink()
                .fillNameInput(name)
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickRegisterButton()
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .clickLoginButton();

        assertTrue(mainPage.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Registration is unsuccessful")
    @Description("Registration is successful with incorrect password")
    public void registrationIsNotSuccessfulWithIncorrectPassword() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@test.ru";
        String password = RandomStringUtils.randomAlphanumeric(5);
        assertTrue(new MainPage(driver)
                .clickEnterAccountButton()
                .clickRegisterLink()
                .fillNameInput(name)
                .fillEmailInput(email)
                .fillPasswordInput(password)
                .isPasswordErrorMessageDisplayed());
    }
}
