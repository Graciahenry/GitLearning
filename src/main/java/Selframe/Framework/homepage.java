package Selframe.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	WebDriver driver;

	public homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	/*By Login = By.xpath("//span[contains(text(),'Login')]");
	By email = By.id("user_email");
	By Password = By.id("user_password");*/
	@FindBy(xpath="//div[@id='nav-signin-tooltip']//span[contains(text(),'Sign in')]")
	WebElement Signin;
	
	private @FindBy(id="ap_email")
	WebElement email;
	
	private @FindBy(id="continue")
	WebElement conti;
	
	private @FindBy(id="ap_password")
	WebElement pwd;
	
	public WebElement Signin ()
	{
		return Signin;
	}
	public WebElement emails()
	{
		return email;	
		}
	public WebElement continues()
	{
		return conti;
	}
	
	public WebElement pwds()
	{
		 return pwd;
	}
	
	
}
