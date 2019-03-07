package com.crmpro.testCase;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crmpro.baseClass.BasePage;
import com.crmpro.pages.LogInPage;
import com.crmpro.utilites.*;



@Listeners(CustomListener.class)
public class LogInPageTest extends BasePage{
	LogInPage loginPage_Obj;
	TestUtile testUtile_Obj;
	private Logger loger = Logger.getLogger(LogInPageTest.class);
;	
	public LogInPageTest() {
		super();	
	}


	@BeforeMethod
	public void setUp() {
		initialition();
		loginPage_Obj = new LogInPage();
	
	}
	
	@Parameters({"userName","password"})
	@Test
	public void LogInTest(String userName, String password){
		loger.info("Entering username and password");
		loginPage_Obj.logInFunction(userName, password);
		String title =driver.getTitle();
		Assert.assertEquals(title , "CRMPRO");
	}
	
	
	@AfterMethod
	public void closeDown() {
		driver.close();
	}

}
