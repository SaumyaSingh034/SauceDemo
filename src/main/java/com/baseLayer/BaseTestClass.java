package com.baseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utilityLayer.UtilityFile;
import com.utilityLayer.WebEventListener;

public class BaseTestClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseTestClass()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(UtilityFile.FILE_LOCATION);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initializeBrowser()
	{
		String browserName = prop.getProperty("browser");
		
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\FrameworkPractice\\SauceDemo_POM\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {

				driver = new InternetExplorerDriver();
				System.setProperty("webdriver.ie.driver",
						"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\IEServer.exe");

			} else if (browserName.equalsIgnoreCase("firefox")) {

				driver = new FirefoxDriver();
				System.setProperty("webdriver.gecko.driver",
						"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\geckodriver.exe");

			} else if (browserName.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
				System.setProperty("webdriver.edge.driver",
						"D:\\Selenium\\FrameworkPractice\\POMHybridFramework" + "\\drivers\\edgedriver.exe");

			} else {
				System.out.println("Please Check Your Browser. You have enter wrong browser......");
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(UtilityFile.PAGE_LOAD_TIME, TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(UtilityFile.IMPLICIT_WAIT, TimeUnit.MINUTES);
			driver.get(prop.getProperty("url"));
	}

}
