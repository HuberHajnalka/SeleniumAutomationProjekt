package PageObjects;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.TestFunctions;


public class IncomingMailsPage {
	
	WebDriver driver;
	String primaryIconPath="div[id=':2l']";
	String socialIconPath="div[id=':2m']";
	String promotionsIconPath="div[id=':2n']";
	String searchOptionsPath="div[data-tooltip='Show search options']";
	String subjectTextPath=":6e";
	String contentTextPath=":6b";
	String messageXpath = "//table[contains(@class,'F cf zt')])[1]//tbody//tr";;
	
	public IncomingMailsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Inbox");
	}
	
	public void primaryIconCheck(String text) throws Exception {
		WebElement primaryIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(primaryIconPath), 1000, "class", "aKz");
		TestFunctions.waitUntilTextPresent(primaryIcon);
		Assert.assertEquals("PrimaryIcon check", text, primaryIcon.getText());
	}
	
	public void socialIconCheck(String text) throws Exception {
		WebElement socialIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(socialIconPath), 1000, "class", "aKz");
		TestFunctions.waitUntilTextPresent(socialIcon);
		Assert.assertEquals("SocialIcon check", text, socialIcon.getText());
		
	}
	
	public void promotionsIconCheck(String text) throws Exception {
		WebElement promotionsIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(promotionsIconPath), 1000, "class", "aKz");
		TestFunctions.waitUntilTextPresent(promotionsIcon);
		Assert.assertEquals("PromotionsIcon check", text, promotionsIcon.getText());
		
	}
	
	private void selectSearchOptions() {
		WebElement searchOptionsButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(searchOptionsPath), 2000);
		searchOptionsButton.click();
	
	}
	/**
	 * Searching text in the given place (extendable options)
	 * 
	 * @param text
	 * @param where
	 * @throws Exception
	 */
	
	public void search(String text, String where) {
		String path;
		selectSearchOptions();
		System.out.println("Advanced search option was clicked");
		switch (where) {
		case "Subject":
			path=subjectTextPath;
			typeTextToSearch(text, path);
			break;
		case "Content":
			path=contentTextPath;
			typeTextToSearch(text, path);
			break;
		}	
		
	}
	

	
	public void typeTextToSearch( String text, String path) {
		WebElement textField= TestFunctions.waitUntilElementIsClickable(driver, By.id(path), 2000);
		textField.clear();
		textField.sendKeys(text);
		textField.sendKeys(Keys.ENTER);
		System.out.println(text+ " was searched");
	}


	
	public void checkResult(int expectedNumber) throws Exception {
		WebElement number=driver.findElement(By.xpath("//span[text()='"+expectedNumber+"']")); //the id-s and all of the attribute values are dynamically changes
		int elementNumber=Integer.parseInt(number.getText());
		Assert.assertEquals("Numbers of the found email",expectedNumber, elementNumber);
	}
	
		
}
