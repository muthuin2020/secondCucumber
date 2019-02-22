package myTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumTest {
	
	WebDriver a1;
	
	@Given("^Launching Browser$")
	public void launching_Browser() throws Throwable {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\Drivers\\chromedriver.exe");		
		  System.out.println("Inside Given");
		   a1=new ChromeDriver();	  
		  a1.manage().window().maximize();		
	}

	
	@When("^Entering \"(.*?)\"Credentials \"(.*?)\"$")
	public void entering_Credentials(String unmae, String paswrd) throws Throwable {
		System.out.println("Inside When");
		a1.get("https://www.flipkart.com/");	
			WebElement e1=a1.findElement(By.xpath("//input[@type='text'][@class='_2zrpKA']"));
			System.out.println(e1);
		
			e1.sendKeys(unmae);
			System.out.println(e1);
		try {
			a1.findElement(By.xpath("//input[@type='password']")).sendKeys(paswrd);
		} catch (Exception e) {
			
		}
	}


	@Then("^Log In$")
	public void log_In() throws Throwable {	  
		System.out.println("Inside Then");
		a1.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']1")).click();
		
	}
	
}
