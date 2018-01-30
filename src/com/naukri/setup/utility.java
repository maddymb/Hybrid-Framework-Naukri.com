package com.naukri.setup;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility {
	WebDriver driver;
	public utility(WebDriver driver){
		
		this.driver = driver;

	}
	
	public boolean naukriPopUpHandles() throws Exception {
		try{
			
		
		
			// It will return the parent window name as a String
				String parent=driver.getWindowHandle();
				// This will return the number of windows opened by Webdriver and will return Set of St//rings
				Set<String>s1=driver.getWindowHandles();
				System.out.println(s1.size());
				// Now we will iterate using Iterator
				Iterator<String> I1= s1.iterator();
				while(I1.hasNext())
				{
				 
				   String child_window=I1.next();
				 
				// Here we will compare if parent window is not equal to child window then we            will close
				 
				if(!parent.equals(child_window))
				{
				driver.switchTo().window(child_window);
				 
				System.out.println(driver.switchTo().window(child_window).getTitle());
				 
				driver.close();
				}
				 
				}
				// once all pop up closed now switch to parent window
				driver.switchTo().window(parent);
		}catch(NoSuchElementException e){
			return false;

	}
	return true; 
	}			
	public static void captureScreenShot(WebDriver driver, String ScreenShotName){
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		  // now copy the  screenshot to desired location using copyFile method
		 
		 FileUtils.copyFile(src, new File("C:\\Users\\Maddy\\Documents\\naukri.com\\ScreenShot\\"+ScreenShotName+".png"));
		       }
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		    }
		 
		}
		
	public static void capturefailedScreenshot(WebDriver driver,String screenshotName)
	{
	 
	try 
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	FileUtils.copyFile(source, new File("C:\\Users\\Maddy\\Documents\\naukri.com\\ScreenShot\\"+screenshotName+".png"));
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	
	
}

	
	
	
	

