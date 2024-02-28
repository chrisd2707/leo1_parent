package Om.leo1_parent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class FurtherOps_DBqueries{
	public int otp1;
	// Lines below are to implement Otp
	public static AndroidDriver driver;
	public static void longPressAction(int x, int y, int d) {
		// Method template

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"x",x,"y",y,"duration",500));
	}
	
	public static int[] individual_digits(int onetimepin) {

		int otp_individual_digits[]=new int[4];
		for(int i=0;i<4;i++) {

			//System.out.println(otp_individual_digits[i]);

			int quotient;
			if (i==0) {
				otp_individual_digits[i] = (onetimepin / 1000); // Quotient of the OTP after dividing by 100
				int first_digit=quotient=((otp_individual_digits[i]) % 10);
				otp_individual_digits[i]=first_digit;
				//	System.out.println("Inside the loop The first digit of otp is"+" "+first_digit);
				//	System.out.println("Inside the loop The first digit of otp is"+" "+quotient);
				//	System.out.println("Inside the loop The first digit of otp in the array is"+" "+otp_individual_digits[i]);
			}
			if (i==1) {
				otp_individual_digits[i] = (onetimepin / 100); // Quotient of the OTP after dividing by 100
				int second_digit=quotient=((otp_individual_digits[i]) % 10);
				otp_individual_digits[i]=second_digit;
				//System.out.println("Inside the loop The second digit of otp is"+" "+second_digit);
				//System.out.println("Inside the loop The second digit of otp is"+" "+quotient);
				//System.out.println("Inside the loop The second digit of otp in the array is"+" "+otp_individual_digits[i]);
			}

			if (i==2) {
				otp_individual_digits[i] = (onetimepin / 10); // Quotient of the OTP after dividing by 10
				int secondlast_digit=quotient=((otp_individual_digits[i]) % 10);
				otp_individual_digits[i]=secondlast_digit;
				//System.out.println("Inside the loop The third digit of otp is"+" "+secondlast_digit);
				//System.out.println("Inside the loop The third digit of otp is"+" "+quotient);
				//System.out.println("Inside the loop The third digit of otp in the array is"+" "+otp_individual_digits[i]);
			}


			if (i==3) {
				int last_digit=(onetimepin % 10);
				otp_individual_digits[i]=last_digit;
				//System.out.println("Inside the loop The last digit of otp is"+" "+last_digit);
				//System.out.println("Inside the loop The last digit of otp in the array is"+" "+otp_individual_digits[i]);
			}

		}

		return otp_individual_digits;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void select_digits_keypad(int arr[]) {
		System.out.println("You are inside the switch block");
		for (int k=0;k<4;k++) {
			//		 HashMap<String, Integer> indiv_digit = new HashMap<String, Integer>();
			switch(arr[k]) {

			case 0:
				System.out.println("0");
				longPressAction(266,1616,10); // Press on the keyboard
				break;
			case 1:
				System.out.println("1");
				longPressAction(266,1616,10); // Press on the keyboard
				break;
			case 2:
				System.out.println("2");
				longPressAction(528,1616,10);
				break;
			case 3:
				System.out.println("3");
				longPressAction(802,1616,10);
				break;
			case 4:
				System.out.println("4");
				longPressAction(254,1777,10);
				break;
			case 5:
				System.out.println("5");
				longPressAction(528,1777,10);
				break;
			case 6:
				System.out.println("6");
				break;
			case 7:
				System.out.println("7");
				break;
			case 8:
				System.out.println("8");
				break;
			case 9:
				System.out.println("9");
				break;
			}

		}
		//	if arr[i]
		//((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
		//		"x",262,"y",1624));


	}

	public int realtime_otp() throws ClassNotFoundException, SQLException {

		String connURL="jdbc:postgresql://nbfcprod.cgkhptdv3xxx.ap-south-1.rds.amazonaws.com:5432/NBFC";
		String Username="dinesh";
//		String pw="Dnj40dThdTY92fR"; // Old pw
		String pw="Dhna@40Dh6snTTg"; // New password
		int otp=0;
		//System.out.println("Before connection");
		Class.forName("org.postgresql.Driver");
		// Open a connection to Prod database
		Connection con=DriverManager.getConnection(connURL,Username,pw);
		Statement st=con.createStatement();
		// Creating and executing a query
		String v="SELECT"+" otp,"+"\"mobileNo\"" +" FROM public.myprofile_otpverification WHERE "
				+ "\"mobileNo\"" +"=7506553677";
		ResultSet rs=st.executeQuery(v);		
		while (rs.next()){
			otp1 = rs.getInt(1);
			String mobileNo=rs.getString(2);
			System.out.println("The OTP is"+" "+otp1+" "+"and mobile number is"+" "+mobileNo);
		}
		// Returning the value of OTP for further operations
		return otp1;
	}



	/*
	 * public int[] individual_digits(int onetimepin) {
	 * 
	 * int otp_individual_digits[]=new int[4]; for(int i=0;i<4;i++) {
	 * 
	 * //System.out.println(otp_individual_digits[i]);
	 * 
	 * int quotient; if (i==0) { otp_individual_digits[i] = (onetimepin / 1000); //
	 * Quotient of the OTP after dividing by 100 int
	 * first_digit=quotient=((otp_individual_digits[i]) % 10);
	 * otp_individual_digits[i]=first_digit; //
	 * System.out.println("Inside the loop The first digit of otp is"+" "
	 * +first_digit); //
	 * System.out.println("Inside the loop The first digit of otp is"+" "+quotient);
	 * //
	 * System.out.println("Inside the loop The first digit of otp in the array is"
	 * +" "+otp_individual_digits[i]); } if (i==1) { otp_individual_digits[i] =
	 * (onetimepin / 100); // Quotient of the OTP after dividing by 100 int
	 * second_digit=quotient=((otp_individual_digits[i]) % 10);
	 * otp_individual_digits[i]=second_digit;
	 * //System.out.println("Inside the loop The second digit of otp is"+" "
	 * +second_digit);
	 * //System.out.println("Inside the loop The second digit of otp is"+" "
	 * +quotient); //System.out.
	 * println("Inside the loop The second digit of otp in the array is"+" "
	 * +otp_individual_digits[i]); }
	 * 
	 * if (i==2) { otp_individual_digits[i] = (onetimepin / 10); // Quotient of the
	 * OTP after dividing by 10 int
	 * secondlast_digit=quotient=((otp_individual_digits[i]) % 10);
	 * otp_individual_digits[i]=secondlast_digit;
	 * //System.out.println("Inside the loop The third digit of otp is"+" "
	 * +secondlast_digit);
	 * //System.out.println("Inside the loop The third digit of otp is"+" "+quotient
	 * );
	 * //System.out.println("Inside the loop The third digit of otp in the array is"
	 * +" "+otp_individual_digits[i]); }
	 * 
	 * 
	 * if (i==3) { int last_digit=(onetimepin % 10);
	 * otp_individual_digits[i]=last_digit;
	 * //System.out.println("Inside the loop The last digit of otp is"+" "
	 * +last_digit);
	 * //System.out.println("Inside the loop The last digit of otp in the array is"
	 * +" "+otp_individual_digits[i]); }
	 * 
	 * }
	 * 
	 * return otp_individual_digits; }
	 */

	// Working on co-ordinates for individual digits 
	char v;
	//v="x",258,  "y",920"
	int i=258;
	int j=920;
	public void digitcords(int i,int j) {
		System.out.println();
		String v="\"x\""+","+i+","+"\"y\""+","+j;
		System.out.println(v);
	}

	// SELECT DIGITS KEYPAD can also be renamed to be digits pressed on keyboard using executor

	/*
	 * public void select_digits_keypad(int arr[]) {
	 * System.out.println("You are inside the switch block"); for (i=0;i<4;i++) { //
	 * HashMap<String, Integer> indiv_digit = new HashMap<String, Integer>();
	 * switch(arr[i]) {
	 * 
	 * case 0: System.out.println("0"); // indiv_digit.put(x, )
	 * 
	 * break; case 1: System.out.println("1"); break; case 2:
	 * System.out.println("2"); break; case 3: System.out.println("3"); break; case
	 * 4: System.out.println("4"); break; case 5: System.out.println("5"); break;
	 * case 6: System.out.println("6"); break; case 7: System.out.println("7");
	 * break; case 8: System.out.println("8"); break; case 9:
	 * System.out.println("9"); break; }
	 * 
	 * } // if arr[i] //((JavascriptExecutor)
	 * driver).executeScript("mobile: clickGesture", ImmutableMap.of( //
	 * "x",262,"y",1624));
	 * 
	 * 
	 * }
	 */

	public HashMap<String, String> getDigits_cordsMap() {
		HashMap<String, String> x_and_y=new HashMap<String, String>();

		x_and_y.put("0", "520:2093");//"x",520,"y",2093
		x_and_y.put("1", "266:1616");
		x_and_y.put("2", "528:1616");
		x_and_y.put("3", "802:1616");
		x_and_y.put("4", "254:1777");
		x_and_y.put("5", "528:1777");
		x_and_y.put("6", "779:1777");
		x_and_y.put("7", "262:1929");
		x_and_y.put("8", "520:1929");
		x_and_y.put("9", "783:1929");

		return x_and_y;
	}

	// Method below splits x co-ordinates from the Hashmap individual digit co-ordinates

	public String x_cordinates(String selected_digit_onkeyboard) {
		String x=getDigits_cordsMap().get(selected_digit_onkeyboard);
		return x.split(":")[0];

	}

	// Method below splits y co-ordinates from the Hashmap for the individual digit co-ordinates

	public String y_cordinates(String selected_digit_onkeyboard) {
		String y=getDigits_cordsMap().get(selected_digit_onkeyboard);
		return y.split(":")[1];

	}

	// Below is being tested 


	//public String y1_cordinates(String key){
	//String y=getDigits_cordsMap().get(k());
	//		return y.split(":")[1];

	//	}

	public void longPressAction(String x, String y) {
		// Method template
	}

	public void clickAction(String x, String y) {
		// Method template
		//((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
		//		"x",262,"y",1624));
	}
	//return onetimepin;

	//return int a[];


	@Test
	public void executeQuery() throws ClassNotFoundException, SQLException {

		//System.out.println(individual_digits(realtime_otp()));


		//	FurtherOps_DBqueries obj1= new FurtherOps_DBqueries();
		//	int b[]=obj1.individual_digits(realtime_otp());
		//	for (int i=0;i<4;i++) {

		//		System.out.println( "This is the copied function"+"  "+b[i]);
		//	}	
		digitcords(i,j);
		//System.out.println("Block of code executed now will be repeated");
		select_digits_keypad(individual_digits(realtime_otp()));
		System.out.println(getDigits_cordsMap());
		System.out.println(x_cordinates("0"));
		System.out.println(y_cordinates("6"));
			

	}



}

////////////////////////////////////////////////////////////////////
//////////////OTP FUNCTION WORKS///////////////////////////////////

