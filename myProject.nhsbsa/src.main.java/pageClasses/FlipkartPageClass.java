package pageClasses;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartPageClass {


	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement homepageCloseIcon;

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement email;

	public void clickOnCloseIcon() {
		homepageCloseIcon.click();
	}

	public void clickAndInputEmail(String mailID) {
		email.click();
		email.sendKeys(mailID);
	}

}
