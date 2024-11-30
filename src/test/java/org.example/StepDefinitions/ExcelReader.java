package org.example.StepDefinitions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static final String EXCEL_PATH = "D:\\Register_Data.xlsx";
    public static void main(String[] args) {
        // Test reading single cell
        System.out.println("Reading single cell (1,1): " + readCell(1, 1));

        // Test reading all data
        List<Map<String, String>> allData = readAllData();
        System.out.println("\nReading all data:");
        for (Map<String, String> row : allData) {
            System.out.println(row);
        }
    }
    public static String readCell(int rowNumber, int columnNumber) {
        try {
            File file = new File(EXCEL_PATH);
            if (!file.exists()) {
                System.out.println("Excel file not found at: " + EXCEL_PATH);
                return "";
            }

            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);  // Get first sheet

            Row row = sheet.getRow(rowNumber);
            if (row == null)
                return "";

            Cell cell = row.getCell(columnNumber);
            if (cell == null)
                return "";

            String value;
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    value = String.valueOf((int) cell.getNumericCellValue());
                    break;
                default:
                    value = "";
            }

            workbook.close();
            fis.close();
            return value;

        } catch (Exception e) {
            System.out.println("Error reading Excel: " + e.getMessage());
            return "";
        }
    }

    public static List<Map<String, String>> readAllData() {
        List<Map<String, String>> data = new ArrayList<>();
        try {
            File file = new File(EXCEL_PATH);
            if (!file.exists()) {
                System.out.println("Excel file not found at: " + EXCEL_PATH);
                return data;
            }

            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);  // Get first sheet
            Row headerRow = sheet.getRow(0);  // Get header row

            // Iterate through all rows (skip header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;

                Map<String, String> rowData = new HashMap<>();

                // Iterate through all cells in row
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell currentCell = currentRow.getCell(j);

                    String header = (headerCell != null) ? headerCell.getStringCellValue() : "Column" + j;
                    String value = "";

                    if (currentCell != null) {
                        switch (currentCell.getCellType()) {
                            case STRING:
                                value = currentCell.getStringCellValue();
                                break;
                            case NUMERIC:
                                value = String.valueOf((int) currentCell.getNumericCellValue());
                                break;
                            default:
                                value = "";
                        }
                    }

                    rowData.put(header, value);
                }

                data.add(rowData);
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            System.out.println("Error reading Excel: " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
}
