package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.Set;

public class AlojamientoAlterPage extends BasePage {
    int numLista = 1;
    By ur = By.xpath("//a[contains(@class, 'openx-ui-tile-"+numLista+"') and substring(@class, string-length(@class) - string-length('openx-ui-tile-"+numLista+"') + 1) = 'openx-ui-tile-"+numLista+"']");
    By cards = By.xpath("//div[contains(@data-testid,'card-container')]");
    By compartir = By.xpath("//button[@id='menu-button--menu--:r0:']");

    By txtPrecioMin = By.xpath("//div[contains(@class,'PriceContainer')]//div[contains(text(),'610')]");

    By as = By.xpath("//*[@id=\"Pill-AllFiltersContainer\"]");
    By check = By.xpath("//ul[@id='lb_list_accomodation_type']//li[@id='exp_elem_accomodation_type_1']");
    public AlojamientoAlterPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarHotelAlternativo(){
        //clic(esperarElementoWeb(byHotelAlternativo));

        cargarSitio(buscarElementoWeb(ur).getAttribute("href"));
        esperarXsegundos(2000);
    }

    public void seleccionarCard(int i){
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

    public void filtrarDetalleCard(){
        clic(esperarElementoWeb(as));
        esperarXsegundos(1000);
        clic(esperarElementoWeb(check));
    }
}

