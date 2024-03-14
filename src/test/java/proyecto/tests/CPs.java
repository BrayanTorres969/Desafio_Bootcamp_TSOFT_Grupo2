package proyecto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proyecto.pages.HomePage;
import proyecto.pages.HotelPage;
import proyecto.pages.MultidestinoPage;
import proyecto.pages.TrenHotelPage;

public class CPs {

    HomePage home;
    MultidestinoPage multidestino;
    TrenHotelPage trenHotel;
    WebDriver driver;
    HotelPage hotelPage;

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones() {
        driver = new ChromeDriver();
        home = new HomePage(driver);
        home.cargarSitio("https://www.rumbo.es/");
        home.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones() {
        home.cerrarBrowser();
    }

    @Test
    public void TC006_Busqueda_Vuelos_Multidestino() {
        home.irAMultidestino();
        home.cambiarALaUltimaVentanaAbierta();
        multidestino = new MultidestinoPage(driver);
        multidestino.ejecutador_TC006("Madrid", "Barcelona", "Cuzco", "Lima",
                "No hay resultados para esta búsqueda");
    }

    @Test
    public void TC011_Busqueda_TrenXHotel_RangoPrecios() {
        home.irATrenHotel();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        trenHotel = new TrenHotelPage(driver);
        trenHotel.ejecutador_TC011("Madrid", "Barcelona", "1 resultado encontrado para 18 mar - 24 mar");
    }

    @Test
    public void T015_Busqueda_HotelesCasa_RangoPrecios(){
        home.irAHotelCasa();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.ejecutador_T015("Andorra", "5 resultados encontrados para 18 mar - 20 mar");
    }

    @Test
    public void T017_Busqueda_HotelesEsqui_VariosFiltrosDeUna(){
        home.irAHotelEsqui();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.ejecutador_T017("Andorra la Vella", "4 resultados encontrados para 18 mar - 10 abr");
    }
}
