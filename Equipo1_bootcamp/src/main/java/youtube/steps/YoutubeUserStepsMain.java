package youtube.steps;

import org.openqa.selenium.WebDriver;
import youtube.pageobjects.YoutubePageObject;

// Capa de steps. tiene que tener metodos de mas alto nivel que simulen nivel de usuario.

public class YoutubeUserStepsMain {

    // HEADER

    private YoutubePageObject youtubePageObject;

    public YoutubeUserStepsMain(WebDriver driver) {
        this.youtubePageObject = new YoutubePageObject(driver);
    }

    public void searchVideo(String word) {
        this.youtubePageObject.sendKeysinSearchBox(word);
        this.youtubePageObject.clickOnSearchButton();
    }

    public void resultsList(String word) {
        this.youtubePageObject.sendKeysinSearchBox(word);
        this.youtubePageObject.clickOnSearchButton();
        this.youtubePageObject.getResultSearchList();
    }

    public void getLeftMenu() {
        this.youtubePageObject.clickOnHamburgerButton();
    }

    public void userLogin() {
        this.youtubePageObject.clickOnLoginButton();
    }

    public void clickTitleVideo(int index) {
        this.youtubePageObject.clickOnSelectedVideo(index);
    }

    public int videoContainsSearchVideo() {
        return this.youtubePageObject.getTotalVideosRelated();
    }

    public boolean getHamburgerButtonIsPressed() {
        return this.youtubePageObject.hamburgerButtonIsPressed();
    }

    public boolean getNotResultsFound() {
        return this.youtubePageObject.noResultsFound();
    }

    public boolean getRelatedSearchContainer() {
        return this.youtubePageObject.lookForSearchRelated();
    }

    public void returnHome(String word) {
        this.youtubePageObject.sendKeysinSearchBox(word);
        this.youtubePageObject.clickOnSearchButton();
        this.youtubePageObject.clickOnYoutubeIcon();

    }

    public boolean getIfVideoIsPlaying() {

        return this.youtubePageObject.isVideoPlaying();
    }



}
