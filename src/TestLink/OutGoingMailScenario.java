package testlink;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageobjects.GmailLoginPage;
import pageobjects.GmailPage;
import pageobjects.OutGoingMailsPage;

public class OutGoingMailScenario {
	
	GmailLoginPage gmailLogin;
	GmailPage gmail;
    OutGoingMailsPage outGoingMail;
	
	@Before
	public void initializeLoginPage() throws Exception{
		gmailLogin=new GmailLoginPage();
		gmail=gmailLogin.login("SeleniumTestAutomation2018", "Selenium2018");

	}
	
	@Test
	public void OutGoingMailPageVerification() throws Exception {
		try {
			outGoingMail=gmail.submitoutGoingMails();
			System.out.println("OutGoingMailPageVerification Test was successfully finished");
		//	TestLinkIntegration.updateResults("ValidLogin", "OutGoingMailPageVerification Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void OutGoingMailPageIconCheck() throws Exception {
		try {
			outGoingMail=gmail.submitoutGoingMails();
			String[] textToCheck= {"Primary", "Social", "Promotions"};
			outGoingMail.checkNotExpectedText(textToCheck);
			System.out.println("OutGoingMailIcon Test was successfully finished");
	
		//	TestLinkIntegration.updateResults("OutGoingMailPageIconCheck", "OutGoingMailIcon Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("OutGoingMailPageIconCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void SearchForSenderCheck() throws Exception {
		try {
			outGoingMail=gmail.submitoutGoingMails();
			outGoingMail.search("me", "From", "1–3 of 3");
			System.out.println("Email(s) were found");
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@Test
	public void SearchForNotInContentCheck() throws Exception {
		try {
			outGoingMail=gmail.submitoutGoingMails();
			outGoingMail.search("test2", "NotInContent", "1–2 of 2");
			System.out.println("Email(s) were found");
		//	TestLinkIntegration.updateResults("ValidLogin", null, TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("ValidLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.quit();



}
}
