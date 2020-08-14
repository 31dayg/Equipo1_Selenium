package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class YoutubePageObject {

    @FindBy(how = How.XPATH, using = "//input[@id = 'search']")
    private WebElement searchBox;

    @FindBy(how = How.ID, using = "search-icon-legacy")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div[@class='style-scope ytd-item-section-renderer']/descendant::ytd-video-renderer")
    private List<WebElement> resultsList;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement seacrhInGoogleButton;


}
