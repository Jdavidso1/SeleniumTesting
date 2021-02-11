package walkthrough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

	public static void main(String[] args) {
		String email = "test6@email.com";
		String gender = "male";
		String firstName = "John";
		String lastName = "Smith";
		String password = "Experiment1";
		String address = "123 Main St";
		String city =  "Cityplace";
		String zipcode = "12345";
		String state = "Wyoming";
		String phone = "1231231234";
		boolean newsletter = false;
		boolean optin = true;
		
		// 1. Define WebDriver - transferred to method in separate file
		String browserType = "firefox";
		WebDriver driver = utilities.DriverFactory.open(browserType);
				
		// 2A. Navigate to Account Management Page
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		
		// next page needs a moment to load entirely before input will take
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
		
		// 2B. Define WebElements
		WebElement maleElement = driver.findElement(By.id("id_gender1"));
		WebElement femaleElement = driver.findElement(By.id("id_gender2"));
		WebElement fnameElement = driver.findElement(By.name("customer_firstname"));
		WebElement lnameElement = driver.findElement(By.name("customer_lastname"));
		WebElement passwordElement = driver.findElement(By.name("passwd"));
		WebElement newsletterElement = driver.findElement(By.name("newsletter"));
		WebElement optinElement = driver.findElement(By.name("optin"));
		WebElement addressElement = driver.findElement(By.name("address1"));
		WebElement cityElement = driver.findElement(By.name("city"));
		WebElement stateElement = driver.findElement(By.name("id_state"));
		WebElement postcodeElement = driver.findElement(By.name("postcode"));
		WebElement phoneElement = driver.findElement(By.name("phone_mobile"));
		
		// 3. Fill out the form
		if (gender.equalsIgnoreCase("male")) { maleElement.click(); }
		else { femaleElement.click(); }		
		
		fnameElement.sendKeys(firstName);
		lnameElement.sendKeys(lastName);
		passwordElement.sendKeys(password);
		
		if (newsletter) {
			if (newsletterElement.isSelected()) { }
			else { newsletterElement.click(); }
		}
		else {
			if (!newsletterElement.isSelected()) { }
			else { newsletterElement.click(); }
		}
		
		if (optin) {
			if (optinElement.isSelected()) { }
			else { optinElement.click(); }
		}
		else {
			if (!optinElement.isSelected()) { }
			else { optinElement.click(); }
		}
		
		addressElement.sendKeys(address);
		cityElement.sendKeys(city);
		new Select(stateElement).selectByVisibleText(state);
		postcodeElement.sendKeys(zipcode);
		phoneElement.sendKeys(phone);
		
		// 4. Click submit
		driver.findElement(By.name("submitAccount")).click();
		
		// 5. Get confirmation
		String confirm = driver.findElement(By.className("info-account")).getText();
		System.out.println("CONFIRMATION: " + confirm);
		
		// 6. Close the browser
		driver.close();
	}
}