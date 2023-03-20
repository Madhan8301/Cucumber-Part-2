package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver getDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		if (driver == null) {
			if (Browser.equalsIgnoreCase("Chrome")) {
				
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);	
			} 
			else if (Browser.equalsIgnoreCase("FireFox")) {
				
				driver = new FirefoxDriver();
				
			} 
			else if (Browser.equalsIgnoreCase("Edge")) {
				
				driver = new EdgeDriver();
				
			}
		}
		driver.manage().window().maximize();

		return driver;

	}

}
