package com.primes.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {
	
	
	DesiredCapabilities cap=null;
	@Parameters("browser")
	@Test
	 public void Gexe(String br) throws Throwable
	 {
		if (br.equalsIgnoreCase("firefox")) 
		{
			 cap= new DesiredCapabilities();
			 cap.setBrowserName("firefox");
			 cap.setPlatform(Platform.WINDOWS);
				}
		else if (br.equalsIgnoreCase("chrome")) 
		{
			 cap= new DesiredCapabilities();
			 cap.setBrowserName("chrome");
			 cap.setPlatform(Platform.WINDOWS);
				
		}
		 
		 RemoteWebDriver driver=new RemoteWebDriver(new URL("http://16.06.22.235:4444/wd/hub"),cap);
		 driver.get("http://primusbank.qedgetech.com/");
		 driver.manage().window().maximize();
		 Lib Php=PageFactory.initElements(driver,Lib.class);
			Php.Admin("Admin","Admin");
	 }
}
