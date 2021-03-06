package com.crmpro.utilites;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crmpro.baseClass.BasePage;


public class CommonAction extends BasePage {
	
	private static Logger log  = Logger.getLogger(CommonAction.class);

	public CommonAction() {
		super();
	}

	public void check_Link_connection(By element) {
		//Store all link in a set.
		try {
			List<WebElement>linkList = driver.findElements(element);
			log.info("\tGet total size link.");
			System.out.println("Total link=====> "+linkList.size());

			//Store all Active link in a list.
			List<WebElement>activeLink = new ArrayList<WebElement>();
			//Iterate on all link and store onle active link in activeLink list.
			for(int i=0; i<linkList.size(); i++) {
				if(linkList.get(i).getAttribute("href")!=null &&(! linkList.get(i).getAttribute("href").contains("javascript"))) {
					activeLink.add(linkList.get(i));
				}
			}
			log.info("\tGet total size of active link.");
			System.out.println("Total Active link=====> "+activeLink.size());


			//Check the connetion of all active link.
			//Iterate on the activeLink and chect their connection.
			for(int i=0;i<activeLink.size(); i++) {
				HttpURLConnection connection = (HttpURLConnection) new URL(activeLink.get(i).getAttribute("href")).openConnection();
				connection.connect();
				String responseMessage = connection.getResponseMessage();
				connection.disconnect();
				log.info("\tPrint all active link.");
				System.out.println(activeLink.get(i).getAttribute("href") +" =====> "+responseMessage);
			}

		}catch(MalformedURLException ex) {
			log.error(ex.getStackTrace() +"\tFailed to get link.");
		}catch(IOException ioEx) {
			log.error(ioEx.getStackTrace() +"\tFailed to get link.");
		}
	}

	public static String getCurrentTime() {
		DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return time.format(now);
	}




}
