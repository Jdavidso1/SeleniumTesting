package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(value= Parameterized.class)
public class NewAccountDDT {
	String email, gender, firstName, lastName, password, address, city, zipcode, state, phone;
	boolean newsletter, optin;
	WebDriver driver;
	WebElement maleElement, femaleElement, fnameElement, lnameElement, passwordElement, newsletterElement, optinElement, addressElement, cityElement, stateElement, postcodeElement, phoneElement;
	
	// This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserAccounts.csv");
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String email, String gender, String firstName, String lastName, String password, String address, String city, String zipcode, String state, String phone, String newsletter, String optin) {
		this.email = email;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
		this.phone = phone;
		
		if (newsletter.equals("TRUE")) { this.newsletter = true; }
		else { this.newsletter = false; }
		
		if (optin.equals("TRUE")) { this.optin = true; }
		else {this.optin = false; }	
	}
	
	@Before
	public void setUp() {
		// Define the WebDriver
		String browserType = "firefox";
		driver = utilities.DriverFactory.open(browserType);
		
		// Navigate to Homepage
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	// This is our test method
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + firstName + " " + lastName + " " + gender + " " + email + " " + password + " " + address + " " + city + " " + zipcode + " " + state + " " + phone + " " + newsletter + " " + optin);
		
		// Navigate to Account Management page
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		
		// Wait Command
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
		
		// Define WebElements
		maleElement = driver.findElement(By.id("id_gender1"));
		femaleElement = driver.findElement(By.id("id_gender2"));
		fnameElement = driver.findElement(By.name("customer_firstname"));
		lnameElement = driver.findElement(By.name("customer_lastname"));
		passwordElement = driver.findElement(By.name("passwd"));
		newsletterElement = driver.findElement(By.name("newsletter"));
		optinElement = driver.findElement(By.name("optin"));
		addressElement = driver.findElement(By.name("address1"));
		cityElement = driver.findElement(By.name("city"));
		stateElement = driver.findElement(By.name("id_state"));
		postcodeElement = driver.findElement(By.name("postcode"));
		phoneElement = driver.findElement(By.name("phone_mobile"));
		
		// Fill out the form
		// gender button algorithm
		if (gender.equalsIgnoreCase("male")) { maleElement.click(); }
		else { femaleElement.click(); }		
		//checkbox algorithms
		if (newsletter) { if (!newsletterElement.isSelected()) { newsletterElement.click(); } }
		else { if (newsletterElement.isSelected()) { newsletterElement.click(); } }
		if (optin) { if (!optinElement.isSelected()) { optinElement.click(); } }
		else { if (optinElement.isSelected()) { optinElement.click(); } }
		//other webelements
		fnameElement.sendKeys(firstName);
		lnameElement.sendKeys(lastName);
		passwordElement.sendKeys(password);
		addressElement.sendKeys(address);
		cityElement.sendKeys(city);
		postcodeElement.sendKeys(zipcode);
		phoneElement.sendKeys(phone);
		new Select(stateElement).selectByVisibleText(state);
		
		// Click Submit
		driver.findElement(By.name("submitAccount")).click();		
	}
	
	@After
	public void tearDown() {
		// Close the browser
		driver.close();
	}
		
}
