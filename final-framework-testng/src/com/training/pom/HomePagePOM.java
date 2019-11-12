package com.training.pom;

import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	private WebDriver driver; 
	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="sign-in")
	private WebElement signin; 
	
	
	@FindBy(xpath="//li[@id='menu-item-354']//a[contains(text(),'New Launch')]")
	private WebElement newLaunch; 
	
	
	 
	public void validateHomePage(){
		assertEquals(driver.getTitle(),"Real Estate");
	}
	
	
	
	public void clickLoginBtn() {
		this.signin.click(); 
	}
	
	
	public void clickNewLaunch() {
		this.newLaunch.click(); 
	}
}
