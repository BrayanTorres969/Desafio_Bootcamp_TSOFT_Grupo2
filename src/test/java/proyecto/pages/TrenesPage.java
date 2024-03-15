package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

import java.util.List;

public class TrenesPage extends BasePage {

    By byBtnSoloIda = By.xpath("//button[text()='Solo ida']");
    By byBtnIdaYVuelta = By.xpath("//button[text()='Ida y vuelta']");
    By byTxtOrigen = By.xpath("//div/input[@placeholder='Origen']");
    By byTxtDestino = By.xpath("//input[@aria-label='Destino']");
    By byFechaIda = By.xpath("//button[@aria-label='Fecha de ida']");
    By byCalendarioVuelta = By.xpath("//button[text()='20']");
    By byCalendarioIda = By.xpath("//button[text()='18']");
    By byAumentarPasajero = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Aumentar el número de adultos']"));
    By byReducirPasajero = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Reducir el número de adultos']"));
    By byTren = By.xpath("//button[@aria-label='Buscar']");
    By byBtnMasRapidoTren = By.xpath("//li[@data-value='duration.asc']");
    By byEstaciones = By.xpath(FixEncoding.corregirEncoding("//h4[text()='Duración del vuelo']"));
    By byBtnIdaYVueltaAlMismoAeropuerto = By.xpath("//div[@class='Switchstyles__Switch-sc-1ym8u79-1 kjREJd']");
    By byVolverArriba = By.xpath("//div[@class='layer-1']");
    By byBtnEscogerPrimerTren = By.xpath("//div[@class='FullTransportPrices__SelectedPriceContainer-sc-1qck0l5-1 guOuFB']");
    By byBtnSeleccionarTren = By.xpath("//button[text()='Seleccionar']");
    By bydatosPasajeros = By.xpath("//h3[text()='Datos de los pasajeros']");
    By byselectSr = By.xpath("//span[text()='Sr.']");
    By bynombrePasajero = By.xpath("//input[@name='groups.1.travellers.1.name']");
    By byapellidoPasajero = By.xpath("//input[@name='groups.1.travellers.1.surname']");
    By bydiaPasajero = By.xpath("//input[@name='groups.1.travellers.1.dateOfBirth']");
    By bymesPasajero = By.xpath("//button[@data-testid='groups.1.travellers.1.dateOfBirth_month']");
    By byanioPasajero = By.xpath("//input[@pattern='[0-9]{1,4}']");
    By bymesEnero = By.xpath("//span[text()='enero']");
    By byBtnTipoDeDocumento = By.xpath("//button[@data-testid='groups.1.travellers.1.documentType']");
    By byBtnDNI = By.xpath("//span[text()='DNI']");
    By byNumDNI = By.xpath("//input[@name='groups.1.travellers.1.documentNumber']");
    By byBtnAsistenciaEspecial = By.id("special-assistance-checkbox");
    By byTipoSolicitud = By.xpath("//select[@data-test='special-request-structured-types']");
    By byTipoAsistencia = By.id("special-requests-structured-requirements_1");
    By byInputOrigen = By.xpath("//input[@aria-label='Origen']");
    By byInputDestino = By.xpath("//input[@aria-label='Destino']");
    By byInputFechaDeVuelta = By.xpath("//button[@aria-label='Fecha de vuelta']");
    By byInputPersonas = By.xpath("//label[contains(text(),'Pasajero')]");
    By byBtnFiltrarResultadosVuelosPorMasBarato = By.xpath(FixEncoding.corregirEncoding("//li[@role='tab' and contains(@class, 'Tabs__ListElement')]/h5[contains(text(), 'Más barato')]"));
    By byListaResuladosTrenes = By.xpath("//div[@data-e2e='trip-card']");

    public TrenesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> obtenerResultadosTrenesBuscados() {
        return buscarElementosWeb(byListaResuladosTrenes);
    }

    public void seleccionarOpcionSoloIdaTren(){
        clic(byBtnSoloIda);
    }

    public void seleccionarOpcionIdaYVueltaTren(){
        clic(byBtnIdaYVuelta);
    }

    public void seleccionarLugarDeOrigen(String lugarOrigen){
        clic(byTxtOrigen);
        agregarTexto(byTxtOrigen,lugarOrigen);
    }

    public void seleccionarLugarDeDestino(String lugarDestino){
        clic(byTxtDestino);
        esperarXsegundos(1000);
        agregarTexto(byTxtDestino,lugarDestino);
    }

    public void seleccionarFechaIdaTren(){
        clic(byFechaIda);
    }

    public void seleccionarFechaEnCalendarioIdaTren(String rutaXpath){
        //clic(byCalendarioIda);
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }

    public void seleccionarFechaEnCalendarioVueltaTren(String rutaXpath){
        //clic(byCalendarioVuelta);
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }

    public void aumentarNumeroDePasajero(){
        clic(byAumentarPasajero);
    }

    public void reducirNumeroDePasajero(){
        clic(byReducirPasajero);
    }

    public void buscarTrenIda(){
        clic(byTren);
    }

    public void seleccionarMasRapidoTren(){
        clic(byBtnMasRapidoTren);
    }

    public void seleccionarIdaYVueltaAlMismoAeropuerto(){
        hacerScrollHasta(buscarElementoWeb(byEstaciones));
        esperarXsegundos(1000);
        clic(byBtnIdaYVueltaAlMismoAeropuerto);
    }

    public void seleccionarPrimerTren(){
        hacerScrollHasta(buscarElementoWeb(byVolverArriba));
        esperarXsegundos(1000);
        clic(byBtnEscogerPrimerTren);
        esperarXsegundos(1000);
        clic(byBtnSeleccionarTren);
    }

    public void datosDelPasajero(String nombre, String apellido, String dia,String rutaXpath, String anio, String DNI){
        hacerScrollHasta(buscarElementoWeb(bydatosPasajeros));
        esperarXsegundos(1000);
        clic(byselectSr);
        esperarXsegundos(1000);
        //clic(bynombrePasajero);
        agregarTexto(bynombrePasajero,nombre);
        //clic(byapellidoPasajero);
        agregarTexto(byapellidoPasajero,apellido);
        esperarXsegundos(1000);
        agregarTexto(bydiaPasajero,dia);
        clic(bymesPasajero);
        esperarXsegundos(1000);
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
        agregarTexto(byanioPasajero,anio);
        clic(byBtnTipoDeDocumento);
        esperarXsegundos(1000);
        clic(byBtnDNI);
        agregarTexto(byNumDNI,DNI);

    }
    public void seleccionarAsistenciaEspecial(){
        clic(byBtnAsistenciaEspecial);
        esperarXsegundos(1000);
        seleccionarCmbPorValue(esperarElementoWeb(byTipoSolicitud),"Movilidad reducidad");
        esperarXsegundos(1000);
        seleccionarCmbPorValue(esperarElementoWeb(byTipoAsistencia),"Pasajero no puede subir ni bajar escalones (WCHS)");
    }

    public void ingresarOrigenTrenes(String texto) {
        clic(byTxtOrigen);
        esperarXsegundos(1000);
        agregarTexto(byTxtOrigen, texto);
    }

    public void ingresarDestinoTrenes(String texto) {
        clic(byTxtDestino);
        esperarXsegundos(1000);
        agregarTexto(byTxtDestino, texto);
    }

    public void insertarValores (String ori, String desti){
        ingresarOrigenTrenes(ori);
        esperarXsegundos(2000);
        ingresarDestinoTrenes(desti);
        esperarXsegundos(2000);
    }
    public void filtrarResultadoPorMasBarato (){
        clic(esperarElementoWeb(byBtnFiltrarResultadosVuelosPorMasBarato));
    }


    public void seleccionarCampoFechaDeVuelta() {
        clic(byInputFechaDeVuelta);
    }

    public void ingresarFechaDeIda(String rutaXpath) {
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }

    public void ingresarFechaDeVuelta(String rutaXpath) {
        WebElement fechaSeleccionada = buscarElementoWeb(By.xpath(rutaXpath));
        clic(fechaSeleccionada);
    }

    public void seleccionCamposIdayVuelta(String dia, String diaSgt){
        seleccionarCampoFechaDeVuelta();
        esperarXsegundos(500);
        ingresarFechaDeIda("//div[@aria-labelledby='2-2024']//button[text()='" + dia + "']");
        esperarXsegundos(1000);
        ingresarFechaDeVuelta("//div[@aria-labelledby='2-2024']//button[text()='" + diaSgt + "']");
        esperarXsegundos(1000);
    }
    public void seleccionarCampoPasajeros() {
        clic(byInputPersonas);
    }

    public void clickCheckEquipaje(WebDriver driver){
        esperarXsegundos(10000);
        WebElement boton = driver.findElement(By.id("id-Equipaje de mano incl."));

        boton.getAttribute("aria-checked");
        if (!boton.getAttribute("aria-checked").equals("true")) {
            boton.sendKeys(" ");
        }
    }

    public void clickCheckEscalaIda(WebDriver driver){
        esperarXsegundos(10000);
        WebElement boton = driver.findElement(By.id("id-1 escala-way0"));

        boton.getAttribute("aria-checked");
        if (!boton.getAttribute("aria-checked").equals("true")) {
            boton.sendKeys(" ");
        }
    }

    public void clickCheckEstaIDA(WebDriver driver){
        esperarXsegundos(10000);
        WebElement boton = driver.findElement(By.id("id-Madrid Puerta de Atocha (XOC)-way0-DepartureLocationsFilter"));


        boton.getAttribute("aria-checked");
        if (!boton.getAttribute("aria-checked").equals("true")) {
            boton.sendKeys(" ");
        }
    }

    public void clickCheckEstaVuelta(WebDriver driver){
        esperarXsegundos(10000);
        WebElement boton = driver.findElement(By.id("id-Madrid Puerta de Atocha (XOC)-way1-ArrivalLocationsFilter"));


        boton.getAttribute("aria-checked");
        if (!boton.getAttribute("aria-checked").equals("true")) {
            boton.sendKeys(" ");
        }
    }

    public void clickChecks (WebDriver driverX) {
        clickCheckEquipaje(driverX);
        clickCheckEscalaIda(driverX);
        clickCheckEstaIDA(driverX);
        clickCheckEstaVuelta(driverX);
        esperarXsegundos(getTiempoCortoEspera());
    }

    public void resultadosLlenos(){
        esperarXsegundos(10000);
        boolean Vof = obtenerResultadosTrenesBuscados().isEmpty();
        if (!Vof) {
            esperarXsegundos(3000);
            System.out.println("Hay resultados para esta busqueda");
            Assertions.assertFalse(Vof);
        } else {
            System.out.println("No hay resultados para esta busqueda");
            Assertions.assertTrue(Vof);
        }
    }




}
