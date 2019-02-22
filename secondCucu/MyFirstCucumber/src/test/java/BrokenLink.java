

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	
	public static void main(String[] args) throws IOException {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Drivers\\chromedriver.exe");
		  WebDriver a1;
		  System.out.println("Initialyzing Browser");
		  a1=new ChromeDriver();	  
		  a1.manage().window().maximize();
		  a1.get("https://www.javatpoint.com/java-programs");		  
		  System.out.println(a1.getTitle());
		
		  int i=0;
		List<WebElement> wb=a1.findElements(By.tagName("a"));
		
		for(WebElement w:wb) {
			i++;
			if (i>10)
				break;
			System.out.println(w.getAttribute("href"));				 
			URL u=new URL(w.getAttribute("href"));
			HttpURLConnection httpU= (HttpURLConnection)u.openConnection();
			
			httpU.setConnectTimeout(3000);
			httpU.connect();
			
			
				System.out.println("Response : "+httpU.getResponseCode());
		
						if(HttpURLConnection.HTTP_NOT_FOUND==httpU.getResponseCode())
						{
							
						}
		}
		
	}

}
