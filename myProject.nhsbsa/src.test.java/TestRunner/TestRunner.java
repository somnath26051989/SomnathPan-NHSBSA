package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src.test.java/features", 
                 plugin = {"html:target/cucumber-html-report"}, 
                 glue = "stepDefinition",
                 tags={"@TestScenario1 , @TestScenario2"})
public class TestRunner {

}
