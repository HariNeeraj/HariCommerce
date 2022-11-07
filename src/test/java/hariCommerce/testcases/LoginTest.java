package hariCommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import hariCommerce.pageobjects.Loginpage;

public class LoginTest extends Testbase {
	
	
	@Test
	public void Logintest() {
		
		Loginpage lp = new Loginpage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
	
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
			lp.clicklogout();
			Assert.assertTrue(true);
			
		} else {
			Assert.assertTrue(false);
			
		}

		}

	}

	
	
	
	

