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
    By byInputDestino = By.xpath("//input[@aria-label='Destino']");
    By byInputFechaDeIda = By.xpath("//button[@aria-label='Fecha de ida']");
    By byInputFechaDeVuelta = By.xpath("//button[@aria-label='Fecha de vuelta']");
    By byInputPersonas = By.xpath("//label[contains(text(),'Pasajeros y clase del vuelo')]");
    By bySeleccMetodoPago = By.xpath("//button[@aria-haspopup='listbox']");
    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");
    By byBtnSgtMes = By.xpath("//button[@aria-label='Next month']");
    By byBtnSgtClaseVuelo = By.xpath("//button[@class='d-128ddiu']");
    By byBtnAumentarNumAdultos = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Aumentar el número de adultos']"));
    By byBtnCualquierClase = By.xpath("//button[contains(text(),'Cualquier clase')]");
    By byBtnClaseTurista = By.xpath("//button[@value='Y' and contains(text(),'Turista')]");
    By byBtnClaseBusiness = By.xpath("//button[@value='C' and contains(text(),'Business')]");
    By byListaResuladosVuelos = By.xpath("//div[@data-e2e='trip-card']");
    By byTituloCompanias = By.xpath(FixEncoding.corregirEncoding("//h3[contains(text(),'Compañías')]"));
    By byBtnFiltrarResultadosPorVuelos = By.xpath("//button[@value='flights']");
    By byBtnFiltrarResultadosVuelosPorMasRapido = By.xpath(FixEncoding.corregirEncoding("//li[@role='tab' and contains(@class, 'Tabs__ListElement')]/h5[contains(text(), 'Más rápido')]"));
    By byBtnFiltrarResultadosVuelosPorMasBarato = By.xpath(FixEncoding.corregirEncoding("//li[@role='tab' and contains(@class, 'Tabs__ListElement')]/h5[contains(text(), 'Más barato')]"));
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
    By bySeleccAmericanExpress = By.xpath("//span[contains(text(), 'American Express')]");
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
    public void irAVuelosFinDeSemana() {
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

    public void seleccionarCualquierClase(){
        seleccionarCampoPasajeros();
        clic(byBtnCualquierClase);
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

    public void validarCampoOrigen(String msjEsperado) {
        WebElement spanErrorOrigen = buscarElementoWeb(By.xpath("//span[contains(text(),'Introduce ciudad o aeropuerto de origen')]"));
        String msjErrorOrigen = obtenerTexto(spanErrorOrigen);
        Assertions.assertEquals(msjEsperado, msjErrorOrigen);
    }

    public void validarCampoDestino(String msjEsperado) {
        WebElement spanErrorDestino = buscarElementoWeb(By.xpath("//span[contains(text(),'Introduce ciudad o aeropuerto de destino')]"));
        String msjErrorDestino = obtenerTexto(spanErrorDestino);
        Assertions.assertEquals(msjEsperado, msjErrorDestino);
    }

    public List<WebElement> obtenerResultadosVuelosBuscados() {
        return buscarElementosWeb(byListaResuladosVuelos);
    }

    public void seleccionarPrimerResultadoDeBusqueda() {
        WebElement primerResultado = obtenerResultadosVuelosBuscados().get(0);
        clic(primerResultado);
    }

    public void seleccionarCampoMetodoPago() {
        clic(bySeleccMetodoPago);
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

    public void filtrarResultadoPorMasBarato (){
        clic(esperarElementoWeb(byBtnFiltrarResultadosVuelosPorMasBarato));
    }
    public void filtrarResultadoMetodoPago(){
        seleccionarCampoMetodoPago();
        clic(bySeleccAmericanExpress);
    }

    public void clickCheck(WebDriver driver){
        esperarXsegundos(10000);
        WebElement boton = driver.findElement(By.id("id-Equipaje facturado incl."));

        // Método 1: Cambiar el valor de aria-checked a true
        boton.getAttribute("aria-checked"); // Verificamos el estado actual
        if (!boton.getAttribute("aria-checked").equals("true")) { // Si no está activo
            boton.sendKeys(" "); // Enviamos una tecla espaciadora para cambiar el estado
        }
    }

    public void validarRutaDetalleVuelo(String origen, String destino) {
        WebElement elemntoTituloCard = buscarElementoWeb(byTituloCardDetallesVuelo);
        String textoTituloCard = obtenerTexto(elemntoTituloCard);
        String ruta = origen + " - " + destino;
        Assertions.assertEquals(ruta, textoTituloCard);
    }

    public String errorNombreDatosDeContactoFormDatosPersonalesYEquipaje() {
        return obtenerTexto(buscarElementoWeb(byErrorInputNombreDatosDeContacto));
    }
    public void vuelosDesplaza (){
        hacerScrollHastaCategoriaVuelos();
        esperarXsegundos(1700);
        irAVuelosFinDeSemana();
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
        seleccionarCampoFechaDeVuelta();
        esperarXsegundos(500);
        ingresarFechaDeIda("//div[@aria-labelledby='2-2024']//button[text()='" + dia + "']");
        esperarXsegundos(1000);
        esperarXsegundos(500);
        ingresarFechaDeVuelta("//div[@aria-labelledby='2-2024']//button[text()='" + diaSgt + "']");
        esperarXsegundos(1000);
    }

    public void resultadosLlenos(){
        esperarXsegundos(10000);
        if (!obtenerResultadosVuelosBuscados().isEmpty()) {
            esperarXsegundos(3000);
            System.out.println("Hay resultados para esta busqueda");
        } else {
            System.out.println("No hay resultados para esta busqueda");
        }
    }

    public void resultadosTC2(){

        buscarVuelos();
        esperarXsegundos(10000);
        boolean VoF = obtenerResultadosVuelosBuscados().isEmpty();

        if (VoF) {
            esperarXsegundos(3000);
            System.out.println("No hay resultados para esta busqueda");
            Assertions.assertTrue(VoF);
        } else {
            System.out.println("Hay resultados para esta busqueda");
            Assertions.assertFalse(VoF);
        }
    }

    public String errorApellidoDatosDeContactoFormDatosPersonalesYEquipaje() {
        return obtenerTexto(buscarElementoWeb(byErrorInputApellidoDatosDeContacto));
    }

    public String errorEmailDatosDeContactoFormDatosPersonalesYEquipaje() {
        return obtenerTexto(buscarElementoWeb(byErrorInputEmailDatosDeContacto));
    }

    public String errorTelefonoDatosDeContactoFormDatosPersonalesYEquipaje() {
        return obtenerTexto(buscarElementoWeb(byErrorInputTelefonoDatosDeContacto));
    }
}



