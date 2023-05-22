package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MainPage extends MainAbstractPage {

    private By personalAccountTopButton = By.xpath(".//p[(@class='AppHeader_header__linkText__3q_va ml-2') and (text() ='Личный Кабинет')]");
    private By personalAccountEnterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private By burgerText = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");

    private By bunTabConstructor = By.xpath(".//span[text() ='Булки']");

    private By sauceTabConstructor = By.xpath(".//span[text() ='Соусы']");
    private By fillingTabConstructor = By.xpath(".//span[text() ='Начинки']");

    private By bunSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Булки']");

    private By sauceSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Соусы']");
    private By fillingSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Начинки']");


    // Конструктор
    public MainPage(WebDriver driver) { // конструктор главной страницы
        super(driver);
    }

    //Методы
    public void clickPersonalAccountTopButton() { // кликаем кнопку "Личный кабинет"
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountTopButton));
        driver.findElement(personalAccountTopButton).click();
    }

    public void clickBun() {
        driver.findElement(bunTabConstructor).click();
    }

    public void clickSauce() {
        driver.findElement(sauceTabConstructor).click();
    }

    public void clickFilling() {
        driver.findElement(fillingTabConstructor).click();
    }

    public void clickPersonalAccountEnterButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(personalAccountEnterButton).click();
    }

    public boolean isBurgerTextVisible() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(burgerText));
        boolean success = driver.findElement(burgerText).isDisplayed();
        return success;
    }

    public boolean isBunLocatorVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(bunSection));
        boolean success = driver.findElement(bunSection).isDisplayed();
        return success;
    }
    public boolean isSauceLocatorVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(sauceSection));
        boolean success = driver.findElement(sauceSection).isDisplayed();
        return success;
    }
    public boolean isFillingLocatorVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingSection));
        boolean success = driver.findElement(fillingSection).isDisplayed();
        return success;
    }

    public String getPersonalAccountEnterButtonText() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountEnterButton));
        String name = driver.findElement(personalAccountEnterButton).getText();
        return name;
    }
}
