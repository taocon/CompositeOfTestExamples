package com.qa.NewProject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;

public class SelLandingPage {
	
	WebDriver driver = new PhantomJSDriver();
	
	
	@FindBy(id= "layout_paint")
	private WebElement paintbox;
//	
//	public void searchBing(String searchText) {
//	searchbox.sendKeys(searchText);
//	searchbox.submit();
//	
//
//	}
	

	
	public void drawing(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveByOffset(500, 200) .clickAndHold() .moveByOffset(120, 0) .release().perform();
		action.moveByOffset(0, 200) .clickAndHold() .moveByOffset(0, 300) .release().perform();
	
	
		Thread.sleep(5000);
		
	}

	
	
	
}
