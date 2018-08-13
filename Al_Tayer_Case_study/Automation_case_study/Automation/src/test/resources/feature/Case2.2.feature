Feature: Case 2.2: Product Listing Page 



@ProductListing
Scenario: Product Listing Page 

Given URL to open the product listing
When Scroll down the page until seventy two items display
And Click on Load more button
And Search for the designer name
Then Verify products only display with title Christian Sirano as a brand is displayed


