package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyLoginPOM;
import com.training.pom.PropertiesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreatePropertyAddingSubFeature {

	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homepagePOM;
	private MyLoginPOM myloginPOM;
	private DashboardPOM dashboardPOM;
	private PropertiesPOM propertiesPOM;
	private AddNewPOM addnewPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		homepagePOM = new HomePagePOM(driver);
		myloginPOM = new MyLoginPOM(driver); 
		dashboardPOM = new DashboardPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		addnewPOM = new AddNewPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		//open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void createPropertyAddingSubFeature() throws InterruptedException {
		homepagePOM.validateHomePage();
		homepagePOM.clickLoginBtn();
		
		myloginPOM.validateLoginPage();
		myloginPOM.sendUserName("admin");
		myloginPOM.sendPassword("admin@123");
		myloginPOM.clickLoginBtn();
		
		dashboardPOM.clickOnProperties();
		
		propertiesPOM.clickOnAddNew();
		
		addnewPOM.addNewFeature("interior", "Best");
		addnewPOM.sendTitle("prestige");
		addnewPOM.sendContent("home town");
		addnewPOM.selectSubFeature("interior", "Best");
		addnewPOM.scrollup();
		addnewPOM.clickOnPublish();
		
		Thread.sleep(5000);
		//screenShot.captureScreenShot("RETC_044");
	}
}
