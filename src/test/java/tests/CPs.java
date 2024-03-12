package tests;

import pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CPs {
    HomePage home;
    WebDriver driver;

    @BeforeAll
    public static void start(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void preCondioniones(){
        driver = new ChromeDriver();
        home = new HomePage(driver);
        home.cargarSitio("https://rumbo.es/");
        home.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){
        //home.cerrarBrowser();
    }

    @Test
    public void CP001_Creacion_Cta_Spotify(){
        home.aceptarCookies();
        home.buscarHoteles();
    }


}
