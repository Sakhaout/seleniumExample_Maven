package com.crmpro.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmpro.utilites.TestUtile;


public class BasePage {
	public static WebDriver driver; 
	public static Properties properties_obj;
	
	public BasePage() {
		try {
			String properties_path = "C:\\Users\\Hossain Sakhaout\\Desktop\\MavenProject\\com.crmpro\\src\\main\\java\\com\\crmpro\\configur\\config.properties";
			properties_obj = new Properties();
			FileInputStream file_input = new FileInputStream(properties_path);
			properties_obj.load(file_input);
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	public static void initialition() {
		String browser = properties_obj.getProperty("browser"); //Get properties from properties file.
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();  //Windows will maximize.
		driver.manage().deleteAllCookies();		//Delete all cookies.
		driver.manage().timeouts().pageLoadTimeout(TestUtile.Page_Load_TimeOut, TimeUnit.SECONDS); //Wait untile page are fully loeaded.
		driver.manage().timeouts().implicitlyWait(TestUtile.Implicitly_Wait, TimeUnit.SECONDS); //Wait until element is found, but wait until a time.
		driver.get(properties_obj.getProperty("url")); //Lunch the url.
		
		
	}


}
