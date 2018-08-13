package pageObjects;

public interface Case2PO {

	// ---Facebook Login

	public final static String id_PromotionPopupCancelButton = "onesignal-popover-cancel-button";

	public final static String css_RemindMeLaterLink = ".remind";
	public final static String css_UserIcon = ".icon-user";
	public final static String css_AmberButton = ".btn.btn-empty.btn-empty-amber.loginWithAmber";

	public final static String id_MobilePrefix = "MobilePrefix";
	public final static String id_MobileNumber = "txtMobileNo";
	public final static String id_ContinueButton = "continue";

	public final static String id_TextPinField = "txtPin";
	public final static String xpath_PinFailMsg = "//*[@class='regular-white-text-p']";

	// ---Product Listing

	public final static String css_LoadMoreButton = ".btn.btn-success.btn-block.load-more";
	public final static String css_ProductListing = ".lazy-hover.hover-img";
	public final static String css_SearchIcon = ".icon-search";
	public final static String xpath_SearchTextField = "//*[@placeholder='Search']";
	public final static String xpath_SearchSubmitIcon = "//input[@type='submit']";
	public final static String xpath_DesignerName = "//*[@class='product-item-bottom']/div[1]/strong/div";

}