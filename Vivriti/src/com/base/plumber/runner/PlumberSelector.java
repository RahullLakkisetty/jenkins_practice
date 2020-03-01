package com.base.plumber.runner;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.plumber.po.PlumberPo;



public class PlumberSelector extends BaseFunction {

	private static WebDriver driver = null;
	public static PlumberPo plumber;

	@BeforeTest
	public void intializeDriver() throws IOException {
		driver = getWebDriver();
		driver.get(LoadConfiguration("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Succesfully opened Website");
		String title = driver.getTitle();
		Assert.assertEquals(
				"Find local professionals for all your projects - StarOfService",
				title);
	}

	@Test(enabled = true)
	public void plumberAutomate() throws IOException {
		plumber = new PlumberPo(driver);
		String data = plumber.automate();
	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
	}

}
