package youtube.leftmenu;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;
import youtube.BaseTestCase;
import youtube.steps.YoutubeUserStepsMain;

import static utils.PropertyReader.getProperty;


public class LeftMenuTestCases extends BaseTestCase {
    @Test
    @Description("El usuario no logueado puede ver todas las opciones del menu izquierdo: Principal, Tendencies, Subscriptions, Biblioteca, Historia")
    @Story("Probar que las opciones del menu izquierdo se muestren")
    public void test1_OpcionesMenuIzquierdoHabilitadas() {
        this.myDriver.get(getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getLeftMenuOptions();
        softAssertion.assertTrue(youtubeUserStepsMain.getCategoriesLeftMenu() <= 5,
                "Categories not available ");
        softAssertion.assertAll();

    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Principal en el Menu izquierdo")
    @Story("Probar la opcion Principal redireccione a la pagina de principal de Youtube")
    public void test2_OpcionPrincipal() {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getMainPage();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/");
        softAssertion.assertTrue(youtubeUserStepsMain.getTitleTrending() <=2, "Categories not available on Main page");
        softAssertion.assertAll();

    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Tendencias a traves del Menu Izquierdo")
    @Story("Probar la opcion Tendencias y redireccione a esta a la pagina de la opcion")
    public void test3_OpcionTendencias() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getTrendingCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/trending");
        softAssertion.assertTrue(youtubeUserStepsMain.getTrendingCategory() <=4, "Options from Categories not available");
        softAssertion.assertAll();

    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Musica a traves de la categoria Tendencias")
    @Story("Probar la opcion Musica despues de seleccionar la categoria Tendencias")
    public void test4_CategoriaTendenciasOpcionMusica() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getMusicTrendingCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wNHJsZhIiUExGZ3F1TG5MNTlhbnFiUXFKUjlkNUIzU0dvdUFKd05Jcg%3D%3D");
        softAssertion.assertEquals(youtubeUserStepsMain.getMusicTrendingCategory(),"Música");
        softAssertion.assertAll();
    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Videojuegos a traves de la categoria Tendencias")
    @Story("Probar la opcion Videojuegos despues de seleccionar la categoria Tendencias")
    public void test5_CategoriaTendenciasOpcionVideojuegos() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getGamingTrendingCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/trending?bp=4gIvCgkvbS8wYnp2bTISIlBMaUN2Vkp6QnVwS251cjFaLVJEUGZpTGgyMXF2TFJLZTA%3D");
        softAssertion.assertEquals(youtubeUserStepsMain.getGamingTrendingCategory(),"Videojuegos");
        softAssertion.assertAll();
    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Noticias a traves de la categoria Tendencias")
    @Story("Probar la opcion Noticias despues de seleccionar la categoria Tendencias")
    public void test6_CategoriaTendenciasOpcionNoticias() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getNewsTrendingCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wNWpoZxIiUEwzWlE1Q3BOdWxRbGVUQzVBLUkxSGQxS0ptaFctTDczXw%3D%3D");
        softAssertion.assertEquals(youtubeUserStepsMain.getNewsTrendingCategory(),"Noticias");
        softAssertion.assertAll();
    }

    @Test
    @Description("El usuario no logueado puede ver  en la opcion Peliculas a traves de la categoria Tendencias")
    @Story("Probar la opcion Peliculas despues de seleccionar la categoria Tendencias")
    public void test7_CategoriaTendenciasOpcionPeliculas() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getMoviesTrendingCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/trending?bp=4gIuCggvbS8wMnZ4bhIiUEx6akZiYUZ6c21NUXgwU0lSRUR2VVZsSGgzNXJEOExZUg%3D%3D");
        softAssertion.assertEquals(youtubeUserStepsMain.getMoviesTrendingCategory(),"Películas");
        softAssertion.assertAll();
    }

    @Test
    @Description("El usuario no logueado no puede navegar en la opcion de Suscripciones del menu izquierdo")
    @Story("Probar la Opcion Suscripciones del menu izquierdo")
    public void test8_OpcionSuscripciones() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getSusbcriptionsCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/subscriptions");
        softAssertion.assertEquals(youtubeUserStepsMain.getSusbcriptionsCategory(),"No te pierdas los nuevos videos");
        softAssertion.assertAll();


    }

    @Test
    @Description("El usuario no logueado no puede navegar en la opcion biblioteca")
    @Story("Probar la Opcion Biblioteca del menu izquierdo")
    public void test9_OpcionBiblioteca() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getLibraryCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/library");
        softAssertion.assertEquals(youtubeUserStepsMain.getLibraryCategory(),"Disfruta de tus videos favoritos");
        softAssertion.assertAll();
    }

    @Test
    @Description("El usuario no logueado no puede navegar en la opcion Historial")
    @Story("Probar la Opcion Historial del menu izquierdo")
    public void test10_OpcionHistorial() throws InterruptedException {
        this.myDriver.get(PropertyReader.getProperty("youtube.properties", "YOUTUBE_URL"));
        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserStepsMain youtubeUserStepsMain = new YoutubeUserStepsMain(this.myDriver);
        youtubeUserStepsMain.getHistoryCategory();
        softAssertion.assertEquals(myDriver.getCurrentUrl(),"https://www.youtube.com/feed/history");
        softAssertion.assertEquals(youtubeUserStepsMain.getHistoryCategory(),"Haz un seguimiento de lo que miras");
        softAssertion.assertAll();
    }


}
