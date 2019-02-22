package myTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableUsingHashmap {
	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		WebElement o_tbl_object = driver.findElement(By.id("customers"));
		
	
		
		LinkedHashMap<Integer,LinkedHashMap<String,String>> o_result = f_get_table_content(o_tbl_object);
		System.out.println(o_result);
		System.out.println(o_result.toString());
		System.out.println(o_result.get(3));
		System.out.println(o_result.get(2).get("Company"));
		System.out.println(o_result.get(2).get("Contact"));
		System.out.println(o_result.get(2).get("Country"));	
		
}


public static LinkedHashMap<Integer,LinkedHashMap<String,String>> f_get_table_content(WebElement o_tbl_object){
	try{

	LinkedHashMap<String,String> o_clm_data;// = new LinkedHashMap<Integer,String>();
	LinkedHashMap<Integer,LinkedHashMap<String,String>> tbl_map_result = new LinkedHashMap<Integer,LinkedHashMap<String,String>>();
	
	 System.out.println("Td size is : "+o_tbl_object.findElements(By.tagName("td")).size());
	List<WebElement> list_rows = o_tbl_object.findElements(By.tagName("tr"));
	List<WebElement> col_names = o_tbl_object.findElements(By.tagName("th"));
	List<WebElement> list_clms;
	int i_row_count = list_rows.size();
	int i_clm_count;// = list_clms.size();
	for(int i=1;i<i_row_count;i++){
		list_clms = list_rows.get(i).findElements(By.tagName("td"));
		
		i_clm_count = list_clms.size();
		o_clm_data = new LinkedHashMap<String,String>();
		for(int j=0;j<i_clm_count;j++){

			o_clm_data.put(col_names.get(j).getText(),list_clms.get(j).getText());
		
		}//End Inner For
		
		tbl_map_result.put(i, o_clm_data);
		
	}//End Outer For
	
	
	if(  (tbl_map_result.get(1).size()>0) && (tbl_map_result.size()>0) ){
		System.out.println("info:HTML table fetched and returned in dual hashmap");
		
	}else{
		System.out.println("fail:Unable to fetch data from table. Row Count:" +  (tbl_map_result.size()) + " Clm Count: " + (tbl_map_result.get(0).size()) );
				
	}
	
	return tbl_map_result;
	}catch(Exception e){
		System.out.println("fail:Unable to fetch data from Html table." +   
				" Stack Trace: " +e.getMessage());
		return null;
	}
}//End Function
	  
  }
