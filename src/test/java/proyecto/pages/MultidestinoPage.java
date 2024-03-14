package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

import java.util.List;

public class MultidestinoPage extends BasePage {
    List<WebElement> listInputDate;

    By byBtnAceptarCookies = By.xpath("//button[@data-test='CookiesPopup-Accept']");
    By byButtonAddDestination = By.xpath("//button[@data-test='addMultiCity']");

    By byInputDestination0 = By.xpath("//div[@data-test='PlacePickerInput-destination-0']//input[@data-test='SearchField-input']");
    By byValueDestino0 = By.xpath("//div[contains(text(),'Madrid, Espa')]");
    By byInputDateDestination0 = By.xpath("//input[@data-test='SearchFieldDateInput']");
    By byFechaDestination0OrigenClick = By.xpath("//div[@data-value='2024-03-18']");
    By byFechaDestination0DestinoClick = By.xpath("//div[@data-value='2024-03-22']");

    By byBtnEstablecerFechas = By.xpath("//button[@data-test='SearchFormDoneButton']");
    By byEquisEliminarDestino = By.xpath("//div[@data-test='PlacePickerInputPlace-close']");

    By byInputDestination1 = By.xpath("//div[@data-test='PlacePickerInput-destination-1']//input[@data-test='SearchField-input']");
    By byValueDestino1 = By.xpath("//div[contains(text(),'Barcelona, Espa')]");
    By byFechaDestination1OrigenClick = By.xpath("//div[@data-value='2024-03-23']");
    By byFechaDestination1DestinoClick = By.xpath("//div[@data-value='2024-03-27']");

    By byInputDestination2 = By.xpath("//div[@data-test='PlacePickerInput-destination-2']//input[@data-test='SearchField-input']");
    By byValueDestino2 = By.xpath("//div[contains(text(),'Cuzco, Per')]");
    By byFechaDestination2OrigenClick = By.xpath("//div[@data-value='2024-03-28']");
    By byFechaDestination2DestinoClick = By.xpath("//div[@data-value='2024-04-02']");

    By byInputDestination3 = By.xpath("//div[@data-test='PlacePickerInput-destination-3']//input[@data-test='SearchField-input']");
    By byValueDestino3 = By.xpath("//div[contains(text(),'Lima, Per')]");
    By byFechaDestination3OrigenClick = By.xpath("//div[@data-value='2024-04-02']");
    By byFechaDestination3DestinoClick = By.xpath("//div[@data-value='2024-04-06']");

    By byBtnBuscarVuelos = By.xpath("//div[@data-test='MulticityDesktopButtons']//button[@data-test='DoneButton']");

    By byBtnViajeros = By.xpath("//button[@data-test='PassengersButton']");
    By byBtnIncrement = By.xpath("//button[@aria-label='increment']");
    By byBtnConfirmarFiltroViajeros = By.xpath("//button[@data-test='PassengersAndBagsFieldFooter-done']");

    By byDivTransportes = By.xpath("//div[contains(text(),'Transporte')]");
    By byOptionVuelos = By.xpath("//span[contains(text(),'Vuelo')]");
    By byDivSoloVuelos = By.xpath("//div[contains(text(),'Solo')]");

    By byBtnClaseViaje = By.xpath("//div[@data-test='CabinClassField-active-economy']");
    By byOptionPrimeraClase = By.xpath("//span[contains(text(),'Primera clase')]");

    By byTituloEscalas = By.xpath("//div[contains(text(),'Escalas')]");

    public MultidestinoPage(WebDriver driver) {
        super(driver);
    }

    public void aceptarCookies() {
        clic(esperarElementoWeb(byBtnAceptarCookies));
    }

    public void addDestination(){
        clic(esperarElementoWeb(byButtonAddDestination));
    }

    public void agregarDestinoYFecha(By byInputDestination, By byValueDestination,
                                     By byFechaDestinationOrigenClick, By byFechaDestinationDestinoClick,
                                     String texto, int i) {
        clic(byInputDestination);
        agregarTexto(byInputDestination, texto);
        esperarXsegundos(getTiempoLargoEspera());
        clic(byValueDestination);
        esperarXsegundos(getTiempoCortoEspera());
        this.listInputDate = buscarElementosWeb(byInputDateDestination0);
        this.listInputDate.get(i).click();
        esperarXsegundos(getTiempoLargoEspera());
        clic(byFechaDestinationOrigenClick);
        esperarXsegundos(getTiempoCortoEspera());
        // Simular click y mantener presionado en el elemento origen
        getActions().clickAndHold(esperarElementoWeb(byFechaDestinationOrigenClick)).perform();
        // Arrastrar el elemento origen hasta el elemento destino
        getActions().moveToElement(esperarElementoWeb(byFechaDestinationDestinoClick)).release().perform();
        clic(byBtnEstablecerFechas);
    }

    public void agregarPrimerDestinoYFecha(String texto){
        this.agregarDestinoYFecha(byInputDestination0, byValueDestino0,
                byFechaDestination0OrigenClick, byFechaDestination0DestinoClick, texto,0);
    }

    public void agregarSegundoDestinoYFecha(String texto){
        List<WebElement> listEquis = buscarElementosWeb(byEquisEliminarDestino);
        listEquis.get(3).click();
        listEquis.get(4).click();
        this.agregarDestinoYFecha(byInputDestination1, byValueDestino1,
                byFechaDestination1OrigenClick, byFechaDestination1DestinoClick, texto,1);
    }

    public void agregarTercerDestinoYFecha(String texto){
        this.agregarDestinoYFecha(byInputDestination2, byValueDestino2,
                byFechaDestination2OrigenClick, byFechaDestination2DestinoClick, texto,2);
    }

    public void agregarCuartoDestinoYFecha(String texto){
        this.agregarDestinoYFecha(byInputDestination3, byValueDestino3,
                byFechaDestination3OrigenClick, byFechaDestination3DestinoClick, texto,3);
        esperarXsegundos(getTiempoMedioEspera());
        clic(byBtnBuscarVuelos);
    }

    public void aumentarPasajerosYPiezaEquipaje(){
        clic(byBtnViajeros);
        List<WebElement> listBtnIncrement = buscarElementosWeb(byBtnIncrement);
        esperarXsegundos(getTiempoCortoEspera());
        listBtnIncrement.get(2).click();
        listBtnIncrement.get(3).click();
        listBtnIncrement.get(4).click();
        listBtnIncrement.get(6).click();
        try {
            buscarElementoWeb(byBtnConfirmarFiltroViajeros);
        } catch (NoSuchElementException e) {
            hacerScrollHastaPiePagina();
        }
    }

    public void filtrarSoloVuelos(){
        hacerScrollHastaPiePagina();
        clic(byDivTransportes);
        esperarXsegundos(getTiempoLargoEspera());
        hacerScrollHastaPiePagina();
        esperarXsegundos(getTiempoCortoEspera());
        hacerScrollTopPagina();
        esperarXsegundos(getTiempoCortoEspera());
        hacerScrollHastaPiePagina();
        esperarXsegundos(getTiempoCortoEspera());
        getActions().moveToElement(esperarElementoWeb(byOptionVuelos)).perform();
        List<WebElement> listDivSolo = buscarElementosWeb(byDivSoloVuelos);
        listDivSolo.get(0).click();
    }

    public void filtrarClaseViaje(){
        clic(byBtnClaseViaje);
        esperarXsegundos(getTiempoCortoEspera());
        clic(byOptionPrimeraClase);
        esperarXsegundos(getTiempoCortoEspera());
        clic(byTituloEscalas);
    }

    //TC006_Busqueda_Vuelos_Multidestino
    public void ejecutador_TC006(String primerDestino, String segundoDestino, String tercerDestino, String cuartoDestino,
                                String resultadoFinalEsperado){
        addDestination();
        addDestination();
        esperarXsegundos(getTiempoCortoEspera());
        agregarPrimerDestinoYFecha(primerDestino);
        esperarXsegundos(getTiempoCortoEspera());
        agregarSegundoDestinoYFecha(segundoDestino);
        esperarXsegundos(getTiempoCortoEspera());
        agregarTercerDestinoYFecha(tercerDestino);
        esperarXsegundos(getTiempoCortoEspera());
        agregarCuartoDestinoYFecha(cuartoDestino);
        esperarXsegundos(getTiempoCortoEspera());
        aceptarCookies();
        esperarXsegundos(getTiempoLargoEspera());
        aumentarPasajerosYPiezaEquipaje();
        esperarXsegundos(getTiempoLargoEspera());
        filtrarSoloVuelos();
        esperarXsegundos(getTiempoLargoEspera());
        filtrarClaseViaje();
        esperarXsegundos(getTiempoLargoEspera());
        validarMensaje(resultadoFinalEsperado, esperarElementoWeb(By.xpath("//div[contains(text(),'"+ FixEncoding.corregirEncoding(resultadoFinalEsperado) + "')]")));
    }
}
