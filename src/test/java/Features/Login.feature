Feature: Login/Signin into Spicejet.com

Scenario Outline: Validating the positive test

Given Initialise the browser with Chrome
And Navigate to "https://www.spicejet.com/" website
And Hover the mouse on the LOGIN/SIGNUP
When Click on Member Login
Then User enters <username> and <password>
And Check if login button is displayed
And Close browsers

Examples:
|username                   |password        |
|7208935924                 |123456          |
|charithats@gmail.com       |123456          |
