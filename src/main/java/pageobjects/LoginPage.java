package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends MainAbstractPage {
    //Локаторы
    private By fieldEmailLoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); // Локатор поля "E-mail"
    private By fieldPasswordLoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); // Локатор поля "Пароль"
    private By buttonEnterLoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By registrationLinkLoginPage = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a"); // Локатор ссылки регистрация
    private By forgotPasswordLink = By.className("Auth_link__1fOlj");

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