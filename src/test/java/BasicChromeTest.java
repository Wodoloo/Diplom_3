import constants.Constants;
import helper.UserHelper;
import page_objects.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicChromeTest {
    protected static WebDriver webDriver;
    protected static UserHelper userHelper = new UserHelper();
    protected static boolean isYandex = false;

    @BeforeClass
    public static void setup() {
        if (isYandex)
            WebDriverManager.chromedriver().setup();
        else
            System.setProperty("webdriver.chrome.driver", "C:/JAN/Testing/WebDrivers/yandexdriver-23.3.0.2246-win64/yandexdriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(Constants.hostname);
        MainPage objMainPage = new MainPage(webDriver);
    }

    @AfterClass
    public static void teardown() {
        webDriver.quit();
    }
}
