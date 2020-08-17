package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class YoutubePageObject extends BasePageObject {

    // DEFINIR ELEMENTOS DE HEADER Y DE LEFT MENU

    @FindBy(how = How.XPATH, using = "//input[@id = 'search']")
    private WebElement searchBox;

    @FindBy(how = How.ID, using = "search-icon-legacy")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//div/descendant::ytd-video-renderer/div/div/div/div/h3/a")
    private List<WebElement> resultSearchList;

    @FindBy(how = How.XPATH, using = "//yt-icon-button[@id='guide-button']/button/yt-icon[@class='style-scope ytd-masthead']")
    private WebElement HamburgerButton;

    @FindBy(how = How.XPATH, using = "//div[@id='buttons']/ytd-button-renderer/a/paper-button/yt-icon")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "logo-icon-container")
    private WebElement youtubeIcon;

    @FindBy(how = How.XPATH, using = "")
    private List<WebElement> leftMenuOptions;

    /*@FindBy(how = How.XPATH, using = "//div[@class='promo-title style-scope ytd-background-promo-renderer']")
    private WebElement noResultsFoundPage;*/


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

    public void getResoultSearchList() {
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
        this.HamburgerButton.click();
    }

    public void clickOnLoginButton() {
        this.loginButton.click();
    }

    public boolean noResultsFound() {
        return true;
    }

    public void clickOnSelectedVideo(int index) {
        this.resultSearchList.get(index).click();
    }




}
