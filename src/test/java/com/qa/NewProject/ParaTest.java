package com.qa.NewProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

@RunWith(Parameterized.class)
public class ParaTest {
	
	WebDriver driver;

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Object[][] ob = new Object[sheet.getPhysicalNumberOfRows()-1][4];
		
//		Reading
		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
				ob[rowNum-1][0] = sheet.getRow(rowNum).getCell(0).getStringCellValue();
				ob[rowNum-1][1] = sheet.getRow(rowNum).getCell(1).getStringCellValue();
				ob[rowNum-1][2] = sheet.getRow(rowNum).getCell(2).getStringCellValue();
				ob[rowNum-1][3] = rowNum;
			}
		return Arrays.asList(ob);
		}
	
	// 0 < 4 
	
	private String username;
	private String password;
	private String expected;
	private int row;
	
	public ParaTest(String username, String password, String expected, int row) {
		this.username = username;
		this.password = password;
		this.expected = expected;
		this.row = row;
	}
	
	@Before
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("phantomjs.binary.path", "C:\\Users\\Admin\\Desktop\\phantomjs.exe");
		driver = new PhantomJSDriver();

	}
	
	@Test
	public void login() throws IOException, InterruptedException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		
		// testing logic
		System.out.println(username + " " + password + " " + expected);
		// grab actual result and insert it into spreadsheet
		System.out.println("actual result needs to be printed in row:" + row);
		
		
		
		WebElement name = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.name("FormsButton2"));

		name.sendKeys(this.username);
		pass.sendKeys(this.password);
		button.click();
		
		WebElement login = driver.findElement(By
				.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();

		WebElement name2 = driver.findElement(By.name("username"));
		WebElement pass2 = driver.findElement(By.name("password"));
		WebElement button2 = driver.findElement(By.name("FormsButton2"));

		name2.sendKeys(this.username);
		pass2.sendKeys(this.password);
		button2.click();
		Thread.sleep(100);
		WebElement last = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote"));
		
		
		
		System.out.println(row);
		XSSFRow actualRow = sheet.getRow(row);
		
		
		XSSFCell actualValue = actualRow.getCell(3);
		if (actualValue == null) {
			actualValue = actualRow.createCell(3);
		}
		actualValue.setCellValue(last.getText());

		
		
		
		
		XSSFCell result = actualRow.getCell(4);
		if (result == null) {
			result = actualRow.createCell(4);
		}

		if (sheet.getRow(row).getCell(2).getStringCellValue()
				.equals(sheet.getRow(row).getCell(3).getStringCellValue())) {

			result.setCellValue("Pass");
		} else {
			result.setCellValue("Fail");
		}

		try {
			assertEquals(1, 0); //assertEquals("error message", expected value, actual value);
			// write pass to excel sheet
		}
		catch (AssertionError e) {
			// write fail to excel sheet
			Assert.fail(); // Because AssertionError was caught, test no longer fails,
							// therefore we force it to fail after we have written it to excel sheet
		} finally {
		
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		// flush saves
		fileOut.flush();
		fileOut.close();

		file.close();
		
		}
		
//		WebElement backToReg = driver.findElement(By
//				.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
//		backToReg.click();
		
		
	}
}