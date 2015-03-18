package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class LoginTest extends TestBase{
	@Test
	public void AddFeaturedUnitTest() throws InterruptedException{
		loginPage.loginWithFacebook();
		
	}

}
