package pageobjects;

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

import base.GmailBase;
import base.TestFunctions;


public class IncomingMailsPage{
	
	WebDriver driver;
	String primaryIconPath="div[id=':2l']";
	String socialIconPath="div[id=':2m']";
	String promotionsIconPath="div[id=':2n']";
	String checkBoxesPath="div[class='T-Jo-auh']";
	String moveToFolderPathId=":31";
	String deteleButtonPath="div[class='ar9 T-I-J3 J-J5-Ji']";
	List<WebElement> checkboxes;

	/**
	 * Constructor -validate page and initialize the check boxes on the page for further usage
	 * @param driver
	 * @throws Exception
	 */
	
	public IncomingMailsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Inbox");
		checkboxes=driver.findElements(By.cssSelector(checkBoxesPath));
		System.out.println("Inbox page was loaded");
	}
	
	/**
	 * Check the existence of Primary icon
	 * @param text
	 * @throws Exception
	 */
	public void primaryIconCheck(String text) throws Exception {
		WebElement primaryIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(primaryIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(primaryIcon);
		Assert.assertEquals("PrimaryIcon check", text, primaryIcon.getText());
	}
	
	/**
	 * Check the existence of Social icon
	 * @param text
	 * @throws Exception
	 */
	public void socialIconCheck(String text) throws Exception {
		WebElement socialIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(socialIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(socialIcon);
		Assert.assertEquals("SocialIcon check", text, socialIcon.getText());
		
	}
	
	/**
	 * Check the existence of Promotions icon
	 * @param text
	 * @throws Exception
	 */
	public void promotionsIconCheck(String text) throws Exception {
		WebElement promotionsIcon=TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(promotionsIconPath), 5, "class", "aKz");
		TestFunctions.waitUntilTextPresent(promotionsIcon);
		Assert.assertEquals("PromotionsIcon check", text, promotionsIcon.getText());
		
	}
	
	/**
	 * Search something given the field to serach and the expected results
	 * @param text
	 * @param where
	 * @param result
	 * @throws Exception
	 */
	public void search(String text, String where, String result) throws Exception {
		TestFunctions.searchBase(this.driver, text, where);
		TestFunctions.validatePage(driver, "Search results");
		 if(!TestFunctions.checkIfTextPresent(driver, result)) {
			 System.out.println(result+"was not found");
			 throw new Exception(result+ " was not found");
		 }
	}
	
	/**
	 * Choose one mail or all (index=0)
	 * @param index
	 * @throws Exception
	 */
	private void setCheckBox(int index) throws Exception {
		WebElement selectedCheckBox=checkboxes.get(index);
		if(selectedCheckBox!=null && selectedCheckBox.isEnabled()) {
			selectedCheckBox.click();
		}else {
			throw new Exception("The checkbox is not available");
		}
	}
	
	/**
	 * Moving a mail or all (emialIndex=0) to another folder
	 * The function is extendible
	 * @param emailIndex
	 * @param where
	 * @throws Exception
	 */
	public void moveMailTo(int emailIndex, String where ) throws Exception {
		setCheckBox(emailIndex);
		WebElement moveToFolder=TestFunctions.waitUntilElementIsClickable(driver, By.id(moveToFolderPathId), 5);
		moveToFolder.click();
		switch(where) {
		case "Spam":
			WebElement folder=TestFunctions.waitUntilElementIsClickable(driver, By.xpath("//div[text()='"+where+"']"), 5);
			folder.click();
			TestFunctions.checkIfTextPresent(driver, "The conversation has been marked as spam.");
			break;
		default:
			throw new Exception("The folder: "+where+" doesn't exist");
		}
	}
	
	/**
	 * Moving a mail or all (emialIndex=0)
	 * @param emailIndex
	 * @throws Exception
	 */
	public void deleteMail(int emailIndex ) throws Exception {
		setCheckBox(emailIndex);
		WebElement delete=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(deteleButtonPath), 5);
		delete.click();
		TestFunctions.checkIfTextPresent(driver, "The conversation has been moved to the Trash and will be permanently deleted in 30 days");
		
	}

	

	
		
}
