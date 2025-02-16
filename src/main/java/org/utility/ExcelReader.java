package org.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static XSSFSheet sheet;
	
	
	public static String[][] reader(String filepath)  {
		

		
		
		try {
			
			FileInputStream fi = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			 sheet = wb.getSheet("Sheet1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 XSSFRow row = sheet.getRow(0);
		 
		 int rowNum = sheet.getPhysicalNumberOfRows();
		 
	 int celln = row.getLastCellNum();
		
		
		String[][] data= new String[rowNum-1][celln];
		
	//	List<String[]> data = new ArrayList();
		
		for(int i=1; i<=data.length;i++) {

				data[i-1][0] = cell(i,0);
				data[i-1][1] = cell(i,1);
	 
				
			}
		return data ;
			

		
		}
		
		
	
	
	
	public static String cell(int row, int column) {
		
		String value;
		
		XSSFRow row2 = sheet.getRow(row);
		
		 XSSFCell cell = row2.getCell(column);
		
		int cellType = cell.getCellType();
		
		if(cellType==1) {
			
			value = cell.getStringCellValue();
			
		} else if(DateUtil.isCellDateFormatted(cell)) {
			
			
			Date dateCellValue = cell.getDateCellValue();
			
			SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			
			         value=d.format(dateCellValue);
		
		}else  {
		
		
			double num = cell.getNumericCellValue();
			
			long l = (long)num;
			
			value=String.valueOf(l);
			
		
	}
		return value;
	

	}
	
	
	
}

