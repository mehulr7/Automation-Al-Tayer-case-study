package pageObjects;

public interface Case1PO {
	
	
	//---Registration
	
		public final static String  css_AccountLink= ".Popup.CustomerPopup";
		public final static String  css_SignUpButton= ".SignInForm-signUpButton";
		public final static String  css_FirstNameTextField= ".Profile-firstName";
		public final static String  css_LastNameTextField= ".Profile-lastName";
		public final static String  css_EmailTextField= ".Profile-email";
		public final static String  css_PasswordTextField= ".Profile-password.no-tracking";
		public final static String  css_PhoneNumber= ".Profile-phoneNumber";
		public final static String  css_SubscribeCheckBox= "#Profile-subscribe";
		public final static String  css_ProfileSignUpButton= ".Profile-signUpButton";
		public final static String  xpath_MyAccountLink= ".//*[@class='CustomerPopup-loggedIn']/a[text()='My Account']";
		public final static String  linkText_YourDetailEditLink= "Edit";
		public final static String  css_UpdateDetailButton= ".Profile-updateDetailsButton";
		
		
		
		//---Add Bag as Saturday Skin
		
		
		public final static String  css_AddToBagButton= ".PDP-addToBag";
		public final static String  css_TopRightCornerBagIcon=".icon-bag";
		public final static String  css_ProductBrandNameBeforeAdded = ".PDP-brand";
		public final static String  css_ProductBrandNameAfterAdded = ".CartItem-brand";
		public final static String  css_CartRemoveIcon = ".CartItem-action";
		public final static String  css_RemoveConfirmationButton = ".ConfirmationModal-yesButton";
		public final static String  css_LetsShopButton = ".EmptyPage-callToAction";

		
		//---Add Bag as Zitah Classic Pumps
		
		public final static String  xpath_PinkColorItem = "//*[@alt='color_Pink']";
		public final static String  xpath_SizeSelectionOption = ".//*[@class='SizeSelection-options']/button[text()='9.5']";
		public final static String  css_AttributeValues = ".CartItem-attributeValue";
		
		
		//--- Add Bag as Mettalic Sandal
		
		public final static String  xpath_SizesSelectionOption = "//*[@class='SizeSelection-option'][text()='39']";
		
		
		
		
		
		
		
		
}
