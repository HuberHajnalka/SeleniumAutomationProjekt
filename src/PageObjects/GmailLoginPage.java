package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Base.GmailBase;
import Base.TestFunctions;

public class GmailLoginPage extends GmailBase{
	String emailFieldPath = "input[autocomplete='username']";
	String passwordFieldPath = "input[type='password']";
	
	
	public GmailLoginPage() throws Exception {
		TestFunctions.validatePage(GmailBase.driver, "Gmail");
	}
	
	public void login(String email, String password) throws Exception {
		System.out.println("Login is started");
		WebElement emailField =TestFunctions.waitUntilElementPresentInDOM(driver, emailFieldPath, 180,"autocomplete", "username");
		emailField.sendKeys(email);
		System.out.println(email+ " was typed into the username field");
		emailField.sendKeys(Keys.ENTER);
		WebElement passwordField =TestFunctions.waitUntilElementPresentInDOM(driver, passwordFieldPath, 180, "autocomplete", "current-password");
		passwordField.sendKeys(password);
		System.out.println("Password typed into the password field");
		passwordField.sendKeys(Keys.ENTER);
	}

}
