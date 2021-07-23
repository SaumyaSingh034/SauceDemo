package com.testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseLayer.BaseTestClass;
import com.pageLayer.DashBoardPage;
import com.pageLayer.LoginPage;
import com.utilityLayer.UtilityFile;

public class TC_002_DashBoardPage extends BaseTestClass{
	
	LoginPage login;
	DashBoardPage dashboard;
	
	public TC_002_DashBoardPage()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initializeBrowser();
		login = new LoginPage();
		dashboard = login.loginToPage(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test(priority = 0)
//	public void loginToApplication() {
//		dashboard = login.loginToPage(prop.getProperty("username"), prop.getProperty("password"));
//	}
	@Test(priority=1)
	public void validateTitle()
	{
		String ACTUAL_TITLE_DASHBOARD = dashboard.getTitleofPage();
		Assert.assertEquals(ACTUAL_TITLE_DASHBOARD, UtilityFile.EXPECTED_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void clickOnAllItems()
	{
		dashboard.clickOnNavigationBar();
		dashboard.clickOnInventorySideBarList("All Items");
		
	}
	@Test(priority=3)
	public void CountofTotalItem()
	{
		int ACTUAL_COUNT = dashboard.countItemInThePage();
		Assert.assertEquals(ACTUAL_COUNT, 6);
	}
	@Test(priority=4)
	public void printDescriptionOfAllItems()
	{
		System.out.println(dashboard.printEachItemDescription());
	}
	@Test(priority=5)
	public void checkPresenceOfRobot()
	{
		boolean robo = dashboard.presenceOfRobot();
		Assert.assertTrue(robo);
	}
	
	@Test(priority=6)
	public void sortData()
	{
		dashboard.sortContainer("Price (low to high)");
	}
	
	
	
	@Test(priority=7)
	public void clickOnLogOut()
	{
		dashboard.clickOnNavigationBar();
		dashboard.clickOnInventorySideBarList("Logout");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
