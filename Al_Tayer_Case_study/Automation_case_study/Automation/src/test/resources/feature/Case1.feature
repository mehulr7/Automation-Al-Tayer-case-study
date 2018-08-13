Feature: Case1: Register Account

    @Register
	Scenario: Register Account
	
	
	Given Create An Account page
	When Enter all mandatory fields
	And Click on Create An Account button
	Then User redirect to Home page and Account icon display
	When I click on My Account option
	And Click on Edit link under your detail section
	Then Email address display in non-editable mode
	And it is the same email with which you registered the account 
	When Update the phone number and click on Update details button
	Then Phone number is updated successfully
	