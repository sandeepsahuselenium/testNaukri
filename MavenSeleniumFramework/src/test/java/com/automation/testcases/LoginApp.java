package com.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginApp extends BaseClass{
	@Test
	public void Login() throws IOException {
		logger=report.createTest("Log in to Naukri");
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		lp.LoginToNaukri(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login success");
	}
}

