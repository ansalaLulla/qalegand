package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUserPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utility.Constants;
import utility.ExcelReadClass;
import utility.RandomDataUtility;

public class ManageUserTestClass  extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageUserPageClass mup;
	
	@Test(priority = 0, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group2"})
	public void verifyTheManageUsersPageIsOpenWhileClickingOnUsers() throws IOException {

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		hp.clickUserManagementBtnInHomePage();
		mup = hp.clickOnUsersOptionUnderUserMngmt();
		String actualRes = mup.getTextOfManageUsersHeading();
		Assert.assertTrue(actualRes.contains(ExcelReadClass.getStringdata(10, 0)));
		//Assert.assertTrue(actualRes.contains("User1"));
	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzerClass.class, groups = {"Group1"})
	public void verifyToAdd_aNewUser() throws InterruptedException {
		
		String new_user_name = RandomDataUtility.getUserFullName();
		String email = RandomDataUtility.getRandomEmail();
		String username = RandomDataUtility.getUsername();
		String password = RandomDataUtility.getPassword();

		lp = new LoginPageClass(driver);
		hp = lp.login(Constants.USERNAME,Constants.PASSWORD);
		hp.clickOnEndTour();
		hp.clickUserManagementBtnInHomePage();
		mup = hp.clickOnUsersOptionUnderUserMngmt();
		mup.addUserInManageUsers(new_user_name, email, username, password, password);
		mup.searchTheAddedUserInSearchBoxAfterAddition(new_user_name);
		boolean actualRes = mup.isCreatedUserNameDisplayed();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actualRes);
		soft.assertAll();
		System.out.println("User rathu added successfully!!!");
	}	
 
}
