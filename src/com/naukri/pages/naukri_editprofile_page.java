package com.naukri.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.naukri.setup.utility;



public class naukri_editprofile_page {

	private WebDriver driver;
	public static final By Save_Button=By.xpath("//*[@class='w150bt fl']");
	
	public naukri_editprofile_page(WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public boolean clickSaveButton() throws InterruptedException, IOException{
		try{
			String parent1=driver.getWindowHandle();
			 
			// This will return the number of windows opened by Webdriver and will return Set of St//rings
			Set<String>s2=driver.getWindowHandles();
			
			// Now we will iterate using Iterator
			Iterator<String> I2= s2.iterator();
			while(I2.hasNext())
			{
			 
			   String child_window1=I2.next();
			 
			// Here we will compare if parent window is not equal to child window then we            will close
			 
			if(!parent1.equals(child_window1))
			{
			driver.switchTo().window(child_window1);
			 
			System.out.println(driver.findElement(By.xpath("//*[@for='name']")).getText());
			System.out.println(driver.switchTo().window(child_window1).getTitle());
			 
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			
			driver.findElement(Save_Button).click();
			
			Thread.sleep(10000);
			
			utility.captureScreenShot(driver,"profileUpdated");
			
			driver.close();
			}
			 
			}
			Thread.sleep(4000);
			// once all pop up closed now switch to parent window
			driver.switchTo().window(parent1);
			 
	        
	   
	        
			
			}
		catch(NoSuchElementException e){
				return false;
			}
		
		return true;
	
	}
	
}
