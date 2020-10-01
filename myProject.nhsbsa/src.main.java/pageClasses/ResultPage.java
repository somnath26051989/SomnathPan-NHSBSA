package pageClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Som This Class will store all the locators and methods of Result page
 */

public class ResultPage {

	WebDriver driver;

	By resultPage= By.cssSelector("h1.heading-large span.heading-secondary");
	

	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyResultHeadlines() {
		

		Assert.assertTrue("'Based on what you've told us' is displayed", driver.findElement(resultPage).isDisplayed());
		Assert.assertEquals("Based on what you've told us", driver.findElement(resultPage).getText());

	}


}
