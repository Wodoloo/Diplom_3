package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends MainAbstractPage {
    // Локаторы
    private By rememberPasswordLink = By.className("Auth_link__1fOlj");

    //Конструктор
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    //Методы
    public void clickRememberPasswordLink() {
        driver.findElement(rememberPasswordLink).click();
    }
}