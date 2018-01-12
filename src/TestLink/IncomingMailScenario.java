package TestLink;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import PageObjects.GmailLoginPage;
import PageObjects.GmailPage;
import PageObjects.IncomingMailsPage;
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
	public void IncominMailPageVerification() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			System.out.println("IncominMailPageVerification Test was successfully finished");
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void IncominMailPageIconsCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.primaryIconCheck("Primary"); //id-s changes dinamically
			incomingMail.socialIconCheck("Social");
			incomingMail.promotionsIconCheck("Promotions");
			System.out.println("IncominMailPageIconchekc Test was successfully finished");
			
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void SearchForSubjectCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.search("gmail", "Subject"); //label 'subject is needed in path
			incomingMail.checkResult(2);
			System.out.println("Email(s) were found");
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void SearchForContentCheck() throws Exception {
		try {
			incomingMail=gmail.submitIncomingMails();
			incomingMail.search("gmail", "Content");
			incomingMail.checkResult(5);
			System.out.println("Email(s) were found");
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.close();
	}

}
