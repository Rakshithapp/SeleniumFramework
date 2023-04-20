package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method is used to fetch data from excel
 * @param sheetName
 * @param rowName
 * @param cellName
 * @author Rakshitha 
 *
 */
public class Excel_utility {
	
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet Sheet = book.getSheet(sheetName);
		Row Row = Sheet.getRow(rowNum);
		Cell cell = Row.getCell(cellNum);
		String Value = cell.getStringCellValue();
		return Value;	
	}
	
	public String getExcelDataformatter(String sheetName,int rowNum,int cellNum) throws Throwable
	
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		DataFormatter format= new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
		
	}
}
