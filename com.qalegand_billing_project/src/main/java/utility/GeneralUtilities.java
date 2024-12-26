package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public void clickElement(WebElement element) {
		element.click();
	}

	public void typeElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clearElement(WebElement element) {
		element.clear();
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}

	public String getAttributeValueOfElement(WebElement element, String attributeName) {

		return element.getAttribute(attributeName);
	}

	public Boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void addSleep(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public void clickUsingJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void toAcceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void toDismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String toGetTextOfAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void typeElementAlert(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void toSelectElementIndex(WebElement element, int index) {
		element.click();
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void pressTabKey(WebDriver driver) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.keyUp(Keys.TAB).perform();
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}

}
