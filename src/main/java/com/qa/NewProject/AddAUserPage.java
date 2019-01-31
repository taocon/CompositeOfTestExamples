package com.qa.NewProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAUserPage {

	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "FormsButton2")
	private WebElement button;
	
	public void addUser(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		button.click();
	}
	
	
	// driver.get((Constants.AddAUserPage
	// AddAUserPage addAUserPage = PageFactory.initElements(driver,AddAUserPage.class);
	// addAUderPage.addUser (username,password);
}