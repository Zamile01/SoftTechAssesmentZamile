package PageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Utillities.HelperMethods;

public class ContactUsPageElements  extends HelperMethods {

	public ContactUsPageElements() {
		
	}
	
	public By findElelmentByText(String text) {
		
		 return By.xpath("//*[contains(text(),'"+text+"')]");
		
	}
	public By getNameTextBox() {
		
		 return By.xpath("//*[@id='your_name-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getWorkMail() {
		
		 return By.xpath("//*[@id='email-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getContactNmumber() {
		
		 return By.xpath("//*[@id='mobilephone-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getCompanySize() {
		
		 return By.xpath("//*[@id='numemployees-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getServiceSelected() {
		
		 return By.xpath("//*[@id='what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getHelpMessage() {
		
		 return By.xpath("//*[@id='message-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getAggreementCheckBox() {
		
		 return By.xpath("//*[@id='LEGAL_CONSENT.subscription_type_10841063-c2e387f9-4bd8-496f-ab2a-81fbbc31712a']");
		
	}
	public By getSubmitButton() {
		
		 return By.xpath("//*[@id='hsForm_c2e387f9-4bd8-496f-ab2a-81fbbc31712a']/div/div[2]/input");
		
	}
	

	
	
	public void SwitchToFrame(WebDriver driver, String id, Duration waitTime) throws Exception {
		WaitForElementVisible(By.xpath("//iframe[@id='"+id+"']"), driver, waitTime, false);
		driver.switchTo().frame(id);
	}
	
	public void enterName(WebDriver driver,Duration waitTime , String Name) throws Exception {
	
		 ClearFieldAndEnterValue(getNameTextBox(),  driver,  Name,  waitTime);
		
	}
	
	
	public void EnterWorkMail(WebDriver driver,Duration waitTime , String WorkMail) throws Exception {
	
		 ClearFieldAndEnterValue(getWorkMail(),  driver,  WorkMail,  waitTime);
			
	}

	public void EnterContactNmumber(WebDriver driver,Duration waitTime , String ContactNumber) throws Exception {
		
		 ClearFieldAndEnterValue(getContactNmumber(),  driver,  ContactNumber,  waitTime);
			
		
	}
	public void SelectCompanySize(WebDriver driver,Duration waitTime , String CompanySize) throws Exception {
		
		SelectDropDownItemUsingOptions(getCompanySize(), driver, CompanySize, waitTime);
	}
	

	
	public void SelectService(WebDriver driver,Duration waitTime , String ServiceSelected) throws Exception {
		
		SelectDropDownItemUsingOptions(getServiceSelected(), driver, ServiceSelected, waitTime);
		
	}
	
	public void WriteHelpMessage(WebDriver driver,Duration waitTime , String HelpMessage) throws Exception {
		
		 ClearFieldAndEnterValue(getHelpMessage(),  driver,  HelpMessage,  waitTime);
			
	}
	
	
	public void AggreeToBeContacted(WebDriver driver,Duration waitTime) throws Exception {
		
		ClickingObject( getAggreementCheckBox(), driver, waitTime);
		
	}

	
	public void ClickSubmitButton(WebDriver driver,Duration waitTime) throws Exception {
		ClickingObject( getSubmitButton(), driver, waitTime);
	}
	
	public void ValidateMessage(WebDriver driver,Duration waitTime, ExtentTest test, String text) throws Exception {

		if(CheckElementIsVisible(findElelmentByText( text), driver,  waitTime)) {
			
			test.pass("Testcase has passed, Expected the message '"+text+"' and Message was found ", MediaEntityBuilder.createScreenCaptureFromBase64String(takeSnapShot(driver) ).build())   ;
			   
			
		}else
		{
			test.fail("Testcase has failed, Expected the message '"+text+"' and Message was NOT found ", MediaEntityBuilder.createScreenCaptureFromBase64String(takeSnapShot(driver) ).build())   ;
			
			
		}
		
		
	}


}
