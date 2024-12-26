package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;

public class HomePageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public HomePageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTour;

	@FindBy(xpath = "//h1[contains(text(), 'Welcome Admin,')]")
	WebElement welcomeAdminHeading;

	@FindBy(xpath = "//div[@class='info-box-content']")
	List<WebElement> allTiles;

	@FindBy(id = "btnCalculator")
	WebElement btnCalculator;

	@FindBy(xpath = "//span[contains(text(),'Management')]")
	WebElement userManagementBtn;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	WebElement usersOptionInUserManagement;

	@FindBy(id = "tour_step5_menu")
	WebElement productsBtnMainInHome;

	@FindBy(xpath = "(//i[contains(@class,'fa-list')])[1]")
	WebElement listProductsUnderProductsBtn;

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	WebElement adminBtn;

	@FindBy(xpath = "//a[contains(text(),'Out')]")
	WebElement signOutBtn;
	
	@FindBy(xpath = "//h1[contains(text(),'POS')]")
	WebElement loginPageDemoHd;

	public void clickOnEndTour() {
		
        try {
            if (endTour.isDisplayed()) {
            	endTour.click();
                System.out.println("Tour popup appeared and 'End tour' button clicked.");
            }
        } catch (Exception e) {
            System.out.println("Tour popup did not appear. Moving on...");
        }	

}

	public String getTextOfWelcomeAdmin() {

		return gl.getTextOfElement(welcomeAdminHeading);
	}

	public boolean isAllTilesDisplayed() {
		for (WebElement element : allTiles) {
			gl.elementIsDisplayed(element);

		}
		return true;
	}

	public void hoverTheMouseOnCalculator() {

		gl.moveToElement(driver, btnCalculator);
	}

	public String getAttributeValueOfTitleOfCalculator(String attribute) {

		return gl.getAttributeValueOfElement(btnCalculator, attribute);
	}

	public void clickUserManagementBtnInHomePage() {

		gl.clickElement(userManagementBtn);
	}

	public ManageUserPageClass clickOnUsersOptionUnderUserMngmt() {

		gl.clickElement(usersOptionInUserManagement);

		return new ManageUserPageClass(driver);
	}

	public ManageProductPageClass clickOnListProductsBtnUnderProducts() {

		gl.clickElement(productsBtnMainInHome);
		gl.clickElement(listProductsUnderProductsBtn);
		return new ManageProductPageClass(driver);
	}
	public LoginPageClass signOutFromHomePage() {

		gl.clickElement(adminBtn);
		gl.clickElement(signOutBtn);
		return new LoginPageClass(driver);
	}
	public String getTextOfDemo_POSHeadingInLoginPage() {

		return gl.getTextOfElement(loginPageDemoHd);
	}


}
