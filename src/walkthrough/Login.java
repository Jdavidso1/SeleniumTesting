package walkthrough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. Define the web driver (chrome)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page (https://wiki.workhardpgh.com/wiki/Special:UserLogin)
		driver.get("https://wiki.workhardpgh.com/wiki/Special:UserLogin");
		
		//Find elements: locate the element, determine the action, pass any parameters
		
		// 3. Enter email address	
		driver.findElement(By.name("wpName")).sendKeys("thisisatest");
		
		// 4. Enter Password
		driver.findElement(By.name("wpPassword")).sendKeys("EXPERIMENT1");
		
		// 5. Click Login
		driver.findElement(By.name("wploginattempt")).click();
		
		// 6. Get confirmation
		String message = driver.findElement(By.id("pt-logout")).getText();
		System.out.println("CONFIRMATION: " + message + " is present.");
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE: " + pageTitle);

		// 7. Close the browser
		driver.close();
	}
}