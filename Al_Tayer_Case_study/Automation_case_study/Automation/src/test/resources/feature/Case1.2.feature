Feature: Case1.2: Add to bag

	@AddBag
	Scenario: Add to bag
	
	Given Items URL to be add
	When Open the One Size item in browser
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then One Size item display in My Bag section
	And Remove One Size item from bag
	When Open the Pink Color with sized item in browser
	And Select Pink color and size
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then Selected item display in My Bag section
	And Remove selected item from bag
	When Open the Size item in browser
	And Select Size
	And Click on ADD TO BAG button
	And Click on BAG icon at top-right corner
	Then Choosed item display in My Bag section
	And Remove choosed item from bag
	