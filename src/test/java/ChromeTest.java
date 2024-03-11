//import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Verify
        Assertions.assertEquals("Hands-On Selenium WebDriver with Java",title);
        //assertThat(title).contains("Selenium WebDriver");
    }

    @Test
    void NavegadorActions(){
        driver.get("https://www.google.com");
        System.out.println("El titulo del sitio es: "+driver.getTitle());
        System.out.println("La url del sitio es: "+driver.getCurrentUrl());
        System.out.println("Page Source: "+driver.getPageSource());
    }

    @Test
    void NavigateActions(){
        driver.get("https://www.google.com");
        System.out.println("El titulo del sitio es: "+driver.getTitle());
        System.out.println("La url del sitio es: "+driver.getCurrentUrl());
        driver.navigate().to("https://mvnrepository.com/");
        System.out.println("El titulo del sitio es: "+driver.getTitle());
        System.out.println("La url del sitio es: "+driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().refresh();
    }

}