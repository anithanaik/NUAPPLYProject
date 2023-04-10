package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverScript.ExecutionScript;

public class DegreeTypePage {

	public static void Select_degreetype() {
		WebDriverWait wait = new WebDriverWait(ExecutionScript.driver, 20);
		WebElement degreeradio = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-check:nth-of-type(6) span")));
		ScrollToElementAndClick(degreeradio);

	}

	public static void Degreetype_Nextbtn() throws InterruptedException {
		Thread.sleep(2000);
		WebElement degreetypebtn = ExecutionScript.driver.findElement(By.xpath("//button[contains(.,'Next')]"));
		ScrollToElementAndClick(degreetypebtn);

	}

	public static void selectStudyArea() {
		WebDriverWait wait = new WebDriverWait(ExecutionScript.driver, 20);
		WebElement degreeradio = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),'Science & Math')]/preceding-sibling::input")));
		ScrollToElementAndClick(degreeradio);

	}

	public static void Nextbtn() throws InterruptedException {
		Thread.sleep(2000);
		WebElement degreetypebtn = ExecutionScript.driver.findElement(By.xpath("//button[contains(.,'Next')]"));
		ScrollToElementAndClick(degreetypebtn);
	}

	public static void ScrollToElementAndClick(WebElement element) {
		waitForElementToBeClickable(element);
		JavascriptExecutor js = ((JavascriptExecutor) ExecutionScript.driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("window.scrollBy(0, -250);", element);
		js.executeScript("arguments[0].click();", element);

	}

	public static void waitForElementToBeClickable(WebElement element) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(ExecutionScript.driver).withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
