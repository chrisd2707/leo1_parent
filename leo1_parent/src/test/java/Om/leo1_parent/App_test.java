package Om.leo1_parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.Setting;

public class App_test extends base{
	//	App_test newapp=new App_test();
	//	public void now() {
	//		System.out.println("this is a base test");
	//		//this.now();
	//}
	
	public int web_realtime_otp() throws ClassNotFoundException, SQLException {
		
//		String connURL="jdbc:postgresql://dev-nbfc-db.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/STAGING1";
		String connURL="jdbc:postgresql://nbfcprod.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/NBFC";
//		String Username="debiprasad";// Old prod Username
		String Username="dinesh";
//		String pw="Dnj40dThdTY92fR"; // Old prod pw
// 	    String pw="Dhsn@8884#hdnDll";
		String pw="Dhna@40Dh6snTTg"; // New prod pw
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


	@Test


	public void now1() throws ClassNotFoundException, SQLException, InterruptedException  {
		//driver.setSetting(Setting.  valueOf("EnforceXpath1"),true);
		driver.setSetting("enforceXpath1",true); // WORKS 
		//driver.setSetting(“enforceXPath1”,true);
		//driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
		
		int v2 =web_realtime_otp(); // troubleshooting
		System.out.println("The lines below show the output of web_realtime_otp function" + v2); // troubleshooting
		System.out.println("this is a base test");

		String v = driver.findElement(By.xpath("//*[@text='Skip']")).getText();
		System.out.println("this is"+v);
		Assert.assertEquals(v, "Skip");
		driver.findElement(By.xpath("//*[@text='Skip']")).click();
		//The code below needs to be deleted
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"x",309,"y",1123,"duration",500));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(500);
		System.out.println("Long Clicked");
		System.out.println(driver.getCapabilities());
		//driver.setSetting()
		/*
		 * 
		 * 
		 */
		// The line below was added to check if Xpath1 issue is resolved
		//driver.findElement(By.xpath("//*[contains(text(),'Sign Up')]")).click();
		WebElement w=driver.findElement(By.xpath("//android.widget.EditText[(@text(),'Mobile Number')]"));
		w.sendKeys("7506553677");
		WebElement arrow=driver.findElement(By.xpath("//com.horcrux.svg.PathView[contains(@bounds,'[863,1103][929,1133]')]"));
		arrow.click();
		Thread.sleep(20000);
		
		System.out.println("You are on Enter OTP Screen"+" better things will follow");
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"x",252,"y",916,"duration",10));
		System.out.println("Keyboard is visible");
		
	//	((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
	//			"x",252,"y",916));
	//	((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
	//			"x",106,"y",352));
		// On OTP Screen below this		

		
	/*
	 * driver.findElement(By.xpath("//*[contains(text(),'Sign Up')]")).click();
	 * WebElement ww=driver.findElement(By.xpath("//*[@text='Mobile Number']"));
	 * ww.sendKeys("7506553677");
	 */
		Thread.sleep(1000);
         // EVERYTHING ABOVE TBIS SHOULD BE DELETED TILL SKIP TEXT FOR DEMO
		web_realtime_otp();
		
		
		
	}
}




