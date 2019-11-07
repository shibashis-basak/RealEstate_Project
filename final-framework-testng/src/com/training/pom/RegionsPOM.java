package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegionsPOM {
	private WebDriver driver; 
	
	public RegionsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tag-name")
	private WebElement name; 
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="parent")
	private WebElement parent;
	
	@FindBy(id="tag-description")
	private WebElement description; 
	
	@FindBy(id="submit")
	private WebElement addNewRegion;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addNew;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	private WebElement features;
	
	public void sendName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void sendSlug(String slug) {
		this.slug.clear(); 
		this.slug.sendKeys(slug); 
	}
	
	public void selectParent(String choice) { 
		Select dropdown = new Select(parent);
		dropdown.selectByVisibleText(choice);
	}
	
	public void sendDescription(String description) {
		this.description.clear(); 
		this.description.sendKeys(description); 
	}
	
	public void clickAddNewRegion() {
		this.addNewRegion.click();
	}
	
	public void clickAddNew() {
		this.addNew.click(); 
	}
	
	public void clickOnFeatures() {
		this.features.click(); 
	}
}
