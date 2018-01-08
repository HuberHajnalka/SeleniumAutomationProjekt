package Base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailBase {
	
	public static WebDriver driver;
	static String webPage = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

	public  GmailBase() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedrivers/2_32/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(webPage);
		//driver.manage().window().maximize();
		System.out.println("Gmail is opened.");
	}

}
