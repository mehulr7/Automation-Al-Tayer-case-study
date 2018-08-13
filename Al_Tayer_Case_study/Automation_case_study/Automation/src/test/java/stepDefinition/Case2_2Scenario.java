package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import actions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Case2PO;

public class Case2_2Scenario extends Common implements Case2PO{
	
	@Given("^URL to open the product listing$")
	public void url_to_open_the_product_listing() throws InterruptedException, IOException{
	    
		actions.Common.scenarioName("Product Listing", "Verify products only display with title Christian Sirano as a brand is displayed$");
		Common.launchBrowser();
		Common.open_URL(Common.getValue("Case2.2URL"));
		Thread.sleep(5000);
		extentTest.log(LogStatus.INFO, "URL open successfully");
		
       WebElement getCancelBtn = driver.findElement(By.id(id_PromotionPopupCancelButton));
       
       
		
		if(driver.findElement(By.id(id_PromotionPopupCancelButton)).isDisplayed()) {
			extentTest.log(LogStatus.INFO, "Cancel button display for promotion popup");
			getCancelBtn.click();
			extentTest.log(LogStatus.INFO, "Clicked on cancel button");
		}
		
		else {
			
			System.out.println("No promotion popup display");
		}
		
		WebElement remindMeLaterLink=driver.findElement(By.cssSelector(Case2PO.css_RemindMeLaterLink));
		if(remindMeLaterLink.isDisplayed()) {
			remindMeLaterLink.click();
			extentTest.log(LogStatus.INFO, "Clicked on remind me link");
		}
		
	}

	@When("^Scroll down the page until seventy two items display$")
	public void scroll_down_the_page_until_seventy_two_items_display() throws InterruptedException, AWTException{
	    
		extentTest.log(LogStatus.INFO, "Scrolling down the page until 72 items not display"); 
	    Robot robot = new Robot();
	    for(int i=0; i<25; i++) {
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        Thread.sleep(2000);
	    }
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    int getProductListingCount = driver.findElements(By.cssSelector(css_ProductListing)).size();
	    Assert.assertEquals(getProductListingCount, 72);
	    extentTest.log(LogStatus.INFO, "Verified 72 product items display after scrolling down");
	    
	}

	@When("^Click on Load more button$")
	public void click_on_Load_more_button() throws InterruptedException{
	    
	    driver.findElement(By.cssSelector(css_LoadMoreButton)).click();
	    extentTest.log(LogStatus.INFO, "Clicked on Load more button");
	    Thread.sleep(3000);
	}

	@When("^Search for the designer name$")
	public void search_for_the_designer_name() throws IOException, InterruptedException{
		
		driver.findElement(By.cssSelector(css_SearchIcon)).click();
		extentTest.log(LogStatus.INFO, "Clicked on search icon");
		driver.findElement(By.xpath(xpath_SearchTextField)).sendKeys(Common.getValue("DesignerName"));
		extentTest.log(LogStatus.INFO, "Entered designer name as "+Common.getValue("DesignerName"));
		
		driver.findElement(By.xpath(xpath_SearchSubmitIcon)).click();
		extentTest.log(LogStatus.INFO, "Clicked on search submit icon");
		Thread.sleep(3000);
	    
	}

	@Then("^Verify products only display with title Christian Sirano as a brand is displayed$")
	public void verify_products_only_display_with_title_Christian_Sirano_as_a_brand_is_displayed(){
	    
		int getDesignerNameCount = driver.findElements(By.xpath(xpath_DesignerName)).size();
		extentTest.log(LogStatus.INFO, "Getting count of designer name");

		
		Assert.assertEquals(getDesignerNameCount, 2);
		extentTest.log(LogStatus.INFO, "Verified two designer display");
		List<WebElement> ele = driver.findElements(By.xpath(xpath_DesignerName));
		
		for(WebElement elements: ele) {
			
			String getDesignerName = elements.getText();
			Assert.assertEquals(getDesignerName, "CHRISTIAN SIRIANO");
			extentTest.log(LogStatus.INFO, "Clicked on search submit icon");

			extentTest.log(LogStatus.INFO, "Verified both products are display with same designer name");
	}
	}

}
