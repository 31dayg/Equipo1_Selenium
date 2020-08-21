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
        this.youtubePageObject.getResoultSearchList();
    }

    public void leftMenu() {
        this.youtubePageObject.clickOnHamburgerButton();
    }

    public void userLogin() {
        this.youtubePageObject.clickOnLoginButton();
    }

    public boolean noResultsFound() {
        return this.youtubePageObject.noResultsFound();
    }

    public void clickTitleVideo(int index) {
        this.youtubePageObject.clickOnSelectedVideo(index);
    }



}
