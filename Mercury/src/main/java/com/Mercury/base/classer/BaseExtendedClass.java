package com.Mercury.base.classer;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mercury.base.Interfac.Browser;
import com.Mercury.base.Interfac.Elements;

public class BaseExtendedClass implements Browser, Elements{
	
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	
	public void click(WebElement e) {
		try {
			wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.click();
		}
		catch(StaleElementReferenceException er) {
			System.out.println("element is not clickable"+ er);
		}
		
	}
	
	public void append(WebElement e, String data) {
		e.sendKeys(data);
		
	}
	public void clear(WebElement e) {
		// TODO Auto-generated method stub
		try {
			e.clear();
		}catch(ElementNotInteractableException er) {
			System.out.println("Element is not interactable" + er);
		}
	}
	public void clearAndType(WebElement e,String data) {
		// TODO Auto-generated method stub
		try {
			e.clear();
			e.sendKeys(data);
			System.out.println(data + "is entered successfully");
		}catch(ElementNotInteractableException er) {
			System.out.println("Element is not interactable" + er);
		}
	}
	public String getElementText(WebElement e) {
		// TODO Auto-generated method stub
		String text=e.getText();
		return text;
	}
	public String getBackgroundColor(WebElement e) {
		// TODO Auto-generated method stub
		String cssValue=e.getCssValue("color");
		return cssValue;
	}
	public String getTypedText(WebElement e) {
		// TODO Auto-generated method stub
		String getAttributeValue=e.getAttribute("value");
		return getAttributeValue;
	}
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		new Select(ele)
		.selectByIndex(index);
	}
	
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		new Select(ele)
		.selectByValue(value);
	}
	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(ele.getText().equals(expectedText)) {
				System.out.println("The Expected and Actual text is matches");
				return true;
				}
			else {
				System.out.println("The expected and Actual text is not matches");
				}
		}
		catch(WebDriverException e) {
			System.out.println("Unknown Exception occured while verify the text");
		}
		
		return false;
	}
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(ele.getText().contains(expectedText)) {
				System.out.println("The Actual text contains the expected text");
				return true;	
				}
			else {
				System.out.println("The Actual text does not contains the expected text");
			}
		}
		catch(WebDriverException e) {
			System.out.println("Unknown Exception occured while verify the text");
		}
		return false;
	}
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				System.out.println("The Actual and Expected Attributes are matches");
				return true;
			}
			else {
				System.out.println("The Actual and Expected Attributes not matches");
			}
		}
		catch(WebDriverException e) {
			System.out.println("Unknown Exception occured while verifying the Attribute");
		}
		return false;
	}
	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			if(ele.getAttribute(attribute).contains(value)) {
				System.out.println("The Actual Attribute contains the Expected Attribute");
				return true;
			}
			else {
				System.out.println("The Actual Attribute not contains the Expected Attribute");
			}
		}
		catch(WebDriverException e) {
			System.out.println("Unknown Exception occured while verifying the Attribute");
		}
		return false;
	}
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isDisplayed()) {
				System.out.println("The Element is visible in the DOM");
				return true;
			}
			else {
				System.out.println("The Element is not visible in the DOM");
			}
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException: " + e.getMessage());
		}
		return false;
	}
	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isDisplayed()==false) {
				System.out.println("The Element is not visible in the DOM");
				return true;
			}
			else {
				System.out.println("The Element is visible in the DOM");
			}
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException: "+ e.getMessage());
		}
		return false;
	}
	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isEnabled()) {
				System.out.println("The Element is enabled in the DOM");
				return true;
			}
			else {
				System.out.println("The Element is not enabled in the DOM");
			}
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException: " + e.getMessage());
		}

		return false;
	}
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isDisplayed()) {
				System.out.println("The Element is selected in the DOM");
			}
			else {
				System.out.println("The Element is not selected in the DOM");
			}
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException: " + e.getMessage());
		}

	}
	public void start_App(String url) {
		// TODO Auto-generated method stub
		
	}
	public void start_App(String browser, String url) {
		// TODO Auto-generated method stub
		
	}
	public WebElement locate_Element(String locatorType, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	public void switch_To_Alert() {
		// TODO Auto-generated method stub
		
	}
	public void accept_Alert() {
		// TODO Auto-generated method stub
		
	}
	public void dismiss_Alert() {
		// TODO Auto-generated method stub
		
	}
	public String get_Alert_Text() {
		// TODO Auto-generated method stub
		return null;
	}
	public void type_Alert(String input) {
		// TODO Auto-generated method stub
		
	}
	public void switch_To_Window(int index) {
		// TODO Auto-generated method stub
		
	}
	public void switch_To_Frame(int index) {
		// TODO Auto-generated method stub
		
	}
	public void default_Content() {
		// TODO Auto-generated method stub
		
	}
	public boolean verify_Title(String title) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean verify_URL(String url) {
		// TODO Auto-generated method stub
		return false;
	}
	public void close() {
		// TODO Auto-generated method stub
		
	}
	public void quit() {
		// TODO Auto-generated method stub
		
	}
	
	
}
