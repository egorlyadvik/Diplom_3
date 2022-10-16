package extensions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getBrowser() {
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                return new ChromeDriver();
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            }
            default:
                throw new RuntimeException("There is no such browser");
        }
    }
}
