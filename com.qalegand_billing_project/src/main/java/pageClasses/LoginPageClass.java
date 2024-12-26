package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public LoginPageClass(WebDriver driver) { 										
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//strong[contains(text(),'credentials')]") 
	WebElement unsuccessLoginMsg;

	@FindBy(xpath = "//input[@name='remember']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//a[contains(@class,'btn-link')]")
	WebElement forgotYourPassLink;
	
	@FindBy(xpath = "//div[@class='panel-heading']")
	WebElement resetPasswordMsg;

	public HomePageClass login(String uname, String pass) {

		gl.typeElement(username, uname);
		gl.typeElement(password, pass);
		gl.clickElement(loginButton);

		return new HomePageClass(driver); 
	}

	public String getTextOfUnSuccessfullLogin() {

		return gl.getTextOfElement(unsuccessLoginMsg);
	}

	public boolean checkRememberMeCheckBoxSelected() {

		return gl.elementIsDisplayed(rememberMeCheckBox);
	}

	public String getCurrentUrlOfThePage() {

		return gl.getCurrentUrlOfPage(driver);
	}
	public void clickOnForgotYourPasswordLink() {

		gl.clickElement(forgotYourPassLink);
	}
	public String getTextOfResetPasswordMsg() {

		return gl.getTextOfElement(resetPasswordMsg);
	}

}
