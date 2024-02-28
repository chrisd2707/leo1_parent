package Om.leo1_parent;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class base {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		System.out.println("This is for logging only");
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4723).withTimeout(Duration.ofSeconds(50)).build();
				
		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("OnePlus 6T");
	//	options.setApp("C:\\Users\\User\\Desktop\\Programs\\app-release.apk");
		options.setApp("C:\\Users\\User\\eclipse-workspace\\leo1_parent\\src\\test\\java\\resources\\app-release-preprod.apk");
		options.setChromedriverExecutable("C:\\Users\\User\\Documents\\Temp\\chromedriver.exe");
		
		
		driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}



	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
		Thread.sleep(1000);
		service.stop();
		System.out.println("Teardown");
	}
}