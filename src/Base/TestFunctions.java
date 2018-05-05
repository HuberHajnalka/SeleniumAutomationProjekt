package base;


import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestFunctions {

	/**
	 * Search paths since they are available everywhere, so common using is possible
	 */
	static String searchOptionsPath="div[data-tooltip='Show search options']";
	static String advancedOptionsInbox="//*[@type='text' and contains(@id,':6')]";
	static String advancedOptionsSentMail="//*[@type='text' and contains(@id,':')]";
	
	public static void validatePage(WebDriver driver, String pageName) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(pageName));

	}
	
	/**
	 * This function waits for a web element to be present in the DOM.Throw an exception if the web element is not found.
	 * 
	 * @param waitElement
	 * @param elementBylocator
	 * @param timeout
	 * @throws Exception
	 */
	public static WebElement waitUntilElementPresentInDOM(WebDriver driver, By locator, int timeout, String attribute, String attributeValue) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	
		WebElement element=null;
			wait.until(ExpectedConditions.attributeContains(locator, attribute, attributeValue));
			element=driver.findElement(locator);
        return element;
	}
	

	
	/**
	 * This function waits if text is presented on the screen
	 * 
	 * @param element
	 */
	
	public static void waitUntilTextPresent(WebElement element) throws InterruptedException {
		if(element.getText().isEmpty()) Thread.sleep(1200);
	}
	
	/**
	 * This function waits for element to be clickable
	 * 
	 * @param driver
	 * @param locator
	 * @param timeout
	 */
	
	public static WebElement waitUntilElementIsClickable(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element=null;
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element=driver.findElement(locator);	

		return element;
	}
	/**
	 * This function waits for the body tag is loaded, then check the text existence
	 * @param driver
	 * @param locator
	 * @param text
	 * @return
	 * @throws InterruptedException 
	 */
	
	public static boolean checkIfTextPresent(WebDriver driver, String text) throws InterruptedException {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText.contains(text);
	}
	
	/**
	 * Searching text in the given place (extendible options)
	 * 
	 * @param text
	 * @param where
	 * @throws Exception
	 */
	
	public static void searchBase(WebDriver driver, String text, String where) throws Exception {
		selectSearchOptions(driver);
		System.out.println("Advanced search option was clicked");
		List<WebElement> options=new ArrayList<>();
		options=driver.findElements(By.xpath(advancedOptionsInbox));
		//check needed regarding on page
		if(options.size()==0) {
			options=driver.findElements(By.xpath(advancedOptionsSentMail));
		}
		switch (where) {
		case "From":
			typeTextToSearch(text, options.get(1));
			break;
		case "To":
			typeTextToSearch(text, options.get(2));
			break;
		case "Subject":
			typeTextToSearch(text, options.get(3));
			break;
		case "Content":
			typeTextToSearch(text, options.get(4));
			break;
		case "NotInContent":
			typeTextToSearch(text, options.get(5));
			break;
		default:
			throw new Exception("search based "+where+" not possible");
		}	
		
	}
	
	/**
	 * Find and click to the advanced select option
	 */
	
	private static void selectSearchOptions(WebDriver driver) {
		WebElement searchOptionsButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(searchOptionsPath), 5);
		searchOptionsButton.click();
	
	}
	
	/**
	 * function to type in the textField the text to search
	 * @param text
	 * @param textField
	 */
	private static void typeTextToSearch( String text, WebElement textField) {
		textField.clear();
		textField.sendKeys(text);
		textField.sendKeys(Keys.ENTER);
		System.out.println(text+ " was searched");
	}


	

}
