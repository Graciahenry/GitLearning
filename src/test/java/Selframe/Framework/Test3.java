package Selframe.Framework;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class Test3 extends base {
	
	private static Logger log = LogManager.getLogger(Test3.class.getName());

	public WebDriver driver;
	@BeforeTest(groups= {"zoo"})
	@Parameters({"url"})
	public void Amazonsprinttest(String Website) throws IOException, InterruptedException
	{
		 //ExtentTest Test= extent.createTest("printtest");
		driver= initializeDriver();
		//PageObject page =new PageObject(driver);
		
		driver.get(Website);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//extent.flush();
	}
	
	@Test(groups= {"zoo"})
	public void pageopen()
	{
		// ExtentTest Test= extent.createTest("page open");
		Actions a = new Actions(driver);
		elementCapture capture = new elementCapture(driver);
		//log.info(capture.Elements().size());
		/*
		 * for (WebElement i:capture.Elements()) { a.contextClick(i).clickAndHold();
		 * //log.info(i.getAttribute("innerText")); //driver.close(); }
		 */
		
		String parentWindowHandle = driver.getWindowHandle();
		
		System.out.println(parentWindowHandle);
		
		/*for(int i =0; i <5; i++)
		{*/
			
			a.contextClick(capture.Element()).clickAndHold().keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).click().build().perform();
			
			String childWindowHandle = driver.getWindowHandle();
			System.out.println(childWindowHandle);
			Set<String> windows=driver.getWindowHandles();
			Iterator<String> iterated= windows.iterator();
			String c= iterated.next();
			String d= iterated.next();
			driver.switchTo().window(d);
			System.out.println(driver.findElement(By.xpath("//script[@type='application/ld+json']/following-sibling::div[1]/h1")).getText());
			driver.switchTo().window(c);
			System.out.println(capture.Element().getText());
			Assert.assertEquals(capture.Element().getText(), "Customer Service");
		

	}
	
	
	  /*@AfterTest */
	/*  public void browserClose() 
	  { 
		  driver.close(); 
		  }
	 */
}
