package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.Wrapper;

public class LoginPage extends Wrapper{
	@FindBy(linkText = "Login")
	public WebElement loginLink;

	@FindBy(xpath = "//div[@id='modal-login']")
	public WebElement loginWithFacebookButton;

	public void loginWithFacebook() {
		loginLink.click();
		waitForElementTobeClickable(loginWithFacebookButton);
		loginWithFacebookButton.click();
	}

}
