package p1;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class Base {
	//some globals for all childs
	static WebDriver driver;
	static EventFiringWebDriver  oEventFire ;
	static WebDriverEventsClass oWebDriverEventsClass ;

	@BeforeClass
	public void setup() {
		//  WebDriverManager.chromedriver().setup();// idk y
		//System.setProperty ("webdriver.chrome.driver","D:/Study/Testing/chromedriver_win32/chromedriver.exe");
		WebDriverManager.chromedriver().setup(); //instead of the previous line
		// if it's static will make a big problem when we use it in paralel executions
		driver = new ChromeDriver();
		oEventFire = new EventFiringWebDriver(driver);//this for eventlistenet
		oWebDriverEventsClass = new WebDriverEventsClass();// this event listener class where we implement WebDriverEventListener
	}

	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver d) {
		driver =d;
	}


	//taking screen shot method and add it to allure report with message 
	public void takeScreentshot(String messageforTakeScreenShot) {
		Allure.addAttachment(messageforTakeScreenShot, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

	}


}
