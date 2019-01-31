package com.qa.NewProject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelSearchPage {

	@FindBy(xpath="//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	private WebElement sponge;

	
	public String getText() {
	return 	sponge.getText();
		
	}
	
	
}
