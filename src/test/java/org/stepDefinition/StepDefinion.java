package org.stepDefinition;

import java.util.List;

import org.ToolQaPojo.ToolQa;
import org.baseclass.BaseClass;
import org.dom4j.util.UserDataElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinion extends BaseClass {
	
	
	
	@Given("Have to open the Chrome and enter into the URL")
	public void have_to_open_the_Chrome_and_enter_into_the_URL() {
	launchchrome();
	launchurl("https://testautomationpractice.blogspot.com/");
	maxwindow();
	}

	@When("Have to find the elements and fill all the empty fields")
	public void have_to_find_the_elements_and_fill_all_the_empty_fields() {
	findbyid("datepicker").click();  
	}

	@Then("Close the page")
	public void close_the_page() {

	}

	
	
}



