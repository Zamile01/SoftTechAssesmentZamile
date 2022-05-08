Feature: Contact us

Scenario Outline: A user fills in the form to be contacted by a dedicated client manager
Given <TestCase>User opens a browser to <ScenariDetails>
When a user enters a URL "https://www.sovtech.co.za/contact-us"
And enter name <Name>
And enter work mail <Email>
And enter contact number <Contact>
And enter company size <Size>
And enter  service the customer is looking for <Service>
And enter  a detailed message of the service the customer needs <Message>
And click agree to recieve the sovTech other comunication
And click submit button
Then validate the message<validation>

Examples: 

|TestCase       |ScenariDetails	                            |Name   |Email               |Contact      |Size                 | Service             |Message      |validation|
|TC_ContactUs_01|filling form with all vaild details        |Sandra |DonCall@Testing.com |0741345678   |5-25								 | Other			         |do not call  |Submission Successful|
|TC_ContactUs_02|filling form with invalid email adresss    |Zamile |DonCallTesting.com  |0741345678   |25-50 							 | Other			         |do not call  |Please change your email address to continue.|
|TC_ContactUs_03|filling form with invalid Contact Number   |Zamile |DonCall@Testing.com |074134567.   |500-1000						 | Other			         |do not call  |Must contain only numbers, +()-. and x.|
|TC_ContactUs_04|filling form with invalid Contact Number   |Zamile |DonCall@Testing.com |074134567@   |50-100							 | Other			         |do not call  |Must contain only numbers, +()-. and x.|

  
