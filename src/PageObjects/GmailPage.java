package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.TestFunctions;


public class GmailPage {
	
	WebDriver driver;
	String writeMailFieldPath="div[class='T-I J-J5-Ji T-I-KE L3']";
	String incominMailButtonPath="a[title*='Inbox']";
	
	public GmailPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Gmail");
	}
	
	public void checkPageIdLoaded() throws Exception {
		WebElement writeMailField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(writeMailFieldPath), 100, "role", "button");
		Assert.assertTrue("Page load check", writeMailField.isEnabled());
	}
	
	public IncomingMailsPage submitIncomingMails() throws Exception {
		WebElement incomingMailButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(incominMailButtonPath), 180);
		incomingMailButton.click();	
		return new IncomingMailsPage(driver);
		
	}


}
