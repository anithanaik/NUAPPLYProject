package driverScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import utlility.CommonMethods;
import pages.DegreeTypePage;
import pages.*;

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

	public static void main(String[] args) throws InterruptedException {

		browserName("Chrome");

		driver.get("https://nu-edu-develop4.go-vip.net/applyformio");
		driver.manage().window().maximize();

		DegreeTypePage.Select_degreetype();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DegreeTypePage.Degreetype_Nextbtn();
		handleFeedbackWindow();
		Thread.sleep(2000);
		DegreeTypePage.selectStudyArea();
		DegreeTypePage.Nextbtn();
		//handleFeedbackWindow();

	}

	public static void handleFeedbackWindow() throws InterruptedException {
		Thread.sleep(8000);

		List<WebElement> feedbackPopup = driver.findElements(By.xpath(
				"//div[@class='QSIWebResponsive-creative-container-fade']/div/div[3]/button[contains(text(),'Provide Feedback')]"));
		int i = feedbackPopup.size();
		if (i > 0) {
			driver.switchTo().activeElement();
			driver.findElement(By.xpath(
					"//div[@class='QSIWebResponsive-creative-container-fade']/div/div[3]/button[contains(text(),'No Thanks')]"))
					.click();
			waitForPageLoaded();
		} else {
			System.out.println("Provide feedback pop up not visible to user");
			waitForPageLoaded();
		}
	}

	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			error.printStackTrace();
		}
	}

}
