package org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\resources\\Features\\demo.Feature", glue = "org.adactinlogin", dryRun = false,
				plugin = "html:C:\\Users\\LAPTOP\\eclipse-workspace\\CucumberJunit\\Reports\\HTML Reports")

public class TestRunner {

}
