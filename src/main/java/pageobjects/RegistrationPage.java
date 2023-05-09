package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage extends MainAbstractPage {
    // Локаторы
    private final By fieldNameRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By fieldEmailRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By fieldPasswordRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private final By buttonRegistrationRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private final By errorMessageRegistrationPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");
    private final By enterLinkRegistrationPage = By.className("Auth_link__1fOlj");

    //Конструктор
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Методы
    public void inputRegistrationData(String name, String email, String password) { // метод, заполняющий текстовые поля разом
        driver.findElement(fieldNameRegistrationPage).sendKeys(name);
        driver.findElement(fieldEmailRegistrationPage).sendKeys(email);
        driver.findElement(fieldPasswordRegistrationPage).sendKeys(password);
    }

    public void buttonRegistrationClick() {
        driver.findElement(buttonRegistrationRegistrationPage).click();
    }

    public void buttonEnterLinkClick() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(enterLinkRegistrationPage));
        driver.findElement(enterLinkRegistrationPage).click();
    }

    public boolean isPasswordErrorDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageRegistrationPage));
        boolean success = driver.findElement(errorMessageRegistrationPage).isDisplayed();
        return success;
    }
}
