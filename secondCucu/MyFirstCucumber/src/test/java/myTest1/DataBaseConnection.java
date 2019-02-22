package myTest1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseConnection {
  @Test
  public void f() {	  
	  
	  try{  
		   String url="jdbc:ucanaccess://C:\\Users\\HP\\Desktop\\Cricket_Players.accdb";  	  
		   Connection c=DriverManager.getConnection(url);  
		   Statement st=c.createStatement();  
		   ResultSet rs=st.executeQuery("select * from tbl_Players");  
		   
		   while(rs.next()){  
		    System.out.println(rs.getString(1)+" "+rs.getString(2));  
		   }  
		  
		}catch(Exception ee){System.out.println(ee);}  
	  
  }
}
