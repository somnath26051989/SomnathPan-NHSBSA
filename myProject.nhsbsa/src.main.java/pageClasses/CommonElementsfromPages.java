package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the Common locators and methods of across most of the  pages
 */

public class CommonElementsfromPages {

	WebDriver driver;

	By selectYesRadioButton= By.id("label-yes");
	By selectNoRadioButton= By.id("label-no");
	By mainQuestionHeadline= By.xpath("//h1[@id='question-heading']");
	By start_next_Button = By.xpath("//input[@id='next-button']");

	public CommonElementsfromPages(WebDriver driver) {
		this.driver = driver;
	}

	public void selectRadioButton(String choosenoption) {

		Assert.assertTrue("Yes option is displayed", driver.findElement(selectYesRadioButton).isDisplayed());
		Assert.assertTrue("No option is displayed", driver.findElement(selectNoRadioButton).isDisplayed());
		
		if (choosenoption.equalsIgnoreCase("Yes")) {
			driver.findElement(selectYesRadioButton).click();

		} else {
			driver.findElement(selectNoRadioButton).click();

		}

	}

	public void verifyQuestion(String question) {

		Assert.assertTrue(question, driver.findElement(mainQuestionHeadline).isDisplayed());
		Assert.assertEquals(question, driver.findElement(mainQuestionHeadline).getText());

	}
	

	public void clickOnButton() {
		Assert.assertTrue("Start/Next button is displayed on Page",driver.findElement(start_next_Button).isDisplayed());
		driver.findElement(start_next_Button).click();

	}


}
