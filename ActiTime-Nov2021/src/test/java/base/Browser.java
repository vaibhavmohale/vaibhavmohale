package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
	}   
      
    public static WebDriver launchMicrosoftEdgeBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Vaibhav\\Documents\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        return driver;

    }
             
   
}


