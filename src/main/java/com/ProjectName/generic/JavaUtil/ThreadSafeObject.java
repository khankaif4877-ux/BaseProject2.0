package com.ProjectName.generic.JavaUtil;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author KAIF KHAN This class help to give thrade safe object in listener
 *         implimentation and in test script
 */
public class ThreadSafeObject {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static void setDriver(WebDriver driverIncetance) {
		driver.set(driverIncetance);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setTest(ExtentTest testInstance) {
		test.set(testInstance);

	}

	public static ExtentTest getTest() {
		return test.get();

	}
}
