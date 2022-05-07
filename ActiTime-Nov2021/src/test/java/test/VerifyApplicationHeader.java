package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import utils.Utility;

public class VerifyApplicationHeader extends Browser {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private ApplicationHeaderPage applicationHeaderPage;
    SoftAssert soft;
    
    static ExtentTest test;
    static ExtentHtmlReporter reporter;
    
    String testID;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browserName) {

		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtentReport"+File.separator+"extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.out.println("launchBrowser");
		if(browserName.equals("Chrome"))
		{	
		    driver =  launchChromeBrowser();
		}
         
	    if(browserName.equals("Edge"))
	    {
		    driver =  launchMicrosoftEdgeBrowser();
		}
	    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void createObjectOfPOMClasses() {
		loginPage = new LoginPage(driver);
		applicationHeaderPage = new ApplicationHeaderPage(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws IOException {	
		 System.out.println("loginToApplication");
		 driver.get("http://localhost/login.do");
		 
		 String user = Utility.getDataFromExcel("abc",1,0);
		 String password = Utility.getDataFromExcel("abc",1,1);
		 
		 driver.manage().window().maximize();
		 loginPage.sendUserName(user);
		 loginPage.sendPasswordName(password);
		 loginPage.clickOnKeepMeLogin();
		 loginPage.clickOnLogin();
    }
	
	@Test
	public void verifyTaskPage() {
		 testID="101";
		 soft = new SoftAssert();
		 System.out.println("verifyTaskPage");
		 applicationHeaderPage.openTasksPage();
		 String url = driver.getCurrentUrl();
		 String title = driver.getTitle();
		 Assert.assertEquals(url,"http://localhost/tasks/otasklist.do");
		 soft.assertEquals(title,"actiTIME - Open Tasks" );
		 soft.assertAll();
	 }
	@Test
	public void verifyUsersPage() {
		 testID="102";
		 soft = new SoftAssert();
		 System.out.println("verifyUsersPage");
		 applicationHeaderPage.openUsersPage();
		 String url = driver.getCurrentUrl();
		 String title = driver.getTitle();
	     Assert.assertEquals(url,"http://localhost/administration/userlist.do","user page url wrong"); // hard assert
		 soft.assertEquals(title,"actiTIME - User List" ); // soft assert
		 soft.assertAll();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		Utility.screenshot(driver,testID);
		}
		
		System.out.println("logoutFromApplication");
		applicationHeaderPage.clickOnLogout();
   
	}
	
	@AfterClass
	public void clearPOMObject() {
		applicationHeaderPage = null;
		loginPage = null;
	
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("closeBrowser");
		driver.quit();
		driver=null;
		System.gc(); // Delete all object without refrences.
	
	}
	
	
}
