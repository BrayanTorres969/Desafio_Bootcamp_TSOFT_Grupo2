package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyecto.utils.BasePage;

public class HomePage extends BasePage {

    //Agrupar los locators
    By byBtnAceptarCookies = By.className("iubenda-cs-accept-btn");
    By byBtnVuelos = By.xpath(("//p[contains(text(),'Vuelos')]"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void aceptarCookies() {
        clic(esperarElementoWeb(byBtnAceptarCookies));
    }

    public void irAVuelos() {
        clic(esperarElementoWeb(byBtnVuelos));
    }
}
