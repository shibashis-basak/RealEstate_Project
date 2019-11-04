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
import com.training.pom.DashboardPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyLoginPOM;
import com.training.pom.ProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewPasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homepagePOM;
	private MyLoginPOM myloginPOM;
	private DashboardPOM dashboardPOM;
	private ProfilePOM profilePOM;
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
		profilePOM = new ProfilePOM(driver); 
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
	public void genNewPassword() {
		homepagePOM.validateHomePage();
		homepagePOM.clickLoginBtn();
		myloginPOM.validateLoginPage();
		myloginPOM.sendUserName("admin");
		myloginPOM.sendPassword("admin@123");
		myloginPOM.clickLoginBtn(); 
		dashboardPOM.editMyProfile();
		profilePOM.newPwd("admin@123");
		profilePOM.confirmUpdate();
		profilePOM.validation();
		//screenShot.captureScreenShot("RETC_014");
	}
}
