package Selframe.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Security {

	WebDriver driver;

	public Security(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	/*By Login = By.xpath("//span[contains(text(),'Login')]");
	By email = By.id("user_email");
	By Password = By.id("user_password");*/
	
	
	
	
	private @FindBy(id="ap_password")
	WebElement pwdsec;
	
	private @FindBy (id="auth-captcha-image")
	WebElement imagecap;
	
	public WebElement secpwd ()
	{
		return pwdsec;
	}
	public WebElement Imagecap()
	{
		return imagecap;	
		}
	
	
	
}
