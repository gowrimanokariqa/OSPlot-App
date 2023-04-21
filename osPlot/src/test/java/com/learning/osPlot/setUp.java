package com.learning.osPlot;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;

public class setUp {
public AppiumDriver driver;
	
	@BeforeTest
	public void start() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("udid", "7T49VGSC9LB6ZTVG");
		capabilities.setCapability("deviceName", "OPPO A16e");
		capabilities.setCapability("appPackage", "com.wlt.apposplot");
		capabilities.setCapability("appActivity", "com.wlt.apposplot.MainActivity");
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		
		URL url= new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver(url,capabilities);

}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
