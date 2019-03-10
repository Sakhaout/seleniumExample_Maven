package com.crmpro.testCase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crmpro.baseClass.BasePage;
import com.crmpro.pages.*;
import com.crmpro.utilites.*;



@Listeners(CustomListener.class)
public class HelpPageTest extends BasePage {
	private LogInPage loginpage_obj;
	private HelpPage helppage_obj;
	private TestUtile testUtiles_obj;
	private static Logger log = Logger.getLogger(HelpPageTest.class);
	
	public HelpPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"userName","password"})
	public void setUp(String userName, String password) {
		initialition();
		loginpage_obj = new LogInPage();
		helppage_obj = new HelpPage();
		testUtiles_obj = new TestUtile();
		loginpage_obj.logInFunction(userName,password);
		driver.switchTo().frame("mainpanel");
	}
	
//	@Test
//	public void verifyHelpLink() {
//		helppage_obj.clickOnHelpLink();
//		testUtiles_obj.windowsHandle(2);
//		String actualUrl = driver.getCurrentUrl();
//		System.out.println("Current URL: "+actualUrl);
//		String expectedUrl = "https://support.cogmento.com/";
//		Assert.assertEquals(actualUrl, expectedUrl);
//	}
	@Test
	public void getLink() {
		helppage_obj.clickOnHelpLink();
		testUtiles_obj.windowsHandle(2);
		log.info("\tWindows handle opened second window.");
		helppage_obj.getAllLink();
		
	}
	
	@AfterMethod
	public void closeDown() {
		driver.quit();
		log.info("\tBrowser closed!!!");
	}

}
