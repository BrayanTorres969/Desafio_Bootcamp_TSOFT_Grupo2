package proyecto.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    //Atributos
    private static Properties prop;

    //métodos
    public static String obtenerProperty(String key) {
        prop = new Properties();

        String rutaFile = System.getProperty("user.dir") + "\\src\\test\\resources\\properties.properties";

        try {
            InputStream input = new FileInputStream(rutaFile);

            prop.load(input);

        } catch (Exception ex) {
            System.out.println("Error al instanciar fichero properties... :/");
            System.out.println("Detalle error: " + ex.getMessage());
        }

        return prop.getProperty(key);
    }

}
