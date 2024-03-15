package proyecto.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proyecto.pages.AlojamientoAlterPage;
import proyecto.pages.HomePage;
import proyecto.pages.HotelPage;
import proyecto.pages.MultidestinoPage;
import proyecto.pages.TrenHotelPage;
import proyecto.pages.TrenesPage;
import proyecto.pages.VuelosPage;
import proyecto.utils.DataDriven;
import proyecto.utils.FixEncoding;
import proyecto.utils.PropertiesManager;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CPs {

    HomePage home;
    MultidestinoPage multidestino;
    TrenHotelPage trenHotel;
    HotelPage hotelPage;
    VuelosPage vuelosPage;
    TrenesPage trenesPage;
    WebDriver driver;
    ArrayList<String> dataCPs; //null
    AlojamientoAlterPage alterPage;

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
    @Order(1)
    public void TC001_Busqueda_Vuelos_Baratos_Europa_IdaYVuelta_Campos_Vacios() {
        dataCPs = DataDriven.prepararData("TC001_Busqueda_Vuelos_Baratos_Europa_IdaYVuelta_Campos_Vacios");

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
    @Order(2)
    public void TC002_Busqueda_Vuelos_Baratos_FindeSem_IdayVuelta_Ciudades_12diff_Horaria() {

        dataCPs = DataDriven.prepararData("TC002_Busqueda_Vuelos_Baratos_FindeSem_IdayVuelta_Ciudades_12diff_Horaria");

        LocalDate fecha = LocalDate.now();
        String dia = fecha.format(DateTimeFormatter.ofPattern("dd"));
        int diaMna = Integer.parseInt(dia) + 1;
        String diaSgt = String.valueOf(diaMna);
        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.vuelosDesplaza();
        vuelosPage.limpiezaBusqueda();
        vuelosPage.insertarValores(dataCPs.get(1).trim(), dataCPs.get(2).trim());
        vuelosPage.seleccionCamposIdayVuelta(dia, diaSgt);
        vuelosPage.resultadosTC2();
        //Fin_funciona100%
    }

    @Test
    @Order(3)
    public void TC003_Busqueda_Vuelos_Nacionales_SoloIda_Valencia_Madrid_ClaseTurista_2Adultos() {


        dataCPs = DataDriven.prepararData("TC003_Busqueda_Vuelos_Nacionales_SoloIda_Valencia_Madrid_ClaseTurista_2Adultos");

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
    @Order(4)
    public void TC004_Filtrado_Vuelos_Baratos_Finde_IdaYVuelta_Precio_Pago_Equipaje_Escala() {

        dataCPs = DataDriven.prepararData("TC004_Filtrado_Vuelos_Baratos_Finde_IdaYVuelta_Precio_Pago_Equipaje_Escala");

        home.irAVuelos();
        vuelosPage = new VuelosPage(driver);
        vuelosPage.vuelosDesplaza();
        vuelosPage.limpiezaBusqueda();
        vuelosPage.insertarValores(dataCPs.get(1).trim(), dataCPs.get(2).trim());
        vuelosPage.seleccionCamposIdayVuelta(dataCPs.get(3).trim(), dataCPs.get(4).trim());

        vuelosPage.seleccionarCampoPasajeros();
        vuelosPage.seleccionarCualquierClase();
        vuelosPage.buscarVuelos();
        vuelosPage.esperarXsegundos(10000);

        vuelosPage.filtrarResultadoPorMasBarato();
        vuelosPage.esperarXsegundos(5000);

        vuelosPage.seleccionarCampoMetodoPago();
        vuelosPage.filtrarResultadoMetodoPago();
        vuelosPage.esperarXsegundos(3000);
        vuelosPage.clickCheck(driver);
        vuelosPage.esperarXsegundos(2000);
        vuelosPage.resultadosLlenos();
    }

    @Test
    @Order(5)
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

        vuelosPage.esperarXsegundos(15000);
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
    @Order(6)
    public void TC006_Busqueda_Vuelos_Multidestino() {
        home.irAMultidestino();
        home.cambiarALaUltimaVentanaAbierta();
        multidestino = new MultidestinoPage(driver);
        multidestino.ejecutador_TC006("Madrid", "Barcelona", "Cuzco", "Lima",
                "No hay resultados para esta búsqueda");
    }

    @Test
    @Order(7)
    public void TC007_BusquedaDeTrenes_SoloIda() {

        dataCPs = DataDriven.prepararData("TC007_BusquedaDeTrenes_SoloIda");

        home.irATrenes();
        trenesPage = new TrenesPage(driver);

        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarOpcionSoloIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeOrigen(dataCPs.get(1).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeDestino(dataCPs.get(2).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioIdaTren(dataCPs.get(3).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.aumentarNumeroDePasajero();

        trenesPage.buscarTrenIda();
        trenesPage.esperarXsegundos(4000);

    }

    @Test
    @Order(8)
    public void TC008_BusquedaDeTrenes_IdaYVuelta() {

        dataCPs = DataDriven.prepararData("TC008_BusquedaDeTrenes_IdaYVuelta");

        home.irATrenes();
        trenesPage = new TrenesPage(driver);

        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarOpcionIdaYVueltaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeOrigen(dataCPs.get(1).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeDestino(dataCPs.get(2).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioIdaTren(dataCPs.get(3).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioVueltaTren(dataCPs.get(4).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.aumentarNumeroDePasajero();

        trenesPage.buscarTrenIda();
        trenesPage.esperarXsegundos(4000);
    }

    @Test
    @Order(9)
    public void TC0009_BusquedaDeTrenes_IdaYVuelta_MasRapido_IdaYVueltaAlMismoTiempo() {

        dataCPs = DataDriven.prepararData("TC0009_BusquedaDeTrenes_IdaYVuelta_MasRapido_IdaYVueltaAlMismoTiempo");

        home.irATrenes();
        trenesPage = new TrenesPage(driver);

        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarOpcionIdaYVueltaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeOrigen(dataCPs.get(1).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeDestino(dataCPs.get(2).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioIdaTren(dataCPs.get(3).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioVueltaTren(dataCPs.get(4).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.aumentarNumeroDePasajero();

        trenesPage.buscarTrenIda();
        trenesPage.esperarXsegundos(5000);

        trenesPage.seleccionarMasRapidoTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarIdaYVueltaAlMismoAeropuerto();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarPrimerTren();

    }

    @Test
    @Order(10)
    public void TC0010_BusquedaDeTrenes_IdaYVuelta_MasRapido_ReservarAsistenciaEspecial_ModalidadReducida() {

        dataCPs = DataDriven.prepararData("TC0010_BusquedaDeTrenes_IdaYVuelta_MasRapido_ReservarAsistenciaEspecial_ModalidadReducida");

        home.irATrenes();
        trenesPage = new TrenesPage(driver);

        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarOpcionIdaYVueltaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeOrigen(dataCPs.get(1).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarLugarDeDestino(dataCPs.get(2).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaIdaTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioIdaTren(dataCPs.get(3).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarFechaEnCalendarioVueltaTren(dataCPs.get(4).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.reducirNumeroDePasajero();

        trenesPage.buscarTrenIda();
        trenesPage.esperarXsegundos(5000);

        trenesPage.seleccionarMasRapidoTren();
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarPrimerTren();
        trenesPage.esperarXsegundos(4000);

        trenesPage.datosDelPasajero(dataCPs.get(5).trim(),dataCPs.get(6).trim(),dataCPs.get(7).trim(),dataCPs.get(8).trim(),dataCPs.get(9).trim(),dataCPs.get(10).trim());
        trenesPage.esperarXsegundos(1000);

        trenesPage.seleccionarAsistenciaEspecial();

    }

    @Test
    @Order(11)
    public void TC011_Busqueda_TrenXHotel_RangoPrecios() {
        home.irATrenHotel();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        trenHotel = new TrenHotelPage(driver);
        trenHotel.ejecutador_TC011("Madrid", "Barcelona", "1 resultado encontrado para 18 mar - 24 mar");
    }

    @Test
    @Order(12)
    public void TC0012_Filtrado_Trenes_MAD_VLC_Precio_Equipaje_Escala_Salida_Aere_Esta () {

         dataCPs = DataDriven.prepararData("TC0012_Filtrado_Trenes_MAD_VLC_Precio_Equipaje_Escala_Salida_Aere_Esta");

        home.irATrenes();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        trenesPage = new TrenesPage(driver);
        trenesPage.esperarXsegundos(home.getTiempoMedioEspera());
        trenesPage.insertarValores(dataCPs.get(1).trim(),dataCPs.get(2).trim());
        trenesPage.seleccionCamposIdayVuelta(dataCPs.get(3).trim(), dataCPs.get(4).trim());
        trenesPage.seleccionarCampoPasajeros();
        trenesPage.buscarTrenIda();
        trenesPage.filtrarResultadoPorMasBarato();
        trenesPage.clickChecks(driver);
        trenesPage.hacerScrollTopPagina();
        trenesPage.esperarXsegundos(home.getTiempoCortoEspera());
        trenesPage.resultadosLlenos();

    }

    @Test
    @Order(13)
    public void TC0013_Filtrar_Detalles_Busqueda() {
        home.esperarXsegundos(2000);
        home.buscarHoteles();
    }

    @Test
    @Order(14)
    public void TC014_Verificar_BotonModificar_ResumenDelViaje_EscapadasAndorra() {
        home.irACasas();
        home.esperarXsegundos(5000);
        //hacer scroll hasta ¿Cuál será tu próxima escapada?
        alterPage = new AlojamientoAlterPage(driver);
        alterPage.hacerScrollHastaProxEscapada();
        alterPage.esperarXsegundos(2000);
        alterPage.seleccionarEscapadasAndorra();
        alterPage.esperarXsegundos(2000);
        alterPage.cambiarALaUltimaVentanaAbierta();
        alterPage.esperarXsegundos(4000);
        alterPage.seleccionarPrimerResultadoEscapeAndorra();
        alterPage.esperarXsegundos(3000);
        alterPage.cambiarALaUltimaVentanaAbierta();
        alterPage.esperarXsegundos(3000);
        alterPage.seleccionarBtnModificarAlojRegimen();
        alterPage.esperarXsegundos(3000);
    }

    @Test
    @Order(15)
    public void T015_Busqueda_HotelesCasa_RangoPrecios() {
        home.irAHotelCasa();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.ejecutador_T015("Andorra", "5 resultados encontrados para 18 mar - 20 mar");
    }

    @Test
    @Order(16)
    public void TC0016_Compartir_InfoCasa_Contacto() {
        home.buscarHotelNav("Playa");
        alterPage = new AlojamientoAlterPage(driver);
        alterPage.compartirInfo();
        alterPage.seleccionarCard(0);
        alterPage.cambioVentana(driver);
        alterPage.esperarXsegundos(1000);
    }

    @Test
    @Order(17)
    public void T017_Busqueda_HotelesEsqui_VariosFiltrosDeUna() {
        home.irAHotelEsqui();
        home.esperarXsegundos(home.getTiempoMedioEspera());
        hotelPage = new HotelPage(driver);
        hotelPage.ejecutador_T017("Andorra la Vella", "4 resultados encontrados para 18 mar - 10 abr");
    }

    @Test
    @Order(18)
    public void TC0018_Filtrar_Detalles_Hotel() {
        home.buscarHoteles();
        alterPage = new AlojamientoAlterPage(driver);
        alterPage.seleccionarHotelAlternativo();
        alterPage.filtrarDetalleCard(driver);
    }

}
