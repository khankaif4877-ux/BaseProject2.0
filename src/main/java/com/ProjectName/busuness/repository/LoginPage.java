package com.ProjectName.busuness.repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver){
this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;

	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	@FindBy(id = "submitButton")
	private WebElement submitEdt;
	@FindBy()
	private WebElement n;
	
	
	
	public WebElement getUserName() {
		return userNameEdt;
	}
	public WebElement getUserPassword() {
		return userPasswordEdt;
	}
	public WebElement getSubmit() {
		return submitEdt;
	}
	
	public void getLoginToApp(String username,String password) {
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		driver.findElement(By.id("submitButton")).submit();
	}

}
