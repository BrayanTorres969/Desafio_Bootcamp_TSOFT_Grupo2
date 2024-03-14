package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BasePage;

import java.util.Set;

public class AlojamientoAlterPage extends BasePage {
    int numLista = 1;
    By ur = By.xpath("//a[contains(@class, 'openx-ui-tile-"+numLista+"') and substring(@class, string-length(@class) - string-length('openx-ui-tile-"+numLista+"') + 1) = 'openx-ui-tile-"+numLista+"']");
    By cards = By.xpath("//div[contains(@data-testid,'card-container')]");
    By compartir = By.xpath("//button[@id='menu-button--menu--:r0:']");
    By botonFiltros = By.xpath("//div[@id='Pill-AllFiltersContainer']");
    By precioMin = By.xpath("//div[@data-testid='slider-bullet-left']");
    By precioMax = By.xpath("//div[@data-testid='slider-bullet-right']");
    public AlojamientoAlterPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarHotelAlternativo(){
        //clic(esperarElementoWeb(byHotelAlternativo));

        cargarSitio(buscarElementoWeb(ur).getAttribute("href"));
    }

    public void seleccionarCard(int i){
        esperarXsegundos(2000);
        clic(esperarElementoWeb(buscarElementosWeb(cards).get(i)));
    }

    public void cambioVentana(WebDriver driver){

        esperarXsegundos(2000);
        Set<String> ventanas = driver.getWindowHandles();

        for(String ventana : ventanas){
            driver.switchTo().window(ventana);
        }
        clic(esperarElementoWeb(compartir));
    }

    public void filtrarDetalleCard(WebDriver driver){
        esperarXsegundos(4000);
        clic(esperarElementoWeb(botonFiltros));
        esperarXsegundos(1000);
        WebElement botonMin = esperarElementoWebM(precioMin);
        WebElement botonMax = esperarElementoWebM(precioMax);

        Actions actions = new Actions(driver);

        actions.clickAndHold(botonMin).moveByOffset(50, 0).release().perform();
        esperarXsegundos(1000);
        actions.clickAndHold(botonMax).moveByOffset(-50, 0).release().perform();

    }
}

