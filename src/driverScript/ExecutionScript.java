package driverScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utlility.CommonMethods;

import pages.DegreeTypePage;


public class ExecutionScript {
	
public static WebDriver driver; 	
	
	public static WebDriver browserName(String bName) {
		
		if (bName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (bName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		return driver;
	}

public static void main(String[] args) {
		
		
       browserName("Chrome");
		
		
		 driver.get("https://nu-edu-develop4.go-vip.net/applyformio");
		
		 DegreeTypePage.Select_degreetype();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DegreeTypePage.Degreetype_Nextbtn();

	}

}
