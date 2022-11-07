package hariCommerce.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import hariCommerce.utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	Readconfig rc= new Readconfig();
	
	public String Baseurl = rc.geturl();
	public String username= rc.getUaername();
	public String password = rc.getPassword();
	public static Logger logger;
	
	public static WebDriver driver;
	
	@BeforeClass
	@Parameters("Browser")
	public void setup(String br) {
		
		
		if(br.equals("Chrome"))	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else
		if(br.equals("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
			}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(Baseurl);
	}
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	
	
}
