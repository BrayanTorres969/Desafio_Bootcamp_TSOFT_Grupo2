package proyecto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proyecto.pages.HomePage;
import proyecto.pages.VuelosPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        //Aceptar cookies
        home.aceptarCookies();
        home.esperarXsegundos(1000);
    }

    @AfterEach
    public void posCondiciones() {
        home.cerrarBrowser();
    }

    @Test
    public void TC001_Busqueda_Vuelos_Baratos_Europa_IdaYVuelta_Campos_Vacios() {


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

    @Test
    public void Tc002_Busqueda_Vuelos_Baratos_FindeSem_IdayVuelta_Ciudades_12diff_Horaria(){
        LocalDate fecha = LocalDate.now();
        String dia = fecha.format(DateTimeFormatter.ofPattern("dd"));
        int diaMna = Integer.parseInt(dia) + 1;
        String diaSgt = String.valueOf(diaMna);
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.vuelosDesplaza();
        vuelosPage.limpiezaBusqueda();
        vuelosPage.insertarValores("Lima", "Tokio");
        vuelosPage.seleccionCamposIdayVuelta(dia, diaSgt);
        vuelosPage.resultadosTC2();
    }

    @Test
    public void TC003_Busqueda_Vuelos_Nacionales_SoloIda_Valencia_Madrid_ClaseTurista_2Adultos() {

        //Aceptar cookies
        home.aceptarCookies();

        home.esperarXsegundos(1000);
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.hacerScrollHastaCategoriaVuelos();
        vuelosPage.irAVuelosNacionales();
        vuelosPage.esperarXsegundos(5000);
        vuelosPage.cambiarALaUltimaVentanaAbierta();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarOpcionSoloIda();

        try {
            vuelosPage.limpiarValorOrigenPorDefecto();
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println(e);
        }

        vuelosPage.ingresarOrigenVuelo("Valencia (VLC)");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarDestinoVuelo("Madrid (MAD)");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoFechaDeIda();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.ingresarFechaDeIda("//div[@aria-labelledby='3-2024']//button[text()='15']");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoPasajeros();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.aumentarNumPasajerosAdultos();
        vuelosPage.seleccionarCampoPasajeros();
        vuelosPage.seleccionarClaseVueloTurista();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.buscarVuelos();

        //validar a lo menos una trip card
        vuelosPage.esperarXsegundos(10000);
        vuelosPage.filtrarResultadosPorVuelo();
        vuelosPage.esperarXsegundos(10000);
        vuelosPage.volverInicioPagina();
        if (!vuelosPage.obtenerResultadosVuelosBuscados().isEmpty()) {
            vuelosPage.esperarXsegundos(3000);
            vuelosPage.seleccionarPrimerResultadoDeBusqueda();
        } else {
            System.out.println("No hay resultados para esta búsqueda");
        }
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.validarRutaDetalleVuelo("Valencia", "Madrid");


    }


    @Test
    public void TC005_Reserva_DatosPersonales_Vacios_Vuelos_FinDeSemana_SoloIda_Lima_NuevaYork_ClaseBusiness_1Adulto_MasRapido() {
        //Aceptar cookies
        home.aceptarCookies();

        home.esperarXsegundos(1000);
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.hacerScrollHastaCategoriaVuelos();
        vuelosPage.irAVuelosFinDeSemana();
        vuelosPage.esperarXsegundos(5000);
        vuelosPage.cambiarALaUltimaVentanaAbierta();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarOpcionSoloIda();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarOrigenVuelo("Lima (LIM)");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarDestinoVuelo("Nueva York (JFK)");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoFechaDeIda();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.seleccionarSgteMes();
        vuelosPage.seleccionarSgteMes();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.ingresarFechaDeIda("//div[@aria-labelledby='5-2024']//button[text()='8']");
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoPasajeros();
        vuelosPage.seleccionarClaseVueloBusiness();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.buscarVuelos();

        vuelosPage.esperarXsegundos(12000);
        vuelosPage.filtrarResultadosPorMasRapido();
        vuelosPage.esperarXsegundos(5000);

        //ingresar al primer trip card
        if (!vuelosPage.obtenerResultadosVuelosBuscados().isEmpty()) {
            vuelosPage.esperarXsegundos(3000);
            vuelosPage.seleccionarPrimerResultadoDeBusqueda();
        } else {
            System.out.println("No hay resultados para esta búsqueda");
        }

        vuelosPage.esperarXsegundos(3000);
        vuelosPage.seleccionarVuelo();
        vuelosPage.esperarXsegundos(15000);
        vuelosPage.seleccionarTarifaVueloClassic();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.seleccionarSgtFormReserva();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.volverInicioPagina();
        //Validar datos de contacto - Datos personales y equipaje
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.validarDatosDeContactoVacioFormDatosPersonalesYEquipaje();


    }
}
