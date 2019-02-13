package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	@Test
	
	public void Loginpage() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.naukri.com/nlogin/logout");
		
		driver.findElement(By.id("usernameField")).sendKeys("sandeep94kumarsahu@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Sonal@94");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());
	}
}
