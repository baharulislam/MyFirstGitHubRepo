package SamplePackage;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Start {
	
	public WebDriver driver;

  
  @BeforeTest
  public void InitiateWebdriver() throws MalformedURLException {
	  System.out.println("InitiateWebdriver - beforeTest is executing");
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  driver = new FirefoxDriver(capabilities);
	  driver.get("https://10.176.237.41/");
	  System.out.println("The browser of the title is " + driver.getTitle());
	  //System.out.println("Browser has opened.");
  }
  
	
  @Test
  public void MainTest() throws InterruptedException {
	  
	
		//opting paytm mobile website...
	  System.out.println("MainTest - @Test is executing");
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total No of links " + links.size()); 
		/*for (int i = 1; i<=links.size(); i=i+1) 
		{ 
			System.out.println("Total no of links" + links.get(i).getText());
		}*/
	
		Thread.sleep(5000);
		System.out.println("The browser of the title is " + " + driver.getTitle() + " );
		
		
	
	/*  driver.get("https://www.facebook.com/login/");
	  Thread.sleep(2000);
	  driver.findElement(By.id("email")).sendKeys("Baharul87@gmail.com");
	  driver.findElement(By.name("pass")).sendKeys("8870922370");
	  driver.findElement(By.name("login")).click();*/
	  
	  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}





