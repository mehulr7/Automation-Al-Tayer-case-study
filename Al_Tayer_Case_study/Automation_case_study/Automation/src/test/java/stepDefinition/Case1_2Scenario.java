package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import actions.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Case1PO;

public class Case1_2Scenario extends Common implements Case1PO{
	
	
	public String item1GetBrandNameBeforeAdd;
	public String item2GetBrandNameBeforeAdd;
	public String item3GetBrandNameBeforeAdd;
	
	
	@Given("^Items URL to be add$")
	public void items_URL_to_be_add(){
		
		actions.Common.scenarioName("Add to Bag", "1.2 Write a test-case which can add these types of items into the bag and then verify that they are added into the “Bag”");
		Common.launchBrowser();
		
	}

	@When("^Open the One Size item in browser$")
	public void open_the_One_Size_item_in_browser() throws InterruptedException, IOException {
	    
		Common.open_URL(Common.getValue("FirstURL"));
		extentTest.log(LogStatus.INFO, "URL opened for "+Common.getValue("FirstURL"));
		
		item1GetBrandNameBeforeAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameBeforeAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name before add to card");
	}

	@When("^Click on ADD TO BAG button$")
	public void click_on_ADD_TO_BAG_button() throws InterruptedException {
		
		Common.driver.findElement(By.cssSelector(Case1PO.css_AddToBagButton)).click();
		Thread.sleep(5000);
		extentTest.log(LogStatus.INFO, "Clicked on Add to bag button");
	    
	}

	@When("^Click on BAG icon at top-right corner$")
	public void click_on_BAG_icon_at_top_right_corner() {
	    
		Common.driver.findElement(By.cssSelector(Case1PO.css_TopRightCornerBagIcon)).click();  
		extentTest.log(LogStatus.INFO, "Clicked on bag icon from top-right corner");
	}

	@Then("^One Size item display in My Bag section$")
	public void one_Size_item_display_in_My_Bag_section() {
		
		String item1GetBrandNameAfterAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameAfterAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name after add to card");
		
		Assert.assertEquals(item1GetBrandNameBeforeAdd, item1GetBrandNameAfterAdd);
		extentTest.log(LogStatus.INFO, "Verified expected and actual brand names are matched successfully");
	    
	}

	@Then("^Remove One Size item from bag$")
	public void remove_One_Size_item_from_bag() {
		
		driver.findElement(By.cssSelector(Case1PO.css_CartRemoveIcon)).click();
		driver.findElement(By.cssSelector(Case1PO.css_RemoveConfirmationButton)).click();
		
		WebElement element = driver.findElement(By.cssSelector(Case1PO.css_LetsShopButton));
		Common.waitForElement(element);
	    System.out.println("First Item Passed");
	    
	}

	@When("^Open the Pink Color with sized item in browser$")
	public void open_the_Pink_Color_with_sized_item_in_browser() throws InterruptedException, IOException {
	    
		Common.open_URL(Common.getValue("SecondURL"));
		extentTest.log(LogStatus.INFO, "URL opened for "+Common.getValue("SecondURL"));
		
		item2GetBrandNameBeforeAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameBeforeAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name before add to card");
	    
	}

	@When("^Select Pink color and size$")
	public void select_Pink_color_and_size() {
		
		driver.findElement(By.xpath(Case1PO.xpath_PinkColorItem)).click();
		extentTest.log(LogStatus.INFO, "Clicked on pink color button");
		driver.findElement(By.xpath(Case1PO.xpath_SizeSelectionOption)).click();
		extentTest.log(LogStatus.INFO, "Clicked on 9.5 size button");
	    
	    
	}

	@Then("^Selected item display in My Bag section$")
	public void selected_item_display_in_My_Bag_section() {
	    
		String item2GetBrandNameAfterAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameAfterAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name after add to card");
		
		Assert.assertEquals(item2GetBrandNameBeforeAdd, item2GetBrandNameAfterAdd);
		extentTest.log(LogStatus.INFO, "Verified expected and actual brand names are matched successfully");
		
		List<WebElement> getColorAndSize = driver.findElements(By.cssSelector(Case1PO.css_AttributeValues));
		extentTest.log(LogStatus.INFO, "Getting attribute values(Color and size) from bag");
		List<String> list = new ArrayList<>();
		list.add("Pink");list.add("9.5");
		for(WebElement getAttributeValues:getColorAndSize) {
			String getValue = getAttributeValues.getText();
			org.testng.Assert.assertTrue(list.contains(getValue), "Attrubute values not matched");
		}
		extentTest.log(LogStatus.INFO, "Verified expected and actual brand color and size are matched successfully");
	    
	}

	@Then("^Remove selected item from bag$")
	public void remove_selected_item_from_bag() {
	    
		driver.findElement(By.cssSelector(Case1PO.css_CartRemoveIcon)).click();
		driver.findElement(By.cssSelector(Case1PO.css_RemoveConfirmationButton)).click();
		
		WebElement element = driver.findElement(By.cssSelector(Case1PO.css_LetsShopButton));
		Common.waitForElement(element);
	    System.out.println("Second item passed");
	    
	}

	@When("^Open the Size item in browser$")
	public void open_the_Size_item_in_browser() throws InterruptedException, IOException {
	    
		Common.open_URL(Common.getValue("ThirdURL"));
		extentTest.log(LogStatus.INFO, "URL opened for "+Common.getValue("ThirdURL"));
		
		item3GetBrandNameBeforeAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameBeforeAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name before add to card");
	    
	}

	@When("^Select Size$")
	public void select_Size() {
	    
		driver.findElement(By.xpath(Case1PO.xpath_SizesSelectionOption)).click();
		extentTest.log(LogStatus.INFO, "Clicked on size39 button");
	}

	@Then("^Choosed item display in My Bag section$")
	public void choosed_item_display_in_My_Bag_section() {
		
		String item3GetBrandNameAfterAdd = driver.findElement(By.cssSelector(Case1PO.css_ProductBrandNameAfterAdded)).getText();
		extentTest.log(LogStatus.INFO, "Getting brand name after add to card");
		
		Assert.assertEquals(item3GetBrandNameBeforeAdd, item3GetBrandNameAfterAdd);
		extentTest.log(LogStatus.INFO, "Verified expected and actual brand names are matched successfully");
		
		WebElement getSelectedSize = driver.findElements(By.cssSelector(Case1PO.css_AttributeValues)).get(1);
		
		extentTest.log(LogStatus.INFO, "Getting attribute values(size 39) from bag");
		Assert.assertEquals(getSelectedSize.getText(), "39");
		extentTest.log(LogStatus.INFO, "Verified expected and actual size is matched successfully");
	    
	    
	}

	@Then("^Remove choosed item from bag$")
	public void remove_choosed_item_from_bag() {
	    
		driver.findElement(By.cssSelector(Case1PO.css_CartRemoveIcon)).click();
		driver.findElement(By.cssSelector(Case1PO.css_RemoveConfirmationButton)).click();
		
		WebElement element = driver.findElement(By.cssSelector(Case1PO.css_LetsShopButton));
		Common.waitForElement(element);
	    System.out.println("Third Item Passed");
	    
	}

}
