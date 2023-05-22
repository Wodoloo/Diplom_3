import helper.UserRegistration;
import page_objects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class PersonalAccountChromeTest extends BasicChromeTest {
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
    @DisplayName("Check transition with «Личный кабинет» button")
    public void clickToPersonalAccountLinkTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        objMainPage.clickPersonalAccountTopButton();
        assertTrue("Ошибка", objPersonalAccountPage.isLogoutButtonIsDisplayed());
    }

    @Test
    @DisplayName("Check transition with «Конструктор» button")
    public void clickToConstructorLinkTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        objMainPage.clickPersonalAccountTopButton();
        objPersonalAccountPage.clickConstructorLink();
        assertTrue("Ошибка", objMainPage.isBurgerTextVisible());
    }

    @Test
    @DisplayName("Check transition with «Stellar Burgers» logo click")
    public void clickToLogoTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
        objMainPage.clickPersonalAccountTopButton();
        objPersonalAccountPage.clickBurgerPicture();
        assertTrue("Ошибка", objMainPage.isBurgerTextVisible());
    }

    @Test
    @DisplayName("Check logging out")
    public void clickLogOutTest() {
        objMainPage.clickPersonalAccountTopButton();
        objLoginPage.inputLoginData(user.getEmail(), user.getPassword());
        objLoginPage.clickEnterButton();
    }
}
