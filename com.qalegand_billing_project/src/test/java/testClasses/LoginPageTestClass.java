package testClasses;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utility.Constants;
import utility.ExcelReadClass;

public class LoginPageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
	
  @Test(priority = 4, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group1"})
  public void verifySuccessfullLogin() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD); 
		hp.clickOnEndTour();
		String actualRes = hp.getTextOfWelcomeAdmin();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(5, 0)));
  }
  
  @Test(priority = 1, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group2"})
	public void verifyTheRememberMeCheckboxIsSelectedByDefault() {

	  	lp = new LoginPageClass(driver);
		boolean actualRes = lp.checkRememberMeCheckBoxSelected();
		Assert.assertTrue(actualRes);
	}
  
  @Test(priority = 3, groups = {"Group1"}, retryAnalyzer = RetryAnalyzerClass.class, dataProvider = "UnsuccessfulLogin", dataProviderClass = DataProviderClass.class)
	public void verifyUnsuccessfulLoginOfTheSite(String uname, String pass) throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(uname, pass);
		String actualRes = lp.getTextOfUnSuccessfullLogin();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(6, 0)));
	}

	@Test(priority = 0, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group1"})
	public void verifyTheExactURL_OpensWhileHittingTheBaseURL() {

		lp = new LoginPageClass(driver);
		String actualRes = lp.getCurrentUrlOfThePage();
		String expectedRes = Constants.LOGIN_URL;
		Assert.assertEquals(actualRes, expectedRes);
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzerClass.class,groups = {"Group2"})
	public void verifyResetPasswordPageComingWhileChickingOnForgotYourPassword() throws IOException {

		lp = new LoginPageClass(driver);
		lp.clickOnForgotYourPasswordLink();
		String actualRes = lp.getTextOfResetPasswordMsg();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(7, 0)));
	}
  
  
}
