package youtube.steps;

import org.openqa.selenium.WebDriver;
import youtube.pageobjects.YoutubePageObject;
import youtube.pageobjects.YoutubeHomePageObject;

// Capa de steps. tiene que tener metodos de mas alto nivel que simulen nivel de usuario.

public class YoutubeUserStepsMain {

    // HEADER

    private YoutubePageObject youtubePageObject;
    private YoutubeHomePageObject youtubeHomePageObject;

    public YoutubeUserStepsMain(WebDriver driver) {
        this.youtubePageObject = new YoutubePageObject(driver);
        this.youtubeHomePageObject = new YoutubeHomePageObject(driver);
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

    //LEFT MENU
    public void getLeftMenuOptions(){
        this.youtubeHomePageObject.getOptionsLeftMenuList();
    }

    public int getCategoriesLeftMenu() {
        return this.youtubeHomePageObject.getOptionsLeftMenuList();
    }

    public void getMainPage(){
        this.youtubeHomePageObject.redirectsMainPage();
    }

    public int getTitleTrending(){
        return this.youtubeHomePageObject.TrendingTitleIsDisplayed();
    }

    public int getTrendingCategory () throws InterruptedException {
        return this.youtubeHomePageObject.redirectsTrendingCategory();
    }

    public String getMusicTrendingCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsMusicPage();
    }

    public String getGamingTrendingCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsGaminPage();
    }

    public String getNewsTrendingCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsNewsPage();
    }

    public String getMoviesTrendingCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsMoviesPage();
    }

    public String getSusbcriptionsCategory() throws InterruptedException{
        return this.youtubeHomePageObject.redirectsSubscriptionPage();
    }

    public String getLibraryCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsLibraryPage();
    }

    public String getHistoryCategory() throws InterruptedException {
        return this.youtubeHomePageObject.redirectsHistoryPage();
    }

    //MAIN PAGE
    public int getVideoCategories(){
        return this.youtubeHomePageObject.getVideoCategoriesMain();

    }

    public boolean getVideoComponents(){
        return this.youtubeHomePageObject.getVideoComponents();
    }

    public void getVideoPlaybackByTitle(){
        this.youtubeHomePageObject.getVideoPlayback();
    }
    public void getVideoPlaybackByThumbnail(){
        this.youtubeHomePageObject.getVideoPlaybackByThumbnail();
    }
    public void clickVideoByTitle(int index) {
        this.youtubeHomePageObject.clickOnSelectedVideoByTitle(index);
    }
    public void clickVideoByThumbnail(int index){
        this.youtubeHomePageObject.clickOnSelectedVideoByThumbnail(index);
    }

}
