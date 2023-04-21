package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StoryboardPage {
	 AndroidDriver driver;
	 StoryboardPage SBPage = PageFactory.initElements(driver, StoryboardPage.class);
	 
	 @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Next\"]")
	 private AndroidBy Next;
	 
	 @AndroidFindBy(xpath="//android.view.View[@content-desc=\"skip\"]")
	 private AndroidBy Skip;

}
