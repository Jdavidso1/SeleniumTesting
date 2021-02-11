package smoketests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	@Test
	public void pageTitleTest() {
		String webURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Login - My Store";
	}
}
