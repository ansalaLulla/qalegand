package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageProductPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utility.Constants;
import utility.ExcelReadClass;
import utility.RandomDataUtility;

public class ManageProductTestClass  extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageProductPageClass mp;
	
	@Test(priority = 0, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group2"})
	public void verifyProductsPageIsOpenWhileClickingOnListProducts() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		mp = hp.clickOnListProductsBtnUnderProducts();
		String actualRes = mp.getTextOfManageProductsHeading();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(11, 0)));

	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzerClass.class,groups = {"Group1"})
	public void verifyToCreateA_newProduct() throws IOException {
		
		String productName = RandomDataUtility.getProductName();
		String alertQnty = RandomDataUtility.getProductQuantity();
		String expiringPeriod = RandomDataUtility.getExpirationPeriod();
		String excTax = RandomDataUtility.generateTaxPercentage();

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		mp = hp.clickOnListProductsBtnUnderProducts();
		mp.addProductInManageProducts(productName, alertQnty, System.getProperty("user.dir")+"\\src\\test\\resources\\product.jpg", expiringPeriod,
				excTax);   
		mp.searchTheAddedProductInSearchBox(productName);
		String actualRes = mp.getTextOfNameFieldOfProductAfterSearch();
		String expectedRes = productName;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualRes, expectedRes);
		soft.assertAll();
		System.out.println("Product added successfully!!!");

	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyzerClass.class ,groups = {"Group1"})
	public void verifyToDeleteAddedProduct() {

		String productName = RandomDataUtility.getProductName();
		String alertQnty = RandomDataUtility.getProductQuantity();
		String expiringPeriod = RandomDataUtility.getExpirationPeriod();
		String excTax = RandomDataUtility.generateTaxPercentage();

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		mp = hp.clickOnListProductsBtnUnderProducts();
		mp.addProductInManageProducts(productName, alertQnty, System.getProperty("user.dir")+"\\src\\test\\resources\\product.jpg", expiringPeriod,
				excTax);   
		mp.searchTheAddedProductInSearchBox(productName);
		mp.deleteAddedproduct();
		String actualRes = mp.getTextOfNoRecordsAfterDeletion();
		Assert.assertTrue(actualRes.contains("records"));
		System.out.println("Product deleted successfully!!!");

	}
	
  
}
