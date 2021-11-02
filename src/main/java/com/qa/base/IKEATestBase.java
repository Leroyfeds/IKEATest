package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class IKEATestBase {

	public static AppiumDriver<MobileElement> driver; 
	public static Properties prop;
	
	public static void openikeaapp() throws MalformedURLException {
		  
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  
		  capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
		  capabilities.setCapability("udid",prop.getProperty("udid"));
		  capabilities.setCapability("platformName", prop.getProperty("platformName"));
		  capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
		  capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
		  capabilities.setCapability("appActivity",prop.getProperty("appActivity"));
		  capabilities.setCapability("autoGrantPermissions", true);
		  //capabilities.setCapability("autoGrantPermissions", true);
		  //capabilities.setCapability("fullReset", true);
		  //capabilities.setCapability("noReset", true);
		  
		
		  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:" + "4723" + "/wd/hub"), capabilities);
	}


	public IKEATestBase() {

		
		//To Load the config file in order to access config properties
		try { 
			prop = new Properties(); 
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
					"/src/main/java/com/qa/config/config.properties"); prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}catch (IOException e) { 
			e.printStackTrace(); }

	}

}
