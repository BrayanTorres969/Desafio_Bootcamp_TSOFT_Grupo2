package pages;

import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //Agrupar los locators
    By byBtnRegistrarse = By.xpath("//button[@data-testid='signup-button']");
    By byAceptarCookies = By.xpath("//button[contains(text(),'Aceptar todo')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Crear los métodos genericos de la page
    public void aceptarCookies(){
        clic(esperarElementoWeb(byAceptarCookies));
    }
}
