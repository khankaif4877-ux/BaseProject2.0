package com.ProjectName.generic.BaseClassUtil;

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
import org.testng.annotations.Listeners;
import org.testng.xml.XmlTest;
import com.ProjectName.busuness.repository.HomePage;
import com.ProjectName.busuness.repository.LoginPage;
import com.ProjectName.generic.DatabaseUtil.DataBaseUtil;
import com.ProjectName.generic.FileUtil.ExcelFileUtil;
import com.ProjectName.generic.FileUtil.PropertyFileUtil;
import com.ProjectName.generic.JavaUtil.ThreadSafeObject;
import com.ProjectName.generic.WebDriverUtil.WebDriverUtil;
@Listeners(com.ProjectName.generic.ListnerUtil.ListenerImplimentation.class)

public class BaseClass {

	WebDriver driver;
	public DataBaseUtil db = new DataBaseUtil();
	public ExcelFileUtil exl = new ExcelFileUtil();
	public PropertyFileUtil prop = new PropertyFileUtil();
	public HomePage hp;
	public LoginPage lp;
	public WebDriverUtil wdu;

	@BeforeSuite(alwaysRun = true)

	public void beforeSuitMethod() {
//		db.getDataBaseconnection();

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClassMethod(XmlTest test) {
		WebDriver driver = null;		
			String browser = System.getProperty("browser");
			if (browser == null) {
				browser = test.getParameter("browser");
				if (browser == null) {
					browser = prop.getProperty("browser");
				}
			}
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}
		this.driver = driver;
		wdu = new WebDriverUtil(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ThreadSafeObject.setDriver(driver);
		wdu.Implicitwait(15);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		String userName = null, passWord = null;
		
			userName = System.getProperty("user");
			passWord = System.getProperty("pass");
			System.out.println(" userName passWord from cmd line are " +userName+"  "+passWord);

			if (userName == null || passWord == null) {
				userName = prop.getProperty("user");
				passWord = prop.getProperty("pass");
				System.out.println(" userName passWord from Proprty file are " +userName+"  "+passWord);

				
				if(userName == null || passWord == null) {
					userName = "admin";
					passWord = "admin";
					System.out.println(" userName passWord from java code are " +userName+"  "+passWord);

				
			} 
		}

		lp.getLoginToApp(userName, passWord);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		hp.logoutFromApp();

	}

	@AfterClass(alwaysRun = true)
	public void afterClassMethod() {

		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuitMethod() {
//		db.closeConnection();

	}
}
