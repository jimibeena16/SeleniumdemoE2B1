package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	  public static void main(String[] args) {

	      // WebDriver driver = DriverFactory.getDriver();
	    	WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	       
	        driver.get("https://demoqa.com/browser-windows");

	        String parentWindow = driver.getWindowHandle();

	        driver.findElement(By.id("windowButton")).click();

	        Set<String> windows = driver.getWindowHandles();

	        for (String window : windows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }

	        String text = driver.findElement(By.id("sampleHeading")).getText();
	        System.out.println(text);

	      //  Assert.assertEquals(text, "This is a sample page");

	        driver.close();

	        driver.switchTo().window(parentWindow);
	    }
}

	
