package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

import java.util.List;

public class TrenHotelPage extends BasePage {

    By byInputLugarOrigen = By.xpath("//input[@id=':Rb8qjalamt2mm:']");
    By byOptionLugarOrigen = By.xpath("//li[@id=':Rb8qjalamt2mm:-option-0']");

    By byInputLugarDestino = By.xpath("//input[@id=':Rd8qjalamt2mm:']");
    By byOptionLugarDestino = By.xpath("//li[@id=':Rd8qjalamt2mm:-option-0']");

    By byMessagePrimerVerficacion = By.xpath("//span[contains(text(),'Primero, selecciona ciudad de origen')]");

    By byFechaIda = By.xpath("//div[@aria-labelledby='2-2024']//button[contains(text(),'18')]");
    By byFechaVuelta = By.xpath("//div[@aria-labelledby='2-2024']//button[contains(text(),'24')]");

    By byBtnAgregarNino = By.xpath("//button[@aria-label='" + FixEncoding.corregirEncoding("Aumentar el número de niños") + "']");
    By byLiEdad5 = By.xpath("//li[contains(text(),'" + FixEncoding.corregirEncoding("5 años") +"')]");

    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");

    By byBtnPrecios = By.xpath("//div[@id='Pill-PriceContainer']");
    By byDivPunteroMovil = By.xpath("//div[@data-testid='slider-bullet-right']");
    By byDivMontoMaxPrecio = By.xpath("//div[@class='sc-dJiZtA BPFME oss-ui-slider-value-label']//div[@class='sc-epALIP hwCPgV oss-ui-slider-value-label']");


    By byBtnValoracion = By.xpath("//div[@id='Pill-RatingContainer']");
    By byOptionValoracionExcelente = By.xpath("//li[@id='exp_elem_rating_excellent']");

    By byBtnTipoAlojamiento = By.xpath("//div[@id='Pill-PropertyTypeContainer']");
    By byOptionTipoAlojamientoApartahotel = By.xpath("//li[@id='exp_elem_accomodation_type_14']");

    By byBtnAplicarFiltro = By.xpath("//button[contains(text(),'Aplicar')]");

    By byMessageCantResultados = By.xpath("//span[contains(text(),'1 resultado encontrado para 18 mar - 24 mar')]");

    public TrenHotelPage(WebDriver driver) {
        super(driver);
    }

    public void verificarMensajeIntentarIngresarLugarDestino(){
        clic(esperarElementoWeb(byInputLugarDestino));
        getActions().moveToElement(buscarElementoWeb(byInputLugarDestino)).click().perform();
        String messageEsperado = FixEncoding.corregirEncoding("PRIMERO, SELECCIONA CIUDAD DE ORIGEN");
        String messageActual = obtenerTexto(esperarElementoWeb(byMessagePrimerVerficacion));
        Assertions.assertEquals(messageEsperado, messageActual);
    }

    public void agregarLugarOrigen(String texto){
        clic(esperarElementoWeb(byInputLugarOrigen));
        esperarXsegundos(getTiempoCortoEspera());
        agregarTexto(byInputLugarOrigen, texto);
        esperarXsegundos(getTiempoMedioEspera());
        clic(esperarElementoWeb(byOptionLugarOrigen));
    }

    public void agregarLugarDestino(String texto){
        clic(esperarElementoWeb(byInputLugarDestino));
        esperarXsegundos(getTiempoCortoEspera());
        agregarTexto(byInputLugarDestino, texto);
        esperarXsegundos(getTiempoMedioEspera());
        clic(esperarElementoWeb(byOptionLugarDestino));
    }

    public void establecerFechas(){
        clic(esperarElementoWeb(byFechaIda));
        clic(esperarElementoWeb(byFechaVuelta));
    }

    public void agregarViajeroYBuscar(){
        clic(esperarElementoWeb(byBtnAgregarNino));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byLiEdad5));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byBtnBuscar));
    }

    public void filtrarPrecio(){
        clic(esperarElementoWeb(byBtnPrecios));
        esperarXsegundos(getTiempoCortoEspera());
        WebElement divPuntoMovilPrecios = esperarElementoWeb(byDivPunteroMovil);
        int initialX = divPuntoMovilPrecios.getLocation().getX();
        WebElement maxPrecio = buscarElementosWeb(byDivMontoMaxPrecio).get(1);
        getActions().clickAndHold(divPuntoMovilPrecios).perform();
        do {
            getActions().moveByOffset(-1, 0).perform();
            if (obtenerTexto(maxPrecio).contains("1000")) {
                break;
            }
        } while (divPuntoMovilPrecios.getLocation().getX() < initialX);
        getActions().release().perform();
        String messageEsperado = "Max.\n1000 \u20ac";
        String messageActual = obtenerTexto(maxPrecio);
        Assertions.assertEquals(messageEsperado, messageActual.trim());
        clic(esperarElementoWeb(byBtnAplicarFiltro));
    }

    public void aplicarFiltroValoracion(){
        clic(esperarElementoWeb(byBtnValoracion));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byOptionValoracionExcelente));
        clic(esperarElementoWeb(byBtnAplicarFiltro));
    }

    public void aplicarFiltroTipoAlojamiento(){
        clic(esperarElementoWeb(byBtnTipoAlojamiento));
        esperarXsegundos(getTiempoCortoEspera());
        clic(esperarElementoWeb(byOptionTipoAlojamientoApartahotel));
        clic(esperarElementoWeb(byBtnAplicarFiltro));
    }

    public void validarMensajeCantResultados(){
        String messageEsperado = FixEncoding.corregirEncoding("1 resultado encontrado para 18 mar - 24 mar");
        String messageActual = obtenerTexto(esperarElementoWeb(byMessageCantResultados));
        Assertions.assertEquals(messageEsperado, messageActual);
    }
}
