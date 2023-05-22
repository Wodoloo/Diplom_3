package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage extends MainAbstractPage {
    // Локаторы
    private final By fieldNameRegistrationPage = By.xpath(".//fieldset[1]//input");
    private final By fieldEmailRegistrationPage = By.xpath(".//fieldset[2]//input");
    private final By fieldPasswordRegistrationPage = By.xpath(".//fieldset[3]//input");
    private final By buttonRegistrationRegistrationPage = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By errorMessageRegistrationPage = By.xpath(".//p[@class='input__error text_type_main-default']");
    private final By signInLinkRegistrationPage = By.xpath(".//a[@href='/login']");

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
                .until(ExpectedConditions.visibilityOfElementLocated(signInLinkRegistrationPage));
        driver.findElement(signInLinkRegistrationPage).click();
    }

    public boolean isPasswordErrorDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageRegistrationPage));
        boolean success = driver.findElement(errorMessageRegistrationPage).isDisplayed();
        return success;
    }
}
