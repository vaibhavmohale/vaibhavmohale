package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	  public static void screenshot(WebDriver driver, String testID) throws IOException {
		
		//Test101 03-03-2022 20 01 12
		                
		Date date = new Date();
		
		String dateTime = date.toString().replace(":","_").replace(" ","_")+".jpg";
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    File dest = new File("G:\\New folder\\Test"+testID+dateTime+".jpg");  
	    
	    FileHandler.copy(source, dest);
	}    
	  
	   public static String getDataFromExcel(String sheetName, int row, int cell) throws  IOException {
	    	String data; 
	    	String path = "C:\\Users\\Vaibhav\\Desktop\\Testing.xlsx" ;
	 		
	 		FileInputStream file = new FileInputStream(path);
	 		
	 		Sheet sheet= WorkbookFactory.create(file).getSheet(sheetName);
	 		
	 		try
	 		{
	 			data = sheet.getRow(row).getCell(cell).getStringCellValue();
	 		}
	 		catch(IllegalStateException ref)
	 		{
	 			double value = sheet.getRow(row).getCell(cell).getNumericCellValue();
	 			if(value%1==0.0)
	 			{
	 				long l = (long)value;
	 				data = String.valueOf(l);
	 			}
	 			else
	 			{
	 				long l = (long)(value/1);
	 				float k = (float)(value%1);
	 				String decimal = Float.toString(k);
	 				decimal = decimal.substring(1);
	 				data = Long.toString(l)+decimal;
	 			}
	 		}
	 		return data;	 
	    	 
	}
	    

}
