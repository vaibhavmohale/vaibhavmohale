package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
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
	  
	   public static String getDataFromExcel(String sheet, int row, int cell) throws  IOException {
	    	 
	    	String path = "C:\\Users\\Vaibhav\\Desktop\\Testing.xlsx" ;
	 		
	 		FileInputStream file = new FileInputStream(path);
	 		
	 		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	 		
	 		return data;	 
	    	 
	}
	    

}
