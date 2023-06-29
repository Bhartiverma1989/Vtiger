package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFronExcel( String sheet_name, int row_num, int cell_num) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstantUtil.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheet_name);
		Row row = sheet.getRow(row_num);
		Cell cell = row.getCell(cell_num);
		String data=cell.getStringCellValue();
		//System.out.println("data enter from "+sheet_name +" sheet, "+row_num+ " row number and "+cell_num+" cell number");
		return data;
			
	}

}
