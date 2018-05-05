package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;

import base.TestFunctions;


public class GmailPage {
	
	WebDriver driver;
	String writeMailFieldPath="div[class='T-I J-J5-Ji T-I-KE L3']";
	String incominMailButtonPath="a[title*='Inbox']";
	String outGoingMailButtonPath="a[title='Sent Mail']";
	String moreOptionsPath="#\\3a 4g > span.CJ";
	String settingsPath="//*[@class='Cr aqJ']/div[3]/div[1]/div/div";
	String optionSettingsPath="div[id=\"ms\"]>div";

	
	/**
	 * Constuctor with page vaildation based on title
	 * @param driver
	 * @throws Exception
	 */
	
	public GmailPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Gmail");
		System.out.println("Login was successfully finished\n");
	}
	
	/**
	 * Check a specific icon to see if the page is loaded
	 * @throws Exception
	 */
	public void checkPageIsLoaded() throws Exception {
		WebElement writeMailField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(writeMailFieldPath), 5, "role", "button");
		Assert.assertTrue("Page load check", writeMailField.isEnabled());
	}
	
	/**
	 * Load incoming mails page (Inbox)
	 * @return
	 * @throws Exception
	 */
	public IncomingMailsPage submitIncomingMails() throws Exception {
		WebElement incomingMailButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(incominMailButtonPath), 5);
		incomingMailButton.click();	
		return new IncomingMailsPage(driver);
		
	}
	
	/**
	 * load ootgoing mail page (Sent Mail)
	 * @return
	 * @throws Exception
	 */
	public OutGoingMailsPage submitoutGoingMails() throws Exception {
		WebElement outgoingMailButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(outGoingMailButtonPath), 5);
		outgoingMailButton.click();	
		return new OutGoingMailsPage(driver);
	}
	
	/**
	 * Function test the existence of the icons, which should be shown on the page
	 * @param iconNames - list of the expected names of the icons
	 * @throws Exception
	 */
	
	public void checkIcons(String[] iconNames) throws Exception{
		for(String iconName:iconNames) {
			WebElement icon=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector("a[title*='"+iconName+"']"), 5);
			Assert.assertTrue("Check of the icon: "+iconName, icon.getText().contains(iconName));
			System.out.println(iconName+" was found");
		}
	}
	
	/**
	 * Click on more to see the hidden folders and labels
	 * @throws Exception
	 */
	public void getMoreOptions() throws Exception{
		WebElement moreOptionsButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(moreOptionsPath), 5);
		moreOptionsButton.click();	
	}
	
	/**
	 * Function to simulate the mouse movement to see hidden parts of the page
	 * The function is extensible
	 * @param text
	 * @throws Exception
	 */
	
	public void moveMouseTo(String text) throws Exception {
		 Actions action = new Actions(driver);

			switch(text) {
			case "More":
				  action.moveToElement(driver.findElement(By.cssSelector(moreOptionsPath)));
				  action.perform();
				  break;
			default: 
				System.out.println("move the mosue to "+text+" is not possible");
				throw new Exception("move the mosue to "+text+" is not possible");
			}

	}
	
	/**
	 * load settings page
	 * @return
	 * @throws Exception
	 */
	public SettingsPage submitSettings() throws Exception {
		WebElement settings=TestFunctions.waitUntilElementIsClickable(driver, By.xpath(settingsPath), 5);
		settings.click();
		WebElement optionsettings=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(optionSettingsPath), 5);
		optionsettings.click();
		
		return new SettingsPage(driver);
		
	}
 

}
