package TestLink;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;


public class LoginScenarios {

	public static WebDriver driver;
	public static String url="http://automationpractice.com/index.php";
	
	@Before
	public void openBrowser() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedrivers/2_32/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}
	
	@Test
	public void validLogin() throws Exception {
		try {
			driver.get(url);
			driver.findElement(By.id("contact-linkkk"));
			TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
}
