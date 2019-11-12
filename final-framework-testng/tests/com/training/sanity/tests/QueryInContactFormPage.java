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
import com.training.pom.DonecQuisPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class QueryInContactFormPage {
	private WebDriver driver; 
	private String baseUrl; 
	private HomePagePOM homepagePOM; 
	private NewLaunchPOM newlaunchPOM;
	private DonecQuisPOM donecquisPOM;
	private static Properties properties; 
	private ScreenShot screenShot; 


	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"manzoor mehadi", "manzoor", "apartments", "looking for an apartment"},
			{"alex hales", "alex@gmail.com", "Plots", "looking for an plot"},
			{"mariya", "mariya@gmail.com", "Vilas", "looking for an vila"}
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
		newlaunchPOM = new NewLaunchPOM(driver);
		donecquisPOM = new DonecQuisPOM(driver);
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
	public void queryInContactFormPage(String name, String email, String subject, String message) {
		homepagePOM.clickNewLaunch();
		newlaunchPOM.clickDonecQuis();
		donecquisPOM.sendName(name);
		donecquisPOM.sendEmail(email);
		donecquisPOM.sendSubject(subject);
		donecquisPOM.sendMessage(message);
		donecquisPOM.clickOnSend();
		donecquisPOM.getMessage();
		//screenShot.captureScreenShot(userName);
	}
	
}