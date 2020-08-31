package youtube.mainarea;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;
import utils.listeners.TestListener;
import youtube.BaseTestCase;
import youtube.steps.YoutubeUserStepsMain;
import static utils.PropertyReader.getProperty;
import youtube.steps.YoutubeUserStepsVideoDetails;

@Listeners({TestListener.class})
public class MainAreaTestCases extends BaseTestCase {
    @Test
    @Description("Un usuario sin iniciar sesion quiere ver las categorias de Video: Recomendados, Tendencias &  Noticias")
    @Story("Probar las categorias de video")
    public void test1_VideoCategories() {
        this.myDriver.get(getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getTitleTrending();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/");
        softAssertion.assertTrue(youtubeUserStepsMain.getVideoCategories() >=2, "Videos not available on Main page");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere ver los siguientes componentes de video:  Titulo del video, Autor del video, Numero de visualizaciones y el thumbnail del video")
    @Story("Probar la visualizacion esperada de los componentes de video")
    public void test2_VideoComponents() {
        this.myDriver.get(getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getVideoComponents();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/");
        softAssertion.assertTrue(youtubeUserStepsMain.getVideoComponents(),"Details Video not available");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere reproducir un video.")
    @Story("Probar la reproduccion de videos")
    public void test3a_VideoPlaybackByTitle() {
        this.myDriver.get(getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getVideoPlaybackByTitle();
        youtubeUserStepsMain.clickVideoByTitle(1);
        softAssertion.assertTrue(youtubeUserStepsMain.getIfVideoIsPlaying(), "No video playing");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere reproducir un video.")
    @Story("Probar la reproduccion de videos")
    public void test3b_VideoPlaybackByThumbnail() {
        this.myDriver.get(getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getVideoPlaybackByThumbnail();
        youtubeUserStepsMain.clickVideoByThumbnail(2);
        softAssertion.assertTrue(youtubeUserStepsMain.getIfVideoIsPlaying(), "No video playing");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesión quiere ver los siguientes detalles: título del video, número de visualizaciones, número de me gusta, número de no me gusta, descripción del video y comentarios.")
    @Story("Probar la visualización esperada de detalles del video")
    public void test4_VideoDetails() {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsVideoDetails youtubeUserStepsVideoDetails = new YoutubeUserStepsVideoDetails(this.myDriver);
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);

        youtubeUserStepsVideoDetails.goToVideoDetails(PropertyReader.getProperty("youtube.properties", "WORD"),
                Integer.parseInt(PropertyReader.getProperty("youtube.properties", "INDEX")));

        System.out.println("Title: " + youtubeUserStepsVideoDetails.getTitleVideo());
        System.out.println("Likes: " + youtubeUserStepsVideoDetails.getLikes());
        System.out.println("Dislikes: " + youtubeUserStepsVideoDetails.getDislikes());
        System.out.println("Views: " + youtubeUserStepsVideoDetails.getViews());
        System.out.println("Related Videos List: \n");
        youtubeUserStepsVideoDetails.getRelatedVideos();
        softAssertion.assertTrue(youtubeUserStepsMain.getIfVideoIsPlaying(), "The video is not playing");
        softAssertion.assertTrue(youtubeUserStepsVideoDetails.getTotalComments() > 0, "There are no comments in the video.");
        softAssertion.assertEquals(youtubeUserStepsVideoDetails.getVideoDescription(),"yt-formatted-string");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesión quiere visualizar los videos encontrados al iniciar una búsqueda")
    @Story("Probar la búsqueda de Youtube")
    public void test5_SearchVideo() {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsVideoDetails youtubeUserStepsVideoDetails = new YoutubeUserStepsVideoDetails(this.myDriver);
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);

        youtubeUserStepsVideoDetails.goToVideoDetails(PropertyReader.getProperty("youtube.properties", "WORD"),
                Integer.parseInt(PropertyReader.getProperty("youtube.properties", "INDEX")));
        String firstURL = myDriver.getCurrentUrl();
        System.out.println("First Search Video Selected: " + youtubeUserStepsVideoDetails.getTitleVideo());
        youtubeUserStepsMain.searchVideo("Marvel");
        youtubeUserStepsMain.clickTitleVideo(Integer.parseInt(PropertyReader.getProperty("youtube.properties", "INDEX")));
        System.out.println("Second Search Video Selected: " + youtubeUserStepsVideoDetails.getTitleVideo());
        softAssertion.assertNotEquals(firstURL,myDriver.getCurrentUrl(),"Header is not working");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario sin iniciar sesión quiere visualizar los videos encontrados al iniciar una búsqueda")
    @Story("Probar la búsqueda de Youtube")
    public void test6_YoutubeIcon() {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsVideoDetails youtubeUserStepsVideoDetails = new YoutubeUserStepsVideoDetails(this.myDriver);
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);

        youtubeUserStepsVideoDetails.goToVideoDetails(PropertyReader.getProperty("youtube.properties", "WORD"),
                Integer.parseInt(PropertyReader.getProperty("youtube.properties", "INDEX")));
        System.out.println("Video Played: " + youtubeUserStepsVideoDetails.getTitleVideo());
        youtubeUserStepsVideoDetails.clickOnYoutubeIcon();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),
                PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"),"Header is not working");
        softAssertion.assertAll();
    }
}
