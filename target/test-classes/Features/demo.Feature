Feature:
User have to Enter Adactin page and have to Book a Room for a particular day.
Scenario: Have to enter the Adactin page and enter the username and password click login
			Given User have to enter the Adactin page on Chrome portal
			And Have to maximaize the Window and check the correct Url is entered or not.
			When User have to enter the UserName and Password and click the login page.
			And Have to check entered in a new Window.
			Then Print the new window page title and URl and title
			And Take a screenshot of the page.

Scenario: User have to fill the text boxes in Adactin page and book the Room 
			When  have to enter the values on mandatory fields on Adactin page  
			Then  Take a Screenshot of the page 
			And 	Click the next page.
Scenario: 	User have to print the hotel name and mark the Hotel 
			Given Have to check the Hotel name is correct
			And 	Have print the Hotel name 
			When  Have Mark the Hotel for booking 
			And 	Have toGet the Screenshot for the confirmation
			Then 	Have Click the Next page 			

  
 






