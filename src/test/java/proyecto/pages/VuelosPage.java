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
    By byBtnVuelosNacionales = By.xpath(("//p[contains(text(),'Reserva ya')]"));
    By byBtnVuelosFinDeSemana = By.xpath(("//p[contains(text(),'Descubrir')]"));
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
    By byBtnSgtClaseVuelo = By.xpath("//button[@class='d-128ddiu']");
    By byBtnAumentarNumAdultos = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Aumentar el número de adultos']"));
    By byBtnClaseTurista = By.xpath("//button[@value='Y' and contains(text(),'Turista')]");
    By byBtnClaseBusiness = By.xpath("//button[@value='C' and contains(text(),'Business')]");
    By byListaResuladosVuelos = By.xpath("//div[@data-e2e='trip-card']");
    By byTituloCompanias = By.xpath(FixEncoding.corregirEncoding("//h3[contains(text(),'Compañías')]"));
    By byBtnFiltrarResultadosPorVuelos = By.xpath("//button[@value='flights']");
    By byBtnFiltrarResultadosVuelosPorMasRapido = By.xpath(FixEncoding.corregirEncoding("//li[@role='tab' and contains(@class, 'Tabs__ListElement')]/h5[contains(text(), 'Más rápido')]"));
    By byTituloCardDetallesVuelo = By.xpath("//h2[@class='Text__BaseText-sc-bargkg-0 chraKX']");
    By byBtnSeleccionarVuelo = By.xpath("//button[contains(text(),'Seleccionar')]");
    By byBtnTarifaVueloClassic = By.xpath("//button[contains(text(),'Elegir Classic')]");
    By byTituloTarifaVuelo = By.xpath(FixEncoding.corregirEncoding("//h4[contains(text(),'Viaja con más flexibilidad')]"));
    By byBtnSgtFormDeReservaVuelo = By.xpath("//button[contains(@class, 'lead-generation-submit__btn-revamped-cta') and contains(text(), 'Siguiente')]");
    //Localizadores del formulario de Datos personales y equipaje
    By byErrorInputNombreDatosDeContacto = By.xpath("//div[contains(@class, 'widget-wrapper--contact')]//span[@data-testid='input-helper-text' and contains(text(),'Introduce el nombre')]");
    By byErrorInputApellidoDatosDeContacto = By.xpath("//div[contains(@class, 'widget-wrapper--contact')]//span[@data-testid='input-helper-text' and contains(text(),'Introduce el apellido')]");
    By byErrorInputEmailDatosDeContacto = By.xpath(FixEncoding.corregirEncoding("//div[contains(@class, 'widget-wrapper--contact')]//span[@data-testid='input-helper-text' and contains(text(),'Introduce un email válido')]"));
    By byErrorInputTelefonoDatosDeContacto = By.xpath(FixEncoding.corregirEncoding("//div[contains(@class, 'widget-wrapper--contact')]//div[@data-testid='next-phone-input-group-errormessage' and contains(text(),'Introduce un número de teléfono válido')]"));
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

    public void irAVuelosNacionales() {
        clic(byBtnVuelosNacionales);
    }

    public void irAVuelosFinDeSemana() {
        clic(byBtnVuelosFinDeSemana);
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

    public void seleccionarVuelo() {
        clic(byBtnSeleccionarVuelo);
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

    public void seleccionarClaseVueloBusiness() {
        seleccionarCampoPasajeros();
        clic(byBtnSgtClaseVuelo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clic(byBtnClaseBusiness);

    }

    public void seleccionarTarifaVueloClassic() {
        hacerScrollHasta(buscarElementoWeb(byTituloTarifaVuelo));
        clic(byBtnTarifaVueloClassic);
    }

    public void seleccionarSgtFormReserva() {
        hacerScrollHasta(buscarElementoWeb(byBtnSgtFormDeReservaVuelo));
        clic(byBtnSgtFormDeReservaVuelo);
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

    public void filtrarResultadosVuelosPorMasRapido() {
        clic(byBtnFiltrarResultadosVuelosPorMasRapido);
    }

    public void filtrarResultadosPorMasRapido() {
        clic(byBtnFiltrarResultadosVuelosPorMasRapido);
    }

    public void validarRutaDetalleVuelo(String origen, String destino) {
        WebElement elemntoTituloCard = buscarElementoWeb(byTituloCardDetallesVuelo);
        String textoTituloCard = obtenerTexto(elemntoTituloCard);
        String ruta = origen + " - " + destino;
        Assertions.assertEquals(ruta, textoTituloCard);
    }

    public void validarFormDatosPersonalesYEquipaje() {

    }

    public void validarDatosDeContactoVacioFormDatosPersonalesYEquipaje() {
        String msjErrorNombreContacto = obtenerTexto(buscarElementoWeb(byErrorInputNombreDatosDeContacto));
        String msjErrorApellidoContacto = obtenerTexto(buscarElementoWeb(byErrorInputApellidoDatosDeContacto));
        String msjErrorEmailContacto = obtenerTexto(buscarElementoWeb(byErrorInputEmailDatosDeContacto));
        String msjErrorTelefonoContacto = obtenerTexto(buscarElementoWeb(byErrorInputTelefonoDatosDeContacto));

        Assertions.assertEquals("Introduce el nombre", msjErrorNombreContacto);
        Assertions.assertEquals("Introduce el apellido", msjErrorApellidoContacto);
        Assertions.assertEquals(FixEncoding.corregirEncoding("Introduce un email válido"), msjErrorEmailContacto);
        Assertions.assertEquals(FixEncoding.corregirEncoding("Introduce un número de teléfono válido"), msjErrorTelefonoContacto);

    }


}
