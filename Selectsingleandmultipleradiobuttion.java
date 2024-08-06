package com.radiobuttonevents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectsingleandmultipleradiobuttion {
      
	 protected static String url="https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
	   WebDriver driver;

	  @BeforeSuite
	  public void startchromebrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  }
	  
	  @BeforeClass
	  public void openurl() {
		  driver.get(url);
	  }
	  	  
	  @Test
	  public void radiobutton() throws InterruptedException {		 
		  WebElement radiobtnmale=driver.findElement(By.xpath("//input[@id='gender']"));
		  radiobtnmale.click();
		  
		  //need to verify if button selected or not
		  boolean result=radiobtnmale.isSelected();
		  System.out.println(result);
		  Thread.sleep(3000);
	  }
	  
	  @Test
	  public void groupofradiobutton() throws InterruptedException {
		  List<WebElement>totalradiobtns=driver.findElements(By.xpath("//input[@type='radio']"));
		  int count=totalradiobtns.size();
		  System.out.println("total number of radio buttons are "+ count);	
		  
		  //check on all buttons one by one
		  for(WebElement el:totalradiobtns) {
			  if(!el.isSelected()) {
				  el.click();
			  }
		  }
		  Thread.sleep(2000);
	  }
	  	  	  
	  @AfterSuite
	  public void closechromebrowser() {
		  driver.quit();
	  }
}
