package walkthrough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver (firefox)
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Testing\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// 2. Navigate to Account Management Page
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.id("email_create")).sendKeys("test@email.com");
		driver.findElement(By.id("SubmitCreate")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
		
		// 3. Fill out the form
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.name("customer_firstname")).sendKeys("Asda");
		driver.findElement(By.name("customer_lastname")).sendKeys("Fafda");
		driver.findElement(By.name("passwd")).sendKeys("Experiment1");
		
		driver.findElement(By.name("address1")).sendKeys("123 Main St");
		driver.findElement(By.name("city")).sendKeys("Cityplace");
		new Select(driver.findElement(By.name("id_state"))).selectByVisibleText("Wyoming");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		driver.findElement(By.name("phone_mobile")).sendKeys("1231231234");
		
		// 4. Click submit
		driver.findElement(By.name("submitAccount")).click();
		
		// 5. Get confirmation
		String confirm = driver.findElement(By.className("info-account")).getText();
		System.out.println("CONFIRMATION: " + confirm);
		
		// 6. Close the browser
		driver.close();

	}

}