package Om.leo1_parent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ChromeMobileTest{


	public class Amazon {

		public AndroidDriver driver;
		public WebDriver driver1;
		//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		DesiredCapabilities c = new DesiredCapabilities();


		public int web_realtime_otp() throws ClassNotFoundException, SQLException {

			String connURL="jdbc:postgresql://dev-nbfc-db.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/STAGING1";
			//String connURL="jdbc:postgresql://nbfcprod.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/NBFC";
			String Username="debiprasad";
			//String pw="Dnj40dThdTY92fR";
			String pw="Dhsn@8884#hdnDll";
			int otp = 0;
			Class.forName("org.postgresql.Driver");
			// Open a connection to Prod database
			Connection con=DriverManager.getConnection(connURL,Username,pw);
			Statement st=con.createStatement();
			// Creating and executing a query
			String v="SELECT"+" otp,"+"\"mobileNo\"" +" FROM public.myprofile_otpverification WHERE "
					+ "\"mobileNo\"" +"=7506553677";
			ResultSet rs=st.executeQuery(v);		
			while (rs.next()){
				otp = rs.getInt(1);
				String mobileNo=rs.getString(2);
				System.out.println("The OTP is"+" "+otp+" "+"and mobile number is"+" "+mobileNo);
			}
			// Returning the value of OTP for further operations
			return otp;
		}

		// Random Alphabet Generator
		public char randomChar() {
			Random r = new Random();
			return (char)(r.nextInt(26) + 'a');
		}

		@Test(invocationCount=1)

		public void LeoMobileChrome2() throws MalformedURLException, ClassNotFoundException, SQLException, InterruptedException {
			//public AndroidDriver driver;

			web_realtime_otp();
			DesiredCapabilities c = new DesiredCapabilities();
			c.setCapability("appium:deviceName", "OnePlus 6T");
			c.setCapability("platformName", "Android");
			c.setCapability("appium:automationName", "UIAutomator2");		
			c.setCapability("appium:browserName", "Chrome");
	//		c.setCapability("noReset",true);
			c.setCapability("adbExecTimeout", "900000");
	//		c.setCapability("chromedriverExecutable", "C:\\Users\\User\\eclipse-workspace\\leo1_parent\\drivers\\chromedriver_win32_v113.0.5672.63.exe");
			c.setCapability("chromedriverExecutable", "C:\\Users\\User\\eclipse-workspace\\leo1_parent\\drivers\\chromedriver.exe");
		//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\leo1_parent\\drivers\\chromedriver_win32_v113.0.5672.63.exe");

			UiAutomator2Options options=new UiAutomator2Options();
			options.setDeviceName("OnePlus 6T");
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			// The line below is for Fluent Wait - DO NOT COMMENT IT
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
			//Thread.sleep(10000);
			//WebDriver driver1 = new ChromeDriver();

			AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),c);
			//driver.get("https://www.amazon.com");
			
			// SEVEN LINES BELOW TEST FILE UPLOAD USING APPIUM
			
	//		File file = new File("storage/emulated/0/Leo1/tmp/Agreement-Purchase-MBRS-project.pdf");		
	//		driver.get("https://the-internet.herokuapp.com/upload");
	//		Thread.sleep(10000);
	//		System.out.println(file.getAbsolutePath());
	//		driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
	//		Thread.sleep(10000);
	//		driver.findElement(By.id("file-submit")).click();
			
			// RESUME HERE
			
			Thread.sleep(1000);
			driver.get("http://uat1.leo1.in");

			//web_realtime_otp();

			String homepage = driver.getTitle();
			System.out.println(homepage);
			Thread.sleep(2000);

			//	driver.findElement(By.xpath("//*[@class='tham-inner bg-white']")).click();
			//	driver.findElement(By.xpath("//*[@class='tham-inner bg-white']")).click();
			//	driver.findElement(By.xpath("//*[@name='Login']")).click();
			char c2 = randomChar();
			char c3= randomChar();// Generating random alphabet
			//driver.pullFile();
			//byte[] folder = driver.pullFolder("/storage/emulated/0/Download");
			
			driver.findElement(By.xpath("//*[@id='name']")).sendKeys("dineshtest"+c3+"DTYSTDFG"+c2);
			driver.findElement(By.xpath("//*[@id='mobile']")).sendKeys("7506553677");
			driver.findElement(By.xpath("//*[@id='mobile']")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@id='redirectButton']")).click();
			int v=web_realtime_otp();
			System.out.println("The OTP is: "+v);
			System.out.println(String.valueOf(v));
			Thread.sleep(5000);
			//		driver.findElement(By.xpath("//input[contains(@aria-label,'Digit 1')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@aria-label,'Digit 1')]")).sendKeys(String.valueOf(v));
			driver.findElement(By.xpath("//button[@id='redirectButton']")).sendKeys(Keys.ENTER); // Enter OTP
			Thread.sleep(3000);
			//		driver.findElement(By.xpath("//a/button[contains(.,'+ Create new application')]")).click();
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/div/a/button")).click();

			System.out.println("Something has passed");
			// CODE BELOW IS FOR CURRENT APPLICATIONS PAGE
			Thread.sleep(5000);
		
			//		driver.findElement(By.id("rc_select_4")).sendKeys(); // this is to hide keyboard
			//		driver.findElement(By.id("rc_select_4")).click();
			driver.findElement(By.name("studentName")).sendKeys(c2+"dadtotest"+c3); //*[@name='studentName']);
			Thread.sleep(1000);
			driver.findElement(By.name("folioRollNumber")).sendKeys("2101");
			//		driver.findElement(By.id("rc_select_4")).sendKeys(); // this is to hide keyboard
			//		driver.findElement(By.id("rc_select_4")).click();
			driver.findElement(By.name("studentDOB")).click();
			Thread.sleep(3000);
			// LINES BELOW ARE ATTEMPT TO SCROLL UP


			// Entering Calendar picker below
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",258,"y",389)); // Click on Year
			Thread.sleep(5000);
			// LINES BELOW ARE ATTEMPT TO SCROLL UP
			//((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			//		"x",258,"y",389,"duration",500));
			// VIMP THE TWO LINES BELOW WERE WORKING BEFORE THEY WERE TAKEN OUT 
			//((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			//		"startX", 311, "startY", 626, "endX", 311, "endY",1434, "speed",5000)); // Calendar scroll down
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX", 311, "startY", 626, "endX", 311, "endY",1900, "speed",5200)); // Calendar scroll down
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",550,"y",719)); // Select appropriate year
			// LINES BELOW ARE ATTEMPT TO SCROLL UP WITH A DIFFERENT TECHNIQUE
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//	js.executeScript("window.scrollBy(0,-350)", "");
			// TWO LINES BELOW WORK
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",788,"y",1614));// Click on Set
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@type='search']")).click(); // Student Gender
			// Actions on Student Gender dropdown
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",219,"y",1822)); // Select Female Student Option

			//select.selectByIndex(1); // Select Female Student
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='rc_select_1']")); // Institute name field
			driver.findElement(By.xpath("//input[@id='rc_select_1']")).sendKeys("WHITEHAT JR"); // Dropdown selection
			driver.findElement(By.xpath("//input[@id='rc_select_1']")).sendKeys(Keys.TAB); // Tab into next field
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='rc_select_3']")).click(); // Course Name field
			//driver.findElement(By.xpath("//input[@id='rc_select_3']")).sendKeys(Keys.))
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='rc_select_3']")).sendKeys("LAPTOP PLUS 1-4(48CREDITS) RI"); // Dropdown selection
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@id='rc_select_3']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@id='rc_select_4']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//div[@class='mt-5']//input[@type='checkbox']")).sendKeys(Keys.TAB);
			driver.findElement(By.name("loanamount")).sendKeys(Keys.TAB);
	//		driver.findElement(By.xpath("//*[@id='productDiv']/div[1]/div/label/span[1]/input")).sendKeys(Keys.ENTER); // to uncheck the box
			driver.findElement(By.xpath("//*[@id='productDiv']/div[1]/div/label/span[1]/input")).sendKeys(Keys.SPACE);
			//driver.findElement(By.xpath("//*[@id='productDiv']/div[1]/div/label/span[1]/input")).sendKeys(Keys.TAB);
			// Tab into next field
			Thread.sleep(500);
			//	js.executeScript("window.scrollBy(0,350)", ""); // Scroll to Proceed
			//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"1995\"));"));

			// LINES BELOW NEED TO BE DELETED OR COMMENTED OUT
			//driver.findElement(By.name("folioRollNumber")).sendKeys(Keys.TAB); // Tabbing into Calendar picker
			//driver.findElement(By.name("studentDOB")).sendKeys("26/07/1974");
			//driver.findElement(By.name("studentDOB")).sendKeys(Keys.CLEAR);
			Thread.sleep(500);
			
			// All actions is to double click on 2nd checkbox to reduce screen size
		//	Actions act=new Actions(driver);
		//	WebElement elem=driver.findElement(By.xpath("//*[@id='productDiv']/div[1]/div/label/span[1]/input"));
		//	act.doubleClick(elem).perform();
			////////////////////////////////////////////////
			//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Proceed\"));")).click();
			//((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
			//		"x",790,"y",1608)); // Click on 'Set' in Calendar Picker

			// Code to reach button at the bottom of the page "PROCEED"
		//	((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		//			"startX", 311, "startY", 800, "endX", 311, "endY",500, "speed",9000));
			Thread.sleep(500);
		//	String v3=driver.findElement(By.xpath("//*[@id=\"summaryDiv\"]/div[3]/div/div/button/span")).getText();
		//	System.out.println(v3);
			Thread.sleep(1500);
			//driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();
			// THIS LOOP USES DO WHILE TO SCROLL TO THE BOTTOM
			System.out.println("Scrolling to Proceed");
			do {
				js.executeScript("window.scrollBy(0,100)", "");  // Trying to get to bottom of page
				Thread.sleep(50);
			}while((driver.findElement(By.xpath("//*[@id=\"__next\"]/div/footer/div[1]/div[2]/p")).isSelected()));
			//js.executeScript("window.scrollBy(0,100)", "");
			((JavascriptExecutor) driver).executeScript("mobile:dragGesture", ImmutableMap.of("startX",119,"startY",1972,"endX",242,"endY",280,"speed",1000)); // Scrolling to Proceed up direction
			Thread.sleep(300);
			driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();
			//driver.findElement(By.xpath("//*[@id=\"summaryDiv\"]/div[3]/div/div/button/span")).click();
			
			Thread.sleep(900);
		//	driver.pullFolder("/storage/emulated/0/Download");
		//	js.executeScript("window.scrollBy(0,100)", "");
		//	driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).isSelected();
		//	js.executeScript("window.scrollBy(0,100)", "");
		//	driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click(); // to click on Proceed
			
			
			
			

			
			// COMMENTED Code to reach button at the bottom of the page "PROCEED"
			//		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			//				"startX", 311, "startY", 800, "endX", 311, "endY",500, "speed",9000));
			//		Thread.sleep(500);
			//		String v3=driver.findElement(By.xpath("//*[@id=\"summaryDiv\"]/div[3]/div/div/button/span")).getText();
			//		System.out.println(v3);
			//		driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();


			//*********************************************************************
			//*******************PAGE 2 OF CREATE AN APPLICATION********************
			//**********************************************************************
			Thread.sleep(5000);
			System.out.println(homepage);
			Boolean a=	driver.findElement(By.xpath("//*[contains(text(),'Complete KYC Process')]")).isDisplayed();
			Boolean b=	driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).isDisplayed();
			Boolean c9=	driver.findElement(By.xpath("//*[contains(text(),'Use Camera')]")).isDisplayed();
			Boolean d= driver.findElement(By.xpath("//*[contains(text(),'Choose files')]")).isDisplayed();
			Boolean e= driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).isDisplayed();
			System.out.println(a);
			System.out.println(b);
			System.out.println(c9);
			System.out.println(d);
			System.out.println("This is proceed"+""+e);
			driver.findElement(By.xpath("//*[contains(text(),'Complete KYC Process')]")).click(); // Complete Digilocker window
			Thread.sleep(6000);
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX", 728, "startY", 736, "endX", 470, "endY",736, "speed",9000)); // Scroll to left on Digilocker window
			Thread.sleep(6000);
	//		driver.findElement(By.xpath("//*[body/script[5]/following-sibling::div/div/img]")).
			// Trying to drag the modal down to click on 'x'
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX", 160, "startY", 1209, "endX", 160, "endY",736, "speed",1643)); // 
			Thread.sleep(2000);
			// Trying to click on'x' on KYC Digio Screen
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
					"x",1045,"y",350,"duration",1000));
			//The line of code below is to verify is the 'X' is clicked or not
			driver.findElement(By.xpath("//body/script[5]/following-sibling::div/div/img")).isSelected();
			driver.findElement(By.xpath("//body/script[5]/following-sibling::div/div/img")).click();
			System.out.println("After this line it's a bug");
			//driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			Thread.sleep(3000);
			System.out.println("This is page 3");
			System.out.println("Test for Page 2");
		
			//driver.findElement(By.xpath("//div[@class='lg:hidden']//input[@type='date']")).isSelected();
			Thread.sleep(5000);
			driver.findElement(AppiumBy.xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).click();
			driver.findElement(AppiumBy.xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys("123123");
			Thread.sleep(300);
			driver.findElement(AppiumBy.xpath("//button[@class='button-submit mt-5']")).isDisplayed();
			driver.findElement(AppiumBy.xpath("//button[@class='button-submit mt-5']")).click();
			Thread.sleep(300);
			driver.findElement(AppiumBy.xpath("//div[@class='lg:hidden']/input[@type='text']")).sendKeys("BLEPB6658M");
			driver.findElement(AppiumBy.xpath("//div[@class='mt-5']//child:: input")).click(); // Test to open calendar picker
			
			// Calendar Picker scroll down for right dates
			
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",258,"y",389)); // Click on Year
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX", 311, "startY", 626, "endX", 311, "endY",1900, "speed",5200)); // Calendar scroll down
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",550,"y",719)); // Select appropriate year
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
					"x",788,"y",1614));// Click on Set
			// Click on Submit Button
			driver.findElement(AppiumBy.xpath("//button[@class='button-submit mt-5']")).click();
			///////////////////////////////////////////////
			
	//		driver.findElement(By.xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys("'");
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX",119,"startY",1972,"endX",242,"endY",280,"speed",6000)); // Trying to scroll to bottom to click Proceed
			Thread.sleep(5000);
			System.out.println("First Scroll");
			driver.findElement(AppiumBy.xpath("//button[@type=\"button\"]/span[contains(text(),\"Proceed\")]")).click();
			//driver.findElement(By.xpath("//span[text()='Proceed']")).click();
			System.out.println("Proceed button click failed");
			((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					"startX",119,"startY",1972,"endX",242,"endY",280,"speed",6000)); 
			// Scrolling to the bottom works correctly IMP FOR CALENDAR PICKER BELOW
		//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Proceed\"));"));
		//	driver.findElement(By.xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys(Keys.TAB);
		//	driver.findElement(By.xpath("//*[contains(text(),'Choose file')]")).sendKeys(Keys.TAB);
		//	Thread.sleep(3000);
			
			//driver.findElement(AppiumBy.xpath("//span[text()='Proceed']")).click();
			driver.findElement(AppiumBy.xpath("//button[@type=\"button\"]/span[contains(text(),\"Proceed\")]")).click();
			System.out.println("You have scrolled correctly");
			Thread.sleep(500);
			System.out.println("You are on page 3");
		
		//  Page 3 STARTS //////////////////////////////////////////////////
			
		/*
		 * // driver.findElement(By.
		 * xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys(
		 * Keys.); driver.findElement(By.
		 * xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys(
		 * Keys.TAB);
		 * 
		 * //driver.findElement(By.xpath("//*[contains(text(),'Submit')]")).click();
		 * 
		 * Thread.sleep(100); driver.findElement(By.
		 * xpath("//div[@class='lg:hidden']/input[@class='pan-inpt pt-2']")).sendKeys(
		 * "BLEPB6658M");
		 * 
		 * 
		 * // PLACEHOLDER TO GET TO ENTER BITHDATE HERE(Line number 343 to 362)
		 * driver.findElement(By.name("studentDOB")).click();
		 * driver.findElement(AppiumBy.xpath("//div[@class='mt-5']//child:: input")).
		 * click(); ((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
		 * ImmutableMap.of( "x",258,"y",389)); // Click on Year
		 * 
		 * Thread.sleep(5000);
		 * 
		 * ((JavascriptExecutor)driver).executeScript("mobile: dragGesture",
		 * ImmutableMap.of( "startX", 311, "startY", 626, "endX", 311, "endY",1900,
		 * "speed",5200)); // Calendar scroll down Thread.sleep(3000);
		 * ((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
		 * ImmutableMap.of( "x",550,"y",719)); // Select appropriate year // LINES BELOW
		 * ARE ATTEMPT TO SCROLL UP WITH A DIFFERENT TECHNIQUE // JavascriptExecutor js
		 * = (JavascriptExecutor) driver; // js.executeScript("window.scrollBy(0,-350)",
		 * ""); // TWO LINES BELOW WORK Thread.sleep(3000); ((JavascriptExecutor)
		 * driver).executeScript("mobile: clickGesture", ImmutableMap.of(
		 * "x",788,"y",1614));// Click on Set
		 * 
		 * // PLACEHOLDER TO ENTER BIRTHDATE COMPLETE
		 * 
		 * // TRYING TO SCROLL TO THE BOTTOM OF PAGE 2
		 * ((JavascriptExecutor)driver).executeScript("mobile: dragGesture",
		 * ImmutableMap.of(
		 * "startX",119,"startY",1972,"endX",242,"endY",280,"speed",2000)); // Scroll to
		 * bottom of page 2
		 * driver.findElement(AppiumBy.xpath("//*[contains(text(),'Proceed')]")).click()
		 * ; // This is to get to page 3 System.out.println("Used AppiumBy line 387");
		 * //
		 * driver.findElement(By.xpath("//div[@class='lg:hidden']//input[@type='date']")
		 * ).isSelected();
		 * driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		 * //driver.findElement(By.xpath("//*[@id="wrapperdigio-ifm-1685575046350"]/img"
		 * )).click(); ((JavascriptExecutor)
		 * driver).executeScript("mobile: clickGesture", ImmutableMap.of(
		 * "x",1045,"y",350));// Click on 'x' button to close Digilocker window
		 * ((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
		 * ImmutableMap.of( "x",532,"y",368)); // click on Digio link
		 * 
		 * Thread.sleep(300); driver.findElement(By.
		 * xpath("//div[@class='font-Manrope bg-fp-bg overflow-x-hidden']")).isDisplayed
		 * (); driver.findElement(By.xpath(
		 * "//div/div[@class='lg:hidden']/*[contains(text(),'Submit')]")).isDisplayed();
		 * 
		 * System.out.println("Page 2 works");
		 * 
		 * // byte[] folder = driver.pullFolder("/storage/emulated/0/Download"); //
		 * driver.pullFolder("/storage/emulated/0/Download");
		 * System.out.println("Folder should be displayed");
		 * 
		 * 
		 * // THIS LOOP USES DO WHILE TO SCROLL TO THE BOTTOM do {
		 * js.executeScript("window.scrollBy(0,350)", ""); // Trying to get to bottom of
		 * page }while(driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).
		 * isSelected()); Thread.sleep(900);
		 * driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click(); //
		 * to click on Proceed //js.executeScript("window.scrollBy(0,1000)", "");
		 * System.out.println("Proceeded");
		 * 
		 * do { js.executeScript("window.scrollBy(0,350)", ""); // Trying to get to
		 * bottom of page
		 * }while(driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).
		 * isSelected()); Thread.sleep(900);
		 * ((JavascriptExecutor)driver).executeScript("mobile:dragGesture",
		 * ImmutableMap.of("StartX",119,"StartY",1972,"endX",242,"endY",480));
		 * Thread.sleep(300);
		 * driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click(); //
		 * to click on Proceed
		 * 
		 * // js.executeScript("window.scrollBy(0,350)", "");
		 * 
		 * // driver.findElement(AppiumBy.xpath("//*[@text='LEO1']")).click(); //
		 * driver.findElement(By.xpath("//*[@text='Please enter Student name']")).
		 * sendKeys("Anuradha D Dube"); //*[@bounds='[975,297][1049,311]']
		 * //driver.findElement(By.xpath("//*[@bounds='[975,297][1049,311]']")).click();
		 * // ((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
		 * ImmutableMap.of( // "x",1003,"y",304)); // Thread.sleep(2000);
		 * //driver.findElement(By.xpath("//*[@text='Login']")).click(); //
		 * driver.findElement(By.xpath("//android.widget.button[@text='Login']")).click(
		 * );
		 * 
		 * // driver.findElement(By.
		 * xpath("//text()[contains(.,'+ Create new application')][1]")).click(); //
		 * driver.findElement(By.xpath("//input[@aria-label='Digit 2']")).click();
		 * //System.out.println(String.valueOf(v)); // This is casted to string value
		 * below //
		 * driver.findElement(By.xpath("//input[@aria-label='Digit 2']")).sendKeys(
		 * String.valueOf(v));
		 * 
		 * 
		 * 
		 * // driver.findElement(By.xpath("//*[@text='amazon']"));
		 * //driver.findElement(By.xpath("//*[@bounds='[975,283][1049,328]']")).click();
		 * //driver.get("https://www.google.com/");
		 * //driver.get("https://www.amazon.com"); //driver.close();
		 * 
		 * // THIS WORKING BLOCK OF CODE CAN BE USED TO SCROLL DOWN CONTINUOUSLY
		 * 
		 * // boolean canScrollMore; // do{ //
		 * canScrollMore=(Boolean)((JavascriptExecutor)driver) //
		 * .executeScript("mobile:scrollGesture",
		 * ImmutableMap.of("left",100,"top",100,"width",200,"height",200,"direction",
		 * "up","percent",3.0)); // }while(canScrollMore); //
		 * System.out.println("Something has passed");
		 */
		}
	}
}
