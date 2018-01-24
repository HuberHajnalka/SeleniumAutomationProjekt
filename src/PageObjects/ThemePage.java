package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestFunctions;

public class ThemePage {
	
	WebDriver driver;
	String setThemButtonPath="//a[text()='Set Theme.']";
	String saveButtonPath="//div[text()='Save']";
	
	/**
	 * Constructor with page validation using the title
	 * @param driver
	 * @throws Exception
	 */
	public ThemePage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Settings");
		System.out.println("Themes page was loaded");
	}
	
	/**
	 * Set a new theme with a specific index then return to Settings page
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public SettingsPage setTheme(int index) throws Exception {
		WebElement setTheme=TestFunctions.waitUntilElementIsClickable(driver, By.xpath(setThemButtonPath), 5);
		setTheme.click();
		WebElement image=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector("div[id*='y.custom-"+index+"']"), 5);
		image.click();
		WebElement saveButton=TestFunctions.waitUntilElementIsClickable(driver, By.xpath(saveButtonPath), 5);
		saveButton.click();
		return new SettingsPage(driver);
	}

	
}
