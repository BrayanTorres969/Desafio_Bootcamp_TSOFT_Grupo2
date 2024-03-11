package proyecto.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import proyecto.utils.BasePage;

public class VuelosPage extends BasePage {
    By byCardCategoriaVuelos = By.xpath("//span[contains(text(),'Vuelos baratos a tu destino favorito')]");
    By byBtnVuelosAEuropa = By.xpath(("//p[contains(text(),'Ver las ofertas')]"));
    By bybtnIdaVuelta = By.xpath("//button[contains(text(),'Ida y vuelta')]");
    By byBtnLimpiar = By.xpath("//button[@aria-label='Limpiar']");
    By byInputOrigen = By.xpath("//input[@aria-label='Origen']");
    By byInputDestino = By.xpath("//input[@aria-label='Destino']");
    By byBtnBuscar = By.xpath("//button[@aria-label='Buscar']");


    public VuelosPage(WebDriver driver) {
        super(driver);
    }

    public void hacerScrollHastaCategoriaVuelos() {
        hacerScrollHasta(buscarElementoWeb(byCardCategoriaVuelos));
    }

    public void irAVuelosAEuropa() {
        clic(byBtnVuelosAEuropa);
    }

    public void seleccionarOpcionIdaYVuelta() {
        clic(bybtnIdaVuelta);
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
}
