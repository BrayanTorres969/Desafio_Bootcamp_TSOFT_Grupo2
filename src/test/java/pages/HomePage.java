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
    By byFechaEntrada = By.xpath("//button[@aria-label='Fecha de entrada']");
    By bySeleccionFEn = By.xpath("/html/body/div[13]/div[3]/div/section/div/div[2]/div/div[2]/div/ul/li[1]/div/div[2]/button[6]");
    By byFechaSalida = By.xpath("//*[@id=\"hub-csw-container\"]/div/div[4]/div/form/div/div[1]/div/div/fieldset/div[3]/button");
    By bySeleccionFSal = By.xpath("/html/body/div[13]/div[3]/div/section/div/div[2]/div/div[2]/div/ul/li[1]/div/div[2]/button[9]");
    By byPersonas = By.xpath("//*[@id=\"hub-csw-container\"]/div/div[4]/div/form/div/div[2]/div/div/div/button");
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

        //clic(esperarElementoWeb(byFechaEntrada));
        //clic(esperarElementoWeb(bySeleccionFEn));
        //clic(esperarElementoWeb(byFechaSalida));
        //clic(esperarElementoWeb(bySeleccionFSal));

        //clic(esperarElementoWeb(byPersonas));
        //clic(esperarElementoWeb(byPibes));
        //clic(esperarElementoWeb(byPibeEdad));
        //clic(esperarElementoWeb(byConfirmar));d
        clic(esperarElementoWeb(byBuscarHotel));



    }
}
