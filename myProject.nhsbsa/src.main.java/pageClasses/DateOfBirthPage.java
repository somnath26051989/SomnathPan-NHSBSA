package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the locators and methods of
 *         date-of-birth page
 */

public class DateOfBirthPage {

	WebDriver driver;

	By selectDay = By.id("dob-day");
	By selectMonth = By.id("dob-month");
	By selectYear = By.id("dob-year");
	By errorSummaryHeadline = By.xpath("//h2[@id='error-summary-heading']");
	By errorMessagelink = By
			.xpath("//body/main[@id='content']/div[2]/div[1]/form[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]");
	By mainQuestionHeadline = By.xpath("//h1[@id='question-heading']");

	public DateOfBirthPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDOB(String day, String month, String year) {

		Assert.assertTrue("Day input field is displayed", driver.findElement(selectDay).isDisplayed());
		driver.findElement(selectDay).clear();
		driver.findElement(selectDay).sendKeys(day);

		Assert.assertTrue("Month input field is displayed", driver.findElement(selectMonth).isDisplayed());
		driver.findElement(selectMonth).clear();
		driver.findElement(selectMonth).sendKeys(month);

		Assert.assertTrue("Year input field is displayed", driver.findElement(selectYear).isDisplayed());
		driver.findElement(selectYear).clear();
		driver.findElement(selectYear).sendKeys(year);
	}

	public void verifyQuestion() {

		Assert.assertTrue("'What is your date of birth?' is displayed",
				driver.findElement(mainQuestionHeadline).isDisplayed());
		Assert.assertEquals("What is your date of birth?", driver.findElement(mainQuestionHeadline).getText());

	}

	public void verifyErrorSummaryHeadline() {
		Assert.assertTrue("'There is a problem' summary headline is displayed",
				driver.findElement(errorSummaryHeadline).isDisplayed());
		Assert.assertEquals("There is a problem", driver.findElement(errorSummaryHeadline).getText());
	}

	public void verifyErrorMsgLink() {
		String actualMsgType = driver.findElement(errorMessagelink).getText();
		String expectedMsgType = "Enter your date of birth";

		if (actualMsgType.equalsIgnoreCase(expectedMsgType)) {
			Assert.assertTrue("'Enter your date of birth' error message link is displayed",
					driver.findElement(errorMessagelink).isDisplayed());
			Assert.assertEquals("Enter your date of birth", driver.findElement(errorMessagelink).getText());
		} else {
			Assert.assertTrue("'Your date of birth must be in the past' error message link is displayed",
					driver.findElement(errorMessagelink).isDisplayed());
			Assert.assertEquals("Your date of birth must be in the past", driver.findElement(errorMessagelink).getText());
		}
		driver.findElement(errorMessagelink).click();

	}

}
