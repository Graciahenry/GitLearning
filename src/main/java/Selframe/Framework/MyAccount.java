package Selframe.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {



	WebDriver driver;

	public MyAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	/*By Login = By.xpath("//span[contains(text(),'Login')]");
	By email = By.id("user_email");
	By Password = By.id("user_password");*/
	@FindBy(xpath="//div[@id='7xDU8MmGH4hMmIgM-hrl7Q']/div[2]/a")
	WebElement RecentOrder;
	
	 @FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	 @FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchkey;
	private @FindBy (xpath="//div[@id='departments']/div/following-sibling::ul/li[5]")
	WebElement Department;
	
	private @FindBy(xpath="//div[@id='brandsRefinements']/div[1]/following-sibling::ul[1]/li[2]")
	WebElement brands;
	
	private @FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div//div/span/div/div//div[@class='a-section a-spacing-none a-spacing-top-small']/div/h5")
	List<WebElement> items;
	
	private @FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[5]//div/span/div/div//div[@class='a-section a-spacing-none a-spacing-top-small']/h2/a")
	WebElement dress;
	
	@FindBy(id="add-to-cart-button")
	WebElement addtocart;
	
	private @FindBy(id="native_dropdown_selected_size_name")
	WebElement size;
	public WebElement RecentOrder ()

	{
		return RecentOrder;
	}

	public WebElement SearchBox()
	{
		return searchbox;
	}
	
	public WebElement Department()
	{
		return Department;
	}
	
	public WebElement Brands()
	{
		return brands;
	}
	
	
	public WebElement Key()
	{
		return searchkey;
	}
	
	
	public List<WebElement> item()
	{
		return items;
	}
	
	public WebElement selecteddress()
	{
		return dress;
	}
	
	public WebElement selectSize()
	{
		return size;
	}
	
	public WebElement addtocart()
	{
		return addtocart;
	}
}

