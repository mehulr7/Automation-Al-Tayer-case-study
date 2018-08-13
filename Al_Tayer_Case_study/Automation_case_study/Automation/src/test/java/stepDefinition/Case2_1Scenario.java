package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import actions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Case2PO;

public class Case2_1Scenario extends Common implements pageObjects.Case2PO{
	
	
	
	@Given("^URL https://www\\.ounass\\.ae/$")
	public void url_https_www_ounass_ae() throws InterruptedException, IOException {
		
		actions.Common.scenarioName("Login with Facebook", "Login with facebook");
		Common.launchBrowser();
		Common.open_URL(Common.getValue("Case2URL"));
		Thread.sleep(5000);
		extentTest.log(LogStatus.INFO, "URL open successfully");
		
		WebElement getCancelBtn = driver.findElement(By.id(id_PromotionPopupCancelButton));
		
		if(getCancelBtn.isDisplayed()) {
			extentTest.log(LogStatus.INFO, "Cancel button display for promotion popup");
			getCancelBtn.click();
			extentTest.log(LogStatus.INFO, "Clicked on cancel button");
		}
		
		WebElement remindMeLaterLink=driver.findElement(By.cssSelector(Case2PO.css_RemindMeLaterLink));
		if(remindMeLaterLink.isDisplayed()) {
			remindMeLaterLink.click();
			extentTest.log(LogStatus.INFO, "Clicked on remind me link");
		}
	
	}

	@When("^Click on to User icon in top left$")
	public void click_on_to_User_icon_in_top_left() {
	    
		driver.findElement(By.cssSelector(Case2PO.css_UserIcon)).click();
		extentTest.log(LogStatus.INFO, "Clicked on user icon");
	    
	}

	@When("^Click Amber button$")
	public void click_Amber_button() {
	    
		driver.findElement(By.cssSelector(Case2PO.css_AmberButton)).click();
		extentTest.log(LogStatus.INFO, "Clicked on amber button");
	}

	@When("^Select prefix as UKcode and enter phone number$")
	public void select_prefix_as_UKcode_and_enter_phone_number() throws IOException, InterruptedException {
		
		
		Thread.sleep(5000);
		
		
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        // print your number of frames
        System.out.println(iframes.size());

        // you can reach each frame on your site
        for (WebElement iframe : iframes) {

            // switch to every frame
            driver.switchTo().frame(iframe);

            // now within the frame you can navigate like you are used t0
            
            Select select = new Select(driver.findElement(By.id(id_MobilePrefix)));
    		select.selectByVisibleText(Common.getValue("PhonePreFix"));
    		extentTest.log(LogStatus.INFO, "Select prefix as "+Common.getValue("PhonePreFix"));

    		driver.findElement(By.id(id_MobileNumber)).sendKeys(Common.getValue("Number"));
    		extentTest.log(LogStatus.INFO, "Entered mobile number as "+Common.getValue("Number"));
    		
    		driver.findElement(By.id(id_ContinueButton)).click();
    		extentTest.log(LogStatus.INFO, "Clicked on Continue");
    		
    		WebElement waitForPinField = driver.findElement(By.id(id_TextPinField));
    		
    		Common.waitForElement(waitForPinField);
    		waitForPinField.sendKeys(Common.getValue("Pin"));
    		extentTest.log(LogStatus.INFO, "Entered pin as "+Common.getValue("Pin"));
    		Thread.sleep(2000);
    		
    		WebElement getPinFailMsg = driver.findElement(By.xpath(xpath_PinFailMsg));
    		if(getPinFailMsg.isDisplayed()) {
    			
    			String getMessage = getPinFailMsg.getText();
    	         if(getMessage.contains("Sorry! The PIN you have entered is not")) {
    	        	 
    	        	 extentTest.log(LogStatus.INFO, Common.getValue("Pin")+" is wrong pin. Assertion Fail");
    	        	 Assert.fail("In valid Pin"); 
    	         }
    			
    		}
        }
        driver.switchTo().defaultContent();
		
	}


	@Then("^User redirect to home page and valid title name display$")
	public void user_redirect_to_home_page_and_valid_title_name_display() {

		String getTitle = driver.getTitle();
		System.out.println(getTitle);
		Assert.assertEquals(getTitle, "OUNASS UAE | Welcome To The Definitive Home Of Luxury");
		extentTest.log(LogStatus.INFO, "User redirect to home screen");
	    
	}

}
