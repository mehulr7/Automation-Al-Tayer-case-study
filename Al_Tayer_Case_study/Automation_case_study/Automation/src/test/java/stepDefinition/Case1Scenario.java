package stepDefinition;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import actions.Case1Action;
import actions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Case1Scenario extends actions.Case1Action implements pageObjects.Case1PO{
	
	public String Email;
		
	@Given("^Create An Account page$")
	public void create_An_Account_page() throws IOException, InterruptedException{
	    
		actions.Common.scenarioName("Register Account", "1.1 Register Account We need you to register an account on nisnass through automation");
		actions.Case1Action.clickSignUpLink();
	    
	}

	@When("^Enter all mandatory fields$")
	public void enter_all_mandatory_fields() throws IOException{
		
		String fName = actions.Common.getValue("FirstName")+RandomStringUtils.randomAlphabetic(2);
		String lName = actions.Common.getValue("LastName")+RandomStringUtils.randomAlphabetic(2);
	           Email = RandomStringUtils.randomAlphabetic(2)+actions.Common.getValue("Email");
		String Phone = actions.Common.getValue("PhoneNumber")+RandomStringUtils.randomNumeric(5);
	    
		actions.Case1Action.enterField(fName, lName, Email, Phone, actions.Common.getValue("Password"));
	    
	}

	@When("^Click on Create An Account button$")
	public void click_on_Create_An_Account_button() throws InterruptedException{
		
	    actions.Case1Action.clickProfileSignUpButton();
	    
	}

	@Then("^User redirect to Home page and Account icon display$")
	public void user_redirect_to_Home_page_and_Account_icon_display() throws IOException{
	   
	    String getCurrentURL = driver.getCurrentUrl();
	    extentTest.log(LogStatus.INFO, "Getting current URL");
	    Assert.assertTrue(getCurrentURL.equals(actions.Common.getValue("Case1URL")), "URL does not matched. Assertion fail");
	    extentTest.log(LogStatus.INFO, "Verified account created successfully and redirect to home page");
	    
	}

	@When("^I click on My Account option$")
	public void i_click_on_My_Account_option() throws IOException, InterruptedException{
	    
	    actions.Case1Action.clickMyAccount();
		
	}

	@When("^Click on Edit link under your detail section$")
	public void click_on_Edit_link_under_your_detail_section(){
	    
		actions.Case1Action.clickEditLink();
	}

	@Then("^Email address display in non-editable mode$")
	public void email_address_display_in_non_editable_mode(){
	    
		
		boolean checkEmailStatus = actions.Case1Action.verifyForNonEditEmailField();
		Assert.assertFalse(checkEmailStatus, "Email is enable. Assertion fail :(");
		extentTest.log(LogStatus.INFO, "Verified email field is non editable");
	    
	}

	@Then("^it is the same email with which you registered the account$")
	public void it_is_the_same_email_with_which_you_registered_the_account(){
		
		String getExistingEmail = actions.Case1Action.verifySameEmailExist();
		System.out.println(getExistingEmail);
		Assert.assertTrue(getExistingEmail.contains(Email), "Email id does not matched. Assertion failed");
		extentTest.log(LogStatus.INFO, "Verified same email exist");
	    
	    
	}

	@When("^Update the phone number and click on Update details button$")
	public void update_the_phone_number_and_click_on_Update_details_button() throws InterruptedException, IOException{
		
		actions.Case1Action.updatePhoneNumber(Common.getValue("UpdationPhoneNo"));
		
	}

	@Then("^Phone number is updated successfully$")
	public void phone_number_is_updated_successfully() throws IOException{
		
		String getUpdatedPhoneNo = Case1Action.verifyUpdatedPhoneNo();
		extentTest.log(LogStatus.INFO, "Getting updated phone numbe as"+ getUpdatedPhoneNo);
		Assert.assertTrue(getUpdatedPhoneNo.contains(Common.getValue("UpdationPhoneNo")), "Phone number does not updated. Assertion Failed");
		extentTest.log(LogStatus.INFO, "Verified phone number updated successfully");
	    
	}
	

}
