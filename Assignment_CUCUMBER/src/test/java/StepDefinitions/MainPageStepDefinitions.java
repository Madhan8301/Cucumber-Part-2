package StepDefinitions;

import PageObjects.MainPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

public class MainPageStepDefinitions {
	
	public TestContextSetup control;
	public String date;
	public String details;
	
	public MainPageStepDefinitions(TestContextSetup control) {
		this.control=control;
	}
	
	@Then("^Click on the Calender Icon$")
    public void click_on_the_calender_icon() throws Throwable {
        MainPage mainPage = control.pageObjectsManager.getMainPage();
        mainPage.goToCalender();
    }
	
	@Then("^Get the date input from the User$")
    public void get_the_date_input_from_the_user() throws Throwable {
        MainPage mainPage = control.pageObjectsManager.getMainPage();
        date = mainPage.GetDatefromUser();
    }
  

    @Then("^Catch all the Details in a particlar Date$")
    public void catch_all_the_details_in_a_particlar_date() throws Throwable {
    	 MainPage mainPage = control.pageObjectsManager.getMainPage();
         details = mainPage.GotoUserDate(date);
    }

    @And("^Print that details in the console$")
    public void print_that_details_in_the_console() throws Throwable {
    	MainPage mainPage = control.pageObjectsManager.getMainPage();
        mainPage.DisplayDetails(details,date);
    }
    @And("^Get the total working hous of the Month$")
    public void get_the_total_working_hous_of_the_month() throws Throwable {
    	MainPage mainPage = control.pageObjectsManager.getMainPage();
    	mainPage.getTotalWorkingHours();
    }
    
    

}
