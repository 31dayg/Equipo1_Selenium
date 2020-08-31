package youtube.steps;

import org.openqa.selenium.WebDriver;
import youtube.pageobjects.YoutubeHomePageObject;
import youtube.pageobjects.YoutubePageObject;
import youtube.pageobjects.YoutubeVideoDetailsPageObject;

public class YoutubeUserStepsVideoDetails {

    private YoutubeVideoDetailsPageObject youtubeVideoDetailsPageObject;
    private YoutubePageObject youtubePageObject;

    public YoutubeUserStepsVideoDetails(WebDriver driver) {
        this.youtubePageObject = new YoutubePageObject(driver);
        this.youtubeVideoDetailsPageObject = new YoutubeVideoDetailsPageObject(driver);
    }

    public void goToVideoDetails(String word, int indexVideo) {
        this.youtubePageObject.sendKeysinSearchBox(word);
        this.youtubePageObject.clickOnSearchButton();
        this.youtubePageObject.clickOnSelectedVideo(indexVideo);
    }

    public boolean videoIsPlaying() {
        return this.youtubeVideoDetailsPageObject.isPlaying();
    }

    public String getTitleVideo() {
        return this.youtubeVideoDetailsPageObject.getTitleVideo();
    }

    public String getLikes() {
        return this.youtubeVideoDetailsPageObject.getLikes();
    }

    public String getDislikes() {
        return this.youtubeVideoDetailsPageObject.getDislikes();
    }

    public String getViews() {
        return this.youtubeVideoDetailsPageObject.getViews();
    }

    public String getVideoDescription() {
        return this.youtubeVideoDetailsPageObject.getVideoDescription();
    }

    public int getComments() {
        return this.youtubeVideoDetailsPageObject.getComments();
    }

    public void getRelatedVideos() {
        this.youtubeVideoDetailsPageObject.getRelatedVideos();
    }

    public void headerIsWorking(String word, int indexVideo) {
        this.youtubeVideoDetailsPageObject.getTitleVideo();
        this.youtubePageObject.sendKeysinSearchBox(word);
        this.youtubePageObject.clickOnSearchButton();
        this.youtubePageObject.clickOnSelectedVideo(indexVideo+1);
        this.youtubeVideoDetailsPageObject.getTitleVideo();
    }

    public void clickOnYoutubeIcon() {
        this.youtubePageObject.clickOnYoutubeIcon();
    }
}
