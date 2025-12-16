package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static synchronized ExtentReports getExtentReports() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			spark.config().setReportName("Automation Test Report");
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Enviroment", "QA");
			extent.setSystemInfo("Author", "Shreyansh");
		}
		return extent;
	}
}
