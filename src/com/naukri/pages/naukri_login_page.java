package com.naukri.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.naukri.setup.utility;


public class naukri_login_page {

		private WebDriver driver;
		public static final By Login_Button=By.id("login_Layer");
		public static final By Email=By.id("eLogin");
		public static final By Password=By.id("pLogin");
		public static final By Sign_In=By.xpath("//*[@value='Login']");
		
		
		
		
		public naukri_login_page(WebDriver driver){
		
				this.driver = driver;
		
		}


		public boolean clickLogin() {
			try{
		
				driver.findElement(Login_Button).click();
			}catch(NoSuchElementException e){
					return false;
		
			}
			return true;
		}
		
		
			public boolean enterEmail(String mail) {
				try{
					driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
					driver.findElement(Email).sendKeys(mail);
				}catch(NoSuchElementException e){
						return false;
			
				}
				return true;		
			}
			
				public boolean enterPassword(String Pwd) {
					try{
				
						driver.findElement(Password).sendKeys(Pwd);
					}catch(NoSuchElementException e){
							return false;
				
					}
					return true;		
				}
				
				
				public boolean clickSignIn() {
					try{
						utility.captureScreenShot(driver,"loginpage");
						driver.findElement(Sign_In).click();
					}catch(NoSuchElementException e){
							return false;
				
					}
					return true;		
					
				
				
				
				
		}



}
