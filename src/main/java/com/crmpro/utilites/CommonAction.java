package com.crmpro.utilites;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crmpro.baseClass.BasePage;


public class CommonAction extends BasePage {
	
public CommonAction() {
	super();
}

public void check_Link_connection(By element) {
	//Store all link in a set.
	try {
		List<WebElement>linkList = driver.findElements(element);
		System.out.println("Total link=====> "+linkList.size());
		
		//Store all Active link in a list.
		List<WebElement>activeLink = new ArrayList<WebElement>();
		//Iterate on all link and store onle active link in activeLink list.
		for(int i=0; i<linkList.size(); i++) {
			if(linkList.get(i).getAttribute("href")!=null &&(! linkList.get(i).getAttribute("href").contains("javascript"))) {
				activeLink.add(linkList.get(i));
			}
		}
		System.out.println("Total Active link=====> "+activeLink.size());
		
		
		//Check the connetion of all active link.
		//Iterate on the activeLink and chect their connection.
		for(int i=0;i<activeLink.size(); i++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLink.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLink.get(i).getAttribute("href") +" =====> "+responseMessage);
		}
	
	}catch(MalformedURLException ex) {
		ex.getStackTrace();
	}catch(IOException ioEx) {
		ioEx.getStackTrace();
}
}

	
	

}
