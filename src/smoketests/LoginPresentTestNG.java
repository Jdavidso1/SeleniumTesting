package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test");
		
		boolean loginEmailBox = driver.findElement(By.id("email")).isDisplayed();
		boolean loginPasswordBox = driver.findElement(By.id("passwd")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email textbox present");
		Assert.assertTrue(loginPasswordBox, "Password textbox present");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("Starting test");
		
		String webURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account"; 
		
		driver = utilities.DriverFactory.open("firefox");
		driver.get(webURL);
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("Closing test");
		
		driver.close();
	}

}