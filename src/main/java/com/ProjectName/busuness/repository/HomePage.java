package com.ProjectName.busuness.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;

	@FindBy(linkText = "Organizations")
	private WebElement Organizations;
	
	@FindBy(xpath  = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOrganizations() {
		return Organizations;
	}
	public WebElement getlogoutIcon() {
		return logoutIcon;
	}
	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	public void logoutFromApp()
	{
		logoutIcon.click();
		SignOutLink.click();
	}

//	
//	@FindBy()
//	private WebElement n;
//	
//	@FindBy()
//	private WebElement n;
	
	
}
