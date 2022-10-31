package examplePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public static String readcell(String filePath, String fileName, String sheetName, int RowNum, int ColNum) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = null;
		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			wb = new XSSFWorkbook(inputStream);

		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			wb = new HSSFWorkbook(inputStream);
		}
		// Read sheet inside the workbook by its name
		Sheet st = wb.getSheet(sheetName);
	
		Cell Cell;
		XSSFRow Row;
	
		

			  Cell = st.getRow(RowNum).getCell(ColNum);

			  String CellData = Cell.getStringCellValue();

			  return CellData;

			
	}
			 }
		
		
		/*
		 * // Find number of rows in excel file int rowCount = st.getLastRowNum() -
		 * st.getFirstRowNum(); // Create a loop over all the rows of excel file to read
		 * it for (int i = 0; i < rowCount + 1; i++) { Row row = st.getRow(i); // Create
		 * a loop to print cell values in a row for (int j = 0; j <
		 * row.getLastCellNum(); j++) { // Print Excel data in console
		 * System.out.print(row.getCell(j).getStringCellValue() + "|| "); }
		 * System.out.println(); }
		 */
	

