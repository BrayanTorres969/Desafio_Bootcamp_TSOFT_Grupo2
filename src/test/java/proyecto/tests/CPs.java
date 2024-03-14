package proyecto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proyecto.pages.HomePage;
import proyecto.pages.TrenesPage;
import proyecto.pages.VuelosPage;
import proyecto.utils.DataDriven;
import proyecto.utils.FixEncoding;
import proyecto.utils.PropertiesManager;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CPs {

    HomePage home;
    VuelosPage vuelosPage;
    TrenesPage trenesPage;
    WebDriver driver;
    ArrayList<String> dataCPs; //null

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones() {
        dataCPs = new ArrayList<String>(); //0
        driver = new ChromeDriver();
        home = new HomePage(driver);
        home.cargarSitio(PropertiesManager.obtenerProperty("url"));
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

        dataCPs = DataDriven.prepararData("TC001_Busqueda_Vuelos_Baratos_Europa_IdaYVuelta_Campos_Vacios");
        //Aceptar cookies
        //home.aceptarCookies();

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
        vuelosPage.validarCampoOrigen(dataCPs.get(1));
        vuelosPage.validarCampoDestino(dataCPs.get(2));
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
        //Fin_funciona100%
    }

    @Test
    public void TC003_Busqueda_Vuelos_Nacionales_SoloIda_Valencia_Madrid_ClaseTurista_2Adultos() {


        dataCPs = DataDriven.prepararData("TC003_Busqueda_Vuelos_Nacionales_SoloIda_Valencia_Madrid_ClaseTurista_2Adultos");

        //Aceptar cookies
        //home.aceptarCookies();

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

        vuelosPage.ingresarOrigenVuelo(dataCPs.get(1).trim());
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarDestinoVuelo(dataCPs.get(2).trim());
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoFechaDeIda();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.ingresarFechaDeIda(dataCPs.get(3));
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
        vuelosPage.validarRutaDetalleVuelo(dataCPs.get(4).trim(), dataCPs.get(5).trim());


    }

    @Test
    public void TC004_Filtrado_Vuelos_Baratos_Finde_IdaYVuelta_Precio_Pago_Equipaje_Escala(){
        String dia ="15";
        String diaSgt = "20";
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.vuelosDesplaza();
        vuelosPage.limpiezaBusqueda();
        vuelosPage.insertarValores("Lima", "Tokio");
        vuelosPage.seleccionCamposIdayVuelta(dia, diaSgt);

        vuelosPage.seleccionarCampoPasajeros();
        vuelosPage.seleccionarCualquierClase();
        vuelosPage.buscarVuelos();
        vuelosPage.esperarXsegundos(15000);

        vuelosPage.filtrarResultadoPorMasBarato();
        vuelosPage.esperarXsegundos(10000);

        vuelosPage.seleccionarCampoMetodoPago();
        vuelosPage.filtrarResultadoMetodoPago();
        vuelosPage.esperarXsegundos(4000);
        vuelosPage.ClickCheckbox();
        vuelosPage.esperarXsegundos(3000);
    }

    @Test
    public void TC005_Reserva_DatosPersonales_Vacios_Vuelos_FinDeSemana_SoloIda_Lima_NuevaYork_ClaseBusiness_1Adulto_MasRapido() {

        dataCPs = DataDriven.prepararData("TC005_Reserva_DatosPersonales_Vacios_Vuelos_FinDeSemana_SoloIda_Lima_NuevaYork_ClaseBusiness_1Adulto_MasRapido");

        //Aceptar cookies
        //home.aceptarCookies();

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
        vuelosPage.ingresarOrigenVuelo(dataCPs.get(1).trim());
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.ingresarDestinoVuelo(dataCPs.get(2).trim());
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.seleccionarCampoFechaDeIda();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.seleccionarSgteMes();
        vuelosPage.seleccionarSgteMes();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.ingresarFechaDeIda(dataCPs.get(3).trim());
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
        vuelosPage.esperarXsegundos(20000);
        vuelosPage.seleccionarTarifaVueloClassic();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.seleccionarSgtFormReserva();
        vuelosPage.esperarXsegundos(1000);
        vuelosPage.volverInicioPagina();
        //Validar datos de contacto - Datos personales y equipaje
        vuelosPage.esperarXsegundos(1000);
        Assertions.assertEquals(dataCPs.get(4).trim(), vuelosPage.errorNombreDatosDeContactoFormDatosPersonalesYEquipaje());
        Assertions.assertEquals(dataCPs.get(5).trim(), vuelosPage.errorApellidoDatosDeContactoFormDatosPersonalesYEquipaje());
        Assertions.assertEquals(dataCPs.get(6).trim(), vuelosPage.errorEmailDatosDeContactoFormDatosPersonalesYEquipaje());
        Assertions.assertEquals(dataCPs.get(7).trim(), vuelosPage.errorTelefonoDatosDeContactoFormDatosPersonalesYEquipaje());

    }

    @Test
    public void CP007_BuscarTrenSoloIda(){

        home.irATrenes();
        trenesPage = new TrenesPage(driver);

        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarOpcionSoloIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeOrigen();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeDestino();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.aumentarNumeroDePasajero();

        trenesPage.buscarTrenIda();


    }

}
