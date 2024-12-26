package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utility.Constants;
import utility.ExcelReadClass;

public class HomePageTestClass  extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
	@Test(retryAnalyzer = RetryAnalyzerClass.class,  priority = 0, groups = {"Group2"})
	public void verifyAllTilesDisplayedOnHomePage() {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		boolean actualRes = hp.isAllTilesDisplayed();
		Assert.assertTrue(actualRes);

	}
	
	@Test(retryAnalyzer = RetryAnalyzerClass.class,  priority = 2, groups = {"Group2"})
	public void verifyTheTooltip_Calculator_isShowingWhileHoveringTheMouseOnCalculator() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		hp.hoverTheMouseOnCalculator();
		String actualRes = hp.getAttributeValueOfTitleOfCalculator("data-original-title");
		String expectedRes = ExcelReadClass.getStringdata(8, 0);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualRes, expectedRes);
		soft.assertAll();

	}
	@Test(retryAnalyzer = RetryAnalyzerClass.class, priority = 1, groups = {"Group1"})
	public void verifySuccessfulSignOut() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		lp = hp.signOutFromHomePage();
		String actualRes = hp.getTextOfDemo_POSHeadingInLoginPage();
		String expectedRes = ExcelReadClass.getStringdata(9, 0);;
		Assert.assertEquals(actualRes, expectedRes);
		System.out.println("Signed Out Successfully!!!");
		
	}	
	
  
}
