package youtube.mainarea;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class MainAreaTestCases {
    @Test
    @Description("Un usuario sin iniciar sesion quiere ver las categorias de Video: Recomendados, Tendencias &  Noticias")
    @Story("Probar las categorias de video")
    public void test1_VideoCategories() {

    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere ver los siguientes componentes de video:  Titulo del video, Autor del video, Numero de visualizaciones y el thumbnail del video")
    @Story("Probar la visualizacion esperada de los componentes de video")
    public void test2_VideoComponents() {

    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere reproducir un video.")
    @Story("Probar la reproduccion de videos")
    public void test3_VideoPlayback() {

    }

    @Test
    @Description("Un usuario sin iniciar sesión quiere ver los siguientes detalles: título del video, número de visualizaciones, número de me gusta, número de no me gusta, descripción del video y comentarios.")
    @Story("Probar la visualización esperada de detalles del video")
    public void test4_VideoDetails() {

    }

    @Test
    @Description("Un usuario sin iniciar sesión quiere visualizar los videos encontrados al iniciar una búsqueda")
    @Story("Probar la búsqueda de Youtube")
    public void test5_SearchVideo() {

    }

    @Test
    @Description("Un usuario sin iniciar sesion quiere añadir un video a una playlist")
    @Story("Probar que es posible añadir un video a una playlist")
    public void test6_AddVideoToPlaylist() {

    }
}
