package StepDefinations;



import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import PageElements.ContactUsPageElements;
import Runner.RunnerClass;
import Utillities.HelperMethods;
import cucumber.api.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends ContactUsPageElements{

	WebDriver driver;
	ContactUsPageElements contEl ;
	Duration waitTime = Duration.ofSeconds(10); 

	HelperMethods helperMethods;
	ExtentTest test;
	int number = 0;
	
	
	
	public Steps() {
		// TODO Auto-generated constructor stub
		
		contEl = new ContactUsPageElements();
		helperMethods = new HelperMethods();
		
	
		
		
	}
	
	 @Given("^(.+)User opens a browser to (.+)$")
	 public void user_opens_a_browser_to(String testcase, String scenaridetails) throws Throwable {
		 
		
	
        test = RunnerClass.extent.createTest(testcase);
        test.info(scenaridetails);
		WebDriverManager.chromedriver().setup();
		driver = new  ChromeDriver();
		driver.manage().window().maximize();
		
    }

    @When("^a user enters a URL \"([^\"]*)\"$")
    public void a_user_enters_a_url_something(String url) throws Throwable {
    	System.out.println("getting url");
	    driver.get(url); 
	    test.pass("successFully Navigated to URL", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
	    contEl.SwitchToFrame(driver, "hs-form-iframe-0", waitTime);
	    
    }


    @Then("^validate the message(.+)$")
    public void validate_the_message(String validation) throws Throwable {

    	ValidateMessage( driver, waitTime,  test,  validation);
    	
    }
    @And("^enter name (.+)$")
    public void enter_name_for_customer(String name) throws Throwable {
    	System.out.println("entering name");
		contEl.enterName(driver, waitTime, name);
		test.pass("Successfully Entered Name", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    }

    @And("^enter work mail (.+)$")
    public void enter_work_mail_for_customer(String email) throws Throwable {
        
    	EnterWorkMail(driver, waitTime, email);
    	test.pass("Successfully Entered email", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    	
    }

    @And("^enter contact number (.+)$")
    public void enter_contact_number(String contact) throws Throwable {
    	
    	EnterContactNmumber(driver, waitTime,contact );
    	test.pass("Successfully entered contact number", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    }

    @And("^enter company size (.+)$")
    public void enter_company_size(String size) throws Throwable {
    	SelectCompanySize(driver, waitTime, size);
    	test.pass("SuccessFully Selected Company Size", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    }

    @And("^enter  service the customer is looking for(.+)$")
    public void enter_service_the_customer_is_looking_for(String service) throws Throwable {
    	SelectService(driver, waitTime, "Other");
    	test.pass("Successfully Selected Service", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    }

    @And("^enter  a detailed message of the service the customer needs (.+)$")
    public void enter_a_detailed_message_of_the_service_the_customer_needs(String message) throws Throwable {
    	WriteHelpMessage(driver, waitTime, "Please do not call we are given an assesment to test before being employed");
    	test.pass("SuccessFully Entered a message", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    	
    }

    @And("^click agree to recieve the sovTech other comunication$")
    public void click_agree_to_recieve_the_sovtech_other_comunication() throws Throwable {
    	AggreeToBeContacted( driver, waitTime) ;
    	test.pass("succesfully Clicked CheckBox", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    }

    @And("^click submit button$")
    public void click_submit_button() throws Throwable {
    	ClickSubmitButton( driver, waitTime) ;
    	test.pass("succesfully clicked submit Button", MediaEntityBuilder.createScreenCaptureFromBase64String(helperMethods.takeSnapShot(driver) ).build())   ;
    	
    }
    @After
	public void afterMethod() {
		
    	driver.quit();
		
	}

}
