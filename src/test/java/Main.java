import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String args[]){

        String rutaWebDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.out.println(rutaWebDriver);
        System.setProperty("webdriver.chrome.driver",rutaWebDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

    }

}
