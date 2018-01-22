package TestLink;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import PageObjects.GmailLoginPage;
import PageObjects.GmailPage;
import PageObjects.IncomingMailsPage;
import PageObjects.LabelsPage;
import PageObjects.SettingsPage;
import PageObjects.ThemePage;
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
			//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", "IncominMailPageIconcheck Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
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
			//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", "IncominMailPageIconcheck Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void ChangeBackground() throws Exception {
		try {
			SettingsPage settings=gmail.submitSettings();
			ThemePage themesPage=settings.goToThemes();
			themesPage.setTheme(2); //it is always a new one
			System.out.println("Setting of a theme test was successfully finished");
			//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", "IncominMailPageIconcheck Test was successfully finished", TestLinkAPIResults.TEST_PASSED);
		}catch(Exception e) {
		//	TestLinkIntegration.updateResults("IncomingMailPageIconsCheck", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	@After
	public void closeBrowser() {
		GmailLoginPage.driver.close();
	}

}
