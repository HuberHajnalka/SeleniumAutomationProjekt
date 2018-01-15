package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.GmailBase;
import Base.TestFunctions;

public class OutGoingMailsPage{
	WebDriver driver;
	String searchOptionsPath="div[data-tooltip='Show search options']";
	
	/**
	*constuctor with page validation
	 * @param driver
	 * @throws Exception
	 */
	public OutGoingMailsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Sent Mail");
	}
	
	/**
	 * function to check the not expected page text elements
	 * @param textToCheck
	 * @throws Exception
	 */
	
	public void checkNotExpectedText(String[] textToCheck) throws Exception {
		for( String text: textToCheck) {
			if(TestFunctions.checkIfTextPresent(driver, text)) {
				Assert.assertFalse(text+ " should not be present",true);
				throw new Exception();
	
			}
		}
	}
	
	public void search(String text, String where, String result) throws Exception {
		TestFunctions.searchBase(this.driver, text, where);
		TestFunctions.validatePage(driver, "Search results");
		 if(!TestFunctions.checkIfTextPresent(driver, result)) {
			 throw new Exception(result+ " was not found");
		 }
	}
	

	

}
