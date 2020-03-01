package com.plumber.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.plumber.runner.BaseFunction;

public class PlumberPo extends BaseFunction {

	private static WebDriver driver = null;

	public PlumberPo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='popular-services']/div/div/ol/li[2]/a/div[2]")
	private WebElement plumbing;

	@FindBy(xpath = "//*[@name='postal_code_input']")
	private WebElement searchCity;

	@FindBy(xpath = "//button[@class='button button--branded blue go']")
	private WebElement goButton;

	@FindBy(xpath = "//button[@data-test='next_button']")
	private WebElement mainNextButton;

	@FindBy(xpath = "//*[@id='landing-main-container']/div[1]/div/div/div/div/div[2]/form/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]/label/div[1]/div")
	private WebElement selectProblem;

	@FindBy(xpath = "//*[@id='landing-main-container']/div[1]/div/div/div/div/div[2]/form/div/div[2]/div/div/div/div[2]/div/div/div[1]/label/div[1]/div")
	private WebElement selectNeed;

	@FindBy(xpath = "//*[@id='landing-main-container']/div[1]/div/div/div/div/div[2]/form/div/div[2]/div/div/div[1]/div[2]/div/div/div[1]/label/div[1]/div")
	private WebElement selectSpecificProblem;

	@FindBy(xpath = "//button[@class='v2__primaryButton___2quFJ v2__baseButton___1yj4M v2__commonBaseButton___n7MII button button--inline button--branded']")
	private WebElement skipButton;

	@FindBy(xpath = "//div[contains(text(),'On a specific date')]")
	private WebElement whenOption;

	@FindBy(xpath = "//button[text()='25' and contains(@aria-label, 'February')]")
	private WebElement date;

	@FindBy(xpath = "//select[@data-test='step_time']")
	private WebElement time;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailAddress;

	@FindBy(xpath = "//div[@data-test='close_button']")
	private WebElement close;

	@FindBy(xpath = "//div[@data-test='cancel_button']")
	private WebElement cancelButton;

	private WebElement toiletCheckBox;

	public String automate() {
		clickButton(plumbing);
		clearText(searchCity);
		enterText(searchCity, "Hyderabad");

		clickButton(goButton);
		clickButton(mainNextButton);

		clickButton(selectProblem);
		clickButton(mainNextButton);

		clickButton(selectNeed);
		clickButton(mainNextButton);

		clickButton(selectSpecificProblem);
		clickButton(mainNextButton);

		clickButton(skipButton);

		clickButton(whenOption);
		clickButton(mainNextButton);

		clickButton(date);
		clickButton(mainNextButton);

		selectOption(time, "11:30");
		clickButton(mainNextButton);

		enterText(emailAddress, "rahul111@gmail.com");
		clickButton(close);
		clickButton(cancelButton);

		String title = driver.getTitle();
		return title;

	}

}
