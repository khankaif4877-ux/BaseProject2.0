package com.ProjectName.generic.WebDriverUtil;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	WebDriver driver;
	WebDriverWait wdWait;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void Implicitwait(int wait) {
		wdWait = new WebDriverWait(driver, Duration.ofSeconds(wait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

	}

//	public void waitForElementToBeVisible1(int wait, WebElement element) {
//		WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(wait));
//		wdWait.until(ExpectedConditions.visibilityOf(element));
//
//	}

	public void waitForElementToBeClickable(WebElement element) {

		wdWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitForElementToBeInvisible(WebElement element) {
		wdWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementTextToBePresent(WebElement element) {
		wdWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForTitleToBeVisible(WebElement element) {
		wdWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementToBeVisible(WebElement element) {
		wdWait.until(ExpectedConditions.visibilityOf(element));

	}

	// <------------------------------------add more method for expliciy wait
	// ----------------------------------------->

	// <------------------------------------Select Class Util Start From Here
	// ----------------------------------------->
	public void selectByIndex(WebElement elemnt, int index) {

		Select select = new Select(elemnt);
		select.selectByIndex(index);

	}

	public void selectByValue(WebElement elemnt, String value) {

		Select select = new Select(elemnt);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement elemnt, String value) {

		Select select = new Select(elemnt);
		select.selectByVisibleText(value);

	}

	public WebElement getFirstSelectedOption(WebElement elemnt) {

		Select select = new Select(elemnt);
		return select.getFirstSelectedOption();

	}

	public List<WebElement> getOptions(WebElement elemnt) {

		Select select = new Select(elemnt);
		return select.getOptions();

	}

	public List<WebElement> getAllSelectedOptions(WebElement elemnt) {

		Select select = new Select(elemnt);
		return select.getAllSelectedOptions();

	}

	public boolean isMultiple(WebElement elemnt, int index) {

		Select select = new Select(elemnt);
		return select.isMultiple();

	}

	public void deselectByIndex(WebElement elemnt, int index) {

		Select select = new Select(elemnt);
		select.deselectByIndex(index);

	}

	public void deselectByValue(WebElement elemnt, String value) {

		Select select = new Select(elemnt);
		select.deselectByValue(value);

	}

	public void deselectBy(WebElement elemnt, String value) {

		Select select = new Select(elemnt);
		select.deselectByVisibleText(value);

	}

	public void deselectAll(WebElement elemnt) {

		Select select = new Select(elemnt);
		select.deselectAll();

	}

	// <------------SWITCH TO FRAME ------------->//

	public void switchToFrame(int index) {

		driver.switchTo().frame(index);

	}

	public void switchToFrame(String nameId) {

		driver.switchTo().frame(nameId);

	}

	public void switchToFrame(WebElement element) {

		driver.switchTo().frame(element);

	}
	// <------------SWITCH TO ALERT ------------->//

	public void switchToAlertAndAcceptg() {
		driver.switchTo().alert().accept();

	}

	public void switchToAlertAndCancel() {
		driver.switchTo().alert().dismiss();

	}

	// <------------MOUSE ACTION ------------->//

	public void mouseMoveOnElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public void doubleClick(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public void clickAndHold(WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();

	}

	public void contextClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();

	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();

	}

	public void scrollByAmount(int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();

	}

	public void scrollByAmount(WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();

	}

	public void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

}
