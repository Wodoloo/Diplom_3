import page_objects.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class ConstructorChromeTest extends BasicChromeTest {
    MainPage objMainPage = new MainPage(webDriver);

    @Test
    @DisplayName("Move to 'fillings' section")
    public void moveToFillingSectionTest() throws InterruptedException {
        objMainPage.clickFilling();
        Thread.sleep(500);
        assertTrue("Ошибка, раздел не открывается", objMainPage.isFillingLocatorVisible());
    }

    @Test
    @DisplayName("Move to 'sauces' section")
    public void moveToSauceSectionTest() throws InterruptedException {
        objMainPage.clickSauce();
        Thread.sleep(500);
        assertTrue("Ошибка, раздел не открывается", objMainPage.isSauceLocatorVisible());
    }

    @Test
    @DisplayName("Move to 'buns' section")
    public void moveToBunSectionTest() throws InterruptedException {
        objMainPage.clickSauce();
        objMainPage.clickBun();
        assertTrue("Ошибка, раздел не открывается", objMainPage.isBunLocatorVisible());
    }
}
