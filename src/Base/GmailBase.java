package Base;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GmailBase {
	
	public static WebDriver driver;
	static String webPage = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

	public  GmailBase() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedrivers/2_33/chromedriver.exe"); //chromedriver 2_33 didn't cause problem at maximize
		ChromeOptions options = new ChromeOptions();
		options.addArguments("en-US");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(webPage);
		
		System.out.println("Gmail is opened.");
		
	}

}
