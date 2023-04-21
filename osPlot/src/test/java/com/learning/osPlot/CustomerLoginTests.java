package com.learning.osPlot;

import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.By;
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

public class CustomerLoginTests extends setUp
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
	public void noPhone() {
		WebElement phoneNo = driver.findElement(By.className("android.widget.EditText"));
		phoneNo.click();
		driver.navigate().back();
		WebElement nextButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		nextButton.click();
		Boolean errorAppear = driver.findElement(By.xpath("//*[@bounds='[0,1366][720,1456]']")).isEnabled();
		System.out.println("Is toast message appear " + errorAppear);
		ExtentTest invalidLogin = extent.createTest("Verify Login function without entering the mobile number").assignAuthor("Gowri");
		invalidLogin.pass("System shows the error");
	}
	
	@Test(priority=2)
	public void validPhone() {
		WebElement phoneNo = driver.findElement(By.className("android.widget.EditText"));
		phoneNo.click();
		phoneNo.sendKeys("1234567890");
		driver.navigate().back();
		WebElement nextButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]"));
		nextButton.click();
		ExtentTest validLogin = extent.createTest("Verify Login function by entering the valid mobile number").assignAuthor("Gowri");
		validLogin.pass("Login Sucessfull");
	}
	
	@Test(priority=3)
	public void validateOtpWithEmptyCrendial()  {
	    
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence sequence = new Sequence(finger, 0);
	    sequence.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), 123 ,885 ));
	    sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
	    sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
	    driver.perform(Collections.singletonList(sequence));
		driver.navigate().back();
	    WebElement Submit = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Submit\"]"));
		Submit.click();
		
		Boolean toastAppear = driver.findElement(By.xpath("//android.view.View[@bounds='[0,1366][720,1456]']")).isEnabled();
		System.out.println("Is System show error in toast " + toastAppear);
		
		ExtentTest emptyOtp = extent.createTest("Verify by entering the valid OTP").assignAuthor("Gowri");
		emptyOtp.pass("System shows the error message");
	}
	
	@Test(priority=4)
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

	
	/*@Test
	public void resendOtp()
	{
		WebElement newOtp = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP\"]"));
		newOtp.click();
		ExtentTest validateNewOtp = extent.createTest("Verify by clicking the Resend OTP link").assignAuthor("Gowri");
		validateNewOtp.pass("Resend OTP link has been clicked");
	}*/
	
	@Test(priority=5)
	public void validatePlanDetails()
	{
		WebElement Plan = driver.findElement(By.xpath("//android.view.View[@bounds='[30,652][676,864]']"));
		Plan.click();
		ExtentTest validatePlan = extent.createTest("Verify by clicking on the plan detail").assignAuthor("Gowri");
		validatePlan.pass("User clicked the Plan");
	}
	
	@Test(priority=6)
	public void validatePay() {
		WebElement Pay = driver.findElement(By.xpath("//android.view.View[@bounds='[30,728][676,940]']"));
		Pay.click();
		ExtentTest validatePay = extent.createTest("Verify by clicking on the pay button").assignAuthor("Gowri");
		validatePay.pass("User clicked the Pay button");
	}
	
	@Test(priority=7)
	public void validateCompletedTab() {
		 PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		 Sequence sequence = new Sequence(finger, 1);
		 sequence.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), 487 ,670 ));
		 sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
		 sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		 driver.perform(Collections.singletonList(sequence));
		 ExtentTest validateCompletedTab = extent.createTest("Verify by clicking on the Completed Tab").assignAuthor("Gowri");
		 validateCompletedTab.pass("User clicked on the Completed Tab");
	}
	
	@Test(priority=8)
	public void validateReceipt() {
		WebElement receipt = driver.findElement(By.xpath("//android.widget.ImageView[@bounds='[30,728][676,940]']"));
		receipt.click();
		ExtentTest validateReceipt = extent.createTest("Verify by clicking on the receipt button").assignAuthor("Gowri");
		validateReceipt.pass("User clicked the Receipt button");
		validateReceipt.fail("Test got failed");
	}
	@Test(priority=9)
	public void validateMorePlans() {
		driver.navigate().back();
		WebElement morePlans = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"More Plans\"]"));
		morePlans.click();
		ExtentTest validateMorePlan = extent.createTest("Verify by clicking on the More plans button").assignAuthor("Gowri");
		validateMorePlan.pass("User clicked the Receipt button");
		
	}
	
	
	@AfterSuite
	public void close() {
		extent.flush();	
	}
}
	
	


