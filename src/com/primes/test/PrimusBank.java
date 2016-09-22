package com.primes.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrimusBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//String ActualVlue= driver.findElement(By.xpath(".//*[@id='login']")).getText();
		//System.out.println("The Actual value is"+ActualVlue);
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='BtnNewBR']")).click();
		String Expected = "New Branch Entry";
		String Actual = driver.findElement(By.id("Labmain")).getText();
		System.out.println(Actual);
		 if(Expected.equalsIgnoreCase(Actual))
		 {
			 System.out.println("The Appliation is open");
			 driver.findElement(By.id("txtbName")).sendKeys("Kukatapully");
			 driver.findElement(By.id("txtAdd1")).sendKeys("4/12, 2nd Road");
			 driver.findElement(By.id("Txtadd2")).sendKeys("Ramachendra nagar");
			 driver.findElement(By.xpath(".//*[@id='txtArea']")).sendKeys("Kukatapally");
			 driver.findElement(By.id("txtZip")).sendKeys("50052");
			 driver.findElement(By.xpath(".//*[@id='lst_counrtyU']")).click();
			 driver.findElement(By.xpath(".//*[@id='lst_counrtyU']/option[2]")).click();
			 driver.findElement(By.id("lst_stateI")).click();
			 driver.findElement(By.xpath(".//*[@id='lst_stateI']/option[2]")).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 //driver.findElement(By.xpath(".//*[@id='lst_cityI']")).click();
			 //String St= driver.findElement(By.xpath(".//*[@id='lst_cityI']/option[2]")).getText();
			 //System.out.println(St);
			 //java.util.List<WebElement> city=driver.findElements(By.xpath(".//*[@id='lst_cityI']")); 
			 driver.findElement(By.xpath(".//*[@id='lst_cityI']/option[2]")).click();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 driver.findElement(By.id("btn_insert")).click();
			 
			 driver.switchTo().alert().accept();
			 
			 
		 }
		 else
		 {
			 System.out.println("Apllication is not pass");
		 driver.close();
		 }
		 
		 
		 
		
	}

}
