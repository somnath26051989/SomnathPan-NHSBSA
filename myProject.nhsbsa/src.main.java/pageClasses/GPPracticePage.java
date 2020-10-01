package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the locators and methods of gp-in-scotland-or-wales page
 */

public class GPPracticePage {

	WebDriver driver;

	By selectYesRadioButton= By.id("label-yes");
	By selectNoRadioButton= By.id("label-no");
	By mainQuestionHeadline= By.xpath("//h1[@id='question-heading']");

	public GPPracticePage(WebDriver driver) {
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

	public void verifyQuestion() {

		Assert.assertTrue("'Is your GP practice in Scotland or Wales?' is displayed", driver.findElement(mainQuestionHeadline).isDisplayed());
		Assert.assertEquals("Is your GP practice in Scotland or Wales?", driver.findElement(mainQuestionHeadline).getText());

	}


}
