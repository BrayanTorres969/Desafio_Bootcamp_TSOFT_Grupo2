import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CPsRumbo {
    WebDriver driver;
    WebDriverWait espera;

    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void preCondiciones(){
        driver = new ChromeDriver();
        espera = new WebDriverWait(driver,10);
        driver.get("https://rumbo.es/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    void posCondiciones() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void CP001_Creacion_Cta_Rumbo() throws InterruptedException{
        WebElement cerrarPopUp = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Aceptar todo')]")));

        if(cerrarPopUp.isDisplayed()){
            cerrarPopUp.click();
        }

        Thread.sleep(1000);

        WebElement btnHoteles = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Hoteles')]")));
        btnHoteles.click();

        WebElement inputBuscar = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=':R9oqnalbldq2mm:']")));
        inputBuscar.click();

        WebElement tipoExotico = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id=':R9oqnalbldq2mm:-option-1']")));
        tipoExotico.click();

        WebElement limpiarBusqueda = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Limpiar']")));

            limpiarBusqueda.click();


        WebElement fechaEntrada = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Fecha de entrada']")));
        fechaEntrada.click();
        Thread.sleep(500);

        WebElement FESeleccion = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'16')]")));
        FESeleccion.click();


        /*WebElement fechaSalida = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Fecha de salida']")));
        fechaSalida.click();
        Thread.sleep(500);

        WebElement FSSelecion = espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'18')]")));
        FSSelecion.click();*/

    }

}
