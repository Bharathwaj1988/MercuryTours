package com.Mercury.base.Interfac;

import org.openqa.selenium.WebElement;

public interface Browser {

	/*
	 * This Method will launch the Chrome Browser and
	 * Maximize the Browser and wait for 30 seconds and load the user given URL.
	 * @Param url - This load the specified url
	 * @Author - Bharathwaj
	 * throws MalformedURLException 
	 */
	public void start_App(String url);
	
	/*
	 * This Method will launch the browser based on user input and maximize
	 * the browser and wait for 30 seconds and load the user given url.
	 * @Param browser - This launch the specified browser.
	 * @Param url - This load the specified url.
	 * @Author - Bharathwaj
	 * throws MalformedURLException.
	 */
	public void start_App(String browser,String url);
	
	/*
	 * This Method will locate the element using any given locator.
	 * @Param locatortype - The locator by which the element to be found.
	 * @Param value - The locator value by which the element to be found.
	 * @Author - Bharathwaj
	 * throws NoSuchElementException
	 * return The first matching element on the current context. 
	 */
	public  WebElement locate_Element(String locatorType,String value);
	
	/*
	 * This Method will switch to Alert
	 * @Author - Bharathwaj
	 * throws NoAlertPresentException
	 */
	public void switch_To_Alert();
	
	/*
	 * This Method will accept the Alert
	 * @Author - Bharathwaj
	 * throws NoAlertPresentException
	 */
	public void accept_Alert();
	
	/*
	 * This Method will dismiss the Alert
	 * @Author - Bharathwaj
	 * throws NoAlertPresentException
	 */
	public void dismiss_Alert();
	
	/*
	 * This Method will return the text in the Alert
	 * @Author - Bharathwaj
	 * throws NoAlertPresentException
	 * return The text present in the Alert
	 */
	public String get_Alert_Text();
	
	/*
	 * This Method will type the text in the Alert
	 * @Param input - The data to be entered in the Alert
	 * @Author - Bharathwaj
	 * throws NoAlertPresentException
	 */
	public void type_Alert(String input);
	
	/*
	 * This Method will switch to the window of Interest
	 * @Param index - The window index to be switched to 0 --> First Window
	 * @Author - Bharathwaj
	 * throws NoSuchWindowException
	 */
	public void switch_To_Window(int index);
	
	/*
	 * This Method will switch to the frame of Interest
	 * @Param index - The frame index to be switched.
	 * @Author - Bharathwaj
	 * throws NoSuchFrameexception
	 */
	public void switch_To_Frame(int index);
	
	/*
	 * This Method will switch back to window from frame
	 * @Author - Bharathwaj
	 * throws NoSuchFrameException
	 */
	public void default_Content();
	
	/*
	 * This Method will verify the title of the page
	 * @Param title - The title to be verified
	 * @Author - Bharathwaj
	 * return true if the title matches with the browser page, false otherwise 
	 */
	public boolean verify_Title(String title);
	
	/*
	 * This Method will verify the URL of the page
	 * @Param url - The url to be verified
	 * @Author - Bharathwaj
	 * return true if the url matches with the browser url, false otherwise 
	 */
	public boolean verify_URL(String url);
	
	/*
	 * This Method will close the active browser
	 * @Author - Bharathwaj 
	 */
	public void close();
	
	/*
	 * This Method will close all the browsers
	 * @Author - Bharathwaj 
	 */
	
	public void quit();
	
	
}
 