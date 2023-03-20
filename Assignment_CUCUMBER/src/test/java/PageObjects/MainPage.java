package PageObjects;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	public WebDriver driver;
	
	public String date;
    public String ALLLL;
	public String actualDate;
	public String InoutDetails;
	public int sumMins=0;
	public int sumHrs=0;
	public String LastPunch,FirstPunch,EffHours,exStay,attendence;
	
	public MainPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By calender = By.xpath("//i[@class='menu-icon fa fa fa-calendar']");
	By dates = By.cssSelector("td[class*='fc-day-number']");
	By hours = By.xpath("//td/a[3]");
	By mad = By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div/div[1]/div/div/div/div/table/tbody/tr/td/div[1]/div/div/div[2]/table/tbody/tr/td");
	
	
	
	
	
	public void goToCalender() throws InterruptedException {
		driver.findElement(calender).click();
		Thread.sleep(4000);
	}
	public String GetDatefromUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the date : ");
		date=sc.next();
		return date;
		
	}
	
	public String GotoUserDate(String actualDate) {		
		List<WebElement> AllDates =	driver.findElements(dates);
		List<WebElement> det = driver.findElements(mad);
		for(int i=0;i<AllDates.size();i++) {
			String d1 = AllDates.get(i).getText().trim();
			if(d1.equalsIgnoreCase(actualDate)) {
				InoutDetails = det.get(i).getText();
				break;
			}
		}
		
	 return InoutDetails;
		
	}
	
	public void DisplayDetails(String details,String actualDate) {
		System.out.println("In out Details for the date : " +actualDate);
		System.out.println(details);
	}
	
	
	public void getTotalWorkingHours() {
		List<WebElement> workhrs = driver.findElements(hours);

		for(int i=0;i<workhrs.size();i++) {
			String act1=driver.findElements(hours).get(i).getText().split(":")[0].split(" ")[0].trim();
			if(act1.equalsIgnoreCase("Effective")) {
				String hrs = driver.findElements(hours).get(i).getText().split("Hours:")[1].split(":")[0].trim();
				String mins = driver.findElements(hours).get(i).getText().split("Hours:")[1].split(":")[1].trim();
				
				sumHrs=sumHrs+Integer.parseInt(hrs);  
				sumMins=sumMins+Integer.parseInt(mins);
			}
			
		}
		System.out.println("Total Working hours is : "+sumHrs+":"+sumMins);
	}
	

	

}


