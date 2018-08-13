package actions;

import java.io.IOException;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.Case1PO;



public class Case1Action extends Common implements Case1PO{
	
		
	public static void clickSignUpLink() throws IOException, InterruptedException{
		
		
		launchBrowser();
		open_URL(getValue("Case1URL"));
		extentTest.log(LogStatus.INFO, "URL opened");

		driver.findElement(By.cssSelector(Case1PO.css_AccountLink)).click();
		extentTest.log(LogStatus.INFO, "Clicked on Account link to open SignIn popup");
		driver.findElement(By.cssSelector(Case1PO.css_SignUpButton)).click();
		extentTest.log(LogStatus.INFO, "Clicked on signup button");
	}
	
	
	public static void enterField(String Fname, String Lname, String Email, String Phone, String Changepwd){
		
		
		
		driver.findElement(By.cssSelector(Case1PO.css_FirstNameTextField)).sendKeys(Fname);
		extentTest.log(LogStatus.INFO, "Entered firstname as "+Fname);
		
		driver.findElement(By.cssSelector(Case1PO.css_LastNameTextField)).sendKeys(Lname);
		extentTest.log(LogStatus.INFO, "Entered lastname as "+Lname);
		
		driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).sendKeys(Email);
		extentTest.log(LogStatus.INFO, "Entered email as "+Email);
		driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).sendKeys(Phone);
		extentTest.log(LogStatus.INFO, "Entered phone number as "+Phone);
		
		driver.findElement(By.cssSelector(Case1PO.css_PasswordTextField)).sendKeys(Changepwd);
		extentTest.log(LogStatus.INFO, "Entered password as "+Changepwd);
		driver.findElement(By.cssSelector(Case1PO.css_SubscribeCheckBox)).click();
		extentTest.log(LogStatus.INFO, "Clicked on subscribe checkbox");

		
	}
	
	
	public static void clickProfileSignUpButton() throws InterruptedException{
		
		driver.findElement(By.cssSelector(Case1PO.css_ProfileSignUpButton)).click();
		extentTest.log(LogStatus.INFO, "Clicked on profile signup button");
		Thread.sleep(10000);
	}
	
	
public static void clickMyAccount() throws IOException, InterruptedException{
		
		
	driver.findElement(By.cssSelector(Case1PO.css_AccountLink)).click();
	extentTest.log(LogStatus.INFO, "Clicked on Account link");
	
	}
	
	public static void clickEditLink(){
		
		driver.findElement(By.linkText(Case1PO.linkText_YourDetailEditLink)).click();
		extentTest.log(LogStatus.INFO, "Clicked on edit icon under your detail section");
		
		
	}
	
	public static boolean verifyForNonEditEmailField(){
		
		extentTest.log(LogStatus.INFO, "Verifying email field is non editable");
		boolean getStatusOfEmailField = driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).isEnabled();
		return getStatusOfEmailField;
	}
	
        public static String verifySameEmailExist(){
		
        extentTest.log(LogStatus.INFO, "Verifying added email exist");
       String getEmailId = driver.findElement(By.cssSelector(Case1PO.css_EmailTextField)).getAttribute("value");
	   return getEmailId;

	
	
	}
        
        
        public static void updatePhoneNumber(String updatephone) throws InterruptedException{
        	
        	
        	driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).clear();
        	extentTest.log(LogStatus.INFO, "Clear the previous phone number");
        	driver.findElement(By.cssSelector(Case1PO.css_PhoneNumber)).sendKeys(updatephone);
        	extentTest.log(LogStatus.INFO, "Entered updated phone number");
        	driver.findElement(By.cssSelector(Case1PO.css_UpdateDetailButton)).click();
        	extentTest.log(LogStatus.INFO, "Clicked on update detail button to update the number");
        	Thread.sleep(2000);
        }
        
        public static String verifyUpdatedPhoneNo() {
        	
        	driver.navigate().back();
        	extentTest.log(LogStatus.INFO, "Clicked on browser's back button to verifying updated phone number");
    		String PhoneNo = null;
    		try {
    			PhoneNo = driver.findElement(By.xpath(".//*[contains(text(),' "+Common.getValue("UpdationPhoneNo")+"')]")).getText();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			e.printStackTrace();
    		}
    		
			return PhoneNo;
    		
    		
        	
        }
        
	
        
	}


