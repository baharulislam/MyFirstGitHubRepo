package SamplePackage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Main {
	

public WebDriver driver;
	 
  @BeforeTest
  public void sample() throws MalformedURLException{
	  System.out.println("Hi Checking reportNg file format");  
	  String deviceName = "Apple iPhone 6";
	  String binaryPath = "C:/Users/baharulislam.khan/AppData/Local/Chromium/Application/chrome.exe";
	  //String binaryPath = "/usr/bin/chromium-browser";
	  System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	  Map<String, String> mobileEmulation = new HashMap<String, String>();
	  mobileEmulation.put("deviceName", deviceName);	  
	  Map<String, Object> Options = new HashMap<String, Object>();
	  Options.put("binary", binaryPath);
	  Options.put("mobileEmulation", mobileEmulation); 
	  DesiredCapabilities dc = DesiredCapabilities.chrome();
	  dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  dc.setCapability(ChromeOptions.CAPABILITY, Options);	  
	  
	  driver = new RemoteWebDriver(new URL("http://localhost:5556/wd/hub"),dc);	
  }
  
  
  @Test
  public void f() throws InterruptedException {
	  
	
		//opting paytm mobile website...
	  driver.get("http://target.com/");
	  System.out.println("The browser of the title is " + driver.getTitle());
	  System.out.println("MainTest - @Test is executing");
	  
	  	driver.findElement(By.xpath("//*[@data-text='my account']")).click();
	    //driver.findElement(By.xpath("//*[@class='a11y-focus']")).click();
	  	driver.findElement(By.xpath("//*[@id='rightNav-signIn']")).click();
	  	driver.findElement(By.xpath("//div[@class='modal-nav modal-right modal-shown in']/div[@id='gam-guest-registration']")).click();
	  	driver.findElement(By.xpath("//*[@id='newEmailSide']")).sendKeys("bismi_87@yahoo.co.in");
	  	driver.findElement(By.xpath("//*[@id='firstNameSide']")).sendKeys("baharul islam");
	  	driver.findElement(By.xpath("//*[@id='lastNameSide']")).sendKeys("Leeyakat Ali Khan");
	  	driver.findElement(By.xpath("//*[@id='logonPasswordSide']")).sendKeys("bismillah");
	  	driver.findElement(By.xpath("//*[@id='passwordToggle']")).click();
	  	driver.findElement(By.xpath("//*[@name='createaccount']")).click();

	  	
	  	Thread.sleep(5000);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total No of links " + links.size()); 
		/*for (int i = 1; i<=links.size(); i=i+1) 
		{ 
			System.out.println("Total no of links" + links.get(i).getText());
		}*/
		Thread.sleep(5000);
		System.out.println("The browser of the title is " + " + driver.getTitle() + " );

	  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  
  
  
}



