package com.ProjectName.generic.ListnerUtil;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ProjectName.generic.JavaUtil.ThreadSafeObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author KAIF KHAN
 */
public class ListenerImplimentation implements ITestListener, ISuiteListener {
	ExtentReports report;
	ExtentTest test;
	String name;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report.html");
		spark.config().setDocumentTitle("Report");
		spark.config().setReportName("Vtiger Report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("User", System.getProperty("user.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		name = result.getMethod().getMethodName();
		test = report.createTest(name);
		ThreadSafeObject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, name + " got Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		test.log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot) ThreadSafeObject.getDriver();
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot, name);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, name + " got skipped");
	}

}
