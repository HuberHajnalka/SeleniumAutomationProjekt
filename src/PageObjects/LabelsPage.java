package PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Base.TestFunctions;

public class LabelsPage {
	WebDriver driver;
	String createNewLabelButtonPath="//div/button[text()= 'Create new label']";
	String labelTextFieldPath="input[id*='.na']";
	String submitButtonPath="button[name='ok']";
	String removeLabelPath="//*[@class='To']/td[4]/span[1]";

	public LabelsPage(WebDriver driver) throws Exception {
		this.driver = driver;
		TestFunctions.validatePage(this.driver, "Settings");
		System.out.println("Labels page was loaded");
	}
	
	public void createNewLabel(String labelText) throws Exception {
		WebElement createLabel=TestFunctions.waitUntilElementIsClickable(driver, By.xpath(createNewLabelButtonPath), 5);
		createLabel.click();
		WebElement labeltextField=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(labelTextFieldPath), 5);
		labeltextField.clear();
		labeltextField.sendKeys(labelText);
		pressOK();
		if(!checkPopUpMessage("The label \""+labelText+"\" was created.")) {
			throw new Exception(labelText+ " lable was not created");
		}
	}
	
	public void deleteLabel(String labeltext) throws Exception{
		WebElement removeButton=TestFunctions.waitUntilElementIsClickable(driver, By.xpath(removeLabelPath), 5);
		removeButton.click();
		pressOK();
		if(!checkPopUpMessage( "The label \""+labeltext+"\" was removed.")) {
			throw new Exception(labeltext+ "was not deleted");
		}
		
	}
	
	private void pressOK() throws Exception{
		WebElement okButton=TestFunctions.waitUntilElementIsClickable(driver, By.cssSelector(submitButtonPath), 5);
		okButton.click();
		
	}
	
	private boolean checkPopUpMessage(String text) throws Exception {
		Thread.sleep(1000);
		return TestFunctions.checkIfTextPresent(driver, text);
	}

}
