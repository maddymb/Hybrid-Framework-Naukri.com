package com.naukri.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.naukri.pages.naukri_editprofile_page;
import com.naukri.pages.naukri_home_page;
import com.naukri.pages.naukri_login_page;
import com.naukri.setup.utility;


public class naukri_test {
WebDriver driver;
String UId="";
String Password="";

	@BeforeTest
	public void setup() throws Exception{
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("/Users/maddy/eclipse-workspace/Hybrid-Framework-Naukri.com/datadriven.properties");
		prop.load(fis);
		String Driver=prop.getProperty("Browser");
		String Driver_Path=prop.getProperty("Driver");
		String Url=prop.getProperty("URL");
		UId=prop.getProperty("Uname");
		Password=prop.getProperty("Pass");
		System.setProperty(Driver,Driver_Path);
		driver= new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Window Maximized");
		driver.get(Url);
		Reporter.log("Application started");
		utility obj_utility= new utility(driver);
		obj_utility.naukriPopUpHandles();
	
	}
	
	@Test
	public void loginFlow(){
		
		naukri_login_page obj_naukri_login_page= new naukri_login_page(driver);
		obj_naukri_login_page.clickLogin();
		obj_naukri_login_page.enterEmail(UId);
		obj_naukri_login_page.enterPassword(Password);
		obj_naukri_login_page.clickSignIn();
	
	}
	
	@Test(dependsOnMethods={"loginFlow"})
	public void homepageFlow(){
		
		naukri_home_page obj_naukri_home_page= new naukri_home_page(driver);
		obj_naukri_home_page.clickMyNaukri();
		obj_naukri_home_page.clickEditProfile();
		
		
	}
	
	@Test(dependsOnMethods={"homepageFlow"})
	public void updateFlow() throws InterruptedException, IOException{
		
		naukri_editprofile_page obj_naukri_editprofile_page= new naukri_editprofile_page(driver);
		obj_naukri_editprofile_page.clickSaveButton();
		
		
	}
	
	
	
	
	@AfterTest
	public void driverQuit()
	{
		utility.capturefailedScreenshot(driver, "failed");
		driver.quit();
		
	}
	
	
	
	
}
