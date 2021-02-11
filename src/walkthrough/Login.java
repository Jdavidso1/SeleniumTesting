package walkthrough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. Define the web driver (chrome)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		//Find elements: locate the element, determine the action, pass any parameters
		
		// 3. Enter email address	
		driver.findElement(By.name("email")).sendKeys("test1@email.com");
		
		// 4. Enter Password
		driver.findElement(By.name("passwd")).sendKeys("Experiment1");
		
		// 5. Click Login
		driver.findElement(By.name("SubmitLogin")).click();
		
		// 6. Get confirmation
		String confirm = driver.findElement(By.className("info-account")).getText();
		System.out.println("CONFIRMATION: " + confirm);
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE: " + pageTitle);

		// 7. Close the browser
		driver.close();
	}
}