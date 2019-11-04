package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePOM {
	private WebDriver driver; 
	
	public ProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="last_name")
	private WebElement lastname; 
	
	@FindBy(id="phone")
	private WebElement phnNo;
	
	
	
	@FindBy(xpath="//button[@class='button wp-generate-pw hide-if-no-js']")
	private WebElement genPwd; 
	
	/*@FindBy(id="pass1-text")
	private WebElement pwdTextbox; */
	
	@FindBy(className="pw-checkbox")
	private WebElement pwdcheckbox; 
	
	
	
	@FindBy(id="submit")
	private WebElement updtProfile; 
	
	
	@FindBy(xpath=".//div[@id='message']//strong")
	private WebElement validateMsg; 
	
	
	public void sendLastName(String lastName) {
		this.lastname.clear();
		this.lastname.sendKeys(lastName);
	}
	
	public void sendPhnNo(String phnno) {
		this.phnNo.clear(); 
		this.phnNo.sendKeys(phnno); 
	}
	
	public void newPwd(String pswd) {
		//click on generate password
		this.genPwd.click();
		
		//type new password in textbox
		WebDriverWait ewait = new WebDriverWait(driver,10);			//wait till 10 seconds
		WebElement newpwd = ewait.until(ExpectedConditions.elementToBeClickable(By.id("pass1-text")));
		newpwd.clear();
		newpwd.sendKeys(pswd);
		
		//click on checkbox
		if(pwdcheckbox.isSelected())
			System.out.println("Already selected");
		else
			pwdcheckbox.click();
	}
	
	
	
	
	public void confirmUpdate() {
		this.updtProfile.click(); 
	}
	
	public void validation() {
		String actualText = validateMsg.getText();
		String expectedText = "Profile updated.";
		assertEquals(actualText,expectedText); 
	}
	
	
	
	
	
	
}
