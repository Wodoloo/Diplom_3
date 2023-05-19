import constants.Constants;
import helper.UserRegistration;
import page_objects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;

public class LoginChromeTest extends BasicChromeTest {
    UserRegistration user;
    MainPage objMainPage = new MainPage(webDriver);
    LoginPage objLoginPage = new LoginPage(webDriver);
    RegistrationPage objRegistrationPage = new RegistrationPage(webDriver);
    ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(webDriver);
    PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(webDriver);

    @Before
    public void registrationTestUser() throws InterruptedException {
        user = userHelper.generateRandomUserCredentials(6);
        userHelper.apiUserRegistration(user);
    }

    @After
    public void testCleanUp() {
        objMainPage.clickPersonalAccountTopButton();
        objPersonalAccountPage.clickLogoutButton();
        userHelper.deleteUser(user);
    }

    @Test
    @DisplayName("Enter account using «Войти в аккаунт» button on main page")
    public void mainPageEnterAccountTest() {
        webDriver.get(Constants.hostname);
        objMainPage.clickPersonalAccountEnterButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        assertEquals("Кнопка не сменила название", "Оформить заказ", objMainPage.getPersonalAccountEnterButtonText());
    }

    @Test
    @DisplayName("Enter account using «Личный кабинет» button")
    public void mainPageTopEnterAccountTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        assertEquals("Кнопка не сменила название", "Оформить заказ", objMainPage.getPersonalAccountEnterButtonText());
    }

    @Test
    @DisplayName("Enter account using registration form button")
    public void registrationPageEnterAccountTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.clickRegistrationLink();
        objRegistrationPage.buttonEnterLinkClick();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        assertEquals("Кнопка не сменила название", "Оформить заказ", objMainPage.getPersonalAccountEnterButtonText());
    }

    @Test
    @DisplayName("Enter using button in restore password form")
    public void forgotPasswordPageEnterAccountTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.clickForgotPasswordLink();
        objForgotPasswordPage.clickRememberPasswordLink();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        assertEquals("Кнопка не сменила название", "Оформить заказ", objMainPage.getPersonalAccountEnterButtonText());
    }
}
