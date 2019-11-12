package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.DashboardPOM;
import com.training.pom.DonecQuisPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.MyLoginPOM;
import com.training.pom.NewLaunchPOM;
import com.training.pom.UsersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeOfRole {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homepagePOM; 
	private MyLoginPOM myloginPOM;
	private DashboardPOM dashboardPOM;
	private UsersPOM usersPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 


	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"manzoor mehadi", "Agent"},
			{"alex hales", "Customer"},
			{"mariya", "Shop manager"}
		};
	}

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
		usersPOM = new UsersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(dataProvider = "inputs")
	public void changeOfRole(String name, String role) {
		homepagePOM.clickLoginBtn();
		myloginPOM.sendUserName("admin");
		myloginPOM.sendPassword("admin@123");
		myloginPOM.clickLoginBtn();
		dashboardPOM.clickOnUsers();
		usersPOM.clickOnAllUsers();
		usersPOM.sendUserName(name);
		usersPOM.clickOnSearchUsers();
		usersPOM.checkUserName(name);
		usersPOM.selectRole(role);
		usersPOM.clickOnChange();
		usersPOM.getMessage();
		//screenShot.captureScreenShot(userName);
	}
	
}