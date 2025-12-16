package com.framework.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.config.ConfigReader;
import com.framework.driver.WebDriverFactory;
import com.framework.utils.ExtentManager;

public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent = ExtentManager.getExtentReports();
	protected static ThreadLocal<ExtentTest> tlTest  = new ThreadLocal<ExtentTest>();
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser , Method m) {
		driver = WebDriverFactory.createDriver(browser);
		tlTest.set(extent.createTest(m.getDeclaringClass().getSimpleName() + " : " + m.getName()));
		driver.get(ConfigReader.getBaseUrl());
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		WebDriverFactory.quiteDriver();
	}
	
	@AfterSuite(alwaysRun = true)
	public void flushReports() {
		extent.flush();
	}
	
}
