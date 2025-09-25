package com.ProjectName.generic.BaseClassUtil;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.ProjectName.generic.DatabaseUtil.DataBaseUtil;
import com.ProjectName.generic.FileUtil.ExcelFileUtil;
import com.ProjectName.generic.FileUtil.PropertyFileUtil;
import com.ProjectName.generic.WebDriverUtil.WebDriverUtil;

public class BaseClass {

	WebDriver driver;
	public static WebDriver sdriver;
	public DataBaseUtil db = new DataBaseUtil();
	public ExcelFileUtil exl = new ExcelFileUtil();
	public PropertyFileUtil prop = new PropertyFileUtil();
	public WebDriverUtil wdu;

	@BeforeSuite(alwaysRun = true)

	public void beforeSuitMethod() {
//		db.getDataBaseconnection();

	}

	@BeforeClass(alwaysRun = true)
//	@Parameters("browser")
	public void beforeClassMethod() throws IOException {
		String browser = "chrome";
		if (browser.equals("chrome")) {
			this.driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			this.driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			this.driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			this.driver = new SafariDriver();
		} else {
			this.driver = new ChromeDriver();
		}
		 sdriver=driver;
		wdu = new WebDriverUtil(driver);
		wdu.Implicitwait(15);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClassMethod() {
		driver.quit();
	}

	@AfterSuite
	public void afterSuitMethod() {
//		db.closeConnection();

	}
}
