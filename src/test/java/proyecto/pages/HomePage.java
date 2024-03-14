package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

public class HomePage extends BasePage {

    //Agrupar los locators
    By byBtnAceptarCookies = By.className("iubenda-cs-accept-btn");
    By byBtnVuelos = By.xpath(("//p[contains(text(),'Vuelos')]"));
    By byBtnVerMas = By.xpath(FixEncoding.corregirEncoding("//a[@title='Ver más']"));
    By byBtnTrenes = By.xpath("//li//div[text()='Trenes']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void aceptarCookies() {
        clic(esperarElementoWeb(byBtnAceptarCookies));
    }

    public void irAVuelos() {
        clic(esperarElementoWeb(byBtnVuelos));
    }

    public void irATrenes(){
        hacerHoverEnElemento(byBtnVerMas);
        clic(byBtnTrenes);
    }
}
