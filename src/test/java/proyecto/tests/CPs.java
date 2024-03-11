package proyecto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proyecto.pages.HomePage;
import proyecto.pages.VuelosPage;

public class CPs {

    HomePage home;
    VuelosPage vuelosPage;
    WebDriver driver;

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
    public void TC001_Busqueda_Vuelos_Baratos_Europa_IdaYVuelta_Campos_Vacios() {
        //Aceptar cookies
        home.aceptarCookies();

        home.esperarXsegundos(1000);
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.hacerScrollHastaCategoriaVuelos();
        vuelosPage.irAVuelosAEuropa();
        vuelosPage.esperarXsegundos(5000);
        vuelosPage.cambiarALaUltimaVentanaAbierta();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarOpcionIdaYVuelta();

        try {
            vuelosPage.limpiarValorOrigenPorDefecto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        vuelosPage.ingresarOrigenVuelo("");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarDestinoVuelo("");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.buscarVuelos();
        vuelosPage.esperarXsegundos(3000);
        //Validar resultados
        vuelosPage.validarCampoOrigen();
        vuelosPage.validarCampoDestino();
    }
}
