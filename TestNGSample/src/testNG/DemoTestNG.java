package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DemoTestNG {
	@BeforeTest
	public void testMethod(){
		System.out.println("starting..");
		
	}
	
	@Test
	@Parameters({"userid","password"})
	public void gmailLogin(String Usrname,String pwd) throws Exception{
		 WebDriver driver =new FirefoxDriver();
		driver.get("https://www.gmail.com");
		String expectedTitle="Gmail";
		String actualTitle= driver.getTitle();//validating 
		Assert.assertEquals(expectedTitle,actualTitle);
		WebElement username =driver.findElement(By.xpath(".//*[@id='Email']"));
		username.sendKeys(Usrname);
		driver.manage().window().maximize();
    	driver.findElement(By.id("next")).click();
    	Thread.sleep(500);
    	driver.findElement(By.xpath(".//input[@type='password']")).sendKeys(pwd);;
    	driver.findElement(By.id("signIn")).click();
	  
  }
}
