package Selframe.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class elementCapture {


	WebDriver driver;

	public elementCapture(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	private @FindBy(xpath="//div[@id='nav-xshop']/a")
	List <WebElement>  Elements;
	
	
	private @FindBy(xpath="//div[@id='nav-xshop']/a[3]")
	WebElement  Element3;
	
	public List<WebElement> Elements()
	{
		return Elements;
	}
	
	public WebElement Element()
	{
		return Element3;
	}
	
	
	
}
