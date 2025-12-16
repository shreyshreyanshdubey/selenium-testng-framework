package com.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver createDriver(String browser) {
		if (tlDriver.get() == null) {
			if ("chrome".equalsIgnoreCase(browser)) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				
				tlDriver.set(new ChromeDriver(options));
			} else {
                   WebDriverManager.chromedriver().setup();
                   tlDriver.set(new ChromeDriver());
			}
		}
		return tlDriver.get();
	}
	
	 public static WebDriver getDriver() {
		 return tlDriver.get();
	 }
	 
	 public static void quiteDriver() {
		 if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	 }
}
