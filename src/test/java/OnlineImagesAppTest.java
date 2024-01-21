import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class OnlineImagesAppTest {
    	
	AppiumDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("devicName", "NoDevice");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "14");
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("app", "/Users/sainadimpalli/Downloads/8.2.2.20 (744802).apk");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("fullReset", false);
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("newCommandTimeout", 120);
	    desiredCapabilities.setCapability("autoGrantPermissions", true);
		desiredCapabilities.setCapability("autoAcceptAlerts", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver(remoteUrl, desiredCapabilities);

		

		
		
 }
 
   @Test
    public void goToDownloadsAndSelectArticle() throws MalformedURLException, InvalidMidiDataException, InterruptedException{
		
		
		
	}
	
	@Test
	public void NavigateToSelectedPageInArticle() {
		
		
		

	}

	@Test
	public void goToImageGallery() {
		
		
	}

	@Test
	public void openCameraInFullScreenAndNavigate(){

		

		

	}

	@Test
	public void closeAfterLastImageAndComeToArticleBox() {
		
		
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
