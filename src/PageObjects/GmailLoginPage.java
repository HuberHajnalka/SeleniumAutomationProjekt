package pageobjects;

import java.io.StringWriter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.GmailBase;
import base.TestFunctions;


public class GmailLoginPage extends GmailBase{
	
	String emailFieldPath = "input[autocomplete='username']";
	String passwordFieldPath = "input[type='password']";
	String userFieldPath="div[id=':5.mn']";
	String passwordErrorPath="//*[@id='password']/div[2]/div[2]";
	String userErrorPath="//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/form/content/div[1]/div/div[2]/div[2]";

	/**
	 * Constuctor and validation of the page based on title
	 * @throws Exception
	 */
	
	public GmailLoginPage() throws Exception {
		TestFunctions.validatePage(this.driver, "Gmail");
	}
	
	/**
	 * Function to login
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public GmailPage login(String email, String password) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		typePassword(password);
		return new GmailPage(driver);
	}
	
	/**
	 * Function to check invalid username/email
	 * @param email
	 * @throws Exception
	 */
	
	public void invalidUserLogin(String email) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		WebElement errorText =TestFunctions.waitUntilElementPresentInDOM(driver, By.xpath(userErrorPath), 5,"jsname", "B34EJ");
		TestFunctions.waitUntilTextPresent(errorText);
		Assert.assertEquals("Invalid email check", "Couldn't find your Google Account", errorText.getText());
		
	}
	/**
	 * Function to check invalid password
	 * @param email
	 * @param password
	 * @throws Exception
	 */
	
	public void invalidPasswordLogin(String email, String password) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		typePassword(password);
		WebElement errorText =TestFunctions.waitUntilElementPresentInDOM(driver, By.xpath(passwordErrorPath), 5,"jsname", "B34EJ");
		TestFunctions.waitUntilTextPresent(errorText);
		Assert.assertEquals("Invalid password check", "Wrong password. Try again or click Forgot password to reset it.", errorText.getText());
		
	}
	
	/**
	 * Function to type email/username
	 * @param email
	 * @throws Exception
	 */
	
	private void typeEmail(String email) throws Exception {
		WebElement emailField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(emailFieldPath), 5,"autocomplete", "username");
		emailField.sendKeys(email);
		System.out.println(email+ " was typed into the username field");
		emailField.sendKeys(Keys.ENTER);
	}
	/**
	 * Function to type password
	 * @param password
	 * @throws Exception
	 */
	private void typePassword(String password) throws Exception {
		WebElement passwordField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(passwordFieldPath), 5, "autocomplete", "current-password");
		passwordField.sendKeys(password);
		System.out.println("Password typed into the password field");
		passwordField.sendKeys(Keys.ENTER);
	}

}
