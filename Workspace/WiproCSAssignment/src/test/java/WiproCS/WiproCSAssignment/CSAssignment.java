package WiproCS.WiproCSAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CSAssignment {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/Pritesh/Browser Bindings/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void navigate_GooglePage()
	{
		driver.get("https://www.google.com");
	}

}
