package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

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


    public TrenesPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarOpcionSoloIdaTren(){
        clic(byBtnSoloIda);
    }

    public void seleccionarOpcionIdaYVueltaTren(){
        clic(byBtnIdaYVuelta);
    }

    public void seleccionarLugarDeOrigen(){
        clic(byTxtOrigen);
        agregarTexto(byTxtOrigen,"Alicante");
    }

    public void seleccionarLugarDeDestino(){
        clic(byTxtDestino);
        esperarXsegundos(1000);
        agregarTexto(byTxtDestino,"Madrid");
    }

    public void seleccionarFechaIdaTren(){
        clic(byFechaIda);
    }

    public void seleccionarFechaEnCalendarioIdaTren(){
        clic(byCalendarioIda);
    }

    public void seleccionarFechaEnCalendarioVueltaTren(){
        clic(byCalendarioVuelta);
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

    public void datosDelPasajero(){
        hacerScrollHasta(buscarElementoWeb(bydatosPasajeros));
        esperarXsegundos(1000);
        clic(byselectSr);
        esperarXsegundos(1000);
        clic(bynombrePasajero);
        agregarTexto(bynombrePasajero,"Dylan");
        clic(byapellidoPasajero);
        agregarTexto(byapellidoPasajero,"Huarcaya");
        esperarXsegundos(1000);
        agregarTexto(bydiaPasajero,"16");
        clic(bymesPasajero);
        esperarXsegundos(1000);
        clic(bymesEnero);
        agregarTexto(byanioPasajero,"2003");
        clic(byBtnTipoDeDocumento);
        esperarXsegundos(1000);
        clic(byBtnDNI);
        agregarTexto(byNumDNI,"65004204V");


    }

    public void seleccionarAsistenciaEspecial(){
        clic(byBtnAsistenciaEspecial);
        esperarXsegundos(1000);
        seleccionarCmbPorValue(esperarElementoWeb(byTipoSolicitud),"Movilidad reducidad");
        esperarXsegundos(1000);
        seleccionarCmbPorValue(esperarElementoWeb(byTipoAsistencia),"Pasajero no puede subir ni bajar escalones (WCHS)");
    }

}
