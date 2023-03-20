package StepDefinitions;

import PageObjects.LoginPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {
	public TestContextSetup control;
	
	public LoginPageStepDefinition(TestContextSetup control) {
		this.control=control;
	}
	
	@Given("^Navigate to the Landing Page$")
    public void navigate_to_the_landing_page() throws Throwable {
		LoginPage loginPage = control.pageObjectsManager.getLoginPage();
		loginPage.goToUrl();       
    }

    @When("^Select KGISL Technologies Private Limited in the dropdown$")
    public void select_kgisl_technologies_private_limited_in_the_dropdown() throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
    	loginPage.ChangeDropdownOptions();
    }

    @Then("^Enter the User name$")
    public void enter_the_user_name() throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
        loginPage.enterUserName(null);
    }

    @Then("^Enter the password$")
    public void enter_the_password() throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
        loginPage.enterPassword();
    }


    @And("^Click Login button$")
    public void click_login_button() throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
        loginPage.Submit();
    }
    
    @Then("^Enter the User name \"([^\"]*)\"$")
    public void enter_the_user_name_something(String strArg1) throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
    	loginPage.enterUserName(strArg1);
    }
    
    @And("^Click Loginer button$")
    public void click_loginer_button() throws Throwable {
    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
        loginPage.ErrorSubmit();
    }
    
//    @Then("^Click the Regularaize button$")
//    public void click_the_regularaize_button() throws Throwable {
//    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
//    }
//
//    @Then("^click on Date section$")
//    public void click_on_date_section() throws Throwable {
//    	LoginPage loginPage = control.pageObjectsManager.getLoginPage();
//    }
    
   

}
