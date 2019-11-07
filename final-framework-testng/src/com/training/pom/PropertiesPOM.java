package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPOM {
	private WebDriver driver; 
	
	public PropertiesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addNew; 
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	private WebElement features;
	
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement regions; 
	
	public void clickOnAddNew() {
		this.addNew.click(); 
	}
	
	public void clickOnFeatures() {
		this.features.click(); 
	}
	
	public void clickOnRegions() {
		this.regions.click(); 
	}
}
