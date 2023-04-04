package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverScript.ExecutionScript;

public class DegreeTypePage {
	
	public static void  Select_degreetype()
    {
WebDriverWait wait = new WebDriverWait(ExecutionScript.driver, 20);
 WebElement degreeradio= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-check:nth-of-type(6) span")));
 degreeradio.click();

    }


public static void  Degreetype_Nextbtn(){
	  WebElement degreetypebtn = ExecutionScript.driver.findElement(By.xpath("//button[contains(.,'Next')]"));
	  degreetypebtn.sendKeys(Keys.ENTER);
}


}
