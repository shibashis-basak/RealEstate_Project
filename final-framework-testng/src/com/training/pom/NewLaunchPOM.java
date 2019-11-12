package com.training.pom;

import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM {
	private WebDriver driver; 
	
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Donec quis')]")
	private WebElement donec_quis; 
	
	@FindBy(xpath="//span[contains(text(),'Maecenas viverra')]")
	private WebElement maecenas_viverra;
	 
	@FindBy(xpath="//span[contains(text(),'Nullam hendrerit Apartments')]")
	private WebElement nullam_hendrerit_apartments;
	
	 
	
	
	
	public void clickDonecQuis() {
		this.donec_quis.click(); 
	}
	
	
	public void clickMaecenasViverra() {
		this.maecenas_viverra.click(); 
	}
	

	public void clickNullamHendreritApartments() {
		this.nullam_hendrerit_apartments.click(); 
	}
}
