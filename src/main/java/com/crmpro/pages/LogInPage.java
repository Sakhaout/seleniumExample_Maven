package com.crmpro.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.baseClass.BasePage;


public class LogInPage extends BasePage {
	
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement logIn_button;
	
	public LogInPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	

	
	public HomePage logInFunction(String userID, String pass){
		try {
			userName.sendKeys(userID);
			password.sendKeys(pass);
			logIn_button.click();
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		
		return new HomePage();
	}

}
