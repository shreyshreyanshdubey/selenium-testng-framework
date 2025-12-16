package com.framework.utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String namePrefix) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String destPath = System.getProperty("user.dir") 
					+ "/test-output/screenshots" + namePrefix + "_" + timestamp + ".png";
			File dest = new File(destPath);
			FileUtils.forceMkdirParent(dest);
			FileUtils.copyFile(src, dest);
			return destPath;
		} catch (Exception e) {
			// TODO: handle exception
		   e.printStackTrace();
		   return null;
		}
	
	}
}
