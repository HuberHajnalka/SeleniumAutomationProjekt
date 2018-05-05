package testlink;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pageobjects.GmailLoginPage;
import pageobjects.GmailPage;
import pageobjects.IncomingMailsPage;
import testlink.api.java.client.TestLinkAPIResults;

public class IncomingMailScenario {
	
	GmailLoginPage gmailLogin;
	GmailPage gmail;
	IncomingMailsPage incomingMail;
	
	@Before
	public void initializeLoginPage() throws Exception{
		gmailLogin=new GmailLoginPage();
		gmail=gmailLogin.login("SeleniumTestAutomation2018", "Selenium2018");

	}

	@Test
	public void IncomingMailPageVerification() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			System.out.println("IncominMailPageVerification Test was successfully finished");
			TestLinkIntegration.updateResults("IncomingMailPageVerification", "IncominMailPageVerification Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("IncomingMailPageVerification", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void IncomingMailPageIconsCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.primaryIconCheck("Primary"); 
			incomingMail.socialIconCheck("Social");
			incomingMail.promotionsIconCheck("Promotions");
			System.out.println("IncominMailPageIconcheck Test was successfully finished");	
			TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", "IncominMailPageIconcheck Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void SearchForSubjectCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.search("gmail", "Subject", "1–2 of 2"); 
			System.out.println("Email(s) were found");
			TestLinkIntegration.updateResults("SearchForSubjectCheck", "Email(s) were found", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("SearchForSubjectCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void SearchForContentCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.search("gmail", "Content", "1–9 of 9");
			System.out.println("Email(s) were found");
			TestLinkIntegration.updateResults("SearchForContentCheck", " 1–8 of 8 email(s) were found", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {	
			TestLinkIntegration.updateResults("SearchForContentCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.close();
	}

}
