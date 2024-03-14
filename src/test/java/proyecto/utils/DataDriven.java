package proyecto.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static ArrayList<String> prepararData(String nombreCP) { //CP001
        ArrayList<String> data = new ArrayList<>();

        //Instanciar un objeto de tipo file
        FileInputStream file = null;

        try{
            file = new FileInputStream(PropertiesManager.obtenerProperty("rutaExcel"));
        }catch (FileNotFoundException ex){
            System.out.println("Fallo al apuntar el archivo...");
            System.out.println("Detalle error: "+ex.getMessage());
        }

        //Crear un objeto de tipo excel en base al archivo
        XSSFWorkbook excel = null;

        try{
            excel = new XSSFWorkbook(file);
        }catch(IOException ex){
            System.out.println("Fallo el crear excel con data...");
            System.out.println("Detalle del error: "+ex.getMessage());
        }

        int sheets = excel.getNumberOfSheets();

        for(int i=0;i<sheets;i++){

            if(excel.getSheetName(i).equalsIgnoreCase(PropertiesManager.obtenerProperty("hojaExcel"))){
                //Encontre la hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                Row fila = filas.next();

                Iterator<Cell> celdas = fila.cellIterator();


                int k = 0;
                int columna = 0;
                while(celdas.hasNext()){
                    Cell celdaSeleccionada = celdas.next();

                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(PropertiesManager.obtenerProperty("tituloCPs"))){
                        //Encontre la columna con los nombres de los casos de prueba
                        columna = k;
                    }
                    k++;
                }

                while(filas.hasNext()){
                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCP)){
                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()){

                            Cell c = cv.next();

                            if(c.getCellType() == CellType.STRING){
                                //System.out.println(c.getStringCellValue());
                                data.add(c.getStringCellValue());
                            }else if(c.getCellType() == CellType.NUMERIC){
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }

            }
        }

        return data;

    }

}
