package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExplicitWaitClass;
import utility.FileUploadUtility;
import utility.GeneralUtilities;

public class ManageUserPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FileUploadUtility fl = new FileUploadUtility();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public ManageUserPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[contains(text(),'Manage')]")
	WebElement manageUsersHeading;

	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement addButton;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm_password")
	WebElement confirm_password;

	@FindBy(id = "submit_user_button")
	WebElement submit_user_button;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;

	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[2]")
	WebElement searchNameFilter;

	public String getTextOfManageUsersHeading() {

		return gl.getTextOfElement(manageUsersHeading);
	}

	public void addUserInManageUsers(String fnam, String mail, String uname, String pass, String confpass) throws InterruptedException {

		gl.clickElement(addButton);
		gl.typeElement(firstName, uname);
		gl.typeElement(email, mail);
		gl.typeElement(username, uname);
		gl.typeElement(password, pass);
		gl.typeElement(confirm_password, confpass);
		gl.clickElement(submit_user_button);
		gl.addSleep(driver);
	}

	public void searchTheAddedUserInSearchBoxAfterAddition(String searchdata) {

		gl.typeElement(searchBox, searchdata);

	}

	public boolean isCreatedUserNameDisplayed() {

		return gl.elementIsDisplayed(searchNameFilter);

	}
}
