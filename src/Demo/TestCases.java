package Demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		
	
	
	}


	@Test
	public void VerifyTitle() {

		 driver.get("https://ecommerce-playground.lambdatest.io/");
	        
	        String url = driver.getCurrentUrl();
	     
	        Assert.assertTrue(url.contains("lambdatest"));
	}
	
	@Test
	public void VerifyHomePage() {

		 driver.get("https://ecommerce-playground.lambdatest.io/");
	        
	      String text= driver.findElement(By.xpath("//span[normalize-space()='Home']")).getText();
	     
	        Assert.assertEquals(text,"Home");
	}


	
	@AfterTest
    void teardown() {
       // Close the driver
        driver.quit();
    }
}