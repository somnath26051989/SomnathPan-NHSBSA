package TestClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.FlipkartPageClass;

public class FlipkartTestClass {
	Logger log = Logger.getLogger("flipkartHomePageTest");
	WebDriver driver;
    //flipkartHome fui = PageFactory.initElements(driver, flipkartHome.class);
	FlipkartPageClass fui = new FlipkartPageClass() ;

@BeforeTest
@Parameters("browser")
public void setUpClass(String browser) {
	//Check if Firefox
	if(browser.equalsIgnoreCase("firefox")) {
		String firefoxPath = "C:\\Users\\Som\\git\\myProject\\myProject.nhsbsa\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driver = new FirefoxDriver();
		
		
		log.info("Maximize the Opened Firefox Browser");
		driver.manage().window().maximize();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		String chromePath = "C:\\Users\\Som\\git\\myProject\\myProject.nhsbsa\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		
		log.info("Maximize the Opened Chrome Browser");
		driver.manage().window().maximize();
	}
	
}

@Test
public void verifyFlipkartHomepage(){
	
	String url = "https://www.flipkart.com/";
	
	driver.get(url);
	fui.clickAndInputEmail("beyonddignity@gmail.com");
	fui.clickOnCloseIcon();	
	driver.close();
}
	
	

}
