package com.primes.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Notepad {

	public static void main(String[] args) throws Throwable {
		Lib li = new Lib();
		System.out.println("This is Opne Application");
		String Result = li.OpenApp("http://projects.qedgetech.com/");
		System.out.println("The Result after Application Start"+Result);
		System.out.println("This is Admin class:");
		li.Admin("Admin","Admin");
		Sleeper.sleepTight(20);
		System.out.println("This is Branch class");
		String Res= li.Branch();
		System.out.println("The Result is="+Res);
		System.out.println("This is Branch Creation Class");
		li.NewBranch();
		String Fpath= "E:\\PrimusBank\\Primus\\src\\com\\primes\\testdata\\Role_data.txt";
		
		String Rpath="E:\\PrimusBank\\Primus\\src\\com\\primes\\results\\Role_data.txt";
		String SD;
		FileReader FR = new FileReader(Fpath);
		BufferedReader Br= new BufferedReader(FR);
		String sread=Br.readLine();
		System.out.println("The Line of a File is"+sread);
		
		FileWriter FW= new FileWriter(Rpath);
		BufferedWriter BW= new BufferedWriter(FW);
		BW.write(sread+"@@@"+"Results");
		BW.newLine();
		while((SD=Br.readLine())!=null)
		{
			System.out.println(SD);
			String [] sr= SD.split("###");
					String Rname= sr[0];
					System.out.println(Rname);
					String Rtype= sr[1];
					System.out.println(Rtype);
					Res= li.Role(Rname,Rtype);
					System.out.println("The Result is="+Res);
					BW.write(Rname+"%%%"+Rtype+"%%%"+Res);
					BW.newLine();
		}
		
		
BW.close();
Br.close();
li.close();
	}
	


}
