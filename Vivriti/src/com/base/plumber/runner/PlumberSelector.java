package com.base.plumber.runner;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.plumber.po.PlumberPo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class PlumberSelector extends BaseFunction {

	private static WebDriver driver = null;
	public static PlumberPo plumber;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"/ExtentReportResults.html");

	test = report.startTest("PlumberSelector");
	}

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
		System.out.println(data);
			
		if(data.equals("The 10 best Plumbers in Putlibowli, Hyderabad - Last Updated February 2020 - StarOfServicee"))
		{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
	@AfterClass
	public void quitDriver()
	{
		driver.quit();
	}
	

}
