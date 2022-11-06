import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {

    private String tab;

    public ConstructorTest(String tab) {
        this.tab = tab;
    }

    @Parameterized.Parameters(name = "Таб = {0}")
    public static Object[][] getTabData() {
        return new Object[][]{
                {"Булки"},
                {"Соусы"},
                {"Начинки"},
        };
    }

    @Test
    @DisplayName("Tab switching is correct")
    @Description("Tab switching is correct by ingredient tab click")
    public void testIngredientTabSwitch() {
        assertTrue("Ingredient tab isn't selected", new MainPage(driver)
                .clickTab(tab)
                .isTabSelected(tab));
    }
}
