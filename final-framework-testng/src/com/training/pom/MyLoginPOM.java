package com.training.pom;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyLoginPOM {
	private WebDriver driver; 
	
	public MyLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	private WebElement loginBtn;
	
	/*
	@FindBy(linkText="Lost Your Password?")
	private WebElement lostpwd;
	*/
	
	public void validateLoginPage() {
		assertEquals(driver.getTitle(),"My Profile – Real Estate");
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickOnLostPassword(){
		WebDriverWait ewait = new WebDriverWait(driver,10);			//wait till 10 seconds
		WebElement lostpwd = ewait.until(ExpectedConditions.elementToBeClickable(By.linkText("Lost Your Password?")));
		lostpwd.click();
	}
	
	
}
