package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }
}
