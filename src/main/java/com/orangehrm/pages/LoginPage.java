package com.orangehrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.actiondriver.ActionDriver;
import com.orangehrm.base.BaseClass;

public class LoginPage {
	
	private ActionDriver actionDriver;
	
	// Define all the locators using By class
	
	private By userNameFieldLocator = By.xpath("//input[@name='username']");
	private By passwordFieldLocator = By.xpath("//input[@name='password']");
	private By loginButtonLocator = By.xpath("//button[@type='submit']");	
	private By errorMessageLocator = By.xpath("//div[contains(@role,\"alert\")]");
	
// how 	to initlize action driver inside page 
	/*
	 * public LoginPage(WebDriver driver) throws IOException, InterruptedException {
	 * //to initlize my action driver i need to create a class of action driver
	 * 
	 * this.actionDriver = new ActionDriver(driver); }
	 */
	
	// we have created singlton patterd for action driver and webdriver 
	public LoginPage()
	{
		this.actionDriver=BaseClass.getActionDriver();
	}
	
	//METHOD TO PERFORM LOGIN 
	
	public void login(String userName ,String password)
	{
		 actionDriver.enterText(userNameFieldLocator,userName);
		 actionDriver.enterText(passwordFieldLocator, password);
		 actionDriver.click(loginButtonLocator);
	}
	// Method To check if error message is displayed 
	
	public boolean indvalidData ()
	{
		return actionDriver.isDisplayed(errorMessageLocator);
	}
	
	//Method to get Text from error message 
	
	public String getErrorMessageText ()
	{
		return actionDriver.getText(errorMessageLocator);
	}
	
	//Verify if error message is correct or not 
	public boolean verifyErrorMessage (String expectedErrorMessage)
	{
		return actionDriver.compareText(errorMessageLocator, expectedErrorMessage);
	}
	
	
	
	
	
	
}
