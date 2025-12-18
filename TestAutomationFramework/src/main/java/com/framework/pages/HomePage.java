package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private By productsHeader = By.className("title");
	private By cartBadge = By.className("shopping_cart_badge");
	private By firstProduct = By.className("inventory_item_name");
	
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
	
	public int getCartCount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		String count = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(cartBadge)
//				).getText();
		
		return Integer.parseInt(driver.findElement(cartBadge).getText());
	}
	
	public void clickOnFirstProduct() {
		driver.findElement(firstProduct).click();
	}
	
}
