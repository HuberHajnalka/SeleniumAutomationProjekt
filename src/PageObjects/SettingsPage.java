package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;

import base.TestFunctions;

public class SettingsPage {
	WebDriver driver;
	String tabsPath="div[class=\"nH fY\"]>div";
	List<WebElement> tabs;
	
	/**
	 * Constructor with page validation and initialize tabs for further usage
	 * @param driver
	 * @throws Exception
	 */
	public SettingsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Settings");
		tabs=driver.findElements(By.cssSelector(tabsPath));
		System.out.println("Settings page was loaded");
	}
	
	/**
	 * Navigate to Labels page
	 * @return
	 * @throws Exception
	 */
	public LabelsPage goToLabels() throws Exception {
		tabs.get(1).click();
		return new LabelsPage(driver);
		
	}
	
	/**
	 * Navigate to Themes page
	 * @return
	 * @throws Exception
	 */
	public ThemePage goToThemes() throws Exception {
		tabs.get(10).click();
		return new ThemePage(driver);
	}

}
