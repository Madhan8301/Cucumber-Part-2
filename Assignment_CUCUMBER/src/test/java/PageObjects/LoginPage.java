package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Dropdown = By.cssSelector("#CompanyId");
	By username = By.cssSelector("#Username");
	By passWord = By.cssSelector("#Password");
	By login = By.cssSelector(".bigger-110");
	

	public void goToUrl() throws IOException {
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String actualUrl = prop.getProperty("url");
		driver.get(actualUrl);
	}
	
	public void ChangeDropdownOptions() {
		//dropDown.click();
		//username.sendKeys("Madhan");
		WebElement SD = driver.findElement(Dropdown);
		SD.click();
		Select sc = new Select(SD);
		sc.selectByVisibleText("KGISL Technologies Private Limited");
		
	}
	
	public void enterUserName(String Name) {
		if (Name==null) {
		driver.findElement(username).sendKeys("madhan.kumar");
		} else {
			driver.findElement(username).sendKeys(Name);
		}
	}
	public void enterPassword() {
		driver.findElement(passWord).sendKeys("Yaalisai@6765");
	}
	public void Submit() {
		driver.findElement(login).click();
		
	}
	public void ErrorSubmit() {
		driver.findElement(login).click();
		String msg = driver.findElement(By.cssSelector(".error")).getText();
		if(msg.equalsIgnoreCase("Invalid Username/Password")) {
			Assert.assertEquals(msg, "Invalid Username/Password1");
		} 
	}

}
