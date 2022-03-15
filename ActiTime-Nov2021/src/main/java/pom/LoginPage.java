 package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement password ;
	
	@FindBy (xpath = "//input[@name='remember']")
	private WebElement keepMeLoginCheckbox ;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement login ;
	
	private WebDriver driver ; // global Declaration do it in every pom class 
	private WebDriverWait wait ; // global declaration for explict wait 
	
	public LoginPage(WebDriver driver)  // driver = new ChromeDriver()
	{
		PageFactory.initElements(driver,this);
		this.driver = driver ;               // Inisilize the driver 
		wait = new WebDriverWait(driver,20); // inisilize common wait for webelement
	}
	
	public void sendUserName(String user) {
		wait.until(ExpectedConditions.visibilityOf(userName)); // 20 seconds
		userName.sendKeys(user);
	}
	
	public void sendPasswordName(String pass) {
		wait.until(ExpectedConditions.visibilityOf(password));  // 20 seconds
		password.sendKeys(pass);
	}

	public void clickOnKeepMeLogin() {
		wait = new WebDriverWait(driver,30);  // Use of global driver  // 30 seconds explict wait seperately applied
		wait.until(ExpectedConditions.visibilityOf(keepMeLoginCheckbox));
		if( !(keepMeLoginCheckbox.isSelected()) ) // Not operator toggle the result. false--->True
		{
			keepMeLoginCheckbox.click();  // or u can write this line no need to use if block direct click
		}
		else
		{
			System.out.println("Keep Me Login Checkbox already selected");
		}
	}

	public void clickOnLogin() {
		login.click();
	}

}
