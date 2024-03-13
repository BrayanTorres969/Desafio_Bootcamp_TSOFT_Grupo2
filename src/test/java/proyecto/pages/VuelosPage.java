package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

import java.util.List;

public class VuelosPage extends BasePage {
    By byCardCategoriaVuelos = By.xpath("//span[contains(text(),'Vuelos baratos a tu destino favorito')]");
    By byBtnVuelosAEuropa = By.xpath(("//p[contains(text(),'Ver las ofertas')]"));
    By byBtnVuelosFinde = By.xpath(("//p[contains(text(),'Descubrir')]"));
    By byBtnVuelosNacionales = By.xpath(("//p[contains(text(),'Reserva ya')]"));
    By bybtnIdaVuelta = By.xpath("//button[contains(text(),'Ida y vuelta')]");
    By bybtnSoloIda = By.xpath("//button[contains(text(),'Solo ida')]");
    By byBtnLimpiar = By.xpath("//button[@aria-label='Limpiar']");
    By byInputOrigen = By.xpath("//input[@aria-label='Origen']");
    By byInputFechaDeIda = By.xpath("//button[@aria-label='Fecha de ida']");
    By byInputFechaDeVuelta = By.xpath("//button[@aria-label='Fecha de vuelta']");
    By byInputPersonas = By.xpath("//label[contains(text(),'Pasajeros y clase del vuelo')]");
    By byInputDestino = By.xpath("//input[@aria-label='Destino']");
    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    By byBtnSgtMes = By.xpath("//button[@aria-label='Next month']");
    By byBtnAumentarNumAdultos = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Aumentar el número de adultos']"));
    By byBtnClaseTurista = By.xpath("//button[@value='Y' and contains(text(),'Turista')]");
    By byListaResuladosVuelos = By.xpath("//div[@data-e2e='trip-card']");
    By byTituloCompanias = By.xpath(FixEncoding.corregirEncoding("//h3[contains(text(),'Compañías')]"));
    By byBtnFiltrarResultadosPorVuelos = By.xpath("//button[@value='flights']");
    By byTituloCardDetallesVuelo = By.xpath("//h2[@class='Text__BaseText-sc-bargkg-0 chraKX']");

    List<WebElement> tripCards;

    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    public void hacerScrollHastaCategoriaVuelos() {
        hacerScrollHasta(buscarElementoWeb(byCardCategoriaVuelos));
    }

    public void irAVuelosAEuropa() {
        clic(byBtnVuelosAEuropa);
    }
    public void irAVuelosFinde() {
        clic(byBtnVuelosFinde);
    }

    public void irAVuelosNacionales() {
        clic(byBtnVuelosNacionales);
    }

    public void seleccionarOpcionIdaYVuelta() {
        clic(bybtnIdaVuelta);
    }

    public void seleccionarOpcionSoloIda() {
        clic(bybtnSoloIda);
    }

    public void seleccionarCampoFechaDeIda() {
        clic(byInputFechaDeIda);
    }
    public void seleccionarCampoFechaDeVuelta() {
        clic(byInputFechaDeVuelta);
    }

    public void seleccionarCampoPasajeros() {
        clic(byInputPersonas);
    }

    public void seleccionarSgteMes() {
        clic(byBtnSgtMes);
    }

    public void aumentarNumPasajerosAdultos() {
        seleccionarCampoPasajeros();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clic(byBtnAumentarNumAdultos);
    }


    public void limpiarValorOrigenPorDefecto() throws InterruptedException {
        if (buscarElementoWeb(byBtnLimpiar).isDisplayed()) {
            Thread.sleep(1000);
            clic(byBtnLimpiar);
        }
    }

    //métodos de entrada
    public void ingresarOrigenVuelo(String texto) {
        clic(byInputOrigen);
        agregarTexto(byInputOrigen, texto);
    }

    public void ingresarDestinoVuelo(String texto) {
        clic(byInputDestino);
        agregarTexto(byInputDestino, texto);
    }

    public void ingresarFechaDeIda(String rutaXpath) {
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }
    public void ingresarFechaDeVuelta(String rutaXpath) {
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }

    public void seleccionarClaseVueloTurista() {
        seleccionarCampoPasajeros();
        clic(byBtnClaseTurista);
    }


    //métodos de salida
    public void buscarVuelos() {
        clic(byBtnBuscar);
    }

    public void validarCampoOrigen() {
        WebElement spanErrorOrigen = buscarElementoWeb(By.xpath("//span[contains(text(),'Introduce ciudad o aeropuerto de origen')]"));
        String msjErrorOrigen = obtenerTexto(spanErrorOrigen);
        Assertions.assertEquals("Introduce ciudad o aeropuerto de origen", msjErrorOrigen);
    }

    public void validarCampoDestino() {
        WebElement spanErrorDestino = buscarElementoWeb(By.xpath("//span[contains(text(),'Introduce ciudad o aeropuerto de destino')]"));
        String msjErrorDestino = obtenerTexto(spanErrorDestino);
        Assertions.assertEquals("Introduce ciudad o aeropuerto de destino", msjErrorDestino);
    }

    public List<WebElement> obtenerResultadosVuelosBuscados() {
        return buscarElementosWeb(byListaResuladosVuelos);
    }

    public void seleccionarPrimerResultadoDeBusqueda() {
        WebElement primerResultado = obtenerResultadosVuelosBuscados().get(0);
        clic(primerResultado);
    }

    public void filtrarResultadosPorVuelo() {
        hacerScrollHasta(buscarElementoWeb(byTituloCompanias));
        clic(byBtnFiltrarResultadosPorVuelos);
    }

    public void validarRutaDetalleVuelo(String origen, String destino) {
        WebElement elemntoTituloCard = buscarElementoWeb(byTituloCardDetallesVuelo);
        String textoTituloCard = obtenerTexto(elemntoTituloCard);
        String ruta = origen + " - " + destino;
        Assertions.assertEquals(ruta, textoTituloCard);
    }

    public void vuelosDesplaza (){
        hacerScrollHastaCategoriaVuelos();
        esperarXsegundos(1700);
        irAVuelosFinde();
        esperarXsegundos(1500);
        cambiarALaUltimaVentanaAbierta();
        esperarXsegundos(1500);
    }

    public void limpiezaBusqueda (){
        try {
            limpiarValorOrigenPorDefecto();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertarValores (String ori, String desti){
        ingresarOrigenVuelo(ori);
        esperarXsegundos(1000);
        ingresarDestinoVuelo(desti);
        esperarXsegundos(1000);
    }

    public void seleccionCamposIdayVuelta(String dia, String diaSgt){
        seleccionarCampoFechaDeIda();
        esperarXsegundos(500);
        ingresarFechaDeIda("//div[@aria-labelledby='2-2024']//button[text()='" + dia + "']");
        esperarXsegundos(1000);
        seleccionarCampoFechaDeVuelta();
        esperarXsegundos(500);
        ingresarFechaDeVuelta("//div[@aria-labelledby='2-2024']//button[text()='" + diaSgt + "']");
        esperarXsegundos(1000);
    }


    public void resultadosTC2(){

        buscarVuelos();
        esperarXsegundos(10000);

        if (obtenerResultadosVuelosBuscados().isEmpty()) {
            esperarXsegundos(3000);
            System.out.println("No hay resultados para esta busqueda");
        } else {
            System.out.println("Hay resultados para esta busqueda");
        }
    }






}
