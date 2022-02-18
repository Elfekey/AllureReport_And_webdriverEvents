package p2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class webdriverEvenListenetTests {
static WebDriver driver ;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver d) {
		driver =d;
	}
	
		String title ="https://www.google.com/";
		@BeforeTest
		public void before() {
			//  WebDriverManager.chromedriver().setup();// idk y
			System.setProperty ("webdriver.chrome.driver","D:/Study/Testing/chromedriver_win32/chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		@Test (priority = 1 ,description = "priority 1 test")
		public void UsegetToWebsiteByTitle() {
			//this how we apply the below EventFiringWebDriver we pass to it the driver first
			EventFiringWebDriver  oEventFire = new EventFiringWebDriver(driver);
			//then we create instance of out event listner class 
			webdriverEvenets oWebdriverEvenListenetTests = new webdriverEvenets();
			//then we use the instance of the EventFiringWebDriver interface to register from our events class
			oEventFire.register(oWebdriverEvenListenetTests);
			//we use oEventFire instead of driver to apply the events on it
        	oEventFire.get(title);//to use navigate method below
			oEventFire.manage().window().maximize();
			oEventFire.findElement(By.id("noneID")).isDisplayed();//to use exception method below
		}
		



		@AfterTest
		public void after() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
		
		
}
