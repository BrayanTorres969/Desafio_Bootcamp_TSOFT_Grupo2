package tests;

import pages.AlojamientoAlterPage;
import pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPs {
    HomePage home;
    AlojamientoAlterPage alterPage;
    WebDriver driver;

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        driver = new ChromeDriver();
        home = new HomePage(driver);
        alterPage = new AlojamientoAlterPage(driver);

        home.cargarSitio("https://rumbo.es/");
        home.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    @Test
    public void CP001_Filtrar_Detalles_Busqueda(){
        home.aceptarCookies();
        home.buscarHoteles();
    }

    @Test
    public void CP002_Compartir_InfoCasa_Contacto(){
        home.aceptarCookies();
        home.buscarHoteles();
        alterPage.seleccionarHotelAlternativo();
        alterPage.seleccionarCard(0);
        alterPage.cambioVentana(driver);
    }

    @Test
    public void CP003_Compartir_InfoCasa_Contacto(){
        home.aceptarCookies();
        home.buscarHoteles();
        alterPage.seleccionarHotelAlternativo();
        alterPage.filtrarDetalleCard();

    }


}
