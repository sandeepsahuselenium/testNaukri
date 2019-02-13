package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(id="usernameField") WebElement uname;
	@FindBy(id="passwordField") WebElement pass;
	@FindBy(xpath="//button[text()='Login']") WebElement loginButton;

	public void LoginToNaukri(String userNameApplication,String passwordApplication) {
		uname.sendKeys(userNameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
}
