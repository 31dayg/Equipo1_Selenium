package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YoutubePageObject extends BasePageObject {

    // DEFINIR ELEMENTOS DE HEADER Y DE LEFT MENU

    @FindBy(how = How.XPATH, using = "//input[@id = 'search']")
    private WebElement searchBox;

    @FindBy(how = How.ID, using = "search-icon-legacy")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div/descendant::ytd-video-renderer/div/div/div/div/h3/a")
    private List<WebElement> resultSearchList;

    @FindBy(how = How.XPATH, using = "//div[@id='start']/yt-icon-button[@id='guide-button']/button")
    private WebElement hamburgerButton;

    @FindBy(how = How.XPATH, using = "//div[@id='buttons']/ytd-button-renderer/a/paper-button/yt-icon")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "logo-icon-container")
    private WebElement youtubeIcon;

    @FindBy(how = How.XPATH, using = "//div[@id='scroll-container']//div[@id='items']/descendant::ytd-search-refinement-card-renderer")
    private List<WebElement> searchRelated;

    @FindBy(how = How.XPATH, using = "//div[@class='style-scope ytd-item-section-renderer'][@id='contents']/descendant::*[@class='style-scope ytd-item-section-renderer']")
    private List<WebElement> noResultsFound;

    @FindBy(how = How.XPATH, using = "//div[@id='movie_player']")
    private WebElement videoIsPlaying;

    public YoutubePageObject(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public void sendKeysinSearchBox(String searchWord) {
        this.searchBox.clear();
        this.searchBox.sendKeys(searchWord);
    }

    public void clickOnSearchButton() {
        this.searchButton.click();
    }

    public void getResultSearchList() {
        int i = 0;
        while (i < resultSearchList.size()) {
            System.out.println(resultSearchList.get(i).getText());
            i++;
        }
    }

    public void clickOnYoutubeIcon() {
        this.youtubeIcon.click();
    }

    public void clickOnHamburgerButton() {
        this.hamburgerButton.click();
    }

    public void clickOnLoginButton() {
        this.loginButton.click();
    }


    public void clickOnSelectedVideo(int index) {
        this.resultSearchList.get(index).click();
    }

    public boolean lookForSearchRelated() {
        return this.searchRelated.size() > 0;
    }

    public int getTotalVideosRelated() {
        int i = 0;
        ArrayList<String> results = new ArrayList<>();
        while (i < resultSearchList.size()) {
            System.out.println(resultSearchList.get(i).getText());
            results.add(resultSearchList.get(i).getText());
            i++;
        }
        int x = 0;
        int totalRelated = 0;
        while (x < results.size()) {
            if(results.get(x).contains("Selenium")) {
                totalRelated++;
            }
            x++;
        }
        return totalRelated;
    }

    public boolean hamburgerButtonIsPressed() {
        return this.hamburgerButton.getAttribute("aria-pressed").equals("true");
    }

    public boolean noResultsFound() {
        return noResultsFound.size() == 1;
    }

    public boolean isVideoPlaying() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(videoIsPlaying));
        return this.videoIsPlaying.isDisplayed();
    }








}
