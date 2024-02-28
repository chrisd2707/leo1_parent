package Om.leo1_parent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileBrowserTest{


	public class Amazon {

		public AndroidDriver driver;
		DesiredCapabilities c = new DesiredCapabilities();

		//	@BeforeClass

		//	public void LeoMobileChrome3() throws MalformedURLException {
		//public AndroidDriver driver;


		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), c);
		//AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),c);
		//public void init() throws MalformedURLException{
		//	DesiredCapabilities c = new DesiredCapabilities();
		//	c.setCapability("appium:deviceName": "OnePlus 6T");
		//	c.setCapability("platformName": "Android");
		//	c.setCapability("appium:automationName": "UIAutomator2");
		//	c.setCapability("appium:BROWSER_NAME": "Chrome");
		//	c.setCapability("appium:VERSION": "113.0.5672");

		//}

		//DesiredCapabilities c = new DesiredCapabilities();
		//  SetCapabilities below	
		//c.setCapability("appium:deviceName", "OnePlus 6T");
		//c.setCapability("appium:appId", "com.leo1_card");
		//c.setCapability("platformName", "Android");
		//c.setCapability("appium:automationName", "UIAutomator2");
		//c.setCapability("unicodeKeyboard","false");
		//c.setCapability("resetKeyboard","false");
		//c.setCapability("appium:app", "C:\\Users\\User\\Desktop\\Programs\\app-release.apk");


		//@Test 
		//public void Leo1MobileChrome() {


		//}

		@Test(invocationCount=1)


		public void LeoMobileChrome2() throws MalformedURLException {
			//public AndroidDriver driver;
			DesiredCapabilities c = new DesiredCapabilities();
			c.setCapability("appium:deviceName", "OnePlus 6T");
			c.setCapability("platformName", "Android");
			c.setCapability("appium:automationName", "UIAutomator2");
			//	c.setCapability(			
			c.setCapability("appium:browserName", "Chrome");
			c.setCapability("chromedriverExecutable", "C:\\Users\\User\\eclipse-workspace\\leo1_parent\\drivers\\chromedriver.exe");
			//	c.setCapability("appium:VERSION", "113.0.5672");
			System.out.println("Hello Mobile Browser");
			UiAutomator2Options options=new UiAutomator2Options();
			options.setDeviceName("OnePlus 6T");

			//	options.setApp("C:\\Users\\User\\Desktop\\Programs\\app-release.apk");
			//	options.setApp("C:\\Users\\User\\eclipse-workspace\\leo1_parent\\src\\test\\java\\resources\\app-release-preprod.apk");
			options.setChromedriverExecutable("C:\\Users\\User\\Documents\\Temp\\chromedriver");
			//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), c);
			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),c);
			driver.get("https://www.amazon.com");
			int i;
			for (i=0;i<3;i++) {
				//driver.get("https://www.amazon.com");
				driver.get("http://lending.leo1.in");
				driver.findElement(By.id("mobileNumber")).sendKeys("8919480241");
				driver.findElement(By.id("name")).sendKeys("Ravinder Sollet");
				driver.findElement(By.id("loanAmount")).sendKeys("21000");
			}
		}

	//		@Test
	//		public void LeoMobileChrome3(driver) {
	//			driver=this.driver;
	//			driver.get("https://www.cnbc.com");
	
	//	}
			//driver.get()
			//driver.close();
	}
}
