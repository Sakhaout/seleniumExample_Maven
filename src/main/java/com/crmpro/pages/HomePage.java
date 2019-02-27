package com.crmpro.pages;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.baseClass.BasePage;
import com.crmpro.utilites.Action;
import com.crmpro.utilites.CommonAction;
import com.crmpro.utilites.TestUtile;




public class HomePage extends BasePage{
	TestUtile testUtile_Obj = new TestUtile();
	Action action = new Action();
	CommonAction commonAction_obj = new CommonAction();
	
	By allList = By.tagName("li");
	
	@FindBy(xpath = "//td[contains(text(),'User: Hossain Sakhaout')]")
	private WebElement userLebel;
	
	
	
	@FindBy(xpath = "//div[@id='navMenu']//a[@title='Mail Accounts'][contains(text(),'Mail Accounts')]")
	private WebElement mailAccount_link;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath = "//a[contains(text(),'Messages')]")
	private WebElement message_link;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	private WebElement newContact;
	
	@FindBy(xpath = "//ul[@class='mlddm']//li[4]//ul[1]//li[2]//a[1]")
	private WebElement combinedFrom;
	

	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void getTable(){
		try {
			String before_xpath = "//*[@id=\"homebox_CALDAY\"]/table/tbody/tr[";
			String after_path = "]/td[1]";
			for(int i=1; i<=19;i++) {
				String date = driver.findElement(By.xpath(before_xpath+i+after_path)).getText();
				System.out.println("Get Data: "+date);

			}
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		
	}
	
	
	
		
	public void clickOnContactsLink() throws IOException {
		action.actionMouseHover(contactsLink);
		combinedFrom.click();

	}
	
	
	
	public void allLink(){
		commonAction_obj.check_Link_connection(allList);
				
	}
	
	public void logout() {
		logout.click();
	}
	
	
	
	

}
