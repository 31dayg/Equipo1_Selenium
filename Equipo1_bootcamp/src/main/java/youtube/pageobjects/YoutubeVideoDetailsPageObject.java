package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YoutubeVideoDetailsPageObject extends BasePageObject{

    @FindBy(how = How.XPATH, using = "//button[@class='ytp-play-button ytp-button']")
    private WebElement videoStream;

    @FindBy(how = How.XPATH, using = "//div[@id='info-contents']//div[@id='container']/h1/yt-formatted-string")
    private WebElement titleVideo;

    @FindBy(how = How.XPATH, using = "//div[@id='top-level-buttons']/descendant::*[@id='text'][1]")
    private WebElement likes;

    @FindBy(how = How.XPATH, using = "//div[@id='top-level-buttons']/descendant::*[@id='text'][2]")
    private WebElement dislikes;

    @FindBy(how = How.XPATH, using = "//div[@id='info-contents']//span[@class='view-count style-scope yt-view-count-renderer']")
    private WebElement views;

    @FindBy(how = How.XPATH, using = "//div[@id='description']/yt-formatted-string")
    private WebElement videoDescription;

    @FindBy(how = How.XPATH, using = "//div[@id='title']/h2[@id='count']")
    private WebElement comments;

    @FindBy(how = How.XPATH, using = "//ytd-watch-next-secondary-results-renderer/div[@id='items']/descendant::*[@class='style-scope ytd-watch-next-secondary-results-renderer']//span[@id='video-title']")
    private List<WebElement> relatedVideos;

    public YoutubeVideoDetailsPageObject(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public boolean isPlaying() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(videoStream));
        return this.videoStream.getAttribute("aria-label").equals("Play (k)");
    }

    public String getTitleVideo() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(titleVideo));
        return this.titleVideo.getText();
    }

    public String getLikes() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(likes));
        return this.likes.getText();
    }

    public String getDislikes() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(dislikes));
        return this.dislikes.getText();
    }

    public String getViews() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(views));
        return this.views.getText();
    }

    public String getVideoDescription() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(videoDescription));
        return this.videoDescription.getTagName();
    }

    public String getTotalComments() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return this.comments.getText();
    }

    public boolean commentsAreDisplayed() {
        return this.comments.isDisplayed();
    }

    public void getRelatedVideos() {
        int i = 0;
        while (i < relatedVideos.size()) {
            System.out.println(relatedVideos.get(i).getText());
            i++;
        }
    }








}
