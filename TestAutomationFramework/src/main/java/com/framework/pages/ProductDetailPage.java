package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

	private WebDriver driver; 
	
	private By productTitle = By.className("inventory_item_name");
	private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
	
	public ProductDetailPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public String getProductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver.findElement(productTitle).getText();
	}
	
	public void addProductToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
	}
	
	
}
