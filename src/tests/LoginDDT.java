package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	WebDriver driver;
	
	@DataProvider
	public String[][] getData() {
		String filename = "C:\\Users\\JDAVI\\OneDrive\\Documents\\BACKUPS\\ACADEMYPGH\\PROJECTS\\Java\\SeleniumTesting\\UserLogin.xls";
		return utilities.Excel.get(filename);
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {

		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
		
		String confirm = driver.findElement(By.className("info-account")).getText();
		System.out.println("CONFIRMATION: " + confirm);
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE: " + pageTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
