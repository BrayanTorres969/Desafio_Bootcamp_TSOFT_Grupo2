package proyecto.utils;

import java.nio.charset.StandardCharsets;

public class FixEncoding {
    public static String corregirEncoding(String textoIncorrecto){
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
