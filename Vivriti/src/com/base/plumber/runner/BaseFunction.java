package com.base.plumber.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseFunction {

	public static Properties config = null;
	public static WebDriver driver;

	public static String LoadConfiguration(String text) throws IOException {
		config = new Properties();
		FileInputStream fipconfig = new FileInputStream(
				System.getProperty("user.dir")
						+ "/src/resources/resource/config.properties");
		config.load(fipconfig);
		String data = config.getProperty(text);
		return data;
	}

	public static WebDriver getWebDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ LoadConfiguration("driverpath"));
		driver = new ChromeDriver();
		return driver;
	}

	public void clickButton(WebElement webElement) {
		webElement.click();
	}

	public static void enterText(WebElement webElement, String inputValue) {
		webElement.sendKeys(inputValue);

	}

	public static void clearText(WebElement webElement) {
		webElement.clear();
	}

	public static void selectOption(WebElement webElement, String text) {
		Select select = new Select(webElement);
		select.selectByVisibleText(text);
	}

}
