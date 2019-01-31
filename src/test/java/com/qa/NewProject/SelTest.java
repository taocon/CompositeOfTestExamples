package com.qa.NewProject;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelTest {

	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	// @Test
	// @Ignore
	// public void testy() throws InterruptedException {
	// // maximises window
	// driver.manage().window().maximize();
	// // opens link
	// driver.get(Constants.URL);
	//// WebElement textbox = driver.findElement(By.name("q"));
	//// textbox.sendKeys("Selenium");
	//// textbox.submit();
	// SelLandingPage thing = PageFactory.initElements(driver,
	// SelLandingPage.class);
	// SelSearchPage thing2 = PageFactory.initElements(driver, SelSearchPage.class);
	// thing.searchBing("Selenium");
	// thing2.getText();
	// Thread.sleep(3000);
	// assertEquals("Selenium Text not found","Selenium",thing2.getText());
	// //*[@id="b_context"]/li[1]/div/div[1]/h2
	// //*[@id="accountButtons"]/header/ul/li[5]/a/img

	@Test
	@Ignore
	public void paint() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL);

		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement myDynamicElement = driver.findElement(By.tagName("h2"));
		WebElement secondElement = driver.findElement(By.id("quote"));
		Thread.sleep(500);
		System.out.println(myDynamicElement.getText());
		assertEquals("Failure", "-The Shafeeq", myDynamicElement.getText());

		Thread.sleep(3000);

	}

	@Test
	@Ignore
	public void explicit() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL);

		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
		assertEquals("Failure", "-The Shafeeq", myDynamicElement.getText());

	}

	@Test
	@Ignore
	public void addUser() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		Thread.sleep(1000);
		WebElement name = driver.findElement(By.name("username"));
		WebElement pass = driver.findElement(By.name("password"));
		WebElement button = driver.findElement(By.name("FormsButton2"));

		name.sendKeys("chadmayr");
		pass.sendKeys("chicken");
		button.click();

		Thread.sleep(1500);

		WebElement login = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();

		WebElement name2 = driver.findElement(By.name("username"));
		WebElement pass2 = driver.findElement(By.name("password"));
		WebElement button2 = driver.findElement(By.name("FormsButton2"));

		name2.sendKeys("chadmayr");
		pass2.sendKeys("chicken");
		button2.click();
		Thread.sleep(3000);
		WebElement last = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote"));
		assertEquals("Fail", "**Successful Login**", last.getText());

	}

	@Test
	@Ignore
	public void dressTest() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		WebElement button = driver.findElement(By.name("submit_search"));
		searchBar.sendKeys("Dress");
		button.click();
		Thread.sleep(3000);

		assertEquals("Fail", "Printed Summer Dress",
				driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"))
						.getAttribute("title"));

	}

	@Test
	@Ignore
	public void hotelBooking() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");

		WebElement div = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[1]"));
		div.click();
		WebElement div2 = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
		Thread.sleep(1500);
		div2.sendKeys("London");
		Thread.sleep(3000);
		div2.sendKeys(Keys.TAB);
		Thread.sleep(3000);

		WebElement div3 = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		div3.sendKeys("31/01/2019");

		Thread.sleep(3000);

		WebElement div4 = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));
		div4.sendKeys("01/02/2019");
		div4.sendKeys(Keys.TAB);
		WebElement div5 = driver.findElement(By.xpath("//*[@id=\"travellersInput\"]"));

		Thread.sleep(1000);

		div5.sendKeys("2 Adult 1 Child");

		Thread.sleep(1000);

		WebElement div6 = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));
		div6.click();
		Thread.sleep(5000);

		// *[@id="body-section"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button
		WebElement details = driver.findElement(By
				.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button"));
		details.click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");

		WebElement checkBox = driver.findElement(
				By.xpath("		//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div"));
		checkBox.click();
		Thread.sleep(5000);

	}

	@Ignore
	@Test
	public void excelTest() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Reading USERNAMES
		// for (int colNum = 1; colNum < sheet.getPhysicalNumberOfRows(); colNum++) {
		//
		// XSSFCell cell = sheet.getRow(colNum).getCell(colNum);
		// String userNames = cell.getStringCellValue();
		// System.out.println(userNames);
		//
		//
		// }

		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");

		for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {

			WebElement name = driver.findElement(By.name("username"));
			WebElement pass = driver.findElement(By.name("password"));
			WebElement button = driver.findElement(By.name("FormsButton2"));

			name.sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			pass.sendKeys(sheet.getRow(rowNum).getCell(1).getStringCellValue());
			button.click();

			WebElement login = driver.findElement(By
					.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
			login.click();

			WebElement name2 = driver.findElement(By.name("username"));
			WebElement pass2 = driver.findElement(By.name("password"));
			WebElement button2 = driver.findElement(By.name("FormsButton2"));

			name2.sendKeys(sheet.getRow(rowNum).getCell(0).getStringCellValue());
			pass2.sendKeys(sheet.getRow(rowNum).getCell(1).getStringCellValue());
			button2.click();

			WebElement last = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote"));

			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell actualValue = row.getCell(3);
			if (actualValue == null) {
				actualValue = row.createCell(3);
			}
			actualValue.setCellValue(last.getText());

			WebElement backToReg = driver.findElement(By
					.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
			backToReg.click();

			XSSFCell result = row.getCell(4);
			if (result == null) {
				result = row.createCell(4);
			}

			if (sheet.getRow(rowNum).getCell(2).getStringCellValue()
					.equals(sheet.getRow(rowNum).getCell(3).getStringCellValue())) {

				result.setCellValue("Pass");
			} else {
				result.setCellValue("Fail");
			}

		}

		// Writing

		// for (int rowNum = 1; rowNum < sheet.getPhysicalNumberOfRows() ; rowNum++) {

		// }

		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		// flush saves
		fileOut.flush();
		fileOut.close();

		file.close();

	}

	@After
	public void tearDown() {

		driver.quit();

	}

}
