package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExplicitWaitClass;
import utility.FileUploadUtility;
import utility.GeneralUtilities;

public class ManageProductPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FileUploadUtility fl = new FileUploadUtility();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public ManageProductPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//small[contains(text(),'Manage')]")
	WebElement manageProductsHeading;

	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement addBtn;

	@FindBy(id = "name")
	WebElement productName;

	@FindBy(id = "alert_quantity")
	WebElement alertQnty;

	@FindBy(xpath = "//div[contains(@class,'fileinput-caption')]")
	WebElement productImage;

	@FindBy(id = "expiry_period")
	WebElement expiryPrd;

	@FindBy(id = "single_dpp")
	WebElement excTax;

	@FindBy(xpath = "//button[@value='submit']")
	WebElement save;

	@FindBy(xpath = "//input[@type='search']")
	WebElement search;

	@FindBy(xpath = "//tbody/tr/td[@class='sorting_1']")
	WebElement searchedName;

	@FindBy(xpath = "//button[contains(@class,'dropdown-toggle')]")
	WebElement action;

	@FindBy(xpath = "//a[@class='delete-product']")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement dltOk;

	@FindBy(xpath = "//tbody/tr/td[@class='dataTables_empty']")
	WebElement noRecords;

	public String getTextOfManageProductsHeading() {

		return gl.getTextOfElement(manageProductsHeading);
	}

	public void addProductInManageProducts(String name, String quantity, String image, String expiry, String tax) {

		gl.clickElement(addBtn);
		gl.typeElement(productName, name);
		gl.typeElement(alertQnty, quantity);
		ew.presenceOfElementLocatedWaitByXpath(driver, "//div[contains(@class,'fileinput-caption')]");
		fl.fileUploadUsingSendKeys(productImage, image);
		gl.typeElement(expiryPrd, expiry);
		gl.scrollToElement(driver, excTax);
		gl.typeElement(excTax, tax);
		gl.clickElement(save);
	}

	public void searchTheAddedProductInSearchBox(String searchdata) {

		gl.typeElement(search, searchdata);

	}

	public String getTextOfNameFieldOfProductAfterSearch() {

		return gl.getTextOfElement(searchedName);

	}

	public void deleteAddedproduct() {

		gl.clickElement(action);
		gl.clickElement(deleteBtn);
		gl.clickElement(dltOk);
	}

	public String getTextOfNoRecordsAfterDeletion() {

		return gl.getTextOfElement(noRecords);

	}
}
