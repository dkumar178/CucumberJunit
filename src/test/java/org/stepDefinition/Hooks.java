package org.stepDefinition;

import org.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
	
	
	@Before("@sanity")
	public void beforestarted() {
		print("sanity its working");
		launchchrome();
		maxwindow();
		
		
	}
	@After("@sanity")
	private void afterended() {
	print("regration is working");
	
	
	}

}
