package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;
import com.framework.pages.ProductDetailPage;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		
	    login.enterUserName("standard_user");
	    Thread.sleep(5000);
	    login.enterPassword("secret_sauce");
	    login.clickLogin();
        Thread.sleep(5000);
	    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
	            "Login failed");

	    HomePage home  = new HomePage(driver);
	    home.clickOnFirstProduct();
	    Thread.sleep(3000);
	    System.out.println("After url login: " + driver.getCurrentUrl());
	    ProductDetailPage pdp = new ProductDetailPage(driver);
	    pdp.addProductToCart();
	    System.out.println("After url login: " + driver.getCurrentUrl());
	    
	    int cartCount = home.getCartCount();
	    System.out.println("Cart Count: " + cartCount);
	    Assert.assertEquals(cartCount, 1, "Product not added to cart");
//	    String header = home.getHeaderText();
//	    Assert.assertEquals(header, "Products");
	    
	    
	}
}
