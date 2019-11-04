package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostPasswordPOM {
	private WebDriver driver; 
	
	public LostPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement email; 
	
	@FindBy(className="lostpassword-button")
	private WebElement resetPassword;
	
	
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	
	
	public void clickResetBtn() {
		this.resetPassword.click(); 
	}
}
