package Runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;

import StepDefinations.Steps;
import Utillities.HelperMethods;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  


@RunWith( Cucumber.class )
@CucumberOptions(
		features= {"src/test/resources/Features"}, 
		glue= {"StepDefinations"},  
		monochrome =  true
		)
		
public class RunnerClass {
	
    public static ExtentReports extent;
	
    
    
    
    
	public void runTest() {
		
		
	}
	
	
	@BeforeClass
	public static void setUp() {
		System.out.println("bofore................");
		extent=   HelperMethods.setUpExtendReport();
	
	}
	@AfterClass
	public static void tearDown() {
		// TODO: Add tear down code
		
		System.out.println("after................");
		extent.flush();
	}

}
