package proyecto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import proyecto.utils.BasePage;
import proyecto.utils.FixEncoding;

public class TrenesPage extends BasePage {

    By byBtnSoloIda = By.xpath("//button[text()='Solo ida']");
    By byTxtOrigen = By.xpath("//div/input[@placeholder='Origen']");
    By byTxtDestino = By.xpath("//input[@aria-label='Destino']");
    By byFechaIda = By.xpath("//button[@aria-label='Fecha de ida']");
    By byCalendarioIda = By.xpath("//button[text()='18']");
    By byAumentarPasajero = By.xpath(FixEncoding.corregirEncoding("//button[@aria-label='Aumentar el número de adultos']"));
    By byTren = By.xpath("//button[@aria-label='Buscar']");


    public TrenesPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarOpcionSoloIdaTren(){
        clic(byBtnSoloIda);
    }

    public void seleccionarLugarDeOrigen(){
        clic(byTxtOrigen);
        agregarTexto(byTxtOrigen,"Alicante");
    }

    public void seleccionarLugarDeDestino(){
        clic(byTxtDestino);
        esperarXsegundos(1000);
        agregarTexto(byTxtDestino,"Madrid");
    }

    public void seleccionarFechaIdaTren(){
        clic(byFechaIda);
    }

    public void seleccionarFechaEnCalendarioTren(){
        clic(byCalendarioIda);
    }

    public void aumentarNumeroDePasajero(){
        clic(byAumentarPasajero);
    }

    public void buscarTrenIda(){
        clic(byTren);
    }



}
