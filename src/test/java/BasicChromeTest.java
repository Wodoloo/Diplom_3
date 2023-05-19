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

    @BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(Constants.hostname);
        MainPage objMainPage = new MainPage(webDriver);
    }

    @AfterClass
    public static void teardown() {
        webDriver.quit();
    }
}
