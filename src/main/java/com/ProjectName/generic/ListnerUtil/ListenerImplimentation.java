package com.ProjectName.generic.ListnerUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ProjectName.generic.BaseClassUtil.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener, ISuiteListener, IRetryAnalyzer {
	int count = 0;
	int LimitCount = 5;
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/VtigerReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setReportName("BaseProjectReport");
		spark.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		String methodName = result.getMethod().getMethodName();
		test = reports.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		test.log(Status.FAIL, "Test Fail");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(path, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, "Test Slkip");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		reports.flush();
	}

	@Override
	public boolean retry(ITestResult result) {

		if (count < LimitCount) {
			count++;
			return true;
		}
		return false;
	}

}
