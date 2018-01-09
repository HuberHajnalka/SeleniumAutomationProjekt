package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.TestFunctions;


public class GmailPage {
	
	WebDriver driver;
	String writeMailFieldPath="div[class=\"T-I J-J5-Ji T-I-KE L3\"]";
	
	public GmailPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Gmail");
	}
	
	public void checkPageIdLoaded() throws Exception {
		WebElement writeMailField =TestFunctions.waitUntilElementPresentInDOMWithCSS(driver, writeMailFieldPath, 100, "role", "button");
		Assert.assertTrue("Page load check", writeMailField.isEnabled());
	}


}
