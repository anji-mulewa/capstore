Feature: Testing the feedback feature for customer

Background:
Given customer has loaded the application in the browser
When customer clicks on the login link
Then customer is navigated to login form page
When customer enters valid email and valid password
And click on login button
Then customer should get navigated to customer home page

Scenario: Testing the common feedback insertion
Given customer is on home page
When customer clicks on give common feedback link
Then customer is navigated to feedback form page
When customer enters feedback in the feedback textbox
When customer selects brand name from the brand name drop down
And customer enters rating in the rating textbox
And the customer clicks on Submit button
Then the customer home page must be displayed

Scenario: Testing the insertion of product feedback
Given the customer is in the order history details page
When the customer clicks on feedback button
Then the customer enters the rating in the rating textbox
And the customer enters the product feedback in the feedback textbox
And the customer clicks on submit button
Then the customer is redirected to customer home page
   

