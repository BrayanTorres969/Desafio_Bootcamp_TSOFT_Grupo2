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
        multidestino.addDestination();
        multidestino.addDestination();
        multidestino.esperarXsegundos(multidestino.getTiempoCortoEspera());
        multidestino.agregarPrimerDestinoYFecha("Madrid");
        multidestino.esperarXsegundos(multidestino.getTiempoCortoEspera());
        multidestino.agregarSegundoDestinoYFecha("Barcelona");
        multidestino.esperarXsegundos(multidestino.getTiempoCortoEspera());
        multidestino.agregarTercerDestinoYFecha("Cuzco");
        multidestino.esperarXsegundos(multidestino.getTiempoCortoEspera());
        multidestino.agregarCuartoDestinoYFecha("Lima");
        multidestino.esperarXsegundos(multidestino.getTiempoCortoEspera());
        multidestino.aceptarCookies();
        multidestino.esperarXsegundos(multidestino.getTiempoLargoEspera());
        multidestino.aumentarPasajerosYPiezaEquipaje();
        multidestino.esperarXsegundos(multidestino.getTiempoLargoEspera());
        multidestino.filtrarSoloVuelos();
        multidestino.esperarXsegundos(multidestino.getTiempoLargoEspera());
        multidestino.filtrarClaseViaje();
        multidestino.esperarXsegundos(multidestino.getTiempoLargoEspera());
        multidestino.validarCampoOrigen();
    }

    @Test
    public void TC011_Busqueda_TrenXHotel_RangoPrecios() {
        home.irATrenHotel();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        trenHotel = new TrenHotelPage(driver);
        trenHotel.verificarMensajeIntentarIngresarLugarDestino();
        trenHotel.esperarXsegundos(trenHotel.getTiempoMedioEspera());
        trenHotel.agregarLugarOrigen("Madrid");
        trenHotel.esperarXsegundos(trenHotel.getTiempoCortoEspera());
        trenHotel.agregarLugarDestino("Barcelona");
        trenHotel.esperarXsegundos(trenHotel.getTiempoCortoEspera());
        trenHotel.establecerFechas();
        trenHotel.esperarXsegundos(trenHotel.getTiempoCortoEspera());
        trenHotel.agregarViajeroYBuscar();
        trenHotel.esperarXsegundos(trenHotel.getTiempoLargoEspera());
        trenHotel.aplicarFiltroValoracion();
        trenHotel.esperarXsegundos(trenHotel.getTiempoLargoEspera());
        trenHotel.aplicarFiltroTipoAlojamiento();
        trenHotel.esperarXsegundos(trenHotel.getTiempoLargoEspera());
        trenHotel.filtrarPrecio();
        trenHotel.esperarXsegundos(trenHotel.getTiempoLargoEspera());
        trenHotel.validarMensajeCantResultados();
    }

    @Test
    public void T015_Busqueda_HotelesCasa_RangoPrecios(){
        home.irAHotelCasa();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.ingresarPrimerosDatos("Andorra");
        hotelPage.esperarXsegundos(hotelPage.getTiempoLargoEspera());
        hotelPage.filtrarPrecio();
    }

    @Test
    public void T017_Busqueda_HotelesEsqui_VariosFiltrosDeUna(){
        home.irAHotelEsqui();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.agregarDatosEsqui("Andorra la Vella");
        hotelPage.esperarXsegundos(hotelPage.getTiempoMedioEspera());
        hotelPage.filtrarVariosDatos();
    }
}
