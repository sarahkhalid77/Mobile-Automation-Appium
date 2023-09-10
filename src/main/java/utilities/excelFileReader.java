package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class excelFileReader {

    private static XSSFSheet sheet;
    static configFileReader fileReader;

    public excelFileReader() {


    }

   public static void readExcel() {
        fileReader = new configFileReader();
        if (sheet != null) {
            return;
        }
        File src = new File(configFileReader.getExcelPath());
        try {
            FileInputStream file = new FileInputStream(src);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
            System.out.println("You got an" + e);
        }
    }

    public static String getCellValue (int row, int column) {
        if(sheet == null) {
            return "";
        }
        XSSFCell cell = sheet.getRow(row).getCell(column);
        return cell.getStringCellValue();
    }

}

