package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

    protected WebDriver driver;
    protected String baseURL;

    public BasePageObject(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isLoaded() {
        return true;
    }


}
