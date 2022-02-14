package org.ToolQaPojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolQa extends BaseClass{

	
	public ToolQa() {
	PageFactory.initElements(driver, this);

	
	}
	
	@FindAll({
		@FindBy(id="first-name"),
		@FindBy(name="firstName")
		
	})
	private WebElement firstname;
	@FindAll({
		@FindBy(id="last-name"),
		@FindBy(name="lastName")
		
	})
	private WebElement lastname;
	@FindAll({
		@FindBy(id="email"),
		@FindBy(name="email")
	})
	private WebElement email;
	
	@FindAll({
		@FindBy(id="mobile"),
		@FindBy(name="mobile")

	})
	private WebElement mobile;
	
	@FindAll({
		@FindBy(name="country"),
		@FindBy(xpath="class=\"upcoming__registration--input\"")
		})
	private WebElement country;
	
	@FindAll({
		@FindBy(id="city"),
		@FindBy(xpath="type=\"text\"")

		
	})
	private WebElement city;
	
	@FindAll({
		
		@FindBy(xpath="//textarea[@name=\"message\"]"),
		@FindBy(name="message")
		
		
	})
	private WebElement messge;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getMessge() {
		return messge;
	}

	
	
	

}
