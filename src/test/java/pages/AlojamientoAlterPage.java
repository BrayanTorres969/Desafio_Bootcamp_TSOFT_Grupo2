package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class AlojamientoAlterPage extends BasePage {
    By byHotelAlternativo = By.xpath("//div[@class='openx-ui-card-details-desk']//div[@class='sc-djVXDX fFfrWf openx-ui-card-details-left openx-ui-card-details-left-expand']");
    By ur = By.xpath("//div[@class='sc-CCtys izSLPp']//a[@class='sc-ggqIjW YqstO openx-ui-card openx-ui-card-appending openx-ui-tile-2']");

    public AlojamientoAlterPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarHotelAlternativo(){
        //clic(esperarElementoWeb(byHotelAlternativo));

        cargarSitio(buscarElementoWeb(ur).getAttribute("href"));
    }


}
