package stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageClasses.DateOfBirthPage;
import pageClasses.GPPracticePage;
import pageClasses.HomePage;
import pageClasses.ResultPage;
import pageClasses.CommonElementsfromPages;
import pageClasses.WhereToLive;

public class stepDefForTestScenario {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Logger log = Logger.getLogger("stepDefForTestScenario");

	String nhsURL = "https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start";
	String partnerInfoQuestion1 = "Do you live with a partner?";
	String partnerInfoQuestion2 = "Do you claim any benefits or tax credits?";
	String partnerInfoQuestion3 = "Are you pregnant or have you given birth in the last 12 months?";
	String partnerInfoQuestion4 = "Do you have an injury or illness caused by serving in the armed forces?";
	String partnerInfoQuestion5 = "Do you have diabetes?";
	String partnerInfoQuestion6 = "To check what help you can get with NHS charges, we need to know if you're affected by any of these conditions";
	String partnerInfoQuestion7 = "Do you have glaucoma?";
	String partnerInfoQuestion8 = "Do you live permanently in a care home?";
	String partnerInfoQuestion9 = "Do you have more than £16,000 in savings, investments or property?";

	@Given("^I am a person from the UK \"(.*?)\"$")
	public void i_am_a_person_from_the_UK(String confrimUKNationality) throws Throwable {

		if (confrimUKNationality.equalsIgnoreCase("yes")) {
			System.out.println("Welcome to NHS Portal !");
		} else {
			System.out.println("You are not Welcome to NHS Portal !");
		}
	}

	@Given("^open the \"(.*?)\" and launch NHS website$")
	public void open_the_and_launch_NHS_website(String selectedBrowser) throws Throwable {

		if (selectedBrowser.equalsIgnoreCase("chrome")) {
			String chromePath = "C:\\Users\\Som\\workspace\\som.auto\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			
			log.info("Maximize the Opened Chrome Browser and Launch NHS Portal");
			driver.manage().window().maximize();
			driver.get(nhsURL);
			
		} else if (selectedBrowser.equalsIgnoreCase("firefox")) {

			String firefoxPath = "C:\\Users\\Som\\workspace\\som.auto\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("marionatte", false);
			FirefoxOptions opt = new FirefoxOptions();
			opt.merge(dc);
			driver = new FirefoxDriver(opt);
			
			log.info("Maximize the Opened Firefox Browser and Launch NHS Portal");
			driver.manage().window().maximize();
			driver.get(nhsURL);

		} else {
			System.out.println("Oopps, User has not selected any Browser yet !");
		}

	}

	@When("^User verifies the NHS homepage and clicks on START button$")
	public void user_verifies_the_NHS_homepage_and_clicks_on_START_button() throws Throwable {
		HomePage homepage = new HomePage(driver);
		log.info("Verify that User is navigated to NHS Homepage ");
		homepage.verifyFeedbackLink();

		log.info("User clicks on 'Start' button on same page ");
		/*WebElement element = driver.findElement(By.id("next-button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);*/
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		commSelections.clickOnButton();

	}

	@Then("^User selects \"(.*?)\" from where to live page and clicks on NEXT button$")
	public void user_selects_from_where_to_live_page_and_clicks_on_NEXT_button(String selectedCountry) throws Throwable {
		
		WhereToLive wheretolive = new WhereToLive(driver);
		log.info("User navigated to 'Where to live' page and verify that 'Which country do you live in?' question is displayed");
		wheretolive.verifyQuestion();
		
		log.info("Verify all four countries are displayed on page and User selects a country");
		wheretolive.selectLiveInCountry(selectedCountry);
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();


	}

	@Then("^User selectes \"(.*?)\" GP Practice from current page and clicks on NEXT button$")
	public void user_selectes_GP_Practice_from_current_page_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		GPPracticePage gppracticepage = new GPPracticePage(driver);
		log.info("User navigated to next page and verify that 'Is your GP practice in Scotland or Wales?' question is displayed");
		gppracticepage.verifyQuestion();
		
		log.info("Verify all four countries are displayed on page and User selects a country");
		gppracticepage.selectRadioButton(selectedOption);
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User selectes Date of Birth \"(.*?)\", \"(.*?)\", \"(.*?)\" and clicks on  NEXT button$")
	public void user_selectes_Date_of_Birth_and_clicks_on_NEXT_button(String day, String month, String year) throws Throwable {
		
		DateOfBirthPage dob = new DateOfBirthPage(driver);
		log.info("User navigated to next page and verify that 'What is your date of birth?' question is displayed");
		dob.verifyQuestion();
		
		log.info("User enters Date of birth");
		dob.selectDOB(day, month, year);
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about the living partner \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_the_living_partner_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Partner tax Information page and verify that 'Do you live with a partner?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion1);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms on claiming benefits or tax credits \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_on_claiming_benefits_or_tax_credits_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Claim Benefits Tax Credits page and verify that 'Do you claim any benefits or tax credits?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion2);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about pregnancy \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_pregnancy_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Pregnancy Info page and verify that 'Are you pregnant or have you given birth in the last 12 months?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion3);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User shares confrimation about war pensioner \"(.*?)\" and clicks on  NEXT button$")
	public void user_shares_confrimation_about_war_pensioner_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to War Pensioner Info page and verify that 'Do you have an injury or illness caused by serving in the armed forces?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion4);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about diabetes \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_diabetes_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Diabetes Info page and verify that 'Do you have diabetes?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion5);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about pre-medical condition \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_pre_medical_condition_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Pre-medical Info page and verify the page headline is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion6);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about glaucoma \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_glaucoma_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Glaucoma Info page and verify that 'Do you have glaucoma?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion7);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
	
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User confirms about care home \"(.*?)\" and clicks on  NEXT button$")
	public void user_confirms_about_care_home_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Care Info page and verify that 'Do you live permanently in a care home?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion8);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User provides savings infromation \"(.*?)\" and clicks on  NEXT button$")
	public void user_provides_savings_infromation_and_clicks_on_NEXT_button(String selectedOption) throws Throwable {
		
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User navigated to Savings Info page and verify that 'Do you have more than £16,000 in savings, investments or property?' question is displayed");
		commSelections.verifyQuestion(partnerInfoQuestion9);
		
		log.info("User selects from Radio options");
		commSelections.selectRadioButton(selectedOption);
		
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();

	}

	@Then("^User navigates with result page$")
	public void user_navigates_with_result_page() throws Throwable {
		
		ResultPage resultpage = new ResultPage(driver);
		log.info("User navigated to Result Page");
		resultpage.verifyResultHeadlines();

	}

	@Then("^User closes the websites$")
	public void user_closes_the_websites() throws Throwable {

		log.info("Close the all Opened Browsers");
		driver.quit();

	}
	
	@Then("^User does not select any values in DOB page and clicks on NEXT button$")
	public void user_does_not_select_any_values_in_DOB_page_and_clicks_on_NEXT_button() throws Throwable {
	   
		CommonElementsfromPages commSelections = new CommonElementsfromPages(driver);
		log.info("User clicks on 'Next' button on same page ");
		commSelections.clickOnButton();
	}

	@Then("^Application displays error on date of birth page$")
	public void application_displays_error_on_date_of_birth_page() throws Throwable {
		
		DateOfBirthPage dob = new DateOfBirthPage(driver);
		log.info("User verifies Error Summary Headline ");
		dob.verifyErrorSummaryHeadline();    
	   
	}

	@When("^User clicks on error link and verifies the error message$")
	public void user_clicks_on_error_link_and_verifies_the_error_message() throws Throwable {
		
		DateOfBirthPage dob = new DateOfBirthPage(driver);
		log.info("User verifies Error Message and click on Link ");
		dob.verifyErrorMsgLink();    
	    
	}

}
