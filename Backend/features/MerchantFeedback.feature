Feature: Testing the feedback feature for merchant

Background:
Given merchant has loaded the application in the browser
When merchant clicks on the login link
Then merchant is navigated to login form page
When merchant enters valid email and valid password
And merchant clicks on login button
Then merchant should get navigated to customer home page

Scenario: Testing the view common feedback list for merchant
Given the merchant is on the merchant home page
When the merchant clicks on see common feedback link
Then the merchant is redirected to common feedback table page


