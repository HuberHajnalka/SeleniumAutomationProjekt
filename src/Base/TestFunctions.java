package Base;

import java.io.StringWriter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestFunctions {
	
	public static String log(StringWriter writer, String textToAppend) {
		writer.append("/n "+textToAppend);
		return writer.toString();
	}
	
	public static void validatePage(WebDriver driver, String pageName) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 180);
		try {
			wait.until(ExpectedConditions.titleContains(pageName));
		}catch(Exception e){
			System.out.println("Validation of the Page is failed");
		}
	}
	
	/**
	 * This function waits for a web element to be present in the DOM. . Throw an exception if the web element is not found.
	 * 
	 * @param waitElement
	 * @param elementBylocator
	 * @param timeout
	 * @throws Exception
	 */
	public static WebElement waitUntilElementPresentInDOM(WebDriver driver, By locator, int timeout, String attribute, String attributeValue) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element=null;
		try {
			wait.until(ExpectedConditions.attributeContains(locator, attribute, attributeValue));
			element=driver.findElement(locator);

		}catch(Exception e){
			System.out.println("Element is not present");
		}
		return element;
	}
	

	
	/**
	 * This function waits if text is not presented but elemnt is availble
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
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			element=driver.findElement(locator);	

		}catch(Exception e){
			System.out.println("Element is not present");
		}
		return element;
	}
	
	/**
	 * Scroll the element into view. This function is needed because the web element is clickable only in view. The parameter can be xpath or a web element.
	 * 
	 * @param driver
	 * @param xPath
	 * @return
	 * @throws InterruptedException
	 */
	public static void scrollToElement(WebDriver driver, WebElement element) throws InterruptedException {
		Thread.sleep(800);
		String scroll = "";
		String elementId = element.getAttribute("id");
		if (elementId.isEmpty()) {
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			scroll = String.format("window.scroll(%s, %s)", x, y);
		}
		else {
			scroll = "element = document.getElementById('" + elementId + "');element.scrollIntoView(true);";
		}
		ExecuteJs(driver, scroll);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(800);
	}
	
	/**
	 * This function is used when a Javascript is sent without a return statement.
	 * 
	 * @param driver
	 * @param JsQuery
	 */
	public static void ExecuteJs(WebDriver driver, final String JsQuery) {
		try {
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript(JsQuery);
		((JavascriptExecutor) driver)
				.executeScript("console.log('JS executed: " + JsQuery.replace("'", "\\\"") + "');");

	}
	
	

}
