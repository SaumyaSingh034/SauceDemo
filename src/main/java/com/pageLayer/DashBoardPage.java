package com.pageLayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseLayer.BaseTestClass;

public class DashBoardPage extends BaseTestClass{
	
	@FindBy(id="react-burger-menu-btn")
	@CacheLookup
	WebElement navigationBar;
	
	@FindBy(xpath ="//nav[@class='bm-item-list']/a")
	@CacheLookup
	List<WebElement> navLinks;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	@CacheLookup
	WebElement sort_Container;
	
	@FindBy(xpath="//div[@class='inventory_item_description']/div[1]/div")
	@CacheLookup
	List<WebElement> item_description;
	
	@FindBy(xpath="//img[@class='footer_robot']")
	@CacheLookup
	WebElement robo;
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleofPage()
	{
		return driver.getTitle();
	}
	
	public void clickOnNavigationBar()
	{
		navigationBar.click();
	}
	
	public void clickOnInventorySideBarList(String sideBarList)
	{
		int siz = navLinks.size();
		for(int i=0;i<siz;i++)
		{
			String navText = navLinks.get(i).getText();
			
			if(navText.equalsIgnoreCase(sideBarList))
			{
				navLinks.get(i).click();
				System.out.println("Successfully Clicked on :: -> "+sideBarList);
				break;
			}
		}
	}
	
	public void sortContainer(String sortContainerBy)
	{
		Select data = new Select(sort_Container);
		System.out.println("Sorting container By :: "+sortContainerBy);
		data.selectByVisibleText(sortContainerBy);
	}
	
	public Integer countItemInThePage()

	{
		return item_description.size();
	}

	public ArrayList<String> printEachItemDescription()

	{
		ArrayList<String> itemDesc = new ArrayList<String>();
		for(int i=0;i<item_description.size();i++)
		{
			String items = item_description.get(i).getText();
			itemDesc.add(items);
		}
		return itemDesc;
	}
	
	public Boolean presenceOfRobot()
	{
		return robo.isDisplayed();
	}
}
