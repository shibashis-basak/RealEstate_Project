package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPOM {
	private WebDriver driver; 
	
	public UsersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'All Users')]")
	private WebElement allUsers;
	
	@FindBy(id="user-search-input")
	private WebElement userName; 
	
	@FindBy(id="search-submit")
	private WebElement search_users;
	
	@FindBy(id="new_role")
	private WebElement new_role;
	
	@FindBy(id="changeit")
	private WebElement change;
	
	@FindBy(xpath="//div[@id='message']/p")
	private WebElement msg;
	
	
	
	public void clickOnAllUsers(){
		this.allUsers.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void clickOnSearchUsers() {
		this.search_users.click(); 
	}
	
	public void checkUserName(String username){
		String path = "//td[contains(text(),'" + username +"')]//ancestor::tr//child::th[1]/input[1]";
		WebElement userCheckbox = driver.findElement(By.xpath(path));
		userCheckbox.click();
	}
	
	
	public void selectRole(String role){
		Select dropdown = new Select(new_role);
		dropdown.selectByVisibleText(role);
	}
	
	public void clickOnChange(){
		this.change.click();
	}
	
	public void getMessage(){
		String message = this.msg.getText();
		System.out.println(message);
	}
	
	
}
