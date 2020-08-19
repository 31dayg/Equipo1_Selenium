package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class YoutubeHomePageObject extends BasePageObject {

    //ELEMENTOS DEL LEFT MENU - TENDECIAS, BIBLIOTECA E HISTORIAL
    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[1]//a[1]")
    private WebElement homeIcon;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[2]//a[1]")
    private WebElement trendingIcon;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[1]//a[1]")
    private WebElement musicIcon;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[2]//a[1]")
    private WebElement gaminIcon;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[3]//a[1]")
    private WebElement newsIcon;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[4]//a[1]")
    private WebElement moviesIcon;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[3]//a[1]")
    private WebElement subscriptionsIcon;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[4]//a[1]")
    private WebElement libraryIcon;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[5]//a[1]")
    private WebElement historyIcon;

    @FindBy(how = How.XPATH, using = "//ytd-item-section-renderer[1]//div[3]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer")
    private List<WebElement> resultsSearchCategorias;

    // AQUI VAN LOS ELEMENTOS DEL MAIN AREA EN HOME.

    public YoutubeHomePageObject(WebDriver driver, String baseURL) {
        super(driver, baseURL);
    }



}
