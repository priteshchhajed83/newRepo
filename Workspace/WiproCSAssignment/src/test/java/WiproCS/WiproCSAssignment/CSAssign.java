package WiproCS.WiproCSAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CSAssign {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/Pritesh/Browser Bindings/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(enabled=false)
	public void navigate_Google() {
	
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println("Google opened successfully");
	}
	
	
	@Test(enabled=false)
	public void read_Highlight() {
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.name("q"));
		
		
		
		if(!element.isDisplayed()) {
			try {
				throw new Exception("Element does not exists on page");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			element.sendKeys("Cucumber");
		}
		
		
		
		
		//List<WebElement> elementList = driver.findElements(By.xpath("//*[id='search']//"));
		List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(text(),'cucumber')]"));
		System.out.println("Element list is : ");
		for(WebElement el : elementList) {
			System.out.println("" + el.getText() + "\n");
			highLightElement(el,driver);
		}
		
	}
	
	
	private void highLightElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js. executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid blue;');", element);
	    try
	    {
	    Thread. sleep(500);
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		
	}
	
	@Test
	public void validate_Font() {
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.name("q"));
		
		if(!element.isDisplayed()) {
			try {
				throw new Exception("Element does not exists on page");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			element.sendKeys("Selenium WebDriver");
			element.sendKeys(Keys.ENTER);
		}
		
		WebElement element1 = driver.findElement(By.cssSelector("a[href*='projects']"));
		element1.click();
		
		WebElement textElement = driver.findElement(By.xpath("//h1[contains(.,'Selenium Projects')]"));
		
		String fontSize = textElement.getCssValue("font-size");
		System.out.println("Font Size -> "+fontSize);
		  
		
		String fontColor = textElement.getCssValue("color");
		System.out.println("Font Color -> "+fontColor);
		  
		  
		String fontFamily = textElement.getCssValue("font-family");
		System.out.println("Font Family -> "+fontFamily);
		
		
 }

	

	/*@AfterTest
	public void tearDown() {
		driver.close();
	}*/

}
