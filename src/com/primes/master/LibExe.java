package com.primes.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LibExe {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		 Lib li= new Lib();
		 String Res= li.OpenApp("http://projects.qedgetech.com/");
		 System.out.println("The result is"+Res);
		 li.Admin("Admin", "Admin");
		 String Result=li.Branch();
		 System.out.println("The Branch result is="+Result);
		 li.NewBranch();
		 FileInputStream fis = new FileInputStream("E:\\PrimusBank\\Primus\\src\\com\\primes\\testdata\\Role_data.xlsx");
		 //Creat Workbook
		 XSSFWorkbook WB= new XSSFWorkbook(fis);
		 //Creat sheet
		 XSSFSheet Ws= WB.getSheet("Role_data");
		 int Rc= Ws.getLastRowNum();
		 System.out.println(Rc);
		 for(int i=1;i<=Rc;i++)
		 {
			  XSSFRow Wr= Ws.getRow(i);
			  XSSFCell Wc=Wr.getCell(0);
			  XSSFCell Wc1=Wr.getCell(1);
			  XSSFCell Wc2=Wr.createCell(2);
			  String Rname= Wc.getStringCellValue();
			  String Rtype= Wc1.getStringCellValue();
			  Res= li.Role(Rname, Rtype);
			  System.out.println("The Result is"+Res);
			  Wc2.setCellValue(Res);
			  
			  
		 }
		 FileOutputStream fos= new FileOutputStream("E:\\PrimusBank\\Primus\\src\\com\\primes\\results\\Role_data.xlsx ");
		 WB.write(fos);
		 WB.close();
		 
		 //li.NewBranch();
	}

}
