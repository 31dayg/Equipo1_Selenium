package youtube;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverFactory;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTestCase {


    protected WebDriver myDriver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // Define which browser to use
        //String browser = "chrome";
        String browser = PropertyReader.getProperty("youtube.properties", "BROWSER");

        // Get correct driver for desire browser
        myDriver = WebDriverFactory.getDriver(browser);
        myDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(PropertyReader.getProperty("youtube.properties", "PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        myDriver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getProperty("youtube.properties", "IMPLICITLY_WAIT_TIMEOUT")), TimeUnit.SECONDS);
        myDriver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        myDriver.close();
        myDriver.quit();
    }

    public WebDriver getWebDriver() {
        return this.myDriver;
    }
}
