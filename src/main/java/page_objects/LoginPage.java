package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends MainAbstractPage {

    private By fieldEmailLoginPage = By.xpath(".//fieldset[1]//input");
    //private By fieldEmailLoginPage = By.xpath(".//input[(@class='text input__textfield text_type_main-default') and (@name='name')]");
    private By fieldPasswordLoginPage = By.xpath(".//fieldset[2]//input");
    //private By fieldPasswordLoginPage = By.xpath(".//input[(@class='text input__textfield text_type_main-default') and (@name='Пароль')]");
    private By buttonEnterLoginPage = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By registrationLinkLoginPage = By.xpath(".//a[@href='/register']");
    private By forgotPasswordLink = By.xpath(".//a[@href='/forgot-password']");

    //Конструктор
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Методы
    public void inputLoginData(String email, String password) { // метод, заполняющий текстовые поля разом
        driver.findElement(fieldEmailLoginPage).sendKeys(email);
        driver.findElement(fieldPasswordLoginPage).sendKeys(password);
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLinkLoginPage).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void clickEnterButton() {
        driver.findElement(buttonEnterLoginPage).click();
    }

    public boolean isButtonEnterIsDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonEnterLoginPage));
        boolean success = driver.findElement(buttonEnterLoginPage).isDisplayed();
        return success;
    }
}