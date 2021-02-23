package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test");
		boolean createAccountPresent = false;
		
		// We want to test the presence of a-tags (hyperlinks)
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		
		// Not necessary, just showing the steps to get here logically
		int numberOfAElements = aElements.size();
		System.out.println("There are " + numberOfAElements + " a-tags on the page.");
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				createAccountPresent = true;
				break;
			}
		}
		
		//Assertion
		Assert.assertTrue(createAccountPresent);
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