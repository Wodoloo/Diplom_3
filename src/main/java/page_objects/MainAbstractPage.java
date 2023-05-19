package page_objects;

import org.openqa.selenium.WebDriver;

public abstract class MainAbstractPage { // абстрактный класс для всех страниц проекта
    protected final WebDriver driver;

    public MainAbstractPage(WebDriver driver) { // конструктор абстрактного класса
        this.driver = driver;
    }
}