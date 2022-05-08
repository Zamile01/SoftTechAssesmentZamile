package Utillities;

import java.io.File;
import java.time.Duration;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class HelperMethods {

	public HelperMethods() {
		// TODO Auto-generated constructor stub
	}
	
	public void WaitForElementToBeClickable(WebElement sElement, WebDriver driver, Duration seconds, ExtentTest test, String fieldName) throws Exception{

		WebDriverWait w = new WebDriverWait(driver,seconds);

		try {

			w.until(ExpectedConditions.elementToBeClickable((sElement)));
		

		} catch (Exception e) {
			// TODO: handle exception

			test.fail("The element "+fieldName+" is not Clickable, Driver waited for "+seconds+" second(s)", MediaEntityBuilder.createScreenCaptureFromPath(takeSnapShot(driver)).build() );
			test.info(e.toString());

		}
	} 
	

	public void ClearFieldAndEnterValue(By sElement, WebDriver driver, String sData, Duration waitTime) throws Exception
	{
		
		try {
			
			
			WaitForElementVisible(sElement, driver, waitTime, false);
			
			driver.findElement(sElement).clear();
			driver.findElement(sElement).sendKeys(sData);
			//test.pass("Succesfully cleared and entered text on "+fieldName, MediaEntityBuilder.createScreenCaptureFromPath(takeSnapShot(driver)).build() );
			
			


		} catch (Exception e) {
			// TODO: handle exception
		
			
		}



	}
	

	public void ClickingObject( By sElement, WebDriver driver, Duration waitTime) throws Exception


	{
		WaitForElementVisible(sElement, driver, waitTime, true);

			driver.findElement(sElement).click();
	}
	
	
	public boolean CheckElementIsVisible(By sElement, WebDriver driver, Duration waitTime) throws Exception {
		
		WaitForElementVisible(sElement, driver, waitTime, false);

	
		try {
			WebElement el = driver.findElement(sElement);
			el = driver.findElement(sElement);
			return el.isDisplayed();

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	

	public void WaitForElementVisible(By sElement, WebDriver driver, Duration seconds, boolean log) throws Exception{
		boolean eleVisible = false;
		WebDriverWait w = new WebDriverWait(driver,seconds);

		try {

			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sElement));
		
			
		} catch (Exception e) {
			// TODO: handle exception

			if(log) {
				
				
			}
			
		}
	} 
	
	
	public static ExtentReports setUpExtendReport() {
		
		String reportname = "SoftTech Automation Report.html";
		String pageTile = "SoftTech Automation";
		
		ExtentSparkReporter spark=new ExtentSparkReporter(reportname);
		ExtentReports extent=new ExtentReports();
		spark.config().setDocumentTitle(pageTile);	
		spark.config().setReportName("Zamile Nsuntsha");
		extent.attachReporter(spark);
		return extent;
	}
	
	
	
	
	 public String takeSnapShot(WebDriver webdriver) throws Exception{

	        //Convert web driver object to TakeScreenshot
		 
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String filename = "ScreenShots/"+dtf.format(now)+Thread.currentThread().getId()+".png";
		   String base64String = null;
		   
		   
	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(filename);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);
	                byte[] scrn = IOUtils.toByteArray(new FileInputStream(filename));
	                base64String = Base64.getEncoder().encodeToString(scrn);
	                return base64String;
	                
	    }
	 

	 
	 
	 public void SelectDropDownItemUsingOptions(By sElement, WebDriver driver,String ItemToSelect, Duration seconds) throws Exception{
		 
			
			
		 String CurrentOptions;
		 boolean isFound=false;
		 try {
			WaitForElementVisible(sElement, driver, seconds, true);
			WebElement ele =  driver.findElement(sElement);
			ele.click();
			 Select s = new Select(ele);
		      // getting the list of options in the dropdown with getOptions()
			 
		      List <WebElement> op = s.getOptions();
		      int size = op.size();
		      for(int i =0; i<size ; i++){
		    	  CurrentOptions = op.get(i).getText();
		    	  
		          if(CurrentOptions.equalsIgnoreCase(ItemToSelect)){
		        	  isFound=true;
		        	  s.selectByIndex(i);
		        	  i = size;
		        	 System.out.println(ItemToSelect+ " match");
		          }
		      }
		      
		      	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Unable to Select Field " + e.getMessage());
			
		}
		 
		
  
	 
}
	
	

	

}
