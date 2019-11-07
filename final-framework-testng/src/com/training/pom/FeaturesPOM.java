package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPOM {
	private WebDriver driver; 
	
	public FeaturesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tag-name")
	private WebElement name; 
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description; 
	
	@FindBy(id="submit")
	private WebElement addNewFeature;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addNew;
	
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement regions;
	
	
	public void sendName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void sendSlug(String slug) {
		this.slug.clear(); 
		this.slug.sendKeys(slug); 
	}
	
	public void sendDescription(String description) {
		this.description.clear(); 
		this.description.sendKeys(description); 
	}
	
	public void clickAddNewFeature() {
		this.addNewFeature.click(); 
	}
	
	public void clickAddNew() {
		this.addNew.click(); 
	}
	
	public void clickOnRegions() {
		this.regions.click(); 
	}
}
