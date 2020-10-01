package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the locators and methods of Where-To-Live
 */

public class WhereToLive {

	WebDriver driver;

	By whichCountryQuestionHeadline = By.cssSelector("h1#question-heading");
	By selectEngland = By.xpath("//label[@id='label-england']");
	By selectScotland = By.xpath("//label[@id='label-scotland']");
	By selectWales = By.id("label-wales");
	By selectNorthernIreland = By.id("label-nire");

	public WhereToLive(WebDriver driver) {
		this.driver = driver;
	}

	public void selectLiveInCountry(String country) {

		Assert.assertTrue("England option is displayed", driver.findElement(selectEngland).isDisplayed());
		Assert.assertTrue("Scotland option is displayed", driver.findElement(selectScotland).isDisplayed());
		Assert.assertTrue("Wales option is displayed", driver.findElement(selectWales).isDisplayed());
		Assert.assertTrue("Northern Ireland option is displayed", driver.findElement(selectNorthernIreland).isDisplayed());
		
		if (country.equalsIgnoreCase("England")) {
			driver.findElement(selectEngland).click();

		} else if (country.equalsIgnoreCase("Scotland")) {
			driver.findElement(selectScotland).click();

		} else if (country.equalsIgnoreCase("Wales")) {
			driver.findElement(selectWales).click();

		} else {
			driver.findElement(selectNorthernIreland).click();

		}

	}

	public void verifyQuestion() {

		Assert.assertTrue("'Which country do you live in?' is displayed", driver.findElement(whichCountryQuestionHeadline).isDisplayed());
		Assert.assertEquals("Which country do you live in?", driver.findElement(whichCountryQuestionHeadline).getText());

	}

}
