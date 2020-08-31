package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser) {
        File rootPath = new File("src/test/resources/drivers");
        if(browser.toLowerCase().equals("chrome")) {
            File chromeFilePath = new File(rootPath, getDriverName());
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
    public static String getDriverName(){
        String operSys = System.getProperty("os.name").toLowerCase();
        if (operSys.contains("mac")) {
            return "chromedriver";
        }
        return "chromedriver.exe";
    }
}
