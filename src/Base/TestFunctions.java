package Base;

import java.io.StringWriter;
import java.util.Date;

import org.openqa.selenium.By;
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
			wait.until(ExpectedConditions.titleIs(pageName));
		}catch(Exception e){
			System.out.println("Validation of the Page is failed");
		}
	}
	
	/**
	 * This function waits for a web element to be present in the DOM. . Throw an exception if the web element is not found.
	 * 
	 * @param waitElement
	 * @param elementCssselector
	 * @param timeout
	 * @throws Exception
	 */
	public static WebElement waitUntilElementPresentInDOMWithCSS(WebDriver driver, String locator, int timeout, String attribute, String attributeValue) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element=null;
		try {
			wait.until(ExpectedConditions.attributeContains(By.cssSelector(locator), attribute, attributeValue));
			element=driver.findElement(By.cssSelector(locator));

		}catch(Exception e){
			System.out.println("Element is not present");
		}
		return element;
	}
	
	/**
	 * This function waits for a web element to be present in the DOM. . Throw an exception if the web element is not found.
	 * 
	 * @param waitElement
	 * @param elementXpath
	 * @param timeout
	 * @throws Exception
	 */
	public static WebElement waitUntilElementPresentInDOMWithXPATH(WebDriver driver, String locator, int timeout, String attribute, String attributeValue) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element=null;
		try {
			wait.until(ExpectedConditions.attributeContains(By.xpath(locator), attribute, attributeValue));
			element=driver.findElement(By.xpath(locator));

		}catch(Exception e){
			System.out.println("Element is not present");
		}
		return element;
	}
	
	public static void waitUntilTextPresent(WebElement element, String text) throws InterruptedException {
		if(element.getText().isEmpty()) Thread.sleep(1200);
	}

}
