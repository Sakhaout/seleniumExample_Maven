package com.crmpro.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crmpro.baseClass.BasePage;
import com.crmpro.pages.*;
import com.crmpro.utilites.*;



@Listeners(CustomListener.class)
public class HomePageTest extends BasePage {
	
	private HomePage HomePage_obj;
	private LogInPage login_obj;


	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialition();
		HomePage_obj = new HomePage();
		login_obj = new LogInPage();
		login_obj.logInFunction("sakhaout","Sakhaout8");
		driver.switchTo().frame("mainpanel");
		
	}
	

	@Test
	public void printAllLink() throws InterruptedException{
		Thread.sleep(5000);
		HomePage_obj.allLink();
	}
	
	
	@Test
	public void varifyTable() throws IOException {
		HomePage_obj.getTable();
	
	}
	
	@Test
	public void varifyContactLink() throws IOException {
		HomePage_obj.clickOnContactsLink();
	}
	

	
	@Test
	public void varifyLogout() {
		HomePage_obj.logout();
		String ActualURL = driver.getCurrentUrl();
		String expectedURL = "https://classic.crmpro.com/index.html";
		Assert.assertEquals(ActualURL, expectedURL);
	}
	
	
	@AfterMethod
	public void closeDown() {
		driver.close();
	}
	

}
