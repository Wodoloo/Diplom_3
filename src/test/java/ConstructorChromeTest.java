import pageobjects.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class ConstructorChromeTest extends BasicChromeTest {
    MainPage objMainPage = new MainPage(webDriver);

    @Test
    @DisplayName("Move to 'buns' section")
    public void moveToBunSectionTest() {
        objMainPage.clickMain();
        objMainPage.clickBun();
        assertTrue("Ошибка, раздел не открывается", objMainPage.isSelectedConstructorIsDisplayed());
    }

    @Test
    @DisplayName("Move to 'sauces' section")
    public void moveToSauceSectionTest() {
        objMainPage.clickSauce();
        assertTrue("Ошибка, раздел не открывается", objMainPage.isSelectedConstructorIsDisplayed());
    }

    @Test
    @DisplayName("Move to 'fillings' section")
    public void moveToFillingSectionTest() {
        objMainPage.clickMain();
        assertTrue("Ошибка, раздел не открывается", objMainPage.isSelectedConstructorIsDisplayed());
    }
}