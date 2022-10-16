import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.MainPage;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Tab switching is correct")
    @Description("Tab switching is correct by ingredient tab click")
    public void testIngredientTabSwitch() {
        new MainPage(driver).checkIngredientTabSwitch();
    }
}
