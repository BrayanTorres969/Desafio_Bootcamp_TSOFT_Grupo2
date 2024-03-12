package pages;

import org.openqa.selenium.WebElement;
import utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends BasePage {
    //Agrupar los locators
    By byAceptarCookies = By.xpath("//button[contains(text(),'Aceptar todo')]");
    By byHoteles = By.xpath("//span[contains(text(),'Hoteles')]");
    By byInputBuscar = By.xpath("//input[@id=':R9oqnalbldq2mm:']");
    By byTipoExotico = By.xpath("//li[@id=':R9oqnalbldq2mm:-option-1']");
    By byLimpiarBusqueda = By.xpath("//*[@id=\"hub-csw-container\"]/div/div[4]/div/form/div/fieldset/div/div/div/button");
    By byFechaEntrada = By.xpath("//div[@aria-labelledby='2-2024']//button[text()='16']");
    By byFechaSalida = By.xpath("//div[@aria-labelledby='2-2024']//button[text()='18']");
    By byPersonas = By.xpath("//div[@class='d-1k5t2mm']//button[contains(@aria-label, 'Aumentar')]");
    By byPibes = By.xpath("/html/body/div[13]/div[3]/div/div/section/div/div[2]/div[2]/div/button");
    By byPibeEdad = By.xpath("/html/body/div[13]/div[3]/div/div/section/div/div[2]/div[2]/div/div/div/ul/li[8]");
    By byConfirmar = By.xpath("/html/body/div[13]/div[3]/footer/div/button");
    By byBuscarHotel = By.xpath("//*[@id=\"hub-csw-container\"]/div/div[4]/div/form/div/div[3]/div/button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Crear los métodos genericos de la page
    public void aceptarCookies(){
        if(esperarElementoWeb(byAceptarCookies).isDisplayed()){
            clic(esperarElementoWeb(byAceptarCookies));
        }
    }

    public void buscarHoteles(){
        clic(esperarElementoWeb(byHoteles));
        /*if(esperarElementoWeb(byLimpiarBusqueda).isDisplayed()){
            clic(esperarElementoWeb(byLimpiarBusqueda));
        }*/
        clic(esperarElementoWeb(byInputBuscar));
        clic(esperarElementoWeb(byTipoExotico));

        clic(esperarElementoWeb(byFechaEntrada));
        clic(esperarElementoWeb(byFechaSalida));
        //clic(esperarElementoWeb(bySeleccionFSal));

        for(int i=0;i<2;i++){
            clic(esperarElementoWeb(byPersonas));
        }
        //clic(esperarElementoWeb(byPibes));
        //clic(esperarElementoWeb(byPibeEdad));
        //clic(esperarElementoWeb(byConfirmar));d
        clic(esperarElementoWeb(byBuscarHotel));
    }
}
