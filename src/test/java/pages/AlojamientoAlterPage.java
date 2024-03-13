package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class AlojamientoAlterPage extends BasePage {
    int numLista = 1;
    By ur = By.xpath("//a[contains(@class, 'openx-ui-tile-"+numLista+"') and substring(@class, string-length(@class) - string-length('openx-ui-tile-"+numLista+"') + 1) = 'openx-ui-tile-"+numLista+"']");
    By cards = By.xpath("//div[contains(@data-testid,'card-container')]");

    public AlojamientoAlterPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarHotelAlternativo(){
        //clic(esperarElementoWeb(byHotelAlternativo));

        cargarSitio(buscarElementoWeb(ur).getAttribute("href"));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(buscarElementosWeb(cards).get(0)));
        esperarXsegundos(2000);
    }


}
