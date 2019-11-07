package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewPOM {
	private WebDriver driver; 
	
	public AddNewPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="title")
	private WebElement title; 
	
	@FindBy(id="content")
	private WebElement content;
	
	
	
	
	@FindBy(id="property_feature-add-toggle")
	private WebElement addNewFeature; 
	
	@FindBy(id="newproperty_feature")
	private WebElement feature; 
	
	@FindBy(id="newproperty_feature_parent")
	private WebElement parent_feature; 
	
	@FindBy(id="property_feature-add-submit")
	private WebElement addFeature; 
	
	
	
	
	@FindBy(id="region-add-toggle")
	private WebElement addNewRegion; 
	
	@FindBy(id="newregion")
	private WebElement region; 
	
	@FindBy(id="newregion_parent")
	private WebElement parent_region; 
	
	@FindBy(id="region-add-submit")
	private WebElement addRegion; 
	
	
	
	
	
	@FindBy(id="publish")
	private WebElement publish;
	
	
	
	
	public void sendTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	public void sendContent(String content) {
		this.content.clear(); 
		this.content.sendKeys(content); 
	}
	
	public void scrollup(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-300)");
	}
	
	
	public void selectFeature(String feature) {
		String before = "//ul[@id='property_featurechecklist']/li[";
		String after = "]/label[1]";
		
		int rowcount = driver.findElements(By.xpath("//ul[@id='property_featurechecklist']/li")).size();
		
		
		for (int rownum=1; rownum<=rowcount; rownum++)
		{
			String runtimeuname = driver.findElement(By.xpath(before + rownum + after)).getText();
			
			if (runtimeuname.equalsIgnoreCase(feature))
			{
				WebElement checkbox = driver.findElement(By.xpath(before + rownum + after + "/input"));
				if(!checkbox.isSelected())
					checkbox.click();
				else
					System.out.println("Already selected");
			}
			
				
		}
	}
	
	
	
	public void selectRegion(String region) {
		String before = "//ul[@id='regionchecklist']/li[";
		String after = "]/label[1]";
		
		int rowcount = driver.findElements(By.xpath("//ul[@id='regionchecklist']/li")).size();
		
		
		for (int rownum=1; rownum<=rowcount; rownum++)
		{
			String runtimeuname = driver.findElement(By.xpath(before + rownum + after)).getText();
			
			if (runtimeuname.equalsIgnoreCase(region))
			{
				WebElement checkbox = driver.findElement(By.xpath(before + rownum + after + "/input"));
				if(!checkbox.isSelected())
					checkbox.click();
				else
					System.out.println("Already selected");
			}
			
				
		}
	}
	
	
	
	
	public void addNewFeature(String parent, String feature) {
		this.addNewFeature.click();
		this.feature.sendKeys(feature);
		Select dropdown = new Select(parent_feature);
		dropdown.selectByVisibleText(parent);
		this.addFeature.click();
		driver.navigate().refresh();
	}
	
	
	
	public void addNewRegion(String parent, String region) {
		this.addNewRegion.click();
		this.region.sendKeys(region);
		Select dropdown = new Select(parent_region);
		dropdown.selectByVisibleText(parent);
		this.addRegion.click();
		driver.navigate().refresh();
	}
	
	
	
	
	
	
	
	public void selectSubFeature(String parent, String feature){
		
		//web table
		
		String before = "//ul[@id='property_featurechecklist']/li[";
		String after = "]/label[1]";
		
		int rowcount = driver.findElements(By.xpath("//ul[@id='property_featurechecklist']/li")).size();
		
		
		for (int rownum=1; rownum<=rowcount; rownum++)
		{
			String runtimeuname = driver.findElement(By.xpath(before + rownum + after)).getText();
			
			if (runtimeuname.equalsIgnoreCase(parent))
			{
				String innerbefore = before + rownum + "]/ul[1]/li";
				int innercount = driver.findElements(By.xpath(innerbefore)).size();
				for (int innerrownum=1; innerrownum<=innercount; innerrownum++)
				{
					String tag = innerbefore + "[" + innerrownum + "]";
					String innername = driver.findElement(By.xpath(tag + "/label[1]")).getText();
					
					if (innername.equalsIgnoreCase(feature))
					{
						WebElement innerchkbox = driver.findElement(By.xpath(tag + "/label[1]/input[1]"));
						if(!innerchkbox.isSelected())
							innerchkbox.click();
						else
							System.out.println("Already selected");
					}
				}
			}
			
		}	//end of web table
		
	}
	
	
	
	
	
	
	
	public void selectSubRegion(String parent, String region){
		
		//web table
		
		String before = "//ul[@id='regionchecklist']/li[3]/ul[1]/li[";
		String after = "]/label[1]";
				
		int rowcount = driver.findElements(By.xpath("//ul[@id='regionchecklist']/li[3]/ul[1]/li")).size();
				
				
		for (int rownum=1; rownum<=rowcount; rownum++)
		{
			String runtimeuname = driver.findElement(By.xpath(before + rownum + after)).getText();
					
			if (runtimeuname.equalsIgnoreCase(parent))
			{
				String innerbefore = before + rownum + "]/ul[1]/li";
				int innercount = driver.findElements(By.xpath(innerbefore)).size();
				for (int innerrownum=1; innerrownum<=innercount; innerrownum++)
				{
					String tag = innerbefore + "[" + innerrownum + "]";
					String innername = driver.findElement(By.xpath(tag + "/label[1]")).getText();
					
					if (innername.equalsIgnoreCase(region))
					{
						WebElement innerchkbox = driver.findElement(By.xpath(tag + "/label[1]/input[1]"));
						if(!innerchkbox.isSelected())
							innerchkbox.click();
						else
							System.out.println("Already selected");
					}		
				}
			}
						
		}	//end of web table
		
	}
	
	
	
	public void clickOnPublish() {
		this.publish.click(); 
	}
}
