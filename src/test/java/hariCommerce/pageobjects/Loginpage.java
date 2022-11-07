package hariCommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	public WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;
	
	
	
	public void setUsername(String un) {
		email.clear();
		email.sendKeys(un);
	}
	
	public void setPassword(String pass) {
		pwd.clear();
		pwd.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}
	
	public void clicklogout() {
		logoutbtn.click();
	}
	
	
}
