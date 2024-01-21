import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import org.checkerframework.checker.units.qual.s;
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
import io.appium.java_client.touch.TapOptions;

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
		WebElement archiveElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Tap me to open the archive\"]/android.view.ViewGroup/android.view.ViewGroup"));;   
        archiveElement.click();

        WebElement downloadSections = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Downloaded\"]"));
        downloadSections.click();

        WebElement downloadedArticle = driver.findElement(By.xpath("//android.widget.ImageView"));
        downloadedArticle.click();

        WebElement sectionsView = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Tap me to open the sections menu\"]/android.view.ViewGroup/android.view.ViewGroup"));
        Assert.assertTrue(sectionsView.isDisplayed());

		
		
	}
	
	@Test
	public void NavigateToSelectedPageInArticle() {
        WebElement newsView = driver.findElement(By.xpath("//android.widget.TextView[@text=\"News\"]"));
        newsView.click();
		WebElement squeakCleanNewsArticle = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"));
        squeakCleanNewsArticle.click();
		
		

	}

	@Test
	public void goToImageGallery() {
		WebElement viewImagesIcon = driver.findElement((By.xpath("//android.widget.ImageView[@content-desc=\"View images\"]")));
        viewImagesIcon.click();
		
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
