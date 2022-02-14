package org.baseclass;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert alrt;
	public static Select s;

	public static void launchchrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchfirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void launchedge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void maxwindow() {
		driver.manage().window().maximize();
	}

	public static void holdtime(int seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	public static void fetchtitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static String returntitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static void filltextbox(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void waitfor(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void print(String value) {
		System.out.println(value);
	}

	public static String currenturl() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public static void toclick(WebElement element) {
		element.click();
	}

	public static void doubleclick(WebElement element) {
		a.doubleClick(element).perform();
	}

	public static void rightclick(WebElement element) {
		a.contextClick(element).perform();
	}

	public static void clickelement(WebElement element) {
		a.click(element).perform();
	}

	public static void moveto(WebElement element) {
	a.moveToElement(element);	
	
	}

	public static void closebrowser() {
		driver.close();
	}

	
	
	public static void copyvalue() throws AWTException {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void cutvalue() throws AWTException {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	public static void pastevalue() throws AWTException {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void takescreenshot(String filename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File path = new File("C:\\Users\\LAPTOP\\Desktop\\dk\\screenshot\\" + filename + ".png");
		FileUtils.copyFile(src, path);
	}

	public static void multiplescreenshots(int value, String filename) throws IOException {
		for (int i = 0; i < value; i++) {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File path = new File("C:\\Users\\LAPTOP\\Desktop\\dk\\screenshot\\" + filename + i + ".png");
			FileUtils.copyFile(src, path);

		}
	}

	public void SelectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);

	}

	public void Selectbyindex(WebElement element, int value) {
		s = new Select(element);
		s.selectByIndex(value);

	}

	public void SelectBytext(WebElement element, String value) {
		s = new Select(element);
		s.selectByVisibleText(value);

	}

	public static void scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void alertaccept() {
		alrt.accept();
	}

	public static void alertdismiss() {
		alrt.dismiss();
	}

	public static WebElement findbyid(String idpath) {
		WebElement idname = driver.findElement(By.id(idpath));
		return idname;
	}

	public static WebElement findbyxpath(String xpath) {
		WebElement pathid = driver.findElement(By.xpath(xpath));
		return pathid;
	}

	public static WebElement findbyname(String namepath) {
		WebElement name = driver.findElement(By.name(namepath));
		return name;
	}

	public static void Sendkeysbyid(String idpath, String value) {
		driver.findElement(By.id(idpath)).sendKeys(value);
	}

	public static String readexcel(String sheetname, int rowno, int cellno) throws IOException {
		File f = new File("C:\\Users\\LAPTOP\\Desktop\\dk\\excel\\Greens1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fs);
		XSSFSheet sh1 = w.getSheet(sheetname);
		Row r1 = sh1.getRow(rowno);
		Cell c1 = r1.getCell(cellno);
		String name;
		int type = c1.getCellType();
		if (type == 1) {
			name = c1.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c1)) {
			java.util.Date value = c1.getDateCellValue();
			SimpleDateFormat simple = new SimpleDateFormat("dd/mmm/yyyy");
			name = simple.format(value);
		} else {
			double d1 = c1.getNumericCellValue();
			long l = (long) d1;
			name = String.valueOf(l);

		}
		return name;
	}

	public static void createexcel(String pathname, String sheetname, int rowvalue, int cellvalue, int celllvalue)
			throws IOException {
		File f = new File("C:\\Users\\LAPTOP\\Desktop\\dk\\excel\\" + pathname + ".xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet sh1 = w.createSheet(sheetname);
		Row r1 = sh1.createRow(rowvalue);
		Cell c1 = r1.createCell(cellvalue);
		c1.setCellValue(cellvalue);
		FileOutputStream fs = new FileOutputStream(f);
		w.write(fs);

	}
}

	
