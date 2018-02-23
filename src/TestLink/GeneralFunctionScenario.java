package testlink;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pageobjects.GmailLoginPage;
import pageobjects.GmailPage;
import pageobjects.IncomingMailsPage;
import pageobjects.LabelsPage;
import pageobjects.SettingsPage;
import pageobjects.ThemePage;
import testlink.api.java.client.TestLinkAPIResults;

public class GeneralFunctionScenario {
	
	GmailLoginPage gmailLogin;
	GmailPage gmail;
	IncomingMailsPage incomingMail;
	
	@Before
	public void initializeLoginPage() throws Exception{
		gmailLogin=new GmailLoginPage();
		gmail=gmailLogin.login("SeleniumTestAutomation2018", "Selenium2018");

	}


	
	@Test
	public void GeneralGmailPageIconsCheck() throws Exception {
		try {
			String[] icons= {"Starred", "Sent Mail", "Inbox", "Drafts"};
			gmail.checkIcons(icons);
			gmail.getMoreOptions();
			gmail.moveMouseTo("More"); //it works only on the primary screen
			String[] moreIcons= {"Important", "Chats", "All Mail", "Spam", "Trash"};
			gmail.checkIcons(moreIcons);
			System.out.println("GmailPageIconcheck Test was successfully finished");	
				TestLinkIntegration.updateResults("GeneralGmailPageIconsCheck", "GmailPageIconcheck Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		    	TestLinkIntegration.updateResults("GeneralGmailPageIconsCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void CreateLabelTest() throws Exception {
		try {
			SettingsPage settings=gmail.submitSettings();
			LabelsPage labelsPage=settings.goToLabels();
			labelsPage.createNewLabel("test2018");
			System.out.println("test2018 label was successfully created");	
			labelsPage.deleteLabel("test2018");
			System.out.println("test2018 label was successfully deleted \n"
					+ " Setting of labels test was successfully finished");
			TestLinkIntegration.updateResults("CreateLabelTest", "Setting of labels test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("CreateLabelTest", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void ChangeBackgroundTest() throws Exception {
		try {
			SettingsPage settings=gmail.submitSettings();
			ThemePage themesPage=settings.goToThemes();
			settings=themesPage.setTheme(2); //it is always a new one
			System.out.println("Setting of a new theme test was successfully finished");			
			TestLinkIntegration.updateResults("ChangeBackgroundTest", "Setting of a new theme test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("ChangeBackgroundTest", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void MoveMailTest() throws Exception {
		try {
			IncomingMailsPage incomingMails=gmail.submitIncomingMails();
			incomingMails.moveMailTo(2, "Spam");
			incomingMails.deleteMail(2);
			System.out.println("Moving a mail test was successfully finished");	
			TestLinkIntegration.updateResults("MoveMailTest", "Moving a mail test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("MoveMailTest", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void DeleteMailTest() throws Exception {
		try {
			IncomingMailsPage incomingMails=gmail.submitIncomingMails();
			incomingMails.deleteMail(2);
			System.out.println("Delete a mail test was successfully finished");	
			TestLinkIntegration.updateResults("DeleteMailTest", "Delete a mail test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
			TestLinkIntegration.updateResults("DeleteMailTest", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.close();
	}

}
