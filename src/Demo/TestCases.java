package Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		
	    ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	
		 Reporter.log("We used Google Chrome for this test");
		
	 Reporter.log("We used Google Chrome for this test");
	
	
	}


	@Test(description="Verify Title")
	public void VerifyTitle() {

		 driver.get("https://ecommerce-playground.lambdatest.io/");
	        
	        String url = driver.getCurrentUrl();
	     
	        Assert.assertTrue(url.contains("lambdatest"));

	        Reporter.log("URL is verified for this test");

	}
	
	@Test(description="Verify HomePage")
	public void VerifyHomePage() {

		 driver.get("https://ecommerce-playground.lambdatest.io/");
	        
	      String text= driver.findElement(By.xpath("//span[normalize-space()='Home']")).getText();
	     
	        Assert.assertEquals(text,"Home");

		 Reporter.log("Home Page is verified for this test");

	}


	
	@AfterTest
    void teardown() {
       // Close the driver
        driver.quit();
    }
}
