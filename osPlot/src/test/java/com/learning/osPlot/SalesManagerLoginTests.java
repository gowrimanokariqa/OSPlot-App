package com.learning.osPlot;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;

public class SalesManagerLoginTests extends setUp
{
	ExtentReports extent;
	@BeforeSuite
	public void extentReport()
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/index.html");
		extent.attachReporter(spark);
	}
	
	@Test(priority=0)
	public void initialTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Next = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		WebElement Skip = driver.findElement(By.xpath("//android.view.View[@content-desc=\"skip\"]"));
		Next.click();
		Skip.click();
		ExtentTest launchTest = extent.createTest("Verify the app has launchable or not").assignAuthor("Gowri");
		launchTest.pass("App has been launched");
	}
	
	@Test(priority=1)
	public void validPhone() {
		WebElement phoneNo = driver.findElement(By.className("android.widget.EditText"));
		phoneNo.click();
		phoneNo.sendKeys("1234567891");
		driver.navigate().back();
		WebElement nextButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		nextButton.click();
		ExtentTest validLogin = extent.createTest("Verify Login function by entering the valid mobile number").assignAuthor("Gowri");
		validLogin.pass("Login Sucessfull");
	}
		
	@Test(priority=2)
	public void validateOtpWithValidCrendial()  {
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence sequence = new Sequence(finger, 1);
	    sequence.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), 123 ,885 ));
	    sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
	    sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    driver.perform(Collections.singletonList(sequence));
	    //send keys to the OTP
	    new Actions(driver).sendKeys("1234").perform();
		WebElement Submit = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Submit\"]"));
		Submit.click();
		ExtentTest validOtp = extent.createTest("Verify by entering the valid OTP").assignAuthor("Gowri");
		validOtp.pass("OTP Validated");	
	}
	
	@Test(priority=3)
	public void validateAddCustomer() {
		WebElement addCustomer = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[576,1368][688,1456]']"));
		addCustomer.click();
		ExtentTest validateAddCustomer = extent.createTest("Verify by clicking the Add Customer button").assignAuthor("Gowri");
		validateAddCustomer.pass("Add Customer button has been clicked");	
	}
	
	@Test(priority=4)
	public void validateChoosePlan() {
		WebElement choosePlan = driver.findElement(By.xpath("//android.view.View[@bounds='[30,438][676,650]']"));
		choosePlan.click();
		ExtentTest validateSelectPlan = extent.createTest("Verify by selecting the Plan").assignAuthor("Gowri");
		validateSelectPlan.pass("Plan has been selected");	
	}
	
	@Test(priority=5)
	public void createCustomer() {
		WebElement bookingFormNo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[1]"));
		bookingFormNo.click();
		bookingFormNo.sendKeys("012345");
		WebElement name = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[2]"));
		name.click();
		name.sendKeys("Gowri");
		driver.navigate().back();
		WebElement fatherName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[3]"));
		fatherName.click();
		fatherName.sendKeys("Ram");
		driver.navigate().back();
		WebElement gender = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Female\"]/android.widget.RadioButton"));
		gender.click();
		WebElement dob = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[4]"));
		dob.click();
		dob.sendKeys("10-04-1995");
		driver.navigate().back();
		
		//Scroll
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence sequence = new Sequence(finger, 1);
	    sequence.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), 330 ,1259 ));
	    sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
	    sequence.addAction(finger.createPointerMove(Duration.ofMillis(300),PointerInput.Origin.viewport(), 330 , 940 ));
	    sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    driver.perform(Collections.singletonList(sequence));
	    
	    WebElement maritalStatus = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Married\"]/android.widget.RadioButton"));
	    maritalStatus.click();
		WebElement occupation = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[5]"));
		occupation.click();
		occupation.sendKeys("Software test engineer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().back();
		WebElement next = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		next.click();
		
		WebElement email = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[1]"));
		email.click();
		email.sendKeys("manual@test.com");
		driver.navigate().back();
		WebElement contact = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[2]"));
		contact.click();
		contact.sendKeys("8888999912");
		driver.navigate().back();
		WebElement plotNo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[3]"));
		plotNo.click();
		plotNo.sendKeys("123");
		driver.navigate().back();
		WebElement street = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[4]"));
		street.click();
		street.sendKeys("Annai Indra nagar");
		driver.navigate().back();
		WebElement city = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[5]"));
		city.click();
		city.sendKeys("Coimbatore");
		driver.navigate().back();
		WebElement state = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[6]"));
		state.click();
		state.sendKeys("TamilNadu");
		driver.navigate().back();
		WebElement zip = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.widget.ScrollView/android.widget.EditText[7]"));
		zip.click();
		zip.sendKeys("641031");
		driver.navigate().back();
		WebElement next1 = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		next1.click();
		WebElement select = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Select\"]"));
		select.click();
		WebElement ID = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Aadhar\"]"));
		ID.click();
		WebElement idProofNo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.widget.ImageView/android.view.View/android.widget.EditText"));
		idProofNo.click();
		idProofNo.sendKeys("741225893698");
		driver.navigate().back();
		WebElement chooseFile = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Choose File\"]"));
		chooseFile.click();
	}
	
	
	@AfterSuite
	public void close() {
		extent.flush();	
	}

}
