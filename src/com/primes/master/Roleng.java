package com.primes.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Roleng extends PrimesTest{
	@Test(dataProvider="rdata")
	public void roleexe(String Rn,String Rt)
	{
		LB.Role(Rn,Rt);
	}
		@DataProvider
		
		public Object[][] rdata()
		{
			Object[][] obj=new Object[3][2];
			
			obj[0][0]="qaengg04";
			obj[0][1]="E";
			
			obj[1][0]="qaengg05";
			obj[1][1]="E";
			
			obj[2][0]="qaengg06";
			obj[2][1]="E";
			
			return obj;
		}

}
