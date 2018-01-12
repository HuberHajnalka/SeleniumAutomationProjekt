package TestLink;


import java.io.Console;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import Base.GmailBase;
import Base.TestFunctions;
import PageObjects.GmailLoginPage;
import PageObjects.GmailPage;
import testlink.api.java.client.TestLinkAPIResults;


public class LoginScenario {
	GmailLoginPage gmailLogin;
	
	@Before
	public void initializeLoginPage() throws Exception{
		gmailLogin=new GmailLoginPage();
	}

	@Test
	public void validLogin() throws Exception {
		try {
			GmailPage gmail=gmailLogin.login("SeleniumTestAutomation2018", "Selenium2018");
			gmail.checkPageIdLoaded();
			System.out.println("ValidLogin Test was successfully finished");
			//TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			//TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void invalidUserName() throws Exception {
		try {
			gmailLogin.invalidUserLogin("SeleniumTestAutomation2019");
			System.out.println("Invalid User Login Test was successfully finished");
			//TestLinkIntegration.updateResults("InvalidUserLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			//TestLinkIntegration.updateResults("InvalidUserLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void invalidPassword() throws Exception {
		try {
			gmailLogin.invalidPasswordLogin("SeleniumTestAutomation2018", "Selenium2019");
			System.out.println("Invalid Password Login Test was successfully finished");
			//TestLinkIntegration.updateResults("InvalidPasswordLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			//TestLinkIntegration.updateResults("InvalidPasswordLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.close();
	}
	
}
