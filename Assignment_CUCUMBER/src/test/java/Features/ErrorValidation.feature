Feature: ErrorValidation

Scenario: To login With the Invalid Username

Given Navigate to the Landing Page
	When Select KGISL Technologies Private Limited in the dropdown
	Then Enter the User name "Madhan.KumarM"
	Then Enter the password
	And Click Loginer button