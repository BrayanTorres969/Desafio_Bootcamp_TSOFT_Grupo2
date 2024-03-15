package proyecto.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {
    //Wrapper de selenium
    private WebDriver driver;
    private WebDriverWait espera;
    private JavascriptExecutor js;
    private Actions actions;

    private int tiempoCortoEspera = 1000;
    private int tiempoMedioEspera = 3000;
    private int tiempoLargoEspera = 5000;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(getDriver());
    }

    public int getTiempoCortoEspera() {
        return tiempoCortoEspera;
    }

    public int getTiempoMedioEspera() {
        return tiempoMedioEspera;
    }

    public int getTiempoLargoEspera() {
        return tiempoLargoEspera;
    }

    public WebDriverWait getEspera() {
        return espera;
    }

    public void setEspera(WebDriverWait espera) {
        this.espera = espera;
    }

    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //Métodos que invocan las librerias de selenium
    public WebElement buscarElementoWeb(By localizador) {
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador) {
        return driver.findElements(localizador);
    }

    public void clic(By localizador) {
        driver.findElement(localizador).click();
    }

    public void clic(WebElement elemento) {
        elemento.click();
    }

    public void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement esperarElementoWeb(By localizador) {
        espera = new WebDriverWait(this.driver, 30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void cargarSitio(String url) {
        driver.get(url);
    }

    public void cerrarBrowser() {
        driver.quit();
    }

    public void agregarTexto(By localizador, String texto) {
        driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto) {
        elemento.sendKeys(texto);
    }

    public void maximizarBrowser() {
        driver.manage().window().maximize();
    }

    public String obtenerTexto(WebElement elemento) {
        return elemento.getText();
    }

    public String obtenerTexto(By localizador) {
        return driver.findElement(localizador).getText();
    }

    public String obtenerAtributo(WebElement elemento, String atributo) {
        return elemento.getAttribute(atributo);
    }

    public void hacerScrollHasta(WebElement elemento) {
        js.executeScript("arguments[0].scrollIntoView();", elemento);
    }

    public void hacerScrollHastaPiePagina() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void hacerScrollTopPagina() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void volverInicioPagina() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void cambiarALaUltimaVentanaAbierta() {
        Set<String> ventanas = driver.getWindowHandles();
        //Cambio a la nueva ventana
        for (String ventana : ventanas) {
            driver.switchTo().window(ventana);
        }
    }

    public void buscarYClick(By localizadorClickeable, By tituloSeccion) {
        boolean found = false;
        while (!found) {
            try {
                clic(esperarElementoWeb(localizadorClickeable));
                found = true;
            } catch (NoSuchElementException | ElementClickInterceptedException e) {
                hacerScrollHasta(esperarElementoWeb(tituloSeccion));
            }
        }
        esperarXsegundos(getTiempoMedioEspera());
    }

    public void validarMensaje(String messageExpected, WebElement MessageActual) {
        Assertions.assertEquals(FixEncoding.corregirEncoding(messageExpected), obtenerTexto(MessageActual));
    }

    public void validarMensajeSinFixEncoding(String messageExpected, WebElement MessageActual) {
        Assertions.assertEquals(messageExpected, obtenerTexto(MessageActual));
    }

    public void agarrarArrastrarPuntero_RangoPrecios(By punteroMovil, By montoEvaluar, int indexMontoEvaluar, String monto, int direccion) {
        WebElement divPuntoMovilPrecios = esperarElementoWeb(punteroMovil);
        int initialX = divPuntoMovilPrecios.getLocation().getX();
        WebElement montoPrecio = buscarElementosWeb(montoEvaluar).get(indexMontoEvaluar);
        getActions().clickAndHold(divPuntoMovilPrecios).perform();
        do {
            getActions().moveByOffset(direccion, 0).perform();
            if (obtenerTexto(montoPrecio).contains(monto)) {
                break;
            }
            if (direccion == -1 && divPuntoMovilPrecios.getLocation().getX() >= initialX) {
                break;
            }
            if (direccion == 1 && divPuntoMovilPrecios.getLocation().getX() <= initialX) {
                break;
            }
        } while (true);
        getActions().release().perform();
    }

    public void hacerHoverEnElemento(By localizador) {
        Actions actions = new Actions(driver);
        actions.moveToElement(buscarElementoWeb(localizador)).perform();
    }

    public void hacerHoverEnElemento(WebElement elemento) {
        Actions actions = new Actions(driver);
        actions.moveToElement(elemento).perform();
    }

    public WebElement esperarElementoWeb(WebElement elemento) {
        espera = new WebDriverWait(this.driver, 30);
        return espera.until(ExpectedConditions.visibilityOf(elemento));
    }

    public WebElement esperarElementoWebMil(By localizador) {
        espera = new WebDriverWait(this.driver, 1000);
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void seleccionarCmbPorValue(WebElement elemento, String value) {
        Select selector = new Select(elemento);
        selector.selectByVisibleText(value);
    }
}
