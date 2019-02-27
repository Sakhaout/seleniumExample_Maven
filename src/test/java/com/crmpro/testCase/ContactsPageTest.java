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
public class ContactsPageTest extends BasePage {
	private LogInPage loginPage_obj;
	private Contacts contactPage_obj;

	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialition();
		loginPage_obj = new LogInPage();
		contactPage_obj = new Contacts();
		loginPage_obj.logInFunction("sakhaout", "Sakhaout8");
		driver.switchTo().frame("mainpanel");
	}
	
	
	
//	@Test
//	public void CreateNewContacts() throws InterruptedException, IOException {
//		contactPage_obj.createNewContact();
//		System.out.println("Created contacts are done");
//	}
	
//	@Test
//	public void varfiedNewContactsPresent() {
//		String actual_linkName = contactPage_obj.getText_NewContactLink();
//		String expeted_linkName = "New Contact";
//		Assert.assertEquals(actual_linkName, expeted_linkName);
//	}
	
//	@Test
//	public void varfied_CombineFormLink_IsPresent() throws IOException {
//		contactPage_obj.getTooltip_CombineFormLink();
//		//Assert.assertTrue(flag, "The Link is not present.");
//	}
//	
//	@Test
//	public void varfied_FullSearchForm_IsPresent() throws IOException {
//		String actual_linkName = contactPage_obj.getText_FullSearchFormLink();
//		String expeted_linkName = "Full Search Form";
//		Assert.assertEquals(actual_linkName, expeted_linkName);
//	}
	
	@AfterMethod
	public void closeDown() {
		driver.close();
	}

}
