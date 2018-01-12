package PageObjects;

import java.io.StringWriter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Base.GmailBase;
import Base.TestFunctions;


public class GmailLoginPage extends GmailBase{
	
	String emailFieldPath = "input[autocomplete='username']";
	String passwordFieldPath = "input[type='password']";
	String userFieldPath="div[id=':5.mn']";
	String passwordErrorPath="//*[@id='password']/div[2]/div[2]"; //two elements have the same id and parameters, only the absolute path was usable as text independent search
	String userErrorPath="//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]";

	
	
	public GmailLoginPage() throws Exception {
		TestFunctions.validatePage(this.driver, "Gmail");
	}
	
	public GmailPage login(String email, String password) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		typePassword(password);
		return new GmailPage(driver);
	}
	
	public void invalidUserLogin(String email) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		WebElement errorText =TestFunctions.waitUntilElementPresentInDOM(driver, By.xpath(userErrorPath), 180,"jsname", "B34EJ");
		TestFunctions.waitUntilTextPresent(errorText);
		Assert.assertEquals("Invalid email check", "Couldn't find your Google Account", errorText.getText());
		
	}
	
	public void invalidPasswordLogin(String email, String password) throws Exception {
		System.out.println("Login is started");
		typeEmail(email);
		typePassword(password);
		WebElement errorText =TestFunctions.waitUntilElementPresentInDOM(driver, By.xpath(passwordErrorPath), 180,"jsname", "B34EJ");
		TestFunctions.waitUntilTextPresent(errorText);
		Assert.assertEquals("Invalid password check", "Wrong password. Try again or click Forgot password to reset it.", errorText.getText());
		
	}
	
	public void typeEmail(String email) throws Exception {
		WebElement emailField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(emailFieldPath), 180,"autocomplete", "username");
		emailField.sendKeys(email);
		System.out.println(email+ " was typed into the username field");
		emailField.sendKeys(Keys.ENTER);
	}
	
	public void typePassword(String password) throws Exception {
		WebElement passwordField =TestFunctions.waitUntilElementPresentInDOM(driver, By.cssSelector(passwordFieldPath), 500, "autocomplete", "current-password");
		passwordField.sendKeys(password);
		System.out.println("Password typed into the password field");
		passwordField.sendKeys(Keys.ENTER);
	}

}
