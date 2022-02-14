package org.testRunner;

import org.baseclass.BaseClass;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
	
	
	@Before("@E2E")
	public void beforestarted() {
		print("before started the class for cucumber");
		launchchrome();
		maxwindow();
		waitfor(5);
		
	}
	@After("@E2E")
	private void afterended() {
		print("After class eneded success fully for cucumber");
		closebrowser();
		
	
	}

}
