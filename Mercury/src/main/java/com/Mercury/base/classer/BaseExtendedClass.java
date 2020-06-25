package com.Mercury.base.classer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		driver.get(url);
		
	}
	public void start_App(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver","./drivers/firefoxdriver.exe");
				driver= new FirefoxDriver();
			}
			
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println("there is a problem in initializing the browser");
			throw new RuntimeException();
		}
		
	}
	public WebElement locate_Element(String locatorType, String value) {
		try {
			switch(locatorType.toLowerCase()) {
			case "id": driver.findElementById(value);
			case "Name": driver.findElement(By.name(value));
			case "class":driver.findElement(By.className(value));
			case "link": driver.findElement(By.linkText(value));
			case "xpath": driver.findElement(By.xpath(value));
			case "css": driver.findElement(By.cssSelector(value));
			}
		}catch(NoSuchElementException e) {
			System.out.println("The LocatorType "+locatorType+" with the value "+value+" is not available");
		}
		return null;
	}
	public void switch_To_Alert() {
		driver.switchTo().alert();
		
	}
	public void accept_Alert() {
		String text="";
		try {
			wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			alert.accept();
			System.out.println("Alert is accepted");
		}
		catch(NoAlertPresentException e) {
			System.out.println("Alert is not present" + e);
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		
	}
	public void dismiss_Alert() {
		String text="";
		try {
			wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			alert.dismiss();;
			System.out.println("Alert is accepted");
		}
		catch(NoAlertPresentException e) {
			System.out.println("Alert is not present" + e);
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		
	}
	public String get_Alert_Text() {
		String text="";
		try {
			wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			text=alert.getText();
			}
		catch(NoAlertPresentException e) {
			System.out.println("Alert is not present" + e);
		}
		catch(WebDriverException e) {
			System.out.println("WebDriverException" + e.getMessage());
		}
		return text;
	}
	public void type_Alert(String input) {
		driver.switchTo().alert().sendKeys(input);
		
	}
	public void switch_To_Window(int index) {
		try {
		Set<String> allWindows=driver.getWindowHandles();
		List<String> allHandles=new ArrayList<String>(allWindows);
		String exWindow=allHandles.get(index);
		driver.switchTo().window(exWindow);
		System.out.println("Window switched successfully");
		}
		catch(NoSuchWindowException e) {
			System.out.println("there is no Window with the given Index");
		}
		
		
	}
	public void switch_To_Frame(int index) {
		driver.switchTo().frame(index);
		
	}
	public void default_Content() {
		driver.switchTo().defaultContent();
		
	}
	public boolean verify_Title(String title) {
		if(driver.getTitle().equals(title)) {
			System.out.println("The Title Matches");
			return true;
		}else {
			System.out.println("The Title doesnt Match");
			return false;
		}
		
	}
	public boolean verify_URL(String url) {
		if(driver.getCurrentUrl().equals(url)) {
			System.out.println("the URL Matches");
			return true;
		}else {
			System.out.println("URL doesnt Match");
			return false;
		}
	}		
		
	public void close() {
		driver.close();
		
	}
	public void quit() {
		driver.quit();
		
	}
	
	
}
