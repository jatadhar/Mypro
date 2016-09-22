package com.primes.master;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Lib {
 
	public static Properties pr;
	public static FileInputStream fis;
	public WebDriver driver; 
	public String Expvalue, Actuvalue;
	 public String OpenApp(String url) throws Throwable
	 {
		 pr = new Properties();
		fis = new FileInputStream("E:\\PrimusBank\\Primus\\src\\com\\primes\\properties\\property.properties");
		 pr.load(fis);
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(pr.getProperty("Plink"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(pr.getProperty("Pmainl"))).click();
		Expvalue="Primus Bank";
		Actuvalue = driver.findElement(By.xpath(pr.getProperty("pbank"))).getText();
		
		System.out.println("The Actuvalue is="+Actuvalue);	
		if(Expvalue.equalsIgnoreCase(Actuvalue))
		{
			System.out.println("This applicatio is lanched");
			return "pass";
		}
		
		else
		{
			System.out.println("This application is not lanched");
			return "Fail";
		}
	 }
	 
	 public void Admin(String Uname, String Pass) throws Throwable
	 {
		  driver.findElement(By.id(pr.getProperty("Uname"))).sendKeys(Uname);
		  Thread.sleep(3000);
		  driver.findElement(By.id(pr.getProperty("Pas"))).sendKeys(Pass);
		  driver.findElement(By.id(pr.getProperty("log"))).click();
		  
	 }
	 public String Branch()
	 {
		 String EB= "Welcome to Admin";
		 String AB=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		 System.out.println(AB);
		 String s;
		 if(EB.equalsIgnoreCase(AB))
		 { 
			 System.out.println("The Barnch Modle is enter");
			 s="Pass Branch Module";
			 
			 	 
		 }
		 else
		 {
			 System.out.println("The Branch Mode is fail");
			   s=  "Fail Branch Module";
			  
		 }
		 
		 return s;
		  }
	 public String Role(String RN,String RT)
	 {
		 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
		 							  //.//*[@id='Table_01']/tbody/tr/td[1]/a/img 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	 	String Expval="Sucessfully";
	 	
	 	Sleeper.sleepTightInSeconds(4);
	 	
	 	driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
	 	driver.findElement(By.id("txtRname")).sendKeys(RN);
	 	driver.findElement(By.id("lstRtypeN")).click();
	 	driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
	 	driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
	 	Sleeper.sleepTightInSeconds(2);
	 	String Actval=driver.switchTo().alert().getText();
	 	
	 	System.out.println(Actval);
	 	
	 	
	       driver.switchTo().alert().accept();
	       //driver.findElement(By.xpath("//*[@id='Table_02']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	       if (Actval.contains(Expval)) 
	       {
	     	  System.out.println("Role Created");
	     	  return Actval;
	 		
	 	}
	       else{
	     	  System.out.println("role not created");
	     	  return "Fail";
	       }
	 
	 	 	
	 	
	 }
	 public void NewBranch() throws Throwable
	 {   driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
	 
		 driver.findElement(By.id("BtnNewBR")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.id("txtbName")).sendKeys("Anantapur");
		 driver.findElement(By.id("txtAdd1")).sendKeys("#3/40");
		 driver.findElement(By.id("Txtadd2")).sendKeys("plot. No 5");
		 driver.findElement(By.id("txtArea")).sendKeys("Ammerpet");
		 driver.findElement(By.id("txtZip")).sendKeys("515004");
		 driver.findElement(By.id("lst_counrtyU")).click();
		 driver.findElement(By.xpath(".//*[@id='lst_counrtyU']/option[2]")).click();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.id("lst_stateI")).click();
		 driver.findElement(By.xpath(".//*[@id='lst_stateI']/option[2]")).click();
		 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(300);
		 driver.findElement(By.xpath(".//*[@id='lst_cityI']/option[2]")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.id("btn_insert")).click();
		 driver.switchTo().alert().accept();
		/* List<WebElement> city= driver.findElements(By.xpath(".//*[@id='lst_cityI']/option"));
		 //List<WebElement> city= driver.findElements(By.xpath(".//*[@id='lst_cityI']/option"));
		 System.out.println(city.size());
		 
		 for(int i=0;i<city.size();i++)
		 { 
			 
			 if(city.get(i).getText().equalsIgnoreCase("Hyderabad"))
			 {
				  city.get(i).click();
		                break; 
				 }
			 
		 }*/
		
	 }
	 public void close()
	 { 
		 driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[3]/a/img")).click();
		 driver.close();
	 }
	 
}
