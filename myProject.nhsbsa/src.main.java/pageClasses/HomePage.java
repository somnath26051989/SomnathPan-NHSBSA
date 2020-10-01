package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the locators and methods of HomePage
 */

public class HomePage {

	WebDriver driver;

	By feedbackLink = By.cssSelector("a#feedback-link");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyFeedbackLink() {
		Assert.assertTrue("Feedback Link is displayed on HomePage", driver.findElement(feedbackLink).isDisplayed());

	}


}
