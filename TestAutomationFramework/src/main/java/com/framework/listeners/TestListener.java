package com.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.framework.driver.WebDriverFactory;
import com.framework.utils.ExtentManager;
import com.framework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getExtentReports();
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		result.setAttribute("extentTest", test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getAttribute("extentTest");
		String path = ScreenshotUtil.takeScreenshot(WebDriverFactory.getDriver(),
				result.getMethod().getMethodName());
		test.fail(result.getThrowable());
	    if (path != null) {
			test.addScreenCaptureFromPath(path);
		}	
	}
	
	  @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentTest test = (ExtentTest) result.getAttribute("extentTest");
	        test.log(Status.SKIP, "Test skipped");
	    }
	  
	  
}
