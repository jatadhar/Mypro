package com.primes.master;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class PrimesTest {
	public Lib LB= new Lib();
	
	@BeforeTest
	public void beforeTest() throws Throwable
	{
		LB.Admin("Admin", "Admin");
		
	}
	@AfterTest
	public void afterTest()
	{
		LB.close();
	}
	@BeforeSuite
	public void beforesuite() throws Throwable
	{
		LB.OpenApp("http://primusbank.qedgetech.com/");
	}
}
