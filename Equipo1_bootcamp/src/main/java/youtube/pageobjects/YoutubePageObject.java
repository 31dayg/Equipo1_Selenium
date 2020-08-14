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

    @FindBy(how = How.XPATH, using = "//div/descendant::ytd-video-renderer/div/div/div/div/h3/a")
    private List<WebElement> resultsListTitles;

    @FindBy(how = How.XPATH, using = "//yt-icon-button[@id='guide-button']/button/yt-icon[@class='style-scope ytd-masthead']")
    private WebElement HamburguerButton;

    @FindBy(how = How.XPATH, using = "//div[@id='buttons']/ytd-button-renderer/a/paper-button/yt-icon")
    private WebElement accederButton;


}
