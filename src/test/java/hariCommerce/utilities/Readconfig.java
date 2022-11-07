package hariCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	
	public Readconfig() {
		
		File fsrc = new File("./configuaration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(fsrc);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		}
		
	public String geturl() {
		
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	public String getUaername() {
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pass= pro.getProperty("password");
		return pass;
	}
	
	
}
