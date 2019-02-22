package myTest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DmmyTeast {
  @Test
  public void f() {
	  String s[][];
	  
	  FileInputStream fs=new FileInputStream("C:\\Users\\HP\\Desktop\\Resume\\Rejected Interview.xlsx");
	  
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  XSSFSheet sh=wb.getSheetAt(0);
	  int n=sh.getLastRowNum();
	  
	  for(int i=0;i<n;i++) {
		  for(int j=0;j<3;j++) {
			  System.out.println(s[i][j]);
		  }
	  }
	  
	  
  }
}