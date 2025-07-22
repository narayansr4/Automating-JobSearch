package jobSearch.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static void writeIntoExcel(String filePath, String sheetName, Object[][] obj){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        int rows = obj.length;
        int cols = obj[0].length;

        for (int r = 0; r < rows; r++){
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < cols; c++){
                XSSFCell cell = row.createCell(c);
                Object value = obj[r][c];
                if (value instanceof String){
                    cell.setCellValue((String) value);
                }
                if (value instanceof Integer){
                    cell.setCellValue((Integer) value);
                }
            }
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Workbook updated");

    }
}
