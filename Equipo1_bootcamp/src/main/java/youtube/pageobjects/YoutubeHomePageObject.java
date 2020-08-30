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
    private List<WebElement> titlesInMain;

    @FindBy(how = How.XPATH, using = "//div[@id='contents']//div[@id='dismissable']")
    private List<WebElement> contentVideoList;

    @FindBy(how = How.XPATH, using = "//yt-formatted-string[contains(text(),'Trending')]")
    private WebElement trendingOption;

    @FindBy(how = How.XPATH, using = "//div[@id='sub-menu']//div[@id='contents']//*[a]")
    private List<WebElement> subOptionsTrending;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[1]//a[1]")
    private WebElement musicOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Música')]")
    private WebElement musicOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[2]//a[1]")
    private WebElement gaminOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Videojuegos')]")
    private WebElement gaminOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[3]//a[1]")
    private WebElement newsOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Noticias')]")
    private WebElement newsOptionTitle;

    @FindBy(how = How.XPATH, using = "//ytd-channel-list-sub-menu-avatar-renderer[4]//a[1]")
    private WebElement moviesOption;

    @FindBy(how = How.XPATH, using = "//ytd-text-header-renderer[contains(text(),'Películas')]")
    private WebElement moviesOptionTitle;

    @FindBy(how = How.XPATH, using = "//yt-formatted-string[contains(text(),'Suscripciones')]")
    private WebElement subscriptionsOption;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'No te pierdas los nuevos videos')]")
    private WebElement subscriptionsMessage;

    @FindBy(how = How.XPATH, using = "//yt-formatted-string[contains(text(),'Biblioteca')]")
    private WebElement libraryOption;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Disfruta de tus videos favoritos')]")
    private WebElement libraryMessage;

    @FindBy(how = How.XPATH, using = "//yt-formatted-string[contains(text(),'Historial')]")
    private WebElement historyOption;

    @FindBy(how = How.XPATH, using = "//yt-formatted-string[@id='message']")
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


    public int redirectsTrendingCategory() throws InterruptedException {

        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();
            Thread.sleep(3000);
            ArrayList<String> results = new ArrayList<>();
            for (WebElement element : this.subOptionsTrending) {
                System.out.println("Opciones dentro de Tendencias:" + element.getText());
                results.add(element.getText());
            }
            int x = 0;
            int totalIcons = 0;
            while (x < results.size()) {
                if (results.get(x).contains("Musica") && results.get(x).contains("Videojuegos") && results.get(x).contains("Noticias") && results.get(x).contains("Películas")) {
                    totalIcons++;
                }
                x++;
            }
            return totalIcons;
        }
        return 0;
    }

    public String redirectsMusicPage() throws InterruptedException {
        String titlemusic = null;
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            if (this.musicOption.isDisplayed() && this.musicOption.isEnabled()) {
                this.musicOption.click();
                titlemusic = this.musicOptionTitle.getText();
            }
        }
        return titlemusic;
    }

    public String redirectsGaminPage() throws InterruptedException {
        String titleGamingPage = null;

        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
            if (this.gaminOption.isDisplayed() && this.gaminOption.isEnabled()) {
                this.gaminOption.click();
                titleGamingPage = this.gaminOptionTitle.getText();
            }
        }
        return titleGamingPage;
    }

    public String redirectsNewsPage() throws InterruptedException {
        String titleNewsPage= null;
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
        if(this.newsOption.isDisplayed() && this.newsOption.isEnabled()){
            this.newsOption.click();
            titleNewsPage=this.newsOptionTitle.getText();
        }
        }
        return titleNewsPage;
    }

    public String redirectsMoviesPage() throws InterruptedException {
        String titleMoviesPage= null;
        if (this.trendingOption.isDisplayed() && this.trendingOption.isEnabled()) {
            this.trendingOption.click();

            Thread.sleep(3000);
        if (this.moviesOption.isDisplayed() && this.moviesOption.isEnabled()) {
            this.moviesOption.click();
            titleMoviesPage=this.moviesOptionTitle.getText();
        }
        }
        return titleMoviesPage;
    }

    public String redirectsSubscriptionPage() throws InterruptedException {
        String titleSubscriptionPage = null;
        if (this.subscriptionsOption.isDisplayed() && this.subscriptionsOption.isEnabled())
        { this.subscriptionsOption.click();

            Thread.sleep(3000);
            if(this.subscriptionsMessage.isDisplayed() && this.subscriptionsMessage.isEnabled()) {
                titleSubscriptionPage = this.subscriptionsMessage.getText();
            }
        }
        return titleSubscriptionPage;
    }

    public String redirectsLibraryPage() throws InterruptedException {
        String titleLibraryPage= null;
        if (this.libraryOption.isDisplayed() && this.libraryOption.isEnabled()) {
            this.libraryOption.click();

            Thread.sleep(3000);
            if(this.libraryMessage.isDisplayed()&& this.libraryMessage.isEnabled()) {
                titleLibraryPage = this.libraryMessage.getText();
            }
        }
        return titleLibraryPage;
    }

    public String redirectsHistoryPage() throws InterruptedException {
        String titleHistoryPage= null;
        if (this.historyOption.isDisplayed() && this.historyOption.isEnabled()) {
            this.historyOption.click();

            Thread.sleep(3000);
            if (this.historyMessage.isDisplayed()&&this.historyOption.isEnabled()) {
                titleHistoryPage = this.historyMessage.getText();
            }
        }
        return titleHistoryPage;
    }
}
