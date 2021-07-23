package com.testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseLayer.BaseTestClass;
import com.pageLayer.LoginPage;
import com.utilityLayer.UtilityFile;

public class TC_001_LoginPage extends BaseTestClass{
	LoginPage login;

	
	public TC_001_LoginPage()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		login = new LoginPage();
	}
	
	@Test(priority=0)
	public void validateTitleOfpage()
	{
		String ACTUAL_PAGE_TITLE = login.getTitleOfPage();
		Assert.assertEquals(ACTUAL_PAGE_TITLE, UtilityFile.EXPECTED_PAGE_TITLE,"The Actual Title is not same as Expected Title");
	}
	
	@Test(priority=1)
	public void validateLogo()
	{
		Boolean logo = login.validateLogoOfPage();
		Assert.assertTrue(logo,"The Logo is not displayed in the age but is supposed to display");
	}
	
	@Test(priority=2)
	public void loginToApplication()
	{
		login.loginToPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=3)
	public void validateTitleOfDashBoardPage()
	{
		String ACTUAL_PAGE_TITLE = login.getTitleOfPage();
		System.out.println("Titel from DashBoard Page :: "+ACTUAL_PAGE_TITLE);
		//Assert.assertEquals(ACTUAL_PAGE_TITLE, UtilityFile.EXPECTED_PAGE_TITLE,"The Actual Title is not same as Expected Title");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
