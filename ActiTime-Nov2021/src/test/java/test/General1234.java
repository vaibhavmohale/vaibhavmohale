package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class General1234 {
	
 

	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test 1234");
	}


	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class 1234");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method 1234");
	}

	@Test (enabled = false)
	public void testA() {
		System.out.println("test A 1234");
	}

	@Test (enabled = false)
	public void testB() throws InterruptedException {
		System.out.println("test B 1234");
	}
	
	@Test 
	public void testC() {
		System.out.println("test C 1234");
	}

	@Test
	public void testD() {
		System.out.println("test D 1234");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method 1234");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after Class 1234");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test 1234");
	}
	
	 

	

}
