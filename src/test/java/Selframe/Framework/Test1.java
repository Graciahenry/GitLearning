package Selframe.Framework;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;


public class Test1 extends base {

	private static Logger log = LogManager.getLogger(Test1.class.getName());
	
	@BeforeMethod(groups= {"zooo"})
	@Parameters({"url"})
	public void BasePageNavigation (String website) throws IOException, InterruptedException
	{
		driver=initializeDriver();
		PageObject page =new PageObject(driver);
	driver.get(website);
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	page.Signin().click();
	Thread.sleep(3000);
	
	}
	
	@Test(dataProvider="getData",groups= {"zooo"})
	public void SignInPage(String username, String Password, String content) throws InterruptedException, SQLException
	{
		Statement stat= getdataBaseConnection();
		ResultSet result =stat.executeQuery("select * from Employee_credentials");
		Actions a = new Actions(driver);
		Email email=new Email(driver);
		String usrname="";
		String passwd="";
		//email.emails().sendKeys(username);
		while (result.next()) {
		usrname=result.getString("email");
		passwd=result.getString("pwd");
		}
		email.emails().sendKeys(usrname);
		log.debug("typing email id");
		email.continues().click();
		log.debug("clicked continue");
		Password pwd = new Password(driver);	
		//email.emails().sendKeys(passwd);
		pwd.pwds().sendKeys(passwd);
		log.debug("typed password");
		pwd.submiot().click();
		log.debug("password submitted");
		Thread.sleep(2000);
		//Security sec= new Security(driver);
		//sec.secpwd().sendKeys(Password);
		////String CAptured= sec.Imagecap().getText();
		//System.out.println(CAptured);
		MyAccount myHome = new MyAccount(driver);
		//myHome.RecentOrder().click();
		//Thread.sleep(2000);
		myHome.searchbox.sendKeys(content);
		log.debug("search content typed");
		a.moveToElement(myHome.searchkey).click().build().perform();
		log.debug("searched");
		Thread.sleep(2000);
		myHome.Department().click();
		log.debug("Department selected");
		Thread.sleep(2000);
		myHome.Brands().click();
		log.debug("Brands selected");
		Thread.sleep(2000);
		log.info("search success");
		
		for(WebElement i:myHome.item())
		{
		System.out.println((i.getText()));
		}
		Thread.sleep(2000);
		log.info("brands displayed");
		myHome.selecteddress().click();
		log.debug("baby dress selected");
		Thread.sleep(2000);
		
		Select s = new Select(myHome.selectSize());
		s.selectByIndex(1);
		log.debug("baby dress size selected");
		Thread.sleep(2000);
		String text = myHome.addtocart.getAttribute("value");
		System.out.println(text);
		myHome.addtocart().click();
		log.debug("item added to cart");
		
		Assert.assertEquals(text,"Add to Cart");
		log.info("added to cart successfully");
		
		
	}
	@AfterTest(groups= {"zooo"})
	public void browserClose()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data = new Object[1][3];
		//0th row
		data[0][0] ="margrac1234@yahoo.com";
		data[0][1]="Jesus@123";
		data[0][2]="Dress for baby girl";
		//1st row
		//data[1][0] ="sun.ultimate@gmail.com";
		//data[1][1]="Think4Me";
		
	
		return data;
		
	}
	
}
