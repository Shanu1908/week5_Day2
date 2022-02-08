package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowReadExcel 
{
	public static String[][] readIncidentExcel(String filename) throws IOException 
	{
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.getSheet("AssignIncident");
		int totalRowsCount = ws.getPhysicalNumberOfRows();
		System.out.println(totalRowsCount);
		int rowsCount = ws.getLastRowNum();
		System.out.println(rowsCount);
		int cellCount = ws.getLastRowNum();
		System.out.println(cellCount);
		String[][] data = new String [rowsCount][cellCount];
		
		for(int i = 1; i<=rowsCount; i++) 
		{
			XSSFRow row = (XSSFRow) ws.getRow(i);
			for(int j = 0;j<cellCount;j++) 
			{
				XSSFCell cell = row.getCell(j);
				String cellValue = cell.getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		wb.close();
		return data;
	}
}