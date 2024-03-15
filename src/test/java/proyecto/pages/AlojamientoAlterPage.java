package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

import java.util.List;
import java.util.Set;

public class AlojamientoAlterPage extends BasePage {
    int numLista = 1;
    By ur = By.xpath("//a[contains(@class, 'openx-ui-tile-" + numLista + "') and substring(@class, string-length(@class) - string-length('openx-ui-tile-" + numLista + "') + 1) = 'openx-ui-tile-" + numLista + "']");
    By cards = By.xpath("//div[contains(@data-testid,'card-container')]");
    By compartir = By.xpath("//button[@id='menu-button--menu--:r0:']");
    By botonFiltros = By.xpath("//div[@id='Pill-AllFiltersContainer']");
    By precioMin = By.xpath("//div[@data-testid='slider-bullet-left']");
    By precioMax = By.xpath("//div[@data-testid='slider-bullet-right']");
    By liResort = By.xpath("//li[@id='exp_elem_accomodation_type_2']");
    By estrellasContainer = By.xpath("//div[@id='StarsContainer']");
    By li4Estrellas = By.xpath("//li[@id='exp_elem_hotel_stars_4']");
    By mealContainer = By.xpath("//div[@id='MealContainer']");
    By ulMeals = By.xpath("//div[@id='MealContainer']//ul/li");
    By ratingContainer = By.xpath("//div[@id='RatingContainer']");
    By liExcelente = By.xpath("//div[@id='RatingContainer']//li[@id='exp_elem_rating_excellent']");
    By faciliContainer = By.xpath("//div[@id='FacilitiesContainer']");
    By facilPiscina = By.xpath("//li[@id='exp_elem_general_accomodation_facilities_4']");
    By facilWifi = By.xpath("//li[@id='exp_elem_general_accomodation_facilities_0']");
    By facilFit = By.xpath("//li[@id='exp_elem_general_accomodation_facilities_13']");
    By acomodaContainer = By.xpath("//div[@id='AccommodationChainsContainer']");
    By acomodaInput = By.xpath("//div[@id='AccommodationChainsContainer']//input[@id='accomodation_chain']");
    By sugeEmergente = By.xpath("//li[@id='exp_elem_accomodation_chain_CHAIN_MARRIOTT']");
    By acomodaCaracContainer = By.xpath("//div[@id='AccommodationThemesContainer']");
    By caracPlaya = By.xpath("//li[@id='exp_elem_accomodation_theme_beachhotel']");
    By caracResort = By.xpath("//li[@id='exp_elem_accomodation_theme_resorthotel']");
    By btnAplicar = By.xpath("//div[contains(@class,'DialogFooter')]//div[contains(text(),'Aplicar')]");

    By bySeccionProxEscapada = By.xpath(FixEncoding.corregirEncoding("//h3[contains(text(),'¿Cuál será tu próxima escapada?')]"));
    By byCardEscapadasAndorra = By.xpath("/html/body/div[2]/div[6]/div/div[2]/div/div/div[3]/div/div/div[2]/div/a/div/figure/img[2]");
    By byCardResultadosEscapadasAndorra = By.xpath("//div[@data-testid='card-container']");
    By byTituloAlojamRegimen = By.xpath(FixEncoding.corregirEncoding("//h2[contains(text(),'Eligir alojamiento y régimen')]"));
    By byBtnModificarAlojRegimen = By.xpath("//button[contains(text(),'Modificar')]");
    By navMejorVal = By.xpath("//div[contains(@class,'list-container')]//div[contains(text(),'Mejor valorados')]");
    By listaCards = By.xpath("//a[contains(@class,'openx-ui-tile-')]");
    By esconderMapa = By.xpath("//div[@id='view-mode']//button");
    /// //button[contains(text(),'Modificar')]
    public AlojamientoAlterPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarHotelAlternativo() {
        //clic(esperarElementoWeb(byHotelAlternativo));

        cargarSitio(buscarElementoWeb(ur).getAttribute("href"));
    }

    public void seleccionarCard(int i) {
        esperarXsegundos(5000);
        clic(esperarElementoWeb(buscarElementosWeb(cards).get(i)));
    }

    public void seleccionarMeal() {
        esperarXsegundos(2000);
        clic(esperarElementoWeb(buscarElementosWeb(ulMeals).get(2)));
    }

    public void cambioVentana(WebDriver driver) {

        esperarXsegundos(2000);
        Set<String> ventanas = driver.getWindowHandles();

        for (String ventana : ventanas) {
            driver.switchTo().window(ventana);
        }
        clic(esperarElementoWeb(compartir));
    }

    public void filtrarDetalleCard(WebDriver driver) {
        esperarXsegundos(4000);
        clic(esperarElementoWeb(botonFiltros));
        esperarXsegundos(1000);
        WebElement botonMin = esperarElementoWebMil(precioMin);
        WebElement botonMax = esperarElementoWebMil(precioMax);

        Actions actions = new Actions(driver);

        actions.clickAndHold(botonMin).moveByOffset(50, 0).release().perform();
        esperarXsegundos(1000);
        actions.clickAndHold(botonMax).moveByOffset(-50, 0).release().perform();

        esperarXsegundos(2000);
        clic(esperarElementoWeb(liResort));
        hacerScrollHasta(esperarElementoWeb(estrellasContainer));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(li4Estrellas));
        hacerScrollHasta(esperarElementoWeb(mealContainer));
        esperarXsegundos(2000);
        seleccionarMeal();
        hacerScrollHasta(esperarElementoWeb(ratingContainer));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(liExcelente));

        hacerScrollHasta(esperarElementoWeb(faciliContainer));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(facilPiscina));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(facilWifi));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(facilFit));

        hacerScrollHasta(esperarElementoWeb(acomodaContainer));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(acomodaInput));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(sugeEmergente));

        hacerScrollHasta(esperarElementoWeb(acomodaCaracContainer));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(caracPlaya));
        esperarXsegundos(2000);
        clic(esperarElementoWeb(caracResort));

        esperarXsegundos(2000);
        clic(esperarElementoWeb(btnAplicar));

        seleccionarCard(0);

    }

    public void hacerScrollHastaProxEscapada() {
        hacerScrollHasta(buscarElementoWeb(bySeccionProxEscapada));
    }

    public void seleccionarBtnModificarAlojRegimen() {
        hacerScrollHasta(buscarElementoWeb(byTituloAlojamRegimen));
        esperarXsegundos(2000);
        clic(byBtnModificarAlojRegimen);
    }

    public void seleccionarEscapadasAndorra() {
        hacerHoverEnElemento(byCardEscapadasAndorra);
        esperarXsegundos(2000);
        clic(byCardEscapadasAndorra);
    }

    public List<WebElement> obtenerResultadosEscapesAndorra() {
        return buscarElementosWeb(byCardResultadosEscapadasAndorra);
    }

    public void seleccionarPrimerResultadoEscapeAndorra() {
        WebElement resultado = obtenerResultadosEscapesAndorra().get(0);
        hacerHoverEnElemento(resultado);
        clic(resultado);
    }

    public void compartirInfo(){
        clic(esperarElementoWeb(buscarElementosWeb(listaCards).get(0)));
        try {
            Thread.sleep(2000);
            clic(esperarElementoWeb(esconderMapa));
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println(e);
        }
        clic(esperarElementoWeb(navMejorVal));
    }
}

