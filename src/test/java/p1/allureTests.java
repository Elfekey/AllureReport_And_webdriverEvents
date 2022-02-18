package p1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(p1.allureListner.class) // we use it if we want to use listener in single class of a few classes else we run from xml file 
public class allureTests extends Base {//only for polymorphism use
	String title ="https://www.google.com/";

	@Override
	public WebDriver getDriver() {
		return driver;
	}
    @Override
	public void setDriver(WebDriver d) {
    driver =d;
	}



	@Test (priority = 1 ,description = "priority 1 test")
	@Severity(SeverityLevel.BLOCKER)
	@Description ("this firsy test getting to browser")
	@Feature("First Feature")//under it we have stories 
	@Story(" First Story  !")
	@Link("https://www.google.com/")
	public void UsegetToWebsiteByTitle() {
		getToWebsiteByTitle(this.title);
	}


	@Test (priority = 2,description = "priority 2 test")
	@Feature("First Feature")//under it we have stories 
	//@Story("Story one !")
	public void checkLogo() {
		boolean logo =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		Assert.assertEquals(logo, true);
	}
	@Test (priority = 3)
	public void checkTitle() {
		String title =driver.getTitle();
		System.out.println("The title is :"+title);
		Assert.assertEquals(title,"Google2");//to make it fail
	}

	//to  just skip
	@Test (priority = 4)
	public void skipping() {
		throw new SkipException("just skipping");
	}


	@AfterTest
	public void after() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


	@Step("This step1 where we get title and go to it >>  {0}  is the title ")
	public void getToWebsiteByTitle(String title) {
		driver.get(title);
		driver.manage().window().maximize();
	}
}
