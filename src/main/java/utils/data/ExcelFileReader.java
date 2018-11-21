package utils.data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ThreadLocalRandom;

public class ExcelFileReader {

    public static String getValueByColumnName(String columnName) {
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(new File("src/test/resources/EmailMessages.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(0);
            int colNumber = -1;
            int rowsCount = sheet.getLastRowNum();
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(columnName)) {
                    colNumber = i;
                }
            }
            value = getCellValue(sheet.getRow(ThreadLocalRandom.current().nextInt(1, rowsCount + 1)), colNumber);

        } catch (Exception e) {

        }
        return value;
    }

    private static String getCellValue(Row row, int cellNum) {
        Cell cell = row.getCell(cellNum);
        return cell != null ? cell.getStringCellValue() : "";
    }

}
