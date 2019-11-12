package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {
	private WebDriver driver; 
	
	public DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Howdy,')]")
	private WebElement admin; 
	
	@FindBy(xpath="//a[contains(text(),'Edit My Profile')]")
	private WebElement profile;
	
	@FindBy(xpath="//a[@class='ab-item' and contains(text(),'Log Out')]")
	private WebElement logout;
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement properties;
	
	@FindBy(xpath="//div[contains(text(),'Users')]")
	private WebElement users;
	


	public void editMyProfile() {
		Actions act = new Actions(driver);
		act.moveToElement(admin).moveToElement(profile).click().build().perform();
	}
	
	
	public void clickOnProperties() {
		this.properties.click();
	}
	
	public void clickOnUsers() {
		this.users.click();
	}
	
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(admin).moveToElement(logout).click().build().perform();
	}
	
	
}
