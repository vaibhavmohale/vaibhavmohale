package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class General {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}


	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method");
	}

	@Test
	public void testA() {
		System.out.println("test A");
	}

	@Test 
	public void testB() {
		System.out.println("test B");
	}
	
	@Test (enabled = false)
	public void testC() {
		System.out.println("test C");
	}

	@Test (enabled = false)
	public void testD() {
		System.out.println("test D");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after Class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println(" after Suite");
	}


	
}
