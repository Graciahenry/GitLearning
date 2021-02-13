package Selframe.Framework;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base {
	public WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sunul\\eclipse-workspace\\Framework\\src\\main\\java\\Selframe\\Framework\\Globalvariables.properties");
		prop.load(fis);
		String browserType= prop.getProperty("browser");
		if (browserType.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browserType.contains("headless"))
			{
			options.addArguments("headless");
			}
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunul\\OneDrive\\Desktop\\data analytics\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
		else if (browserType.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sunul\\OneDrive\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
	Thread.sleep(2000);
	return driver;
	
	
	
	}
	
	public String getScreenShotPath(String testCasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCasename+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
	}
	
	
	  public static ExtentReports Reports() {
	 
	 String path = System.getProperty("user.dir")+"\\reports\\index.html";
	 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	 reporter.config().setReportName("Webautomation");
	 reporter.config().setDocumentTitle("Test results");
	 ExtentReports extent = new ExtentReports(); 
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Maria Gracia" , "Test Lead"); 
	 return extent;
	 }
	 
	public Statement getdataBaseConnection() throws SQLException
	{
		String localhost = "localhost";
		String port = "3306";
		
		
		Connection con =DriverManager.getConnection( "jdbc:mysql://"+localhost+":"+port+"/qa", "root", "Jesus@123");
		Statement s = con.createStatement();
		//ResultSet result =s.executeQuery("select name, location from Employee_info where id='1';");
		return s;
	}
}
