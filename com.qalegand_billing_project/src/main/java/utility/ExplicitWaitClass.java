package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	WebDriverWait wait;
	
	public void vivsibilityOfElement(WebElement element,WebDriver driver) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.visibilityOf(element));		
	}

	public void elementToBeClickableWait(WebElement element,WebDriver driver) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	public void elementToBeSelectedWait(WebElement element,WebDriver driver) {
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.elementToBeSelected(element));		
	}
	
	public void presenceOfElementLocatedWaitByXpath(WebDriver driver,String locator) {

		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));		
	}
	
	public void presenceOfElementLocatedWaitById(WebDriver driver,String locator) {

		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));		
	}
	
	public void presenceOfElementLocatedWaitByName(WebDriver driver,String locator) {

		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
	}
	
	public void alertPresentWait(WebDriver driver) {
		 wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		 wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	
}
