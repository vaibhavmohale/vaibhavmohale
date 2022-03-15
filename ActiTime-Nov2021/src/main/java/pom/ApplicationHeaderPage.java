package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {
	
	@FindBy (xpath = "//div[text()='Time-Track']") // change xpath
	private WebElement timeTrack ;
	
	@FindBy (xpath = "//a[@class='content tasks']")  
	private WebElement tasks ;
	
	@FindBy (xpath = "//a[@class='content reports']")
	private WebElement reports ;
	
	@FindBy (xpath = "//a[@class='content users']")
	private WebElement users ;
	
	@FindBy (xpath = "//div[text()='Work Schedule']") // change xpath
	private WebElement workSchedule ;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logout ;
	
 
	
	public ApplicationHeaderPage(WebDriver driver)  // driver = new ChromeDriver()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void openTimeTrackPage() {
		timeTrack.click();
	}
	
	public void openTasksPage() {
		tasks.click();
	}
	
	public void openReportsPage() {
		reports.click();
	}
	
	public void openUsersPage() {
		users.click();
	}
	
	public void openWorkSchedulePage() {
		workSchedule.click();
	}
	 
	public void clickOnLogout() {
		logout.click();
	}
}
