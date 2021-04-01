Feature: Login into Faceabbok Application

Scenario Outline: positive test validation Fblogin
Given Initilize the browser with chrome
And Navigate to "http://www.facebook.com" site
When User enters <username> and <password>
Then User click the login button
Then Verify the user is Successfully logged in
And close the browser

Examples:
|username                      |password     |
|9177157021                    |veera(ru)    |
|pveerasankar@gmail.com		   |Navya@8688   |