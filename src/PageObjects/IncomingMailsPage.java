package PageObjects;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.GmailBase;
import Base.TestFunctions;


public class IncomingMailsPage{
	
	WebDriver driver;
	String primaryIconPath="div[id=':2l']";
	String socialIconPath="div[id=':2m']";
	String promotionsIconPath="div[id=':2n']";


	
	public IncomingMailsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Inbox");
	}
	
	public void primaryIconCheck(String text) throws Exception {
		WebElement primaryIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(primaryIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(primaryIcon);
		Assert.assertEquals("PrimaryIcon check", text, primaryIcon.getText());
	}
	
	public void socialIconCheck(String text) throws Exception {
		WebElement socialIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(socialIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(socialIcon);
		Assert.assertEquals("SocialIcon check", text, socialIcon.getText());
		
	}
	
	public void promotionsIconCheck(String text) throws Exception {
		WebElement promotionsIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(promotionsIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(promotionsIcon);
		Assert.assertEquals("PromotionsIcon check", text, promotionsIcon.getText());
		
	}
	
	public void search(String text, String where, String result) throws Exception {
		TestFunctions.searchBase(this.driver, text, where);
		TestFunctions.validatePage(driver, "Search results");
		 if(!TestFunctions.checkIfTextPresent(driver, result)) {
			 throw new Exception(result+ " was not found");
		 }
	}
	


	

	

	
		
}
