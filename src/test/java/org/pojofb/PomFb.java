package org.pojofb;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;



public class PomFb extends BaseClass  {
	
	
	public PomFb() {
		PageFactory.initElements(driver, this);
	}
	@FindAll({
		@FindBy(id="email"),
		@FindBy(name="email"),
		@FindBy(xpath="//input[@data-testid=\"royal_email\"]")
		
	})
	private WebElement txtusername;
	@FindAll({
		@FindBy(name="pass"),
		@FindBy(id="pass"),
		@FindBy(xpath="//input[@type=\"password\"]")
		
	})
	private WebElement txtpass;
	
	@FindAll({
		@FindBy(id="u_0_d_AE"),
		@FindBy(name="login"),
		@FindBy(xpath="//button[@type=\"submit\"]")
	})
	private WebElement login;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
}



