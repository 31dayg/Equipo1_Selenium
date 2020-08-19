package youtube.header;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Story;
import org.aspectj.lang.SoftException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import youtube.BaseTestCase;
import youtube.steps.YoutubeUserSteps;

public class HeaderTestCases extends BaseTestCase {

    @Test
    @Description("Un usuario sin iniciar sesion quiere buscar un video.")
    @Story("Probar la busqueda de Youtube")
    public void test1_SearchVideo() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
        System.out.println("Lista de videos encontrados por busqueda: \n");
        youtubeUserSteps.resultsList("Selenium");

        softAssertion.assertEquals(myDriver.getCurrentUrl(), "https://www.youtube.com/");
    }

    @Test
    @Description("Validar el hamburguer button que pueda desplegar el menu y ocultarlo")
    @Story("Probar que el boton de hamburguesa funcione")
    public void test2_HamburgerButtonWorks() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);

        youtubeUserSteps.leftMenu();
        //Me falta ver como validar esta parte. Sacar los valores del menu?

    }

    @Test
    @Description("Un usuario puede inciar sesion.")
    @Story("Probar el boton acceder")
    public void test3_LoginButton() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
        youtubeUserSteps.userLogin();

        softAssertion.assertEquals(myDriver.getCurrentUrl(), "https://accounts.google.com/signin");
    }

    /*@Test
    @Description("Verificar mensaje cuando no se encontraron resultados ")
    @Story("Probar que no se encontro resultados")
    public void test4_ResultNotFound() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
    }*/

    @Test
    @Description("Validar que al ingresar el signo de \"?\", el buscador de youtube aparezaca los titulos recomendados")
    @Story("Probar titulos recomendados")
    public void test6_RecommendationSearch() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
        youtubeUserSteps.searchVideo("Selenium");
        youtubeUserSteps.selectVideotoWatch(12);
    }

    @Test
    @Description("Validar que al ingresar caracteres especiales, en el buscador de youtube, aparezca una lista de recomendaciones")
    @Story("Probar caracteres especiales")
    public void test7_SpecialSearch() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
        youtubeUserSteps.searchVideo("Selenium");
        youtubeUserSteps.selectVideotoWatch(12);
    }

    @Test
    @Description("Validar, la busqueda de titulos en ingles")
    @Story("Probar titulos en ingles")
    public void test8_LanguageSearch() {
        this.myDriver.get("https://www.youtube.com/");

        SoftAssert softAssertion = new SoftAssert();
        YoutubeUserSteps youtubeUserSteps = new YoutubeUserSteps(this.myDriver);
        youtubeUserSteps.searchVideo("Selenium");
        youtubeUserSteps.selectVideotoWatch(12);
    }







}