package com.crmpro.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.baseClass.BasePage;
import com.crmpro.utilites.Action;
import com.crmpro.utilites.TestUtile;



public class Contacts extends BasePage {
	
	private Action action_obj = new Action();
	private TestUtile testUtile_obj = new TestUtile();
	
	@FindBy(xpath = "//ul[@class='mlddm']//li[4]//ul[1]//li[2]//a[1]")
	private WebElement combinedFrom;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	private WebElement newContact;
	
	@FindBy(xpath = "//a[contains(text(),'Combined Form')]")
	private WebElement sublink_CombinedForm;
	
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/ul/li[3]")
	private WebElement sublink_FullSearchLink;
	
//	@FindBy (xpath = "//a[contains(text(),'New Contact')]")
//	private WebElement new_Contact;
	
	@FindBy(xpath = "//select[@name='title']")
	private WebElement title_box;
	
	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement first_name;
	
	@FindBy(xpath = "//input[@name='middle_initial']")
	private WebElement middle_name;
	
	@FindBy(xpath = "//input[@name='surname']")
	private WebElement last_name;
	
	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	private WebElement save_button;
	
	
	public Contacts() {
		super();
		PageFactory.initElements(driver, this);
	}
	

	

	
	
	public void clickOn_newContactsLink() throws IOException, InterruptedException {
		action_obj.actionMouseHover(contactLink);
		newContact.click();
	}
	
	 //This method will create set of new contacts
	public void createNewContact() throws IOException, InterruptedException {
		clickOn_newContactsLink();
		ArrayList<String> firstName = testUtile_obj.readExcelfile(0);
		ArrayList<String>middleName = testUtile_obj.readExcelfile(1);
		ArrayList<String>lastName = testUtile_obj.readExcelfile(2);
		
		for(int i=0;i<firstName.size();i++) {
			first_name.sendKeys(firstName.get(i));
			middle_name.sendKeys(middleName.get(i));
			last_name.sendKeys(lastName.get(i));
			save_button.click();
			Thread.sleep(4000);
		}
	}
	

	
	public void getTooltip_CombineFormLink() throws IOException {
		String str = action_obj.getTooltipText(contactLink, sublink_CombinedForm);
		System.out.println("ToolTip: "+str);
	}	
	
	public String getText_FullSearchFormLink() throws IOException {
		action_obj.actionMouseHover(contactLink);
		action_obj.actionMouseHover(sublink_FullSearchLink);
		String linkName = sublink_FullSearchLink.getText();
		return linkName;
	}
	

}
