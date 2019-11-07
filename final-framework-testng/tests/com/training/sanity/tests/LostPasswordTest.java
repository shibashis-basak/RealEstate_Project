package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LostPasswordPOM;
import com.training.pom.MyLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LostPasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private HomePagePOM homepagePOM;
	private MyLoginPOM myloginPOM;
	private LostPasswordPOM lostpasswordPOM;
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
		lostpasswordPOM = new LostPasswordPOM(driver);
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
	public void lostpasswordTest() {
		homepagePOM.validateHomePage();
		homepagePOM.clickLoginBtn();
		
		myloginPOM.validateLoginPage();
		myloginPOM.scrolldown();
		myloginPOM.clickOnLostPassword();
		
		lostpasswordPOM.sendEmail("admin");
		lostpasswordPOM.clickResetBtn();
		//screenShot.captureScreenShot("RETC_012");
	}
}
