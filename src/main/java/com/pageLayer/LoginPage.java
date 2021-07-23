package com.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseLayer.BaseTestClass;

public class LoginPage extends BaseTestClass{
	
	@FindBy(id="user-name")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(id="login-button")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(css = ".login_logo")
	@CacheLookup
	WebElement logo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleOfPage()
	{
		return driver.getTitle();
	}
	
	public Boolean validateLogoOfPage()
	{
		Boolean logoVal = logo.isDisplayed();
		return logoVal;
	}
	
	public DashBoardPage loginToPage(String user, String pass)
	{
		userName.sendKeys(user);
		pwd.sendKeys(pass);
		loginBtn.click();
		return new DashBoardPage();
		
	}
	

}
