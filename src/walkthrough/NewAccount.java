package walkthrough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

	public static void main(String[] args) {
		String browserType = "firefox";
		WebDriver driver;
		
		String email = "test5@email.com";
		String gender;
		String firstName = "Asda";
		String lastName = "Fafda";
		String password = "Experiment1";
		String address = "123 Main St";
		String city =  "Cityplace";
		String zipcode = "12345";
		String state = "Wyoming";
		String phone = "1231231234";
		
		// 1. Create WebDriver
		// code transferred to method in DriverFactory
		driver = utilities.DriverFactory.open(browserType);

		// 2. Navigate to Account Management Page
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
		
		// 3. Fill out the form
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.name("customer_firstname")).sendKeys(firstName);
		driver.findElement(By.name("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.name("passwd")).sendKeys(password);
		
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		new Select(driver.findElement(By.name("id_state"))).selectByVisibleText(state);
		driver.findElement(By.name("postcode")).sendKeys(zipcode);
		driver.findElement(By.name("phone_mobile")).sendKeys(phone);
		
		// 4. Click submit
		driver.findElement(By.name("submitAccount")).click();
		
		// 5. Get confirmation
		String confirm = driver.findElement(By.className("info-account")).getText();
		System.out.println("CONFIRMATION: " + confirm);
		
		// 6. Close the browser
		driver.close();
	}
}