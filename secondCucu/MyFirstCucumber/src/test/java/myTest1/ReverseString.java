package myTest1;

import org.testng.annotations.Test;

public class ReverseString {
  @Test
  public void f() {
	  String s="muthu selvam k";
	  String s1 ="";
	  int n=s.length();
	  System.out.println(s);
	  for(int i=n-1; i>=0;i--) {
		  
		  s1=s1+s.charAt(i);
	  }
	  
	  System.out.println(s1);
	  
  }
}
