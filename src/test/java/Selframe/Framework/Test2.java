package Selframe.Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2 extends base {
	
	private static Logger log = LogManager.getLogger(Test2.class.getName());


	@BeforeTest(groups= {"zoo"})
	@Parameters({"url"})
	public void Amazonloadtest(String Website) throws IOException, InterruptedException
	{
		driver= initializeDriver();
		//PageObject page =new PageObject(driver);
		driver.get(Website);
		Thread.sleep(2000);
	}
	
	@Test(groups= {"zoo"})
	public void element()
	{
		elementCapture capture = new elementCapture(driver);
		//System.out.println(capture.Elements().size());
		log.info(capture.Elements().size());
		for (WebElement i:capture.Elements())
		{
		log.info(i.getAttribute("innerText"));
			//driver.close();
		//System.out.println(i.getAttribute("innerText"));
		}
	}
	
	@AfterTest(groups= {"zoo"})
	public void browserClose()
	{
		driver.close();
	}

}
