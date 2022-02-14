package org.adactinlogin;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Adactin extends BaseClass {

	@Given("User have to enter the Adactin page on Chrome portal")
	public void user_have_to_enter_the_Adactin_page_on_Chrome_portal() {
		print("launching chrome");
		launchchrome();
		print("Enterinto Adactin page");
		launchurl("https://adactinhotelapp.com/index.php");
		waitfor(5);
	}

	@Given("Have to maximaize the Window and check the correct Url is entered or not.")
	public void have_to_maximaize_the_Window_and_check_the_correct_Url_is_entered_or_not() {

		maxwindow();
		String url = currenturl();
		if (url.contains("hotelapp.com/index")) {
			print("entered correct page");
		} else {
			print("Entered into wrong page");
		}

	}

	@When("User have to enter the UserName and Password and click the login page.")
	public void user_have_to_enter_the_UserName_and_Password_and_click_the_login_page() {

		findbyid("username").sendKeys("dkumar178");
		findbyname("password").sendKeys("Saibaba@123");
		findbyxpath("//input[@type=\"Submit\"]").click();

	}

	@When("Have to check entered in a new Window.")
	public void have_to_check_entered_in_a_new_Window() {
		String currenturl = currenturl();
		if (currenturl.contains("/SearchHotel")) {
			print("We entered a new window for booking");

		} else {

			print("Wrong window");
		}

	}

	@Then("Print the new window page title and URl and title")
	public void print_the_new_window_page_title_and_URl_and_title() {
		String title = driver.getTitle();
		String currenturl = currenturl();
		print("new window title" + title + "\n new window currenturl" + currenturl);

	}

	@Then("Take a screenshot of the page.")
	public void take_a_screenshot_of_the_page() throws IOException {
		takescreenshot("Adactincucumber");

	}

	@When("have to enter the values on mandatory fields on Adactin page")
	public void have_to_enter_the_values_on_mandatory_fields_on_Adactin_page() {
		WebElement loc = findbyname("location");
		SelectBytext(loc, "London");
		WebElement room = findbyid("room_nos");
		Selectbyindex(room, 2);
		findbyxpath("//input[@name=\"datepick_in\"]").sendKeys("12/02/2022");
		findbyname("datepick_out").sendKeys("13/02/2022");
		WebElement adult = findbyname("adult_room");
		Selectbyindex(adult, 2);
	}

	@Then("Take a Screenshot of the page")
	public void take_a_Screenshot_of_the_page() throws IOException {
		takescreenshot("2nd page");
	}

	@Then("Click the next page.")
	public void click_the_next_page() {
		findbyname("Submit").click();
		print("wait for another page");

	}

	@Given("Have to check the Hotel name is correct")
	public void have_to_check_the_Hotel_name_is_correct() {
	WebElement hotel = findbyname("hotel_name_1");
	String namehotel = hotel.getAttribute("value");
	if (namehotel.equals("Hotel Cornice")) {
		print("hotel is present");
		print("Hotel name is :"+namehotel);
	}
	
	
	}

	@Given("Have print the Hotel name")
	public void have_print_the_Hotel_name() {
		print("Hotel name:");
	}

	@When("Have Mark the Hotel for booking")
	public void have_Mark_the_Hotel_for_booking() {
		findbyname("radiobutton_1").click();
		
		
	}

	@When("Have toGet the Screenshot for the confirmation")
	public void have_toGet_the_Screenshot_for_the_confirmation() {
		try {
			takescreenshot("After marked");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Then("Have Click the Next page")
	public void have_Click_the_Next_page() {
	
	findbyname("continue").click();
	}

}
