package com.training.pom;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DonecQuisPOM {
	private WebDriver driver; 
	
	public DonecQuisPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="your-name")
	private WebElement name; 
	
	@FindBy(name="your-email")
	private WebElement email;
	 
	@FindBy(name="your-subject")
	private WebElement subject;
	
	@FindBy(name="your-message")
	private WebElement message;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement send;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement msg ;
	
	public void sendName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email); 
	}
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);  
	}
	
	public void sendMessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);  
	}

	public void clickOnSend() {
		this.send.click(); 
	}
	
	
	public void getMessage(){
		String txt = this.msg.getText();
		System.out.println(txt);
	}
}
