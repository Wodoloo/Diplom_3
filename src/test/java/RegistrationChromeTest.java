import helper.UserRegistration;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegistrationPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class RegistrationChromeTest extends BasicChromeTest {
    MainPage objMainPage = new MainPage(webDriver);
    LoginPage objLoginPage = new LoginPage(webDriver);
    RegistrationPage objRegistrationPage = new RegistrationPage(webDriver);

    @Test
    @DisplayName("Successful registration")
    public void successRegistrationTest() {
        UserRegistration user = userHelper.generateRandomUserCredentials(8);
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.clickRegistrationLink();
        objRegistrationPage.inputRegistrationData(user.getName(), user.getEmail(), user.getPassword());
        objRegistrationPage.buttonRegistrationClick();
        assertTrue("Ошибка", objLoginPage.isButtonEnterIsDisplayed());
        userHelper.deleteUser(user);
    }

    @Test
    @DisplayName("Short password error. Min 6 symbols")
    public void shortPasswordTest() {
        UserRegistration user = userHelper.generateRandomUserCredentials(4);
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.clickRegistrationLink();
        objRegistrationPage.inputRegistrationData(user.getName(), user.getEmail(), user.getPassword());
        objRegistrationPage.buttonRegistrationClick();
        assertTrue("Ошибка", objRegistrationPage.isPasswordErrorDisplayed());
    }
}
