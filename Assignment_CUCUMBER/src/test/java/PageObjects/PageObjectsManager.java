package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public MainPage mainPage;
	
	public PageObjectsManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage getLoginPage() {
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	public MainPage getMainPage() {
		mainPage = new MainPage(driver);
		return mainPage;
	}

}
