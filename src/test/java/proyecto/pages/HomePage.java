package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

public class HomePage extends BasePage {

    By byAMultidestino = By.className("d-109iyyz");
    By byBtnAceptarCookies = By.className("iubenda-cs-accept-btn");

    By byBtnVerMas = By.xpath("//p[contains(text(),'" + FixEncoding.corregirEncoding("Ver más") + "')]");
    By byOptionTrenHotel = By.xpath("//div[contains(text(),'Tren + Hotel')]");

    By byBtnHoteles = By.xpath("//p[contains(text(),'Hoteles')]");
    By byOptionCasa = By.xpath("//div[contains(text(),'Casas')]");

    By byOptionEsqui = By.xpath("//div[contains(text(),'" + FixEncoding.corregirEncoding("Esquí") + "')]");
    //Agrupar los locators
    By byBtnAceptarCookies = By.className("iubenda-cs-accept-btn");
    By byBtnVuelos = By.xpath(("//p[contains(text(),'Vuelos')]"));
    By byBtnVerMas = By.xpath(FixEncoding.corregirEncoding("//a[@title='Ver más']"));
    By byBtnTrenes = By.xpath("//li//div[text()='Trenes']");
    By byHoteles = By.xpath("//span[contains(text(),'Hoteles')]");
    By byInputBuscar = By.xpath("//input[@id=':R9oqnalbldq2mm:']");
    By byTipoExotico = By.xpath("//li[@id=':R9oqnalbldq2mm:-option-1']");
    By byFechaEntrada = By.xpath("//div[@aria-labelledby='2-2024']//button[text()='16']");
    By byFechaSalida = By.xpath("//div[@aria-labelledby='2-2024']//button[text()='18']");
    By byPersonas = By.xpath("//div[@class='d-1k5t2mm']//button[contains(@aria-label, 'Aumentar')]");
    By byBuscarHotel = By.xpath("//*[@id=\"hub-csw-container\"]/div/div[4]/div/form/div/div[3]/div/button");
    By byBtnLimpiar = By.xpath("//div[@aria-label='Hoteles']//button[@aria-label='Limpiar']");
    By byNavBarHoteles = By.xpath("//p[contains(text(),'Hoteles')]");
    By byBtnCasas = By.xpath("//a[@title='Casas']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void aceptarCookies() {
        clic(esperarElementoWeb(byBtnAceptarCookies));
    }

    public void irAMultidestino(){
        this.aceptarCookies();
        clic(byAMultidestino);
    }

    public void irATrenHotel(){
        this.aceptarCookies();
        getActions().moveToElement(esperarElementoWeb(byBtnVerMas)).perform();
        clic(esperarElementoWeb(byOptionTrenHotel));
    }

    public void irAHotelCasa(){
        this.aceptarCookies();
        getActions().moveToElement(esperarElementoWeb(byBtnHoteles)).perform();
        clic(esperarElementoWeb(byOptionCasa));
    }

    public void irAHotelEsqui(){
        this.aceptarCookies();
        getActions().moveToElement(esperarElementoWeb(byBtnHoteles)).perform();
        clic(esperarElementoWeb(byOptionEsqui));
    public void irAVuelos() {
        clic(esperarElementoWeb(byBtnVuelos));
    }

    public void irATrenes() {
        hacerHoverEnElemento(byBtnVerMas);
        clic(byBtnTrenes);
    }

    public void irACasas() {
        hacerHoverEnElemento(byNavBarHoteles);
        clic(byBtnCasas);
    }

    public void limpiarValorOrigenPorDefecto() throws InterruptedException {
        if (buscarElementoWeb(byBtnLimpiar).isDisplayed()) {
            Thread.sleep(1000);
            clic(byBtnLimpiar);
        }
    }

    public void buscarHoteles() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        clic(esperarElementoWeb(byHoteles));
        try {
            Thread.sleep(2000);
            limpiarValorOrigenPorDefecto();
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println(e);
        }
        clic(esperarElementoWeb(byInputBuscar));
        clic(esperarElementoWeb(byTipoExotico));

        clic(esperarElementoWeb(byFechaEntrada));
        clic(esperarElementoWeb(byFechaSalida));
        //clic(esperarElementoWeb(bySeleccionFSal));

        for (int i = 0; i < 2; i++) {
            clic(esperarElementoWeb(byPersonas));
        }
        clic(esperarElementoWeb(byBuscarHotel));
    }
}
