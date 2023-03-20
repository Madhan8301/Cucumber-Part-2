Feature: TalentX Calender

Scenario: Login to TalentX Application

	Given Navigate to the Landing Page
	When Select KGISL Technologies Private Limited in the dropdown
	Then Enter the User name
	Then Enter the password
	And Click Login button
	Then Click on the Calender Icon
	Then Get the date input from the User
	Then Catch all the Details in a particlar Date
	And Print that details in the console
#	Then Click the Regularaize button
#	Then click on Date section