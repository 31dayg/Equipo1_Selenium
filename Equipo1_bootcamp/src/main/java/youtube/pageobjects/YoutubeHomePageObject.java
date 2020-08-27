package youtube.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class YoutubeHomePageObject extends BasePageObject {

    //ELEMENTOS DEL LEFT MENU - PRINCIPAL, TENDECIAS, BIBLIOTECA E HISTORIAL
    @FindBy(how = How.XPATH, using = "*//a[@class='yt-simple-endpoint style-scope ytd-guide-entry-renderer']")
    private List<WebElement> resultsOptionsLeftMenu;

    @FindBy(how = How.XPATH, using = "//div[@id='sections']/ytd-guide-section-renderer[1]/div[1]/ytd-guide-entry-renderer[1]/a[1]")
    private WebElement homeOption;

    @FindBy (how = How.XPATH,using = "//div[@id='contents']//div[@id='rich-shelf-header']//span")
    //private WebElement titleTrending;
    private List<WebElement> titlesInMain;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[2]//a[1]")
    private WebElement trendingOption;

    @FindBy(how = How.XPATH, using = "//div[@id='sub-menu']//div[@id='contents']//*[a]")
    private List<WebElement> subOptionsTrending;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[1]//a[1]")
    private WebElement musicOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Videojuegos')]")
    private WebElement musicOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[2]//a[1]")
    private WebElement gaminOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Música')]")
    private WebElement gaminOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[3]//a[1]")
    private WebElement newsOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Noticias')]")
    private WebElement newsOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[4]//a[1]")
    private WebElement moviesOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Películas')]")
    private WebElement moviesOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[3]//a[1]")
    private WebElement subscriptionsOption;

    @FindBy(how = How.XPATH, using = "")
    private WebElement subscriptionsMessage;

    @FindBy(how = How.XPATH, using = "//ytd-guide-entry-renderer[@id='header-entry']//a[@id='endpoint']")
    private WebElement libraryOption;

    @FindBy(how = How.XPATH, using = "")
    private WebElement libraryMessage;

    @FindBy(how = How.XPATH, using = "//ytd-mini-guide-entry-renderer[5]//a[1]")
    private WebElement historyOption;

    @FindBy(how = How.XPATH, using = "")
    private WebElement historyMessage;

    @FindBy(how = How.XPATH, using = "//ytd-item-section-renderer[1]//div[3]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer")
    private List<WebElement> resultsSearchCategories;

    // AQUI VAN LOS ELEMENTOS DEL MAIN AREA EN HOME.

    public YoutubeHomePageObject(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public int getOptionsLeftMenuList() {
        ArrayList<String> results = new ArrayList<>();

        for (WebElement element : resultsOptionsLeftMenu) {
            System.out.println("Opciones del menu izquierdo:"+ element.getText());
            results.add(element.getText());
        }
        int x = 0;
        int totalCategories = 0;
        while (x < results.size()) {
            if (results.get(x).contains("Principal") && results.get(x).contains("Tendencias") && results.get(x).contains("Suscripciones") && results.get(x).contains("Biblioteca") && results.get(x).contains("Historial")) {
                totalCategories++;
            }
            x++;
        }
        return totalCategories;
    }
    public void redirectsMainPage(){
        if (this.homeOption.isDisplayed() && this.homeOption.isEnabled())
        { this.homeOption.click(); }
    }

    public int TrendingTitleIsDisplayed(){

        ArrayList<String> results= new ArrayList<>();
        for (WebElement element : titlesInMain)
        {
            System.out.println("Secciones en dentro del Main:"+ element.getText());
            results.add(element.getText());
        }
        int x=0;
        int totalTitles=0;
        while(x<results.size()){
            if(results.get(x).contains("Tendencias") && results.get(x).contains("Noticias sobre el COVID‑19")){
                totalTitles++;
            }
            x++;
        }
        return totalTitles;
    }


    public void redirectsTrendingCategory() throws InterruptedException {
        if(this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()){
            this.trendingOption.click();

            Thread.sleep(3000);
            int i = 0;
            while (i < subOptionsTrending.size()) {
                System.out.println(subOptionsTrending.get(i).getText());
                i++;
            }
        }
    }

    public void redirectsMusicPage() throws InterruptedException {
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            this.musicOption.click();
            this.musicOptionTitle.getText();
        }
    }

    public void redirectsGaminPage() throws InterruptedException {
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            this.gaminOption.click();
            this.gaminOptionTitle.getText();
        }
    }

    public void redirectsNewsPage() throws InterruptedException {
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            this.newsOption.click();
            this.newsOptionTitle.getText();
        }
    }

    public void redirectsMoviesPage() throws InterruptedException {
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            this.moviesOption.click();
            this.moviesOptionTitle.getText();
        }
    }

    public void redirectsSubscriptionPage() throws InterruptedException {
        if (this.subscriptionsOption.isDisplayed() && this.subscriptionsOption.isEnabled())
        { this.subscriptionsOption.click();
            Thread.sleep(3000);
            this.subscriptionsMessage.getText();
        }
    }

    public void redirectsLibraryPage() throws InterruptedException {
        if (this.libraryOption.isDisplayed() && this.libraryOption.isEnabled())
        { this.libraryOption.click();
            Thread.sleep(3000);
            this.libraryMessage.getText();
        }
    }

    public void redirectsHistoryPage() throws InterruptedException {
        if (this.historyOption.isDisplayed() && this.historyOption.isEnabled())
        { this.historyOption.click();
            Thread.sleep(3000);
            this.historyMessage.getText();
        }
    }
}
