package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//Локаторы
public class MainPage extends MainAbstractPage {
    private By personalAccountTopButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p"); // Локатор кнопки "Личный кабинет"
    private By personalAccountEnterButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    private By burgerText = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1");
    private By bunConstructor = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span");
    private By sauceConstructor = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private By mainConstructor = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
    private By selectedConstructorLocator = By.cssSelector("#root > div > main > section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > div.tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10.noselect");

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
        driver.findElement(bunConstructor).click();
    }

    public void clickSauce() {
        driver.findElement(sauceConstructor).click();
    }

    public void clickMain() {
        driver.findElement(mainConstructor).click();
    }

    public void clickPersonalAccountEnterButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(personalAccountEnterButton).click();
    }

    public boolean isBurgerTextIsDisplayed() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(burgerText));
        boolean success = driver.findElement(burgerText).isDisplayed();
        return success;
    }

    public boolean isSelectedConstructorIsDisplayed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(selectedConstructorLocator));
        boolean success = driver.findElement(selectedConstructorLocator).isDisplayed();
        return success;
    }

    public String test() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountEnterButton));
        String name = driver.findElement(personalAccountEnterButton).getText();
        return name;
    }
}
