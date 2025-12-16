package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private By productsHeader = By.className("title");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHeaderText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		return driver.findElement(productsHeader).getText();
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(productsHeader)
				).getText();
	}
}
