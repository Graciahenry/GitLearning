package Selframe.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	WebDriver driver;

	public PageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	/*By Login = By.xpath("//span[contains(text(),'Login')]");
	By email = By.id("user_email");
	By Password = By.id("user_password");*/
	private @FindBy(xpath="//div[@id='nav-signin-tooltip']//span[contains(text(),'Sign in')]")
	WebElement Signin;
	
	
	
	public WebElement Signin ()
	{
		return Signin;
	}
	
	
	
}
