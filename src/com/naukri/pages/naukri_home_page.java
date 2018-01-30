package com.naukri.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.naukri.setup.utility;


public class naukri_home_page {

		private WebDriver driver;
		public static final By My_Naukri=By.xpath("//*[text()='My Naukri']");
		public static final By Edit_Profile=By.xpath("//a[@href='https://my.naukri.com/Profile/edit?id=&altresid']");
	
		public naukri_home_page(WebDriver driver){
				this.driver= driver;
		}
	
		
		public boolean clickMyNaukri(){
			try{
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);  
			     WebElement myNaukriElement = driver.findElement(My_Naukri);
			     Actions act= new Actions(driver);
			     act.moveToElement(myNaukriElement).perform();
			     driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				}
			catch(NoSuchElementException e){
					return false;
				}
			
			return true;
		}
		
		public boolean clickEditProfile(){
			try{
				utility.captureScreenShot(driver,"homepage");
				driver.findElement(Edit_Profile).click();
			     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
			catch(NoSuchElementException e){
					return false;
				}
			
			return true;
		}
		
		
		
		
}
