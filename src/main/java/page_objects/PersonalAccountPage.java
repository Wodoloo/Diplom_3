package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage extends MainAbstractPage {
    //Локаторы
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    private By burgerPicture = By.className("AppHeader_header__logo__2D0X2");
    private By constructorLink = By.className("AppHeader_header__link__3D_hX");

    // Конструктор
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    // Методы
    public void clickLogoutButton() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public void clickBurgerPicture() {
        driver.findElement(burgerPicture).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public boolean isLogoutButtonIsDisplayed() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        boolean success = driver.findElement(logoutButton).isDisplayed();
        return success;
    }
}
