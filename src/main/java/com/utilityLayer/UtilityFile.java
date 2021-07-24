package com.utilityLayer;

import com.baseLayer.BaseTestClass;

public class UtilityFile extends BaseTestClass{
	
	public static String FILE_LOCATION = "D:\\Selenium\\FrameworkPractice\\SauceDemo_POM\\Configuration\\config.properties";
	public static long PAGE_LOAD_TIME = 1;
	public static long IMPLICIT_WAIT = 1;
	public static String EXPECTED_PAGE_TITLE = "Swag Labs";
	public static String EXPECTED_PAGE_DASHBOARD = "Single Page Apps for GitHub Pages";
	
	public static String getTitelOfPage()
	{
		return driver.getTitle();
	}

	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
		
		
	}

}
