package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser) {
        File rootPath = new File("testngtest/src/test/resources/drivers");
        if(browser.toLowerCase().equals("chrome")) {
            //ChromeOptions options = new ChromeOptions();
            //new ChromeDriver(options);
            //options.addArguments("--disable-notifications");
            File chromeFilePath = new File(rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            File firefoxFilePath = new File(rootPath, "geckodriver");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        } else {
            return null;
        }
    }


}

