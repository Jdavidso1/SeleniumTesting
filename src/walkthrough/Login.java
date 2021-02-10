package walkthrough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// 1. Define the web driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page (https://wiki.workhardpgh.com/wiki/Special:UserLogin)
		driver.get("https://wiki.workhardpgh.com/wiki/Special:UserLogin");
		
		// 3. Enter email address
		// 4. Enter Password
		// 5. Click Login
		// 6. Get confirmation
		// 7. Close the browser
	}
}