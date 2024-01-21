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

public class OnlineMailAppTest {
	
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

		

		WebElement allowPermissionButton = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
		allowPermissionButton.click();

		
		WebElement continueButton = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Continue\"]"));

		while(continueButton.isDisplayed()) {
			continueButton.click();
		}

		WebElement homePageTitle = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Latest issue\"]"));
        Assert.assertTrue(homePageTitle.isDisplayed());
		
 }
 
   @Test
    public void scrollTillRecentIssues() throws MalformedURLException, InvalidMidiDataException, InterruptedException{
		
		
		    
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

		               
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);

		               
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

		               
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		try{
			WebElement recentIssues = driver.findElement(By.xpath("//android.widget.TextView[@text='Recent issues']"));
			while(!recentIssues.isDisplayed()) {
				driver.perform(List.of(scroll));
			}
			Assert.assertTrue(recentIssues.isDisplayed());
		}catch(Exception e) {
			System.out.println("Recent issues is not displayed");
		}
		
		
	}
	
	@Test
	public void scrollRightToSeeMore() {
		
		
		int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

		               
        int endX = (int) (driver.manage().window().getSize().getHeight() * 0.2);

		               
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

		               
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endX));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		try{
			WebElement seeMore = driver.findElement(By.xpath("//android.widget.TextView[@text=\"See more\"]"));

			while(!seeMore.isDisplayed()) {
				driver.perform(List.of(scroll));
			}
			Assert.assertTrue(seeMore.isDisplayed());
		}catch(Exception e) {
			System.out.println("See More");
		}

	}

	@Test
	public void tapOnArchiveTabAndDownload() {
		
		WebElement archiveTab = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Tap me to open the archive\"]/android.view.ViewGroup/android.view.ViewGroup"));
		archiveTab.click();
		WebElement downloadArchiveElement = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup"));
		downloadArchiveElement.click();
	}

	@Test
	public void signintopaywall(){

		WebElement siginPage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Welcome to Mail+ Editions\"]"));

		WebElement paywallElement = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"));
		paywallElement.click();
		siginPage.isDisplayed();
		WebElement emailElement = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Email\"]"));
		emailElement.sendKeys("email");
		WebElement passwordElement = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]"));
		passwordElement.sendKeys("password");
		paywallElement.click();

		Assert.assertTrue(siginPage.isDisplayed()==false);


		

	}

	@Test
	public void waitAndConfirmDownloadIsCompleted() {
		
		WebElement archiveTab = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Tap me to open the archive\"]/android.view.ViewGroup/android.view.ViewGroup"));
		archiveTab.click();
		WebElement downloadArchiveElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Downloads\"]"));
		downloadArchiveElement.click();
		List <WebElement> downloadElements = driver.findElements(By.xpath("android.widget.ImageView"));
		Assert.assertTrue(downloadElements.size() > 0);
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
