package com.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseLayer.BaseTestClass;

public class LoginPage extends BaseTestClass{
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement pwd;
	
	

}
