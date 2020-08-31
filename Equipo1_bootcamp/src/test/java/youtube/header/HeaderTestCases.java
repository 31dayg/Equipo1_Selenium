package youtube.header;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;
import utils.listeners.TestListener;
import youtube.BaseTestCase;
import youtube.steps.YoutubeUserStepsMain;

import java.util.concurrent.TimeUnit;

@Listeners({ TestListener.class})
public class HeaderTestCases extends BaseTestCase {

    @Test(groups = {"Regression", "Happy path"})
    @Description("Un usuario sin iniciar sesion quiere buscar un video.")
    @Story("Probar la busqueda de Youtube")
    public void test1_SearchVideo() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        System.out.println("Lista de videos encontrados por busqueda: \n");
        youtubeUserSteps.resultsList("Selenium");
        softAssertion.assertTrue(youtubeUserSteps.videoContainsSearchVideo() > 10,
                "Results are not related to your search");
        softAssertion.assertAll();
    }

    @Test
    @Description("Validar el hamburguer button que pueda desplegar el menu y ocultarlo")
    @Story("Probar que el boton de hamburguesa funcione")
    public void test2_HamburgerButtonWorks() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);

        youtubeUserSteps.getLeftMenu();
        softAssertion.assertFalse(youtubeUserSteps.getHamburgerButtonIsPressed(),
                "Hamburger button was not pressed");
        softAssertion.assertAll();
    }

    @Test
    @Description("Un usuario puede inciar sesion.")
    @Story("Probar el boton acceder")
    public void test3_LoginButton() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserSteps.userLogin();

        softAssertion.assertEquals(myDriver.getCurrentUrl(), "https://accounts.google.com/signin/v2/identifier?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Den%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252F&hl=en&ec=65620&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        softAssertion.assertAll();
    }

    @Test
    @Description("Verificar mensaje cuando no se encontraron resultados ")
    @Story("Probar que no se encontro resultados")
    public void test4_ResultNotFound() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        SoftAssert softAssertion = new SoftAssert();

        youtubeUserSteps.searchVideo("..");
        softAssertion.assertTrue(youtubeUserSteps.getNotResultsFound(), "Results were found");
        softAssertion.assertAll();
    }

    @Test
    @Description("Verificar que el boton \"YouTube\" regrese al inicio.")
    @Story("Probar el icono 'Youtube' regrese al inicio")
    public void test5_youtubeIcon() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserSteps.returnHome("Selenium");
        softAssertion.assertEquals(myDriver.getCurrentUrl(), "https://www.youtube.com/");
    }

    @Test
    @Description("Validar que se muestre el contenedor de busquedas relacionadas")
    @Story("Probar titulos recomendados")
    public void test6_RecommendationSearch() {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserSteps.searchVideo("Program");

        softAssertion.assertTrue(youtubeUserSteps.getRelatedSearchContainer(),
                "No Related results container is shown");
        softAssertion.assertAll();
    }

    @Test
    @Description("Validar, la busqueda de titulos en ingles")
    @Story("Probar titulos en ingles")
    public void test7_LanguageSearch() throws InterruptedException {
        //this.myDriver.get("https://www.youtube.com/");
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserSteps = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserSteps.searchVideo("learning selenium");
        youtubeUserSteps.clickTitleVideo(1);
        softAssertion.assertTrue(youtubeUserSteps.getIfVideoIsPlaying(), "No video playing");
        softAssertion.assertAll();
    }
}
